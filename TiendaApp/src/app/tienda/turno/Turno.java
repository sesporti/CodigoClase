package app.tienda.turno;

public class Turno<T extends Comparable<T>> {

	private final T valor;

	public T getValor() {
		new Turno<String>("");
		return valor;
	}

//	private void setValor(int valor) {
//		this.valor = valor;
//	}
	
	Turno(T valor) {
//		setValor(valor);
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Turno " + getValor();
	}

}
