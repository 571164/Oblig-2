package no.hvl.dat102.Oppgave5.sirkulaer;

import no.hvl.dat102.Oppgave5.adt.*;
import no.hvl.dat102.Oppgave5.exception.*;

public class SirkulaerKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
	private int front;
	private int bak;
	private int antall;
	private T[] koe;

	public SirkulaerKoe() {
		koe = (T[]) (new Object[STDK]);
		front = 0;
		bak = 0;
		antall = 0;
	}

	public SirkulaerKoe(int startKapasitet) {
		koe = (T[]) (new Object[startKapasitet]);
		front = 0;
		bak = 0;
		antall = 0;
	}

	public void innKoe(T element) {
		if (antall() == koe.length) {
			utvid();
		}
		koe[bak] = element;
		bak = (bak + 1) % koe.length;
		antall++;
	}

	public T foerste() {
		if (erTom()) {
			throw new EmptyCollectionException("sirkulaer-koe");
		}
		return (koe[front]);

	}

	public T utKoe() {
		if (erTom()) {
			throw new EmptyCollectionException("sirkulaer-koe");
		}
		T resultat = koe[front];
		front = (front + 1) % koe.length;
		antall--;
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Object[koe.length * 2]);
		for (int i = 0; i < koe.length; i++) {
			hjelpeTabell[i] = koe[i];
		}
		koe = hjelpeTabell;
	}

	public int antall() {
		return antall;
	}

	public boolean erTom() {
		return (antall == 0);
	}

}
