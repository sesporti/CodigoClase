package com.other.library;

import es.mdef.acing.Contenido;
import es.mdef.acing.Identificador;

public class Book extends Contenido {
//	String isbn;
	//String title;
	String genre;
	
	public String getIsbn() {
		return getId().getValor();// isbn;
	}
	
	public String getTitle() {
		return getTitulo();//title;
	}
	
	public String getGenre() {
		return genre;
	}

	public Book(String isbn, String title) {
		this(new Identificador<String>(isbn), title);
	}

	public Book(Identificador<String> identificador, String title) {
		super(identificador, title);
//		this.isbn = identificador.getValor();
	}
	
	
}
