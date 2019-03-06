package no.hvl.dat102.Oppgave5.klient;

import no.hvl.dat102.Oppgave5.Person.*;
import no.hvl.dat102.Oppgave5.kjedet.KjedetKoe;
import no.hvl.dat102.Oppgave5.sirkulaer.SirkulaerKoe;

import java.util.Scanner;

public class KlientPersonKoe {

	public static void main(String[] args) {

		KjedetKoe<Person> kjeKoe = new KjedetKoe<Person>();
		SirkulaerKoe<Person> sirKoe = new SirkulaerKoe<Person>();

		Scanner in = new Scanner(System.in);
		int i = 1;

		// Leser inn 6 personer og legger til i kjeKoe og sirKoe
		while (i < 7) {
			System.out.print("Person " + i + "\n");
			System.out.print("Fornavn: ");
			String fornavn = in.next();
			System.out.print("Etternavn: ");
			String etternavn = in.next();
			System.out.print("Årstall: ");
			int årstall = in.nextInt();

			Person p = new Person(fornavn, etternavn, årstall);
			kjeKoe.innKoe(p);
			sirKoe.innKoe(p);
			i++;
			System.out.println();
		}
		in.close();

		// Skriver ut kjedet-kø
		System.out.println("Kjedet-kø:");
		while (!kjeKoe.erTom()) {
			System.out.println(kjeKoe.utKoe().toString());
		}
		System.out.println();

		// Skriver ut sirkulær-kø
		System.out.println("Sirkulær-kø:");
		while (!sirKoe.erTom()) {
			System.out.println(sirKoe.utKoe().toString());
		}
		System.out.println();

	}

}
