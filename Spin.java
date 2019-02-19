
public class Spin extends RisicoRijkeAttracties implements GokAttractie{
	
	public Spin() {
		super("spin",225,120);
		super.draaiLimiet=5;
	}

	@Override
	public int kansSpelBelastingBetalen() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void onderhoudsbeurt(){
		boolean inputNeeded = true;
		while(inputNeeded) {
		System.out.println("Type [m] om onderhoud uit te voeren, of [n] om dat niet te doen.");
		String input =	super.reader.nextLine();
			switch(input) {
				case "m":
					System.out.println("Onderhoudsbeurt uitgevoerd. Attractie " + super.toString() +  " weer beschikbaar.");
					this.kaartenBijLaatsteOnderhoud=super.getAantalKaarten();
					inputNeeded=false; 
					break;
				case "n":
					System.out.println("Geen onderhoud uitgevoerd. Attractie " + super.toString() +  " buiten gebruikt!");
					inputNeeded=false; 
					break;
				default: 
					System.out.println("Verkeerde input!");
					break;
			}
		}
	}
	
	@Override
	public boolean opstellingsKeuring() {
		// automatische keuring
		if (!super.gekeurd) {
			System.out.println("Opstellingskeuring wordt uitgevoerd bij de " + super.toString() + "!");
			super.gekeurd = true;
		}
		return super.gekeurd;
	}
	

}
