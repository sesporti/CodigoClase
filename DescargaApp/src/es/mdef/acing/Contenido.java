package es.mdef.acing;

public class Contenido {
	private Identificador id;
	private String titulo;
	
	public Identificador getId() {
		return id;
	}
	
	//	private void setId(Identificador id) {
//		this.id = id;
//	}
	
	public String getTitulo() {
		return titulo;
	}

//	private void setTitulo(String titulo) {
//		this.titulo = titulo;
//	}
//


	public Contenido (Identificador id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	

}
