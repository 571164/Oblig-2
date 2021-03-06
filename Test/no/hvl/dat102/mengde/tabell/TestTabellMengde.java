package no.hvl.dat102.mengde.tabell;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.*;

class TestTabellMengde {

	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;

	public void setupFellesElementer() {
		m1 = new TabellMengde<Integer>();
		m2 = new TabellMengde<Integer>();

		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		m1.leggTil(4);
		m1.leggTil(5);

		m2.leggTil(3);
		m2.leggTil(4);
		m2.leggTil(5);
		m2.leggTil(6);
		m2.leggTil(7);
	}

	public void setupIngenFellesElementer() {
		m1 = new TabellMengde<Integer>();
		m2 = new TabellMengde<Integer>();

		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		m1.leggTil(4);
		m1.leggTil(5);

		m2.leggTil(6);
		m2.leggTil(7);
		m2.leggTil(8);
		m2.leggTil(9);
		m2.leggTil(10);
	}

	@Test
	void testUnionFellesElementer() {
		setupFellesElementer();
		MengdeADT<Integer> begge = new TabellMengde<Integer>();
		MengdeADT<Integer> fasit = new TabellMengde<Integer>();
		fasit.leggTil(1);
		fasit.leggTil(2);
		fasit.leggTil(3);
		fasit.leggTil(4);
		fasit.leggTil(5);
		fasit.leggTil(6);
		fasit.leggTil(7);
		begge = m1.union(m2);
		assertTrue("Skjekker om begge er lik fasit", begge.equals(fasit));
	}

	@Test
	void testUnionIngenFellesElementer() {
		setupIngenFellesElementer();
		MengdeADT<Integer> begge = new TabellMengde<Integer>();
		MengdeADT<Integer> fasit = new TabellMengde<Integer>();
		fasit.leggTil(1);
		fasit.leggTil(2);
		fasit.leggTil(3);
		fasit.leggTil(4);
		fasit.leggTil(5);
		fasit.leggTil(6);
		fasit.leggTil(7);
		fasit.leggTil(8);
		fasit.leggTil(9);
		fasit.leggTil(10);
		begge = m1.union(m2);
		assertTrue("Skjekker om begge er lik fasit", begge.equals(fasit));
	}

	@Test
	void testSnittFellesElementer() {
		setupFellesElementer();
		MengdeADT<Integer> snitt = new TabellMengde<Integer>();
		MengdeADT<Integer> fasit = new TabellMengde<Integer>();
		fasit.leggTil(3);
		fasit.leggTil(4);
		fasit.leggTil(5);
		snitt = m1.snitt(m2);
		assertTrue("Skjekker om snitt er lik fasit", snitt.equals(fasit));
	}

	@Test
	void testSnittIngenFellesElementer() {
		setupIngenFellesElementer();
		MengdeADT<Integer> snitt = new TabellMengde<Integer>();
		MengdeADT<Integer> fasit = new TabellMengde<Integer>();
		snitt = m1.snitt(m2);
		assertTrue("Skjekker om snitt er lik fasit", snitt.equals(fasit));
	}

	@Test
	void testDifferensFellesElementer() {
		setupFellesElementer();
		MengdeADT<Integer> differens = new TabellMengde<Integer>();
		MengdeADT<Integer> fasit1 = new TabellMengde<Integer>();
		fasit1.leggTil(1);
		fasit1.leggTil(2);

		MengdeADT<Integer> fasit2 = new TabellMengde<Integer>();
		fasit2.leggTil(6);
		fasit2.leggTil(7);

		differens = m1.differens(m2);
		assertTrue("Skjekker m1 minus m2", differens.equals(fasit1));

		differens = m2.differens(m1);
		assertTrue("Skjekker m2 minus m1", differens.equals(fasit2));
	}

	@Test
	void testDifferensIngenFellesElementer() {
		setupIngenFellesElementer();
		MengdeADT<Integer> differens = new TabellMengde<Integer>();
		MengdeADT<Integer> fasit1 = new TabellMengde<Integer>();
		fasit1.leggTil(1);
		fasit1.leggTil(2);
		fasit1.leggTil(3);
		fasit1.leggTil(4);
		fasit1.leggTil(5);

		MengdeADT<Integer> fasit2 = new TabellMengde<Integer>();
		fasit2.leggTil(6);
		fasit2.leggTil(7);
		fasit2.leggTil(8);
		fasit2.leggTil(9);
		fasit2.leggTil(10);

		differens = m1.differens(m2);
		assertTrue("Skjekker m1 minus m2", differens.equals(fasit1));

		differens = m2.differens(m1);
		assertTrue("Skjekker m2 minus m1", differens.equals(fasit2));
	}
}
