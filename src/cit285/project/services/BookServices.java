package cit285.project.services;

import java.sql.SQLException;
import java.util.ArrayList;

import cit285.project.dao.BookDao;
import cit285.project.domain.Book;

public class BookServices implements BookServicesAPI {
	private BookDao bookDao;

	public BookServices() {
		bookDao = new BookDao();
	}

	@Override
	public ArrayList<Book> getBooks() {
		ArrayList<Book> bookList = null;
		// ArrayList<String> students = new ArrayList<>();
		try {
			bookList = bookDao.getBooks();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}

		return bookList;
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

}
