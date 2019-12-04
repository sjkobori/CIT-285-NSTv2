package cit285.project.services;

import java.util.ArrayList;

import cit285.project.domain.Book;

public interface BookServicesAPI {
	public ArrayList<Book> getBooks();
	
	public void addBook(Book book);
}
