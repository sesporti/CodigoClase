package app.tienda.turno;

import java.util.Map;
import java.util.function.Function;

import app.tienda.valor.Serializado;

/**Clase que se utiliza para generar turnos
 * 
 * @author profesor
 * @param <T>
 *
 */
public class GeneradorTurnos<T extends Comparable<T> & Serializado<T>>  {
	private Turno<T> ultimoTurno;
	
	public Turno<T> getUltimoTurno() {
		return ultimoTurno;
	}

	private Turno<T> generarTurno(T valor) {
		return new Turno<>(valor);
	}

	public Turno<T> cogerTurno() {
		T valorUltimoTurno = getUltimoTurno().getValor();
		T valorSiguiente = valorUltimoTurno.siguiente(valorUltimoTurno);
		return generarTurno(valorSiguiente);
	}
	
}
