package no.hvl.dat102.klient2;

import no.hvl.dat102.datakontaktfirma.Datakontakt;
import no.hvl.dat102.datakontaktfirma.Hobby;
import no.hvl.dat102.datakontaktfirma.Medlem;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet2.KjedetMengde;

public class KlientMedlem {

	public static void main(String[] args) {

		// MEDLEMMER
		Medlem m1 = new Medlem("Svein", -1);
		Medlem m2 = new Medlem("Ole", -1);
		Medlem m3 = new Medlem("Geir", -1);
		Medlem m4 = new Medlem("Lise", -1);
		Medlem m5 = new Medlem("Olav", -1);
		Medlem m6 = new Medlem("Sigurd", -1);
		Medlem m7 = new Medlem("Jane", -1);
		Medlem m8 = new Medlem("Jeff", -1);
		Medlem m9 = new Medlem("Aud", -1);
		Medlem m10 = new Medlem("Halgeir", -1);

		// HOBBYER
		Hobby h1 = new Hobby("Fiske");
		Hobby h2 = new Hobby("Svømme");
		Hobby h3 = new Hobby("Hoppe");
		Hobby h4 = new Hobby("Ake");
		Hobby h5 = new Hobby("Jakte");
		Hobby h6 = new Hobby("Jogge");
		Hobby h7 = new Hobby("Trene");
		Hobby h8 = new Hobby("Bokse");
		Hobby h9 = new Hobby("Tegne");
		Hobby h10 = new Hobby("Skrive");

		// <Fiske>, <Svømme>, <Hoppe>
		MengdeADT<Hobby> mh1 = new KjedetMengde<Hobby>();
		mh1.leggTil(h1);
		mh1.leggTil(h2);
		mh1.leggTil(h3);

		// <Ake>, <Jakte>, <Jogge>
		MengdeADT<Hobby> mh2 = new KjedetMengde<Hobby>();
		mh2.leggTil(h4);
		mh2.leggTil(h5);
		mh2.leggTil(h6);

		// <Trene>, <Bokse>, <Tegne>
		MengdeADT<Hobby> mh3 = new KjedetMengde<Hobby>();
		mh3.leggTil(h7);
		mh3.leggTil(h8);
		mh3.leggTil(h9);

		m1.setHobbyer(mh1);
		m2.setHobbyer(mh2);
		m3.setHobbyer(mh3);
		m4.setHobbyer(mh2);

		Datakontakt d = new Datakontakt(100);
		d.leggTilMedlem(m1);
		d.leggTilMedlem(m2);
		d.leggTilMedlem(m3);
		d.leggTilMedlem(m4);
		d.leggTilMedlem(m5);
		d.leggTilMedlem(m6);
		d.leggTilMedlem(m7);
		d.leggTilMedlem(m8);
		d.leggTilMedlem(m9);
		d.leggTilMedlem(m10);

		m1.skrivUt();
		System.out.println();
		m2.skrivUt();
		System.out.println();
		m4.skrivUt();
		System.out.println();

		System.out.println("Passer " + m1.getNavn() + " til " + m2.getNavn() + " :: " + m1.passerTil(m2));
		System.out.println("Passer " + m2.getNavn() + " til " + m4.getNavn() + " :: " + m2.passerTil(m4));

	}

}
