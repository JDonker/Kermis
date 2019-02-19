
public class Hawaii extends RisicoRijkeAttracties {
	
	public Hawaii() {
		super("hawaii",290,400);
		super.draaiLimiet=10;
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
		// inspecteur moet worden opgeroepen voor keuring.
		if (!super.gekeurd) {
			boolean inputNeeded = true;
			while(inputNeeded) {
			System.out.println("Type [i] om keuring uit te voeren, of [n] om dat niet te doen.");
			String input =	super.reader.nextLine();
			switch(input) {
				case "i":
					System.out.println("Keuring uitgevoerd. Attractie " + super.toString() +  " toegangkelijk.");
					this.kaartenBijLaatsteOnderhoud=super.getAantalKaarten();
					super.gekeurd=true; 
					inputNeeded=false; 
					break;
				case "n":
					System.out.println("Geen keuring uitgevoerd. Attractie " + super.toString() +  " buiten gebruikt!");
					inputNeeded=false; 
					break;
				default: 
					System.out.println("Verkeerde input!");
					break;
			}
		}
		}
		return super.gekeurd;
	}
	


}
