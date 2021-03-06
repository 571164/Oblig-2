package no.hvl.dat102.datakontaktfirma;

public class Hobby {

	private String hobbyNavn;

	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}

	public boolean equals(Object hobby2) { //
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}

	public void setHobbyNavn(String hobbyNavn) {
		this.hobbyNavn = hobbyNavn;
	}

	public String getHobbyNavn() {
		return hobbyNavn;
	}

	public String toString() {
		return ("<" + hobbyNavn + ">");
	}

}
