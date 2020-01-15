package app.tienda.valor;

public interface Serializado<T> extends Comparable<T> {
	
	T siguiente(T actual);
	
	@Override
	default int compareTo(T o) {
		return this.compareTo(o);
	}
}
