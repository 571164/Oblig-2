package no.hvl.dat102.Oppgave5.exception;

public class EmptyCollectionException extends RuntimeException {

	public EmptyCollectionException(String samling) {
		super("Denne " + samling + " er tom");
	}

}
