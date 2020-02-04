package app.tienda.valor;

public class Numero implements Serializado<Numero> {
	public static boolean comprobarMaximo(Numero serializado) {
		return serializado.equals(serializado.ultimo().getClass().getTypeParameters()[0].getClass());
	}
	
	private static final Numero ULTIMO = new Numero(99);
	private static final Numero PRIMERO = new Numero(0);
	private final int entero;
	
	public Numero(int entero) {
		this.entero = entero;
	}

	public static Numero siguiente(Numero actual) {
		return new Numero(actual.entero + 1);
	}

	@Override
	public Numero primero() {
		return PRIMERO;
	}

	@Override
	public Numero siguiente() {
		return siguiente(this);
	}
	
	@Override
	public Numero ultimo() {
		return ULTIMO;//new Numero(99);
	}

	@Override
	public String toString() {
		return "Numero " + entero;
	}

}
