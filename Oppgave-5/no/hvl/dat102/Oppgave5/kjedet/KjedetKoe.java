package no.hvl.dat102.Oppgave5.kjedet;

import no.hvl.dat102.Oppgave5.adt.*;
import no.hvl.dat102.Oppgave5.exception.*;

public class KjedetKoe<T> implements KoeADT<T> {

	private LinearNode<T> front;
	private LinearNode<T> bak;
	private int antall;

	public KjedetKoe() {
		front = null;
		bak = null;
		antall = 0;
	}

	public void innKoe(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);

		if (erTom()) {
			front = nyNode;
		} else {
			bak.setNeste(nyNode);
		}
		bak = nyNode;
		antall++;
	}

	public T utKoe() {
		if (erTom()) {
			throw new EmptyCollectionException("koe");
		}
		T resultat = front.getElement();
		front = front.getNeste();
		antall--;

		if (erTom()) {
			bak = null;
		}
		return resultat;
	}

	public T foerste() {
		if (erTom()) {
			throw new EmptyCollectionException("koe");
		}
		return (front.getElement());
	}

	public boolean erTom() {
		return (antall == 0);
	}

	public int antall() {
		return antall;
	}

}
