package app.tienda.valor;

public class LetraYNumero implements Serializado<LetraYNumero> {
	Serializado<String> letra;
	Numero numero;
//	ColorSerializado color;
	
	@Override
	public LetraYNumero primero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LetraYNumero siguiente() {
		LetraYNumero siguiente = new LetraYNumero();
		siguiente.numero = this.numero.siguiente();
//		siguiente.letra = this.letra.siguiente();
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
