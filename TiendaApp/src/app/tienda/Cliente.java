package app.tienda;

import app.tienda.turno.GeneradorTurnos;
import app.tienda.turno.Turno;
import app.tienda.valor.Serializado;

public class Cliente<T extends Serializado<T>> {
	private Turno<T> turno;

	public Turno<T> getTurno() {
		return turno;
	}

	public void pedirTurno(GeneradorTurnos<T> generador) {
		turno = generador.cogerTurno();
	}

	@Override
	public String toString() {
		return "Cliente con " + turno;
	}
	
	

}
