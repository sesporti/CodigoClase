package es.mdef.acing;

public class OtraImplementacion implements Descargable, ConRuta {

	@Override
	public String getRuta() {
		return "ruta4.txt";
	}

	@Override
	public Double getTamanoMegas() {
		return 20.5;
	}

	@Override
	public Contenido getContenido() {
		return new ContenidoImpl(new Identificador<String>("#4"), "Mi titulo");
	}

}
