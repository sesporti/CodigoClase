package es.mdef.vehiculos;

import java.util.ArrayList;
import java.util.Collection;

import es.mdef.comun.Arrancable;
import es.mdef.comun.Ordenador;

public class EjemploArrancables {

	public static void main(String[] args) {
		Arrancable persona = new Arrancable() {
			int numeroCafes = 0;
			
			boolean isDespierto() {
				return numeroCafes >= 3;
			}
			
			@Override
			public boolean arrancar() {
				numeroCafes++;
				System.out.println("Me tomo un café. En total: " + numeroCafes);
				return isDespierto();
			}
			
			@Override
			public String toString() {
				return "Estoy " + ((isDespierto())?"despierto":"dormido");
			}
		};
		
		Collection<Arrancable> arrancables = new ArrayList<>();
		arrancables.add(new Coche("Morado", "Polo"));
		arrancables.add((Coche) DatosPrueba.flota[0]);
		arrancables.add(new Ordenador());
		arrancables.add(persona);
		arrancables.add((Moto) DatosPrueba.flota[1]);
		arrancables.remove(DatosPrueba.flota[0]);
		
		System.out.println(arrancables);
		arrancarTodo(arrancables);
		System.out.println("Después de arrancar");
		arrancables.forEach(System.out::println);
	}

	static void arrancarTodo(Collection<Arrancable> arrancables) {
		for(Arrancable a : arrancables) {
			boolean arrancado = false;
			do {
				if(arrancado) {
					System.out.println(">>> Se ha conseguido arrancar " + a);
				}
				else {
					System.out.println(">>> NO se ha conseguido arrancar " + a);
				}
			} while(!(arrancado = a.arrancar()));
		}
	}
}
