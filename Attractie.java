
public class Attractie {
	private int kostenRitje; // in eurocenten
	private String name; // 
	private int oppervlakte; // 
	protected int omzet; // in eurocenten
	private int aantalKaartjes;
	
	Attractie(String name, int kosten, int oppervlakte){
		this.aantalKaartjes=0;
		this.omzet=0;
		this.name=name;
		this.kostenRitje=kosten;
		this.oppervlakte=oppervlakte;
	}
	
	
	public int getAantalKaarten() {
		return this.aantalKaartjes;
	}
	
	public int getOmzet() {
		return this.omzet;
	}
	
	public String getOmzetString() {
		return String.format("%.2f",(double)this.omzet*0.01);
	}
	
	public int getKosten() {
		return this.kostenRitje;
	}
	
	public boolean draaien() {
		System.out.println("De attractie "+ this.name + " draait!");
		this.aantalKaartjes++;
		this.omzet+=this.kostenRitje;
		return true;
	}
	
	public void printOmzet() {
		if (this.name.length()<8) {
			System.out.println(this.name + "\t\t " + getOmzetString() );
		} else {
		
		System.out.println(this.name + "\t " + getOmzetString() );
		}
	}
	
	public void printKaartVerkoop() {
		if (this.name.length()<8) {
			System.out.println(this.name + "\t\t " + getAantalKaarten() );
		} else {
		
		System.out.println(this.name + "\t " + getAantalKaarten() );
		}
	}
	

	
	public int getOppervlakte() {
		return this.oppervlakte;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
