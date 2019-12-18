package es.mdef.acing;

import com.other.library.Book;

public class Libro extends ContenidoImpl {

	String genero;
	Book book;
	
	public String getGenero() {
		return genero;
	}

	public Book getBook() {
		return book;
	}

	public Libro(Book book) {
		super(new Identificador<String>(book.getIsbn()),
				book.getTitle());
		genero = book.getGenre();
		this.book = book;
	}

	@Override
	public String toString() {
		return super.toString() + " [" + getGenero() + "]";
	}
}
