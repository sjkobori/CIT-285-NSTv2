package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cit285.project.domain.Address;
import cit285.project.domain.Author;
import cit285.project.domain.Book;
import cit285.project.domain.Email;
import cit285.project.domain.User;

public class BookDao {

	public ArrayList<Book> getBooks() throws SQLException, ClassNotFoundException {
		ArrayList<Book> booksList = new ArrayList<>();

		Connection connection = getConnection();
		// Create statement
		Statement statement = connection.createStatement();

		// Execute statement
		ResultSet resultSet = statement.executeQuery("select * from Book");

		// Create prepared statement to get Author.
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Author where AuthorID=?");

		// Iterate through the result and print
		while (resultSet.next()) {
			Book book = new Book();
			Author author = new Author();
			book.setBookid(resultSet.getInt(1));
			book.setIsbn(resultSet.getString(2));
			book.setTitle(resultSet.getString(3));
			book.setEditor(resultSet.getString(4));
			book.setEdition(resultSet.getString(5));
			book.setYear(resultSet.getInt(6));
			author.setAuthorid(resultSet.getInt(7));
			book.setAuthor(author); // fix later
			
			//Get the author for this book
			preparedStatement.setInt(1, author.getAuthorid()); //
			ResultSet rset = preparedStatement.executeQuery();
			if (rset.next()) {
				// Author author = new Author();

				// author.setAuthorid(rset.getInt(1));
				author.setAuthorfirstname(rset.getString(2));
				author.setAuthorlastname(rset.getString(3));
				// book.setAuthor(author);
			}

			booksList.add(book);
		}
		return booksList;
	}

	private static Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded!");

		// Connect to the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/book_store",
				System.getenv("MYSQL_USER"), System.getenv("MYSQL_PW"));
		System.out.println("Database connected!");

		return connection;
	}

	public void addBook(Book book) throws SQLException, ClassNotFoundException {
		// get connection
		Connection connection = getConnection();
		// Create statement
		PreparedStatement statement = connection.prepareStatement("insert into book values (?,?,?,?,?,?,?)");
		// assign ids to user, email, and address

		book.setBookid(generateId());
		Author author = new Author();
		author = book.getAuthor();
		
		
		statement.setInt(1, book.getBookid());
		statement.setString(2, book.getIsbn());
		statement.setString(3, book.getTitle());
		statement.setString(4, book.getEditor());
		statement.setString(5, book.getEdition());
		statement.setInt(6, book.getYear());
		statement.setInt(7, 10000001);
		
		statement.executeUpdate();
		// check if ids are in database
		// add user, email, and address to database
	}

	public static Integer generateId() {
		int max = 99999999;
		int min = 10000000;
		Random rand = new Random();

		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
}