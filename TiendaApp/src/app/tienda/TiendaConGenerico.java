package app.tienda;

import java.util.ArrayList;
import java.util.Collection;

import app.tienda.turno.GeneradorTurnos;
import app.tienda.turno.Turno;
import app.tienda.valor.Letra;
import app.tienda.valor.LetraYNumero;
import app.tienda.valor.Numero;
import app.tienda.valor.Serializado;

public class TiendaConGenerico {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		GeneradorTurnos<Numero> generador = new GeneradorTurnos<>(Numero.class);//new Numero(48) ;

//			@Override
//			public Numero primero() {
//				return new Numero(30);
//			}
//
//			@Override
//			public Numero ultimo() {
//				return new Numero(50);
//			}
//			
//		});
		
		Collection<Turno<Numero>> misTurnos = new ArrayList<>();
		for (int i = 0; i < 500; i++) {
			misTurnos.add(generador.cogerTurno());
		}
		misTurnos.forEach(System.out::println);
		
		System.out.println("\n---Turnos Letras---");
		GeneradorTurnos<Letra> generadorLetras = new GeneradorTurnos<>(Letra.class);
		Collection<Turno<Letra>> misTurnosLetra = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			misTurnosLetra.add(generadorLetras.cogerTurno());
		}
		misTurnosLetra.forEach(System.out::println);
		
		System.out.println("\n---Turnos Combinados---");
		GeneradorTurnos<LetraYNumero> generadorLetraYNumero = new GeneradorTurnos<>(new LetraYNumero("C", 97));
		Collection<Turno<LetraYNumero>> misTurnosLetraYNumero = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			misTurnosLetraYNumero.add(generadorLetraYNumero.cogerTurno());
		}
		misTurnosLetraYNumero.forEach(System.out::println);
	}

}
