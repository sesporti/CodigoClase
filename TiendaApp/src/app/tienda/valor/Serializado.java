package app.tienda.valor;

public interface Serializado<T> extends Comparable<T> {
	
	static <S> boolean comprobarMaximo(Serializado<S> serializado, Serializado<? extends S> modelo) {
		return serializado.equals(modelo.ultimo());
	}
	
	static <S> boolean comprobarMaximo(Serializado<S> serializado) {
		return comprobarMaximo(serializado, serializado);
	}
	
	T primero();
	T siguiente();
	T ultimo();
	
	@Override
	default int compareTo(T o) {
		return this.compareTo(o);
	}
}
