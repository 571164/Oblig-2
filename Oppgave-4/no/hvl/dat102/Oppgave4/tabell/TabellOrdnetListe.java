package no.hvl.dat102.Oppgave4.tabell;

import no.hvl.dat102.Oppgave4.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		T resultat = liste[bak - 1];
		bak--;
		liste[bak] = null;
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom()) {
			return null;
		}
		T resultat = liste[0];

		for (int i = 0; i < bak - 1; i++) {
			liste[i] = liste[i + 1];
		}
		bak--;

		return resultat;
	}

	@Override
	public T foerste() {
		T resultat = null;
		if (!erTom()) {
			resultat = liste[0];
		}
		return resultat;
	}

	@Override
	public T siste() {
		T resultat = null;
		// ...Fyll ut

		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	public void leggTil(T element) {
		if (antall() == liste.length) {
			utvid();
		}
		int i = bak;

		while ((i > 0) && (liste[i - 1].compareTo(element) > 0)) {
			liste[i] = liste[i - 1];
			i--;
		}
		bak++;
		liste[i] = element;
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		T resultat = null;
		int indeks = finn(element);

		if (indeks >= 0) {
			resultat = liste[indeks];
			bak--;

			for (int i = indeks; i < bak; i++) {
				liste[i] = liste[i + 1];
			}
		}
		return resultat;
	}

	private int finn(T el) {
		int i = 0;
		int resultat = IKKE_FUNNET;

		if (!erTom()) {
			while (i < bak && el.compareTo(liste[i]) > 0) {
				i++;
			}
			if (i < bak && el.compareTo(liste[i]) == 0) {
				resultat = i;
			}
		}
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class