package es.mdef.acing;

import java.util.Comparator;

/**
 * @author profesor
 * @since 0.1
 * @see http://fnpoienf.com
 *
 */
public interface Descargable extends Comparable<Descargable> {

	Comparator<Descargable> COMPARADOR = new Comparator<Descargable>() {

		@Override
		public int compare(Descargable o1, Descargable o2) {
			int valorComparacion = o1.getContenido().getId().compareTo(
									o2.getContenido().getId());
			
			if(valorComparacion == 0) {
				valorComparacion = -COMPARADOR_POR_TAMANO.compare(o1, o2);
			}
			
			return valorComparacion;
		}
	};
	
//	Comparator<Descargable> COMPARADOR_POR_TAMANO = new Comparator<Descargable>() {
//
//		@Override
//		public int compare(Descargable o1, Descargable o2) {
//			return Double.compare(o1.getTamanoMegas(), o2.getTamanoMegas());
//		}
//	};
	//Esta linea hace lo mismo que lo comentado de arriba
	/**
	 * Las descargas deben tener un valor, no se admiten tamaños de megas null
	 */
	Comparator<Descargable> COMPARADOR_POR_TAMANO = (o1, o2) -> Double.compare(o1.getTamanoMegas(), o2.getTamanoMegas());
	
	
	Double getTamanoMegas();
	
	Contenido getContenido();

	@Override
	default int compareTo(Descargable descarga) {
		return COMPARADOR.compare(this, descarga);
	}
	
}
