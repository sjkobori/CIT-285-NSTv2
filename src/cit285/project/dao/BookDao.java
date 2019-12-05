package cit285.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cit285.project.domain.Author;
import cit285.project.domain.Book;

public class BookDao implements Dao {

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
			book.setPrice(resultSet.getDouble(7));
			book.setDescription(resultSet.getString(8));
			book.setImagepath(resultSet.getString(9));
			author.setAuthorid(resultSet.getInt(10));
			book.setAuthor(author);
			
			
			//Get the author for this book
			preparedStatement.setInt(1, author.getAuthorid()); //
			ResultSet rset = preparedStatement.executeQuery();
			if (rset.next()) {
				
				author.setAuthorfirstname(rset.getString(2));
				author.setAuthorlastname(rset.getString(3));
			}

			booksList.add(book);
		}
		return booksList;
	}

	public void addBook(Book book) throws SQLException, ClassNotFoundException {
		// get connection
		Connection connection = getConnection();
		// Create statement 
		PreparedStatement statement = connection.prepareStatement("insert into book values (?,?,?,?,?,?,?,?,?,?)");
		// assign ids to user, email, and address

		book.setBookid(generateId());
		Author author = new Author(); //FIX LATER
		author = book.getAuthor();
		
		
		statement.setInt(1, book.getBookid());
		statement.setString(2, book.getIsbn());
		statement.setString(3, book.getTitle());
		statement.setString(4, book.getEditor());
		statement.setString(5, book.getEdition());
		statement.setInt(6, book.getYear());
		statement.setDouble(7, book.getPrice());
		statement.setString(8, book.getDescription());
		statement.setString(9, book.getImagepath());
		statement.setInt(10, 12345670);
		book.setAuthor(author);
		
		statement.executeUpdate();
		// check if ids are in database
		// add user, email, and address to database
	}

}