package app.tienda.valor;

public class LetraYNumero implements Serializado<LetraYNumero> {
	Letra letra;
	Numero numero;
//	ColorSerializado color;
	
	public LetraYNumero() {
		this("" + Letra.LETRAS_VALIDAS.charAt(0), 0);
	}
	
	public LetraYNumero(String letra, int numero) {
		this.letra = new Letra(letra);
		this.numero = new Numero(numero);
	}
	
	@Override
	public LetraYNumero primero() {
		// TODO Auto-generated method stub
		return new LetraYNumero();
	}

	@Override
	public LetraYNumero siguiente() {
		LetraYNumero siguiente = new LetraYNumero();
		if (Serializado.comprobarMaximo(numero)) {
			siguiente.numero = numero.primero();
			if (Serializado.comprobarMaximo(letra)) {
				siguiente.letra = letra.primero();
			}
			else {
				siguiente.letra = letra.siguiente();
			}
		}
		else {
			siguiente.numero = numero.siguiente();
			siguiente.letra = letra;
		}
//		siguiente.color = this.color.siguiente();
		return siguiente;
	}

	@Override
	public LetraYNumero ultimo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "" + letra + numero;
	}

}
