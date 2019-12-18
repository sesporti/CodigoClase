package com.other.library;

import es.mdef.acing.Contenido;
import es.mdef.acing.Identificador;

public class LibroBook extends Book implements Contenido {

	Identificador<String> identificador;
	
	@Override
	public Identificador<String> getId() {
		return identificador;
	}

	@Override
	public String getTitulo() {
		return getTitle();
	}

	public void setGenero(String genero) {
		genre = genero;
	}
	
	public LibroBook(String isbn, String title, String genre) {
		super(isbn, title, genre);
		identificador = new Identificador<String>(isbn);
	}
	
	@Override
	public String toString() {
		return string() + " [" + getGenre() + "]";
	}
}
