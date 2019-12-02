package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cit285.project.domain.Author;
import cit285.project.domain.Book;

public class BookDao {
	
	public ArrayList<Book> getBooks() 
			throws SQLException, ClassNotFoundException {
		ArrayList<Book> booksList = new ArrayList<>();
		
		Connection connection = getConnection();
		// Create statement
		Statement statement = connection.createStatement();
		
		// Execute statement
		ResultSet resultSet = statement.executeQuery("select * from Book");
		
		// Create prepared statement to get Author.
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Author where AuthorID=?");
		
		// Iterate through the result and print
		while(resultSet.next()) {
			Book book = new Book();
			Author author = new Author();
			book.setBookid(resultSet.getInt(1));
			book.setIsbn(resultSet.getString(2));
			book.setTitle(resultSet.getString(3));
			book.setEditor(resultSet.getString(4));
			book.setEdition(resultSet.getString(5));
			book.setYear(resultSet.getInt(6));
			author.setAuthorid(resultSet.getInt(7));
			book.setAuthor(author); //fix later
			
			// Get the author for this book
			preparedStatement.setInt(1, author.getAuthorid()); //
			ResultSet rset = preparedStatement.executeQuery();
			if(rset.next()) {
				//Author author = new Author();
				
				//author.setAuthorid(rset.getInt(1));
				author.setAuthorfirstname(rset.getString(2));
				author.setAuthorlastname(rset.getString(3));
				//book.setAuthor(author);
			}
			
			booksList.add(book);
		}
		return booksList;
	}
	
	private Connection getConnection() 
			throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded!");
		
		// Connect to the database
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost/book_store",
						System.getenv("MYSQL_USER"), System.getenv("MYSQL_PW"));
		System.out.println("Database connected!");
		
		return connection;
	}
}
