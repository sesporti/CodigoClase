package app.tienda.turno;

/**Clase que se utiliza para generar turnos
 * 
 * @author profesor
 *
 */
public class GeneradorTurnos {
	
	Turno<Integer> ultimoTurnoInteger;
	Turno<String> ultimoTurnoString;
	
	public <T extends Comparable<T>, K extends Comparable<K>> Turno<T> generarTurno (T valor) {
		Turno<K> ultimoTurno = getUltimoTurno();
		return new Turno<>(valor);
	}

	public <T extends Comparable<T>> Turno<T> getUltimoTurno () {
		
		return null;
	}

	
}
