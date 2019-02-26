package no.hvl.dat102.mengde.kjedet;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;
import no.hvl.dat102.mengde.adt.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (!erTom()) {
			int valg = rand.nextInt(antall) + 1;
			if (valg == 1) {
				resultat = start.getElement();
				start = start.getNeste();
			} else {
				forgjenger = start;
				for (int nr = 2; nr < valg; nr++) {
					forgjenger = forgjenger.getNeste();
				}
				aktuell = forgjenger.getNeste();
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste());
			}
			antall--;
		} // if
		return resultat;
	}//

	@Override
	public T fjern(T element) {
		boolean funnet = false;
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;

		if (!erTom()) {
			if (start.getElement().equals(element)) {
				resultat = start.getElement();
				start = start.getNeste();
			} else {
				forgjenger = start;
				aktuell = start.getNeste();

				for (int i = 0; i < antall && (!funnet); i++) {
					if (aktuell.getElement().equals(element)) {
						funnet = true;
					} else {
						forgjenger = aktuell;
						aktuell = aktuell.getNeste();
					}
				}

				if (funnet) {
					resultat = aktuell.getElement();
					forgjenger.setNeste(aktuell.getNeste());
					antall--;
				}
			}
			return resultat;
		}

		return resultat;
	}//

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;

		while (aktuell != null) {
			begge.leggTil(aktuell.getElement());
			aktuell = aktuell.getNeste();
		} // while
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		return begge;
	}//

	public MengdeADT<T> effektivUnion(MengdeADT<T> m2) {
		MengdeADT<T> begge = new KjedetMengde<T>();
		Iterator<T> iterator = oppramser();
		T element = null;
		while (iterator.hasNext()) {
			element = iterator.next();
			((KjedetMengde<T>) begge).settInn(element);
		}
		Iterator<T> iterator2 = m2.oppramser();
		T element2 = null;
		while (iterator2.hasNext()) {
			element2 = iterator2.next();
			if (!inneholder(element2)) {
				((KjedetMengde<T>) begge).settInn(element2);
			}
		}
		return begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new KjedetMengde<T>();
		T element;

		Iterator<T> iterator = m2.oppramser();

		while (iterator.hasNext()) {
			element = iterator.next();
			if (this.inneholder(element)) {
				((KjedetMengde<T>) snittM).settInn(element);
			}
		}
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new KjedetMengde<T>();
		T element;
		Iterator<T> iterator = this.oppramser();
		while (iterator.hasNext()) {
			element = iterator.next();
			if (!m2.inneholder(element)) {
				((KjedetMengde<T>) differensM).settInn(element);
			}
		}
		return differensM;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		boolean likeMengder = true;
		T element = null;

		if (antall() == m2.antall()) {

			Iterator<T> iterator = m2.oppramser();
			while (iterator.hasNext() && likeMengder) {
				element = iterator.next();
				if (!this.inneholder(element)) {
					likeMengder = false;
				}
			}
		} else {
			likeMengder = false;
		}
		return likeMengder;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		// Fyll ut
		return erUnderMengde;
	}

	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	// -------------TEST------------------
	public void skrivUt() {
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			System.out.print(aktuell.getElement() + " ");
			aktuell = aktuell.getNeste();
		}
		System.out.println();
	}

	/******************************************************************
	 * Returnerer en streng som representerer mengden.
	 ******************************************************************/
	public String toString() {// For klassen KjedetMengde
		String resultat = "";
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			resultat += aktuell.getElement().toString() + "\t";
			aktuell = aktuell.getNeste();
		}
		return resultat;
	}

}// class