package no.hvl.dat102.Oppgave5.klient;

import no.hvl.dat102.Oppgave4.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.Oppgave4.tabell.TabellOrdnetListe;
import no.hvl.dat102.Oppgave5.Person.*;
import java.util.Scanner;

public class KlientPersonOrdnetListe {

	public static void main(String[] args) {

		KjedetOrdnetListe<Person> kjeListe = new KjedetOrdnetListe<Person>();
		TabellOrdnetListe<Person> tabListe = new TabellOrdnetListe<Person>();

		Scanner in = new Scanner(System.in);
		int i = 1;

		// Leser inn 6 personer og legger til i kjeListe og tabListe
		while (i < 3) { // 7
			System.out.print("Person " + i + "\n");
			System.out.print("Fornavn: ");
			String fornavn = in.next();
			System.out.print("Etternavn: ");
			String etternavn = in.next();
			System.out.print("Årstall: ");
			int årstall = in.nextInt();

			Person p = new Person(fornavn, etternavn, årstall);
			kjeListe.leggTil(p);
			tabListe.leggTil(p);
			i++;
			System.out.println();
		}
		in.close();

		// Skriver ut kjedet ordnet liste
		System.out.println("Kjedet ordnet liste:");
		while (kjeListe.antall() > 0) {
			System.out.println(kjeListe.fjernFoerste().toString());
		}
		System.out.println();

//		 Skriver ut tabell ordnet liste
		System.out.println("Tabell ordnet liste:");
		while (tabListe.antall() > 0) {
			System.out.println(tabListe.fjernFoerste());
		}
		System.out.println();

	}

}
