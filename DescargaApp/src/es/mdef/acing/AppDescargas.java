package es.mdef.acing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppDescargas {

	public static void main(String[] args) {
		
		Collection<Descargable> misDescargas = new ArrayList<Descargable>(); 
		Contenido cancion1 = new Contenido(new Identificador(1), "thunder");
		Contenido pelicula1 = new Contenido(new Identificador(2), "La chaqueta metálica");
		
		
		misDescargas.add(new DescargableImpl(12.5, cancion1));
		misDescargas.add(new DescargableImpl(278.0, pelicula1));
		misDescargas.add(new DescargableImpl(128.5, pelicula1));
		misDescargas.add(new DescargableImpl(12.5, cancion1));
		
		ordenarListaDescarga(misDescargas);
		
		
		
		
	}
	protected static void ordenarListaDescarga (Collection<Descargable> listaDescargable) {
		List<Descargable> nuevaList = new ArrayList<>(listaDescargable);
		Comparator<Descargable> comparador = new Comparator<Descargable>() {

			@Override
			public int compare(Descargable o1, Descargable o2) {
				
				return o1.getContenido().getId().getValor();
			}
		};
		Collections.sort(nuevaList, comparador);
	}
		
		
	
	
//	- calcularTamanoDescarga (ArrayList<Descargable>): Double
//	- calcularTiempoDescarga (Double, Conexion) : Double

}
