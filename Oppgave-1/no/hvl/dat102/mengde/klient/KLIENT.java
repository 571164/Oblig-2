package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.tabell.*;
import no.hvl.dat102.mengde.kjedet.*;
import no.hvl.dat102.mengde.adt.*;

public class KLIENT {

	public static void main(String[] args) {

		// --------------------TABELL-MENGDE-----------------------
		// Oppretter mengde1
		int[] mengde1 = { 1, 2, 3, 4, 5, 7 };
		MengdeADT<Integer> m1 = new TabellMengde<Integer>();
		for (int i = 0; i < mengde1.length; i++) {
			m1.leggTil(mengde1[i]);
		}

		// Oppretter mengde2
		int[] mengde2 = { 1, 2, 3, 7 };
		MengdeADT<Integer> m2 = new TabellMengde<Integer>();
		for (int i = 0; i < mengde2.length; i++) {
			m2.leggTil(mengde2[i]);
		}
		// --------------------TABELL-MENGDE-----------------------

		// --------------------KJEDET-MENGDE-----------------------
		// Oppretter mengde1
		int[] kmengde1 = { 1, 2, 3, 4, 5 };
		MengdeADT<Integer> km1 = new KjedetMengde<Integer>();
		for (int i = 0; i < kmengde1.length; i++) {
			km1.leggTil(kmengde1[i]);
		}

		// Oppretter mengde2
		int[] kmengde2 = { 6, 7, 8, 9, 10 };
		MengdeADT<Integer> km2 = new KjedetMengde<Integer>();
		for (int i = 0; i < kmengde2.length; i++) {
			km2.leggTil(kmengde2[i]);
		}
		// --------------------KJEDET-MENGDE-----------------------

//		//--------------------SKRIV-UT - TABELL-MENGDE-----------------------
//		System.out.println("TABELL-MENGDE:\n");
//		System.out.print("Mengde 1:   ");
//		m1.skrivUt();
//		System.out.print("Mengde 2:   ");
//		m2.skrivUt();
//		System.out.println();
//
//		// UNION
//		MengdeADT<Integer> union = new TabellMengde<Integer>();
//		union = m1.union(m2);
//		System.out.print("Union:      ");
//		union.skrivUt();
//
//		// SNITT
//		MengdeADT<Integer> snitt = new TabellMengde<Integer>();
//		snitt = m1.snitt(m2);
//		System.out.print("Snitt:      ");
//		snitt.skrivUt();
//
//		// DIFFERENS		
//		MengdeADT<Integer> differens = new TabellMengde<Integer>();
//		differens = m1.differens(m2);
//		System.out.print("Differens:  ");
//		differens.skrivUt();
//		//--------------------SKRIV-UT - TABELL-MENGDE-----------------------

		// --------------------SKRIV-UT - KJEDET-MENGDE-----------------------
		System.out.println("KJEDET-MENGDE:\n");
		System.out.print("Mengde 1:   ");
		km1.skrivUt();
		System.out.print("Mengde 2:   ");
		km2.skrivUt();
		System.out.println();

		// UNION
		MengdeADT<Integer> kUnion = new KjedetMengde<Integer>();
		kUnion = km1.union(km2);
		System.out.print("Union:      ");
		kUnion.skrivUt();

		// SNITT
		MengdeADT<Integer> kSnitt = new KjedetMengde<Integer>();
		kSnitt = km1.snitt(km2);
		System.out.print("Snitt:      ");
		kSnitt.skrivUt();

		// DIFFERENS
		MengdeADT<Integer> kDifferens = new KjedetMengde<Integer>();
		kDifferens = km2.differens(km1);
		System.out.print("Differens:  ");
		kDifferens.skrivUt();
		// --------------------SKRIV-UT - KJEDET-MENGDE-----------------------

	}

}
