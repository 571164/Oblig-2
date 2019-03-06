import no.hvl.dat102.Oppgave4.adt.*;
import no.hvl.dat102.Oppgave4.kjedet.*;
import no.hvl.dat102.Oppgave4.tabell.*;

public class Klient {

	public static void main(String[] args) {

		KjedetOrdnetListe<Integer> k1 = new KjedetOrdnetListe<Integer>();
//		TabellOrdnetListe<Integer> k1 = new TabellOrdnetListe<Integer>();

		int e0 = 0;
		int e1 = 1;
		int e2 = 2;
		int e3 = 3;
		int e4 = 4;
		int e5 = 5;

		k1.leggTil(e3);
		k1.leggTil(e5);
		k1.leggTil(e1);
		k1.leggTil(e4);
		k1.leggTil(e4);
		k1.leggTil(e0);
		k1.leggTil(e2);

		k1.skrivUt();

		k1.fjern(4);

		k1.skrivUt();

		System.out.println(k1.erTom());

		k1.fjern(4);
		k1.fjern(0);
		k1.fjern(1);
		k1.fjern(2);
		k1.fjern(3);
//		k1.fjern(5);

		System.out.println(k1.erTom());

	}

}
