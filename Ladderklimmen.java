
public class Ladderklimmen extends Attractie implements GokAttractie {
	public int gereserveerdeKansSpelBelasting;
	
	
	public Ladderklimmen () {
		super("ladderklimmen",500,60);
		gereserveerdeKansSpelBelasting=0;
	}
	
	public int kansSpelBelastingBetalen() {
		int tempBelasting =gereserveerdeKansSpelBelasting;
		gereserveerdeKansSpelBelasting=0;
		super.omzet -=tempBelasting;
		return tempBelasting;
	}
	
	@Override
	public boolean draaien() {
		boolean draai = super.draaien();
		if (draai) {
			this.gereserveerdeKansSpelBelasting += (this.getKosten()*0.3);
		}
		return draai;
	}
}
