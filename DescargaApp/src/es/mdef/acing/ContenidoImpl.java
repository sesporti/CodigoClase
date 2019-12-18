package es.mdef.acing;

public class ContenidoImpl implements Contenido {
	private Identificador<String> id;
	private String titulo;
	
	@Override
	public Identificador<String> getId() {
		return id;
	}
	
	@Override
	public String getTitulo() {
		return titulo;
	}
	
	public ContenidoImpl (Identificador<String> id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	
	@Override
	public String toString() {
		return Contenido.pasarAString(this);// string();//return "(" + getId() + ") " + getTitulo();
	}

}
