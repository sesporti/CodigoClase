package es.mdef.acing;

public class Identificador<T extends Comparable<T>> implements Comparable<Identificador<T>> {
	private T identificador;

	public Identificador(T id) {
		identificador = id;
	}

	public T getValor() {
		return identificador;
	}
	
	@Override
	public String toString() {
		return getValor() + "";
	}

	@Override
	public int compareTo(Identificador<T> id) {
		return this.getValor().compareTo(id.getValor());
	}
	
}
