import java.util.Scanner;

public abstract class RisicoRijkeAttracties extends Attractie {
	protected int draaiLimiet;
	protected int kaartenBijLaatsteOnderhoud;
	protected boolean gekeurd;
	protected Scanner reader;
	
	public RisicoRijkeAttracties(String name,int kosten,int oppervlakte) {
		super(name, kosten, oppervlakte);
		this.gekeurd=false;
		this.reader = new Scanner(System.in);
	}
	
	
	// laat sub-klasse zelf bepalen hoe een opstellingskeuring wordt uitgevoerd
	public abstract boolean opstellingsKeuring();
	
	// laat atractie zelf bepalen hoe een onderhoudsbeurt wordt uitgevoerd
	public abstract void onderhoudsbeurt();
	
	@Override
	public boolean draaien() {
		// kijken of attractie gekeurd is en zo nee doe dat dan
		if(opstellingsKeuring()) {
			// kijken of de attractie al tegen zijn draailimiet aanzit
			try {
				if((super.getAantalKaarten()-this.kaartenBijLaatsteOnderhoud)<=this.draaiLimiet) {
					return super.draaien();
				} else {
					throw new OnderhoudException();
				}
			} catch (OnderhoudException e) {
				onderhoudsbeurt();
			}
		}
		return false;
	}
}
