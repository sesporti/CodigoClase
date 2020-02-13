package app.tienda.turno;

import app.tienda.valor.Numero;
import app.tienda.valor.Serializado;

/**Clase que se utiliza para generar turnos
 * 
 * @author profesor
 * @param <T>
 *
 */
public class GeneradorTurnos<T extends Comparable<T> & Serializado<T>> {
	/**
	 * Es el ultimo turno generado
	 */
	private Turno<T> ultimoTurno;
	private T modeloDeSerie;
	
	public Turno<T> getUltimoTurno() { 
		return ultimoTurno;
	}

	private void setUltimoTurno(Turno<T> ultimoTurno) {
		this.ultimoTurno = ultimoTurno;
	}

	private T getModeloDeSerie() {
		return modeloDeSerie;
	}

	public GeneradorTurnos(Class<T> tipo) throws InstantiationException, IllegalAccessException {
		this(tipo.newInstance());
	}
	
	public GeneradorTurnos(T modelo) {
		generarTurno(modelo);
		modeloDeSerie = modelo;
	}
	
	/**Genera un turno y actualiza el ultimoTurno
	 * @param valor T que envuelve el turno
	 * @return Devuelve el ultimoTurno
	 */
	private Turno<T> generarTurno(T valor) {
		setUltimoTurno(new Turno<>(valor));
		return getUltimoTurno();
	}

	public Turno<T> cogerTurno() {
		T valorUltimoTurno = getUltimoTurno().getValor();
		T valorSiguiente;
		if (Serializado.comprobarMaximo(valorUltimoTurno, getModeloDeSerie())) {
			valorSiguiente = getModeloDeSerie().primero();
		}
		else {
			valorSiguiente = valorUltimoTurno.siguiente();
		}
		
		return generarTurno(valorSiguiente);
	}
	
//	private boolean comprobarMaximo(Serializado<T> serializado) {
//		return serializado.equals(getModeloDeSerie().ultimo());
//	}
}
