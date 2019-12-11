package es.mdef.vehiculos;

import es.mdef.comun.Coloreable;
import es.mdef.comun.Mueble;

public class PracticarConDistintosTipos {

	public static void main(String[] args) {
		Object[] objetos = new Object[] { 3, true, "Hola" };
		
		String colorEnEsteAmbito = "Marrón";
		
		Coloreable[] flota = new Coloreable[] {
				DatosPrueba.flota[0],
				DatosPrueba.flota[1],
				DatosPrueba.flota[2],
				DatosPrueba.flota[3],
				DatosPrueba.flota[4],
				new Coloreable() {
					
					@Override
					public String getColor() {
						return "Verde";
					}
				},
				new Mueble("Ceniza")
		};
		
		Coloreable triciclo = flota[4];
//		System.err.println(triciclo.getNumeroPlazas());
		
		Coche[] coches = new Coche[] {
				(Coche) flota[0],
				new Coche("Verde", "Citroen AX")//,
//				(Coche) flota[2]
		};
		coches[1].matricula = "9834 KDT";
		((Coche)flota[0]).matricula = "2346 FTG";
		
//		int numeroPintado = cambiarColorDeFlota(flota, "rojo");
//		imprimirArray(flota);
		imprimirLineasDeLaFlota(flota);
//		System.out.println("Se han pintado " + numeroPintado + " vehiculos.");
//		imprimirMatriculasDeLaFlota(coches);
	}

	public static void imprimirArray(Object[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void imprimirLineasDeLaFlota(Coloreable[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(i+1 + " " + lineaImpresionVehiculo(array[i]) + " Color: " + array[i].getColor());//array[i].getColor());
		}
	}
	
	private static String lineaImpresionVehiculo(Coloreable vehiculo) {
		return "Vehiculo: " + vehiculo.toString() + " => " + vehiculo.getClass().getName();//.getSimpleName();
	}
	
	public static void imprimirMatriculasDeLaFlota(Coche[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].matricula);
		}
	}
	
	public static int cambiarColorDeFlota(Vehiculo[] flota, String color) {
		int contador = 0;
		for (Vehiculo vehiculo : flota) {
			if(Vehiculo.pintarVehiculo(vehiculo, color) != null) {
				contador++;
			}
		}
		
		return contador;
	}
	
}
