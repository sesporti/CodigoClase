package com.other.library;

public class Book extends AnotherClass {
	String isbn;
	String title;
	String genre;
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getGenre() {
		return genre;
	}

	public Book(String isbn, String title, String genre) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.genre = genre;
	}
	
}
