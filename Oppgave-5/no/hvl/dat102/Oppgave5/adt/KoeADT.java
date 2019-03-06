package no.hvl.dat102.Oppgave5.adt;

public interface KoeADT<T> {

	public void innKoe(T element);

	public T utKoe();

	public T foerste();

	public boolean erTom();

	public int antall();

}
