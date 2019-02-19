
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kermis {

	private static int aantalRitjes;
	private static List<Attractie> attracties;
	private static Kassa kassa;
	private static BelastingInspecteur inspecteur;

	public static void main(String[] args) {
		
		// initializeren variabelen
		attracties = new ArrayList<>();
		aantalRitjes = 0;
        
        kassa = new Kassa();
        inspecteur = new BelastingInspecteur();
        
        
		
		// attracties plaatsen
		attracties.add(new Botsautos());
		attracties.add(new Spin());
		attracties.add(new Spiegelpaleis());
		attracties.add(new Spookhuis());
		attracties.add(new Hawaii());
		attracties.add(new Ladderklimmen());
		
		// kermis openen
		kermisIsOpen();
	}
	
	

	private static void kermisIsOpen() {
		// initieer wat dingen om user input te lezen;
		Scanner reader = new Scanner(System.in);
		String input = "";
		
		while(!input.equals("s")) {
			
			// print het menu
			printMenu();
			
			input = reader.nextLine();
			switch(input) {
			case "o":
				printOmzet();
				break;
			case "k":	
				printKaartVerkoop();
				break;
			case "s":
				System.out.println("Tot ziens!");
				break;
			default:
				// dan maar kijken of er een integer is meegestuurd
				try {
					int inputVal = Integer.parseInt(input);
					if (inputVal>0 && inputVal<=attracties.size()) {
						// er wordt een attractie aangeroepen 
						draaiAttractie(inputVal);
					} else {
						// waarde is geen geldig commando
						throw new IllegalArgumentException();
					}
				} catch(Exception e) {
					System.out.println("Verkeerde invoer");
				} 
			}

		}
		reader.close();
	}



	private static void printOmzet() {
		System.out.println("Attractie\t omzet");
		System.out.println("---------------------------------");
		attracties.forEach((attractie) -> attractie.printOmzet());
		System.out.println("---------------------------------");
		System.out.println("Totaal \t\t " + kassa );
		System.out.println("");
	}
	
	
	
	private static void printKaartVerkoop() {
		System.out.println("Attractie\taantal kaarten");
		System.out.println("---------------------------------");
		attracties.forEach((attractie) -> attractie.printKaartVerkoop());
		System.out.println("---------------------------------");
		System.out.println("Totaal \t\t " + kassa.getKaarten() );
		System.out.println("");
	}



	private static void draaiAttractie(int inputVal) {
		if (attracties.get(inputVal-1).draaien()) {
			kassa.add(attracties.get(inputVal-1).getKosten());
			aantalRitjes++;
			if (inspecteur.komtLangs(aantalRitjes)) {
				System.out.println("De belastinginspecteur komt langs, " + (aantalRitjes-kassa.laatsteBezoek() ) + " nieuwe verkopen.");
				inspecteur.inBelasting(attracties, kassa);
				kassa.bezoekInspecteur();
			}
		}
	}
	

	private static void printMenu() {
		System.out.println("Welkom op de kermis!");
		for(int i=0;i<attracties.size();i++) {
			System.out.print((i+1) + " voor " + attracties.get(i));
			if (i==(attracties.size()-1)) {
				System.out.println(".");
			} else {
				System.out.println(",");
			}
		}
		System.out.println("Toets [o] voor omzet overzicht; toets [k] voor kaart overzicht; toets [s] om te stoppen.");
	}

}
