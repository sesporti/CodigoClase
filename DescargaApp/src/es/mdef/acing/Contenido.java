package es.mdef.acing;

public class Contenido {
	private Identificador<String> id;
	private String titulo;
	
	public Identificador<String> getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public Contenido (Identificador<String> id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	
	@Override
	public String toString() {
		return "(" + getId() + ") " + getTitulo();
	}

}
