package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.mengde.kjedet.*;
import no.hvl.dat102.mengde.tabell.*;

public class KLIENT2 {

	public static void main(String[] args) {

		MengdeADT<Integer> mengde = new KjedetMengde<Integer>();

		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde.leggTil(3);
		mengde.leggTil(4);
		mengde.leggTil(5);

		MengdeADT<Integer> tMengde = new TabellMengde<Integer>();
		tMengde.leggTil(5);
		tMengde.leggTil(4);
		tMengde.leggTil(3);
		tMengde.leggTil(2);
		tMengde.leggTil(1);

		System.out.println(mengde.toString());
		System.out.println(tMengde.toString());

	}

}
