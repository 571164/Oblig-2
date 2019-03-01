package no.hvl.dat102.meny;

import no.hvl.dat102.datakontaktfirma.*;
import java.util.Scanner;

public class Meny {

	private Tekstgrensesnitt GUI;

	private Datakontakt dKontakt;
	private int valg;
	private Scanner in;

	public Meny(Datakontakt arkiv) {
		GUI = new Tekstgrensesnitt();
		this.dKontakt = arkiv;
	}

	public void start() {
		in = new Scanner(System.in);
		hovedMeny();
		in.close();
	}

	public void hovedMeny() {

		String meny = "1. Les fra eksisterende arkiv\n2. Opprett nytt arkiv\n3. Avslutt";

		do {
			System.out.println(meny);
			valg = in.nextInt();
			System.out.println();

			switch (valg) {
			case (1): {
				// Ikke implementert enda
				break;
			}
			case (2): {
				underMeny();
				break;
			}
			case (3): {
				System.out.println("Avsluttet...");
				break;
			}
			}

		} while (valg != 3);
	}

	public void underMeny() {
		String meny = "1. Legg til medlem\n" + "2. Finn medlem\n" + "3. Finn partner for et medlem\n"
				+ "4. Skriv ut hobbylisten for et medlem\n" + "5. Skriv ut en par-liste med felles hobbyer\n"
				+ "6. Tilbake til hovedmenyen\nValg: ";

		do {
			System.out.println(meny);
			valg = in.nextInt();
			System.out.println();

			switch (valg) {
			// LEGG TIL MEDLEM
			case (1): {
				Medlem nyttMedlem = GUI.lesMedlem();
				dKontakt.leggTilMedlem(nyttMedlem);
				break;
			}
			// FINN MEDLEM
			case (2): {
				System.out.print("Oppgi navn på medlem: ");
				String navn = in.next();
				int medlemsIndex = dKontakt.finnMedlemsIndeks(navn);

				if (medlemsIndex >= 0) {
					System.out.println("Medlems-index: " + medlemsIndex + "\nNavn: " + navn);
				} else {
					System.out.println("Medlemmet er ikke registrert...");
				}
				System.out.println();
				break;
			}
			// FINN PARTNER TIL MEDLEM
			case (3): {
				System.out.println("Oppgi navn på medlem: ");
				String navn = in.next();
				int medlemsIndex = dKontakt.finnMedlemsIndeks(navn);
				int matchIndex = dKontakt.finnPartnerFor(navn);
				if (matchIndex < 0) {
					System.out.println("Fant ingen match...");
				} else {
					System.out.println(navn + "(index: " + medlemsIndex + ") passer for "
							+ dKontakt.getTab()[matchIndex].getNavn() + "(index: " + matchIndex + ")");
				}
				System.out.println();
				break;
			}
			// SKRIVER HOBBYLISTEN FOR ET MEDLEM
			case (4): {
				System.out.println("Oppgi navn på medlem: ");
				String navn = in.next();
				int medlemsIndex = dKontakt.finnMedlemsIndeks(navn);

				if (medlemsIndex < 0) {
					System.out.println("Medlemmet er ikke registrert...");
				} else {
//					GUI.skrivHobbyListe(dKontakt.getTab()[medlemsIndex].getHobbyer());
					GUI.skrivHobbyListe(dKontakt.getTab()[medlemsIndex]);
				}
				System.out.println();
				break;
			}
			case (5): {
				GUI.skrivParListe(dKontakt);
				break;
			}
			case (6): {
				break;
			}
			}

		} while (valg != 6);

	}

}
