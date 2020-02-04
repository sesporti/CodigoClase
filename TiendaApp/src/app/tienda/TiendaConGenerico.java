package app.tienda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import app.tienda.turno.GeneradorTurnos;
import app.tienda.turno.Turno;
import app.tienda.valor.LetraYNumero;
import app.tienda.valor.Numero;
import app.tienda.valor.Serializado;

public class TiendaConGenerico {

	public static void main(String[] args) {
		GeneradorTurnos<Numero> generador = new GeneradorTurnos<>(new Numero(10) {

			@Override
			public Numero ultimo() {
				return new Numero(50);
			}
			
		});
		
		Serializado.comprobarMaximo(new Numero(0));//new LetraYNumero());
		Numero.comprobarMaximo(new Numero(0));
		
		GeneradorTurnos<LetraYNumero> generador2 = new GeneradorTurnos<>(null);
		
		Collection<Turno<Numero>> misTurnos = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			misTurnos.add(generador.cogerTurno());
		}
		misTurnos.forEach(System.out::println);
	}

}
