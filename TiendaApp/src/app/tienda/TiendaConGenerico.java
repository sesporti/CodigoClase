package app.tienda;

import java.util.ArrayList;
import java.util.Collection;

import app.tienda.turno.GeneradorTurnos;
import app.tienda.turno.Turno;
import app.tienda.valor.Letra;

public class TiendaConGenerico {

	public static void main(String[] args) {
		GeneradorTurnos<Letra> generador = new GeneradorTurnos<>(new Letra("A"));
		Collection<Cliente<Letra>> clientes = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
		    clientes.add(new Cliente<>());
		}
		clientes.forEach(c -> {
		    c.pedirTurno(generador);
		    Turno<Letra> turno = c.getTurno();
		    if(turno.getValor().esPrimero()) {
		        System.err.println("Empezamos por " + turno);
		    }
		    else if(turno.getValor().esUltimo()) {
                System.err.println("Damos la vuelta en " + turno);
            }
		    System.out.println(c);
		});
	}

}
