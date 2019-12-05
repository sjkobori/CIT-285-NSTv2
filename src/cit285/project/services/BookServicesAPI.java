package cit285.project.services;

import java.util.ArrayList;

import cit285.project.domain.Book;
import cit285.project.domain.Author;

public interface BookServicesAPI {
	public ArrayList<Book> getBooks();
	public ArrayList<Author> getAuthors();
	
	public void addBook(Book book);
	public void addAuthor(Author author);
}
