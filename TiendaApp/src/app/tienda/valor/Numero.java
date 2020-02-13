package app.tienda.valor;

public class Numero implements Serializado<Numero> {
	public static boolean comprobarMaximo(Numero serializado) {
		return serializado.equals(serializado.ultimo().getClass().getTypeParameters()[0].getClass());
	}
	
	private static final Numero ULTIMO = new Numero(99);
	private static final Numero PRIMERO = new Numero();
	private final int entero;
	
	public Numero() {
		this(0);
	}
	
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
		return "" + entero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + entero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Numero other = (Numero) obj;
		if (entero != other.entero)
			return false;
		return true;
	}

}
