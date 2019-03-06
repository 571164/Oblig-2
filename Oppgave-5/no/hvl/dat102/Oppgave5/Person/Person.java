package no.hvl.dat102.Oppgave5.Person;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int fødselsår;

	public Person() {
		this("", "", 0);
	}

	public Person(String fornavn, String etternavn, int fødselsår) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fødselsår = fødselsår;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public int getFødselsår() {
		return fødselsår;
	}

	public void setFødselsår(int fødselsår) {
		this.fødselsår = fødselsår;
	}

	public String toString() {
		return (fødselsår + " " + etternavn + ", " + fornavn);
	}

	
	public int compareTo(Person denAndre) {
		int resultat = 0;

		// Skjekker fødselsår
		if (fødselsår < denAndre.getFødselsår()) {
			resultat = -1;
		} else if (fødselsår == denAndre.getFødselsår()) {
			resultat = 0;
		} else {
			resultat = 1;
		}

		// Skjekker etternavn
		if (resultat == 0) {
			if (etternavn.compareTo(denAndre.getEtternavn()) < 0) {
				resultat = -1;
			} else if (etternavn.compareTo(denAndre.getEtternavn()) == 0) {
				resultat = 0;
			} else {
				resultat = 1;
			}
		}

		// Skjekker fornavn
		if (resultat == 0) {
			if (fornavn.compareTo(denAndre.getFornavn()) < 0) {
				resultat = -1;
			} else if (fornavn.compareTo(denAndre.getFornavn()) == 0) {
				resultat = 0;
			} else {
				resultat = 1;
			}
		}
		return resultat;
	}

}
