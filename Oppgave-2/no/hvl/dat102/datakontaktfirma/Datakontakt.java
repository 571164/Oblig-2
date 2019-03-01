package no.hvl.dat102.datakontaktfirma;

import no.hvl.dat102.mengde.adt.*;

public class Datakontakt {

	private Medlem[] tab;
	private int antallMedlemmer; // Antall
	private final static int STDK = 100;

	public Datakontakt() {
		tab = new Medlem[STDK];
		antallMedlemmer = 0;
	}

	public Datakontakt(int startKapasitet) {
		tab = new Medlem[startKapasitet];
		antallMedlemmer = 0;
	}

	public Medlem[] getTab() {
		return tab;
	}
	
	public int getAntallMedlemmer() {
		return antallMedlemmer;
	}

	public void leggTilMedlem(Medlem person) {
		if (antall() == tab.length) {
			utvid();
		}
		tab[antallMedlemmer] = person;
		antallMedlemmer++;
	}

	public int finnMedlemsIndeks(String medlemsnavn) {
		int index = 0;
		boolean funnet = false;
		if (erTom()) {
			return -1;
		} else {
			while (!funnet && index < antall()) {
				if (tab[index].getNavn().equals(medlemsnavn)) {
					funnet = true;
				} else {
					index++;
				}
			}
		}
		if (funnet) {
			return index;
		} else {
			return -1;
		}
	}

	public int finnPartnerFor(String medlemsnavn) {
		int medlemsIndex = finnMedlemsIndeks(medlemsnavn);
		int index = 0;
		boolean funnet = false;

		if (medlemsIndex < 0) {
			return -1;
		} else {
			while ((!funnet) && (index < antallMedlemmer)) {
				if ((tab[index].passerTil(tab[medlemsIndex])) && (index != medlemsIndex)) {
					tab[index].setStatusIndeks(tab[medlemsIndex].getStatusIndeks());
					tab[index].setStatusIndeks(medlemsIndex);
					tab[medlemsIndex].setStatusIndeks(index);
					funnet = true;
				} else {
					index++;
				}
			}
		}
		if (funnet) {
			return index;
		} else {
			return -1;
		}
	}

	public void tilbakestillStausIndeks(String medlemsnavn) {

		int medlemsIndex = finnMedlemsIndeks(medlemsnavn);
		int matcherIndex = finnPartnerFor(medlemsnavn);

		if (medlemsIndex > 0 && matcherIndex > 0) {
			tab[medlemsIndex].setStatusIndeks(-1);
			tab[matcherIndex].setStatusIndeks(-1);
		} else if (medlemsIndex > 0) {
			tab[medlemsIndex].setStatusIndeks(-1);
		}

	}

	private void utvid() {
		Medlem[] hjelpeTabell = new Medlem[tab.length * 2];
		for (int i = 0; i < tab.length; i++) {
			hjelpeTabell[i] = tab[i];
		}
		tab = hjelpeTabell;
	}

	public int antall() {
		return antallMedlemmer;
	}

	public boolean erTom() {
		return (antall() == 0);
	}

	public void skrivUt() {
		for (int i = 0; i < antallMedlemmer; i++) {
			tab[i].skrivUt();
			System.out.println();
		}
		System.out.println();
	}

}
