package es.mdef.acing;

public interface Contenido {

	Identificador<String> getId();

	String getTitulo();
	
	default String string() {
		return "(" + getId() + ") " + getTitulo();
	}
	
	static String pasarAString(Contenido c) {
		return "(" + c.getId() + ") " + c.getTitulo();
	}

}