package no.hvl.dat102.datakontaktfirma;

import no.hvl.dat102.mengde.kjedet2.*;
import no.hvl.dat102.mengde.tabell2.*;
import no.hvl.dat102.mengde.adt.*;
import java.util.Iterator;

public class Medlem {

	private String navn;
	private MengdeADT<Hobby> hobbyer; // Eller TabellMengde
	private int statusIndeks;

	public Medlem() {
		navn = "";
		hobbyer = null;
		statusIndeks = -1;
	}

	public Medlem(String navn, int statusIndeks) {
		this.navn = navn;
		hobbyer = null;
		hobbyer = new KjedetMengde<Hobby>();
		this.statusIndeks = statusIndeks;
	}

	public boolean passerTil(Medlem medlem2) {
		return this.getHobbyer().equals(medlem2.getHobbyer());
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	public void skrivUt() {
		Iterator<Hobby> iterator = hobbyer.oppramser();

		System.out.println("Navn: " + navn);
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
		System.out.println("Status: " + statusIndeks);

	}
}
