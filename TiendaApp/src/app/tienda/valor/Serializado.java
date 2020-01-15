package app.tienda.valor;

public interface Serializado<T> extends Comparable<T> {
	
    T siguiente();
    T primero();
	T ultimo();
	
	default boolean esPrimero() {
	    return this.equals(this.primero());
	}
	
	default boolean esUltimo() {
        return this.equals(this.ultimo());
    }
	
	@Override
	default int compareTo(T o) {
		return this.compareTo(o);
	}
}
