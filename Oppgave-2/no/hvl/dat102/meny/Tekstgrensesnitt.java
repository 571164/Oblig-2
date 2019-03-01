package no.hvl.dat102.meny;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Scanner;

import java.util.Iterator;

import no.hvl.dat102.datakontaktfirma.*;
import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.mengde.kjedet.*;

public class Tekstgrensesnitt {

	private Scanner in;
	private Hobby nyHobby;

	public Medlem lesMedlem() {

		in = new Scanner(System.in);

		System.out.print("Legg til nytt medlem:\nNavn: ");
		String navn = in.next();

		MengdeADT<Hobby> hobbyer = new KjedetMengde<Hobby>();
		System.out.print("Skriv inn hobbyer, avslutt med zzz: ");
		String hobby = in.next();

		while (!hobby.equals("zzz")) {
			nyHobby = new Hobby(hobby);
			hobbyer.leggTil(nyHobby);
			System.out.print("Skriv inn hobbyer, avslutt med zzz: ");
			hobby = in.next();
		}

		int statusIndex = -1;

		Medlem nyttMedlem = new Medlem(navn, statusIndex);
		nyttMedlem.setHobbyer(hobbyer);
		System.out.println();
		return nyttMedlem;
	}

	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene: ");
		System.out.println(medlem.getHobbyer().toString());
	}

	/*
	 * skriver ut på skjermen en oversikt over medlemmer som er koblet til hverandre
	 * i medlemstabellen til enhver tid. Et slikt par skal kun vises én gang på
	 * utskriftlisten. Metoden skriver også ut antall par som er funnet. Eksempel på
	 * utskrift: PARNAVN HOBBYER Erna og Jonas <ski, musikk, politikk> Eva og Adam
	 * <epleplukking, paradishopping> ……………………. Antall par funnet: 12
	 */
//	public static void skrivParListe(Datakontakt arkiv) {
//		
//		
//		MengdeADT<Integer> par = new KjedetMengde<Integer>();
//		int antallPar = 0;
//		int partnerIndex = -1;
//		
//		
//		for (int i=0; i<arkiv.getAntallMedlemmer(); i++) {
//			
//			partnerIndex = arkiv.getTab()[i].getStatusIndeks();
//			
//			if (partnerIndex > -1 && )
//		}
//		
//
//	}

	public void skrivParListe(Datakontakt arkiv) {
		KjedetMengde<Integer> par = new KjedetMengde<Integer>();
		int partnerIndex = -1;
		int antallPar = 0;
		for (int i = 0; i < arkiv.antall(); i++) {
			partnerIndex = arkiv.getTab()[i].getStatusIndeks();
			if (partnerIndex > -1 && !par.inneholder(i) && arkiv.getTab()[i] != null) {
				par.leggTil(i);
				par.leggTil(partnerIndex);
				antallPar++;
			}
		}
		
		System.out.printf("%15s%15s%n", "Par: (Antall: " + antallPar + ")", "Interesser:");

		Iterator<Integer> teller = par.oppramser();
		Integer id1;
		Integer id2;
		for (int i = 0; i < antallPar; i++) {
			id1 = teller.next().intValue();
			id2 = teller.next().intValue();
			System.out.printf("%-20s", arkiv.getTab()[id1].getNavn() + " og " + arkiv.getTab()[id2].getNavn());

			// Hobbyer for id1 og id2 vil være like
			System.out.printf("%15s%n", arkiv.getTab()[id1].getHobbyer());
		}
	}

}
