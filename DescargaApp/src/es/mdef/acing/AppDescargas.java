package es.mdef.acing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AppDescargas {

	public static void main(String[] args) {
		
		List<Descargable> misDescargas = new ArrayList<Descargable>(); 
		Contenido cancion1 = new Contenido(new Identificador(1), "thunder");
		Contenido pelicula1 = new Contenido(new Identificador(2), "La chaqueta metálica");
		
		
		misDescargas.add(new DescargableImpl(12.5, cancion1));
		misDescargas.add(new DescargableImpl(278.0, pelicula1));
		misDescargas.add(new DescargableImpl(728.5, pelicula1));
		misDescargas.add(new DescargableImpl(null, cancion1));
		
		//ordenarListaDescarga(misDescargas);
		//misDescargas.sort(Descargable.COMPARADOR_POR_TAMANO);
		misDescargas.forEach(System.out::println);
		
		
		//System.out.println("El total de megas es: " + calcularTamanoDescarga(misDescargas));
		System.out.println("El tiempo para la descarga es: "
		+ calcularTiempoDescarga(misDescargas, new Conexion() {
			@Override
			public Double getVelocidad() { return 3.5; }
			
			@Override
			public String getNombreConexion() { return "Mi conexión"; }
		}));
	}
	
	protected static void ordenarListaDescarga (List<Descargable> listaDescargable) {
		Collections.sort(listaDescargable, Descargable.COMPARADOR);
	}
		
	/**Calcula el tamaño total de megas para las descargas en el parámetro
	 * listaDescargable
	 * @param listaDescargable Colección de descargas
	 * @return Tamaño total en megas
	 * @throws Exception si el tamaño de al menos una descarga es null
	 */
	protected static double calcularTamanoDescarga(Collection<Descargable> listaDescargable) throws Exception {
		double totalMegas = 0;
		for (Descargable descargable : listaDescargable) {
			Double tamanoDescarga = descargable.getTamanoMegas();
			if (tamanoDescarga == null) {
				throw new Exception("Hay una descarga con tamaño null");
			} else {
				totalMegas += tamanoDescarga;
			}
			
		}
		return totalMegas;
	}
	/** Es lo mismo que llamar a tamano/conexion.getVelocidad()
	 * @param tamano se debe pasar en megas
	 * @param conexion se debe pasar en megas/segundos
	 * @return devuelve segundos
	 */
	private static double calcularTiempoDescarga(double tamano, Conexion conexion) {
		return tamano/conexion.getVelocidad();
	}
	protected static double calcularTiempoDescarga(Collection<Descargable> descargables, Conexion conexion) {
		double tiempoTotal;
		try {
			tiempoTotal = calcularTiempoDescarga(calcularTamanoDescarga(descargables), conexion);
		} catch (Exception e) {
			tiempoTotal = -1;
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return tiempoTotal;
	}

}
