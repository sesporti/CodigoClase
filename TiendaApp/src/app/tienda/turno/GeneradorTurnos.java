package app.tienda.turno;

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

	private void setUltimoTurno(Turno<T> ultimoTurno) {
        this.ultimoTurno = ultimoTurno;
    }
	
	public GeneradorTurnos(Class<T> tipoValor) {
        super();
        try {
            this.ultimoTurno = new Turno<>(tipoValor.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
	
	public GeneradorTurnos(T ultimoServido) {
        super();
        this.ultimoTurno = new Turno<>(ultimoServido);
    }

    private Turno<T> generarTurno(T valor) {
		return new Turno<>(valor);
	}

	public Turno<T> cogerTurno() {
		T valorUltimoTurno = getUltimoTurno().getValor();
		if(valorUltimoTurno.equals(valorUltimoTurno.ultimo())) {
		    setUltimoTurno(generarTurno(valorUltimoTurno.primero()));
		}
		else {
		    T valorSiguiente = valorUltimoTurno.siguiente();
		    setUltimoTurno(generarTurno(valorSiguiente));
		}
		return getUltimoTurno();
	}
	
}
