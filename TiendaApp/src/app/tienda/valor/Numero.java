package app.tienda.valor;

public class Numero implements Serializado<Integer> {

	@Override
	public Integer siguiente(Integer actual) {
		return ++actual;
	}

}
