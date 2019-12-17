package es.mdef.acing;

public class Identificador {
	private int identificador;

	public Identificador(int i) {
		identificador = i;
	}

	public int getValor() {
		return identificador;
	}
	
	@Override
	public String toString() {
		return getValor() + "";
	}
	
}
