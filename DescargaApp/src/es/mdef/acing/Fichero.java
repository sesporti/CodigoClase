package es.mdef.acing;

public class Fichero extends DescargableImpl implements ConRuta {

	String ruta;
	
	@Override
	public String getRuta() {
		return ruta;
	}
	
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Fichero(Double tamanoMegas, Contenido contenido) {
		super(tamanoMegas, contenido);
	}

}
