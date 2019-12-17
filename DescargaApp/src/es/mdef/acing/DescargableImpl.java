package es.mdef.acing;

public class DescargableImpl implements Descargable {
	private Double tamanoMegas;
	private Contenido contenido;
	
	@Override
	public Double getTamanoMegas() {
		return tamanoMegas;
	}

	@Override
	public Contenido getContenido() {
		return contenido;
	}

	public DescargableImpl(Double tamanoMegas, Contenido contenido) {
		super();
		this.tamanoMegas = tamanoMegas;
		this.contenido = contenido;
	}
	
	@Override
	public String toString() {
		return getContenido() + " - " + getTamanoMegas() + " MB";
	}
	
}
