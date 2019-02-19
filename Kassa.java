
public class Kassa {
	private int omzet;
	private int aantalKaarten;
	private int LaatsteBezoekInspecteur;
	
	public Kassa() {
		this.omzet=0;
	}
	
	public void add(int eurocenten) {
		this.omzet+=eurocenten;
		this.aantalKaarten++;
	}
	
	public int get() {
		return this.omzet;
	}
	
	public String toString() {
		return String.format("%.2f",(double)this.omzet*0.01);
	}
	
	public int getKaarten() {
		return this.aantalKaarten;
	}
	
	public void remove(int eurocenten) {
		this.omzet-=eurocenten;
	}
	
	public void bezoekInspecteur(){
		this.LaatsteBezoekInspecteur=this.aantalKaarten;
	}

	public int laatsteBezoek() {
		return this.LaatsteBezoekInspecteur;
	}


}
