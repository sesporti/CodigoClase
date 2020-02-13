package es.mdef.vehiculos;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class EjemploComparacion {

	public static void main(String[] args) {
		Collection<Vehiculo> misVehiculos = DatosPrueba.vehiculos;
		
		Vehiculo[] flota = DatosPrueba.flota;
		Consumer<Vehiculo> consumer = new Consumer<Vehiculo>() {
			@Override
			public void accept(Vehiculo t) {
				System.out.println(t);
			}
		};
		consumer = o -> System.out.println(o);
		Arrays.asList(flota).forEach(System.out::println);
		Arrays.sort(flota);
		
		System.out.println("\nDespués de ordenarlo por color (orden natural)");
		Arrays.asList(flota).forEach(System.out::println);
		
		Comparator<Vehiculo> comparadorVehiculos = new Comparator<Vehiculo>() {
			@Override
			public int compare(Vehiculo v1, Vehiculo v2) {
				return v1.getModelo().compareTo(v2.getModelo());
			}
		};
		
		System.out.println("\nDespués de ordenarlo por modelo");
		Arrays.sort(flota, comparadorVehiculos);
		Arrays.asList(flota).forEach(System.out::println);
		
		System.out.println("\nDespués de ordenarlo tamaño del color en letras");
		List<Vehiculo> vehiculos = Arrays.asList(flota);
		vehiculos.sort((v1, v2) -> v1.getColor().length() - v2.getColor().length());
		vehiculos.forEach(System.out::println);
		
		vehiculos.sort(null);
		vehiculos.forEach(System.out::println);
	}

}
