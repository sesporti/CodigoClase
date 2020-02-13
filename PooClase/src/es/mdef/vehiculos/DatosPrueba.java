package es.mdef.vehiculos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import es.mdef.comun.Coloreable;

public class DatosPrueba {

	public static Vehiculo[] flota = new Vehiculo[] {
			new Coche("Azul", "Seat Ibiza"),
			new Moto("Negra", "Suzuki"),
			new Vehiculo(Coloreable.ROJO, "Ford Fiesta"),
			new VehiculoConRuedas("Rosa", "Patinete") {
				
				@Override
				public int getNumeroDeRuedas() {
					return 2;
				}
			},
			new VehiculoConRuedas("Colorao", "Triciclo") {
				int numeroPlazas = 2;
				
				@Override
				public String getColor() {
					return "Marron";
				}
				
				private int getNumeroPlazas() {
					return numeroPlazas;
				}
				
				@Override
				public String toString() {
					return super.toString() + " plazas: " + getNumeroPlazas();
				}
				
				@Override
				public int getNumeroDeRuedas() {
					return 3;
				}
			}
	};
	
	public static Collection<Vehiculo> vehiculos;
	
	static {
		vehiculos = Arrays.asList(flota);
//		vehiculos = new ArrayList<Vehiculo>();
		vehiculos.add(new Coche("MORADO"));
	}
}
