package app.tienda;

import app.tienda.turno.GeneradorTurnos;
import app.tienda.valor.Numero;

public class TiendaConGenerico {

	public static void main(String[] args) {
		GeneradorTurnos<Numero> generador = new GeneradorTurnos<>();
	}

}
