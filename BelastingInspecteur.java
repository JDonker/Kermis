import java.util.List;
import java.util.Random;

public class BelastingInspecteur {
	private Random random;
	private int komLangs;
	
	public BelastingInspecteur() {
		this.random = new Random();		
		this.komLangs=this.random.nextInt(15);
	}
	
	
	
	public void inBelasting(List<Attractie> attracties,Kassa kassa){
		int sum = 0;
		// loop alle attracties af en check of het gok attracties zijn
		for(Attractie attractie:attracties) {
			if(attractie instanceof GokAttractie) {
				int betaald = ((GokAttractie) attractie).kansSpelBelastingBetalen();
				String betaaldString = String.format("%.2f",(double)betaald*0.01);
				System.out.println(betaaldString + " euro kansspelbelasting geïnd bij " + attractie.toString() + "." );
				sum+=betaald;
			}
		}
		kassa.remove(sum);
		String geind = String.format("%.2f",(double)sum*0.01);
		System.out.println("De belastinginspecteur heeft in totaal " + geind + " euro kansspelbelasting geïnd." );
	}
	
	
	public boolean komtLangs(int aantalRitjes) {
		
		// Per 15 ritjes komt de man 1 keer langs bepaal hier welke keer 		
		if ((aantalRitjes%15)==0) {
			this.komLangs=this.random.nextInt(15);
		}
				
		// check of het deze keer is
		if ((aantalRitjes%15)==this.komLangs) {
			return true;
		}
		
		return false;
	}
}
