package no.hvl.dat102.klient2;

import no.hvl.dat102.meny.*;
import no.hvl.dat102.datakontaktfirma.*;

public class KlientMeny {

	public static void main(String[] args) {

		Datakontakt dKontakt = new Datakontakt();

		Meny meny = new Meny(dKontakt);

		meny.start();

	}

}
