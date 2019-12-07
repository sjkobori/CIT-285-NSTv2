package cit285.project.services;

import java.sql.SQLException;
import java.util.ArrayList;

import cit285.project.dao.BookDao;
import cit285.project.domain.Book;
import cit285.project.domain.Author;

public class BookServices implements BookServicesAPI {
	private BookDao bookDao;

	public BookServices() {
		bookDao = new BookDao();
	}

	@Override
	public ArrayList<Book> getBooks() {
		ArrayList<Book> bookList = null;
		try {
			bookList = bookDao.getBooks();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}

		return bookList;
	}
	
	@Override
	public ArrayList<Author> getAuthors() {
		ArrayList<Author> authorList = null;
		// ArrayList<String> students = new ArrayList<>();
		try {
			authorList = bookDao.getAuthors();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}

		return authorList;
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		try {
			bookDao.addBook(book);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		
	}
	
	public void addAuthor(Author author) {
		// TODO Auto-generated method stub
		try {
			bookDao.addAuthor(author);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		
	}

	@Override
	public void deleteBook(int bookId) {
		try {
			bookDao.deleteBook(bookId);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public boolean updateBook(Book book) {
		try {
			bookDao.updateBook(book);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
			return false;
		}
		return true;
	}

}
