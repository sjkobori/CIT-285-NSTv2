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
	
	public ArrayList<Author> getAuthors() throws SQLException, ClassNotFoundException {
		ArrayList<Author> authorsList = new ArrayList<>();

		Connection connection = getConnection();
		// Create statement
		Statement statement = connection.createStatement();

		// Execute statement
		ResultSet resultSet = statement.executeQuery("select * from Author");

		while (resultSet.next()) {
			Author author = new Author();
			author.setAuthorid(resultSet.getInt(1));
			author.setAuthorfirstname(resultSet.getString(2));
			author.setAuthorlastname(resultSet.getString(3));
			
		
			authorsList.add(author);
		}
		return authorsList;
	}

	public void addBook(Book book) throws SQLException, ClassNotFoundException {
		// get connection
		Connection connection = getConnection();
		// Create statement 
		PreparedStatement statement = connection.prepareStatement("insert into book values (?,?,?,?,?,?,?,?,?,?)");
		// assign ids to user, email, and address

		book.setBookid(generateId());
		//Author author = new Author(); //FIX LATER
		//author = book.getAuthor();
		
		
		statement.setInt(1, book.getBookid());
		statement.setString(2, book.getIsbn());
		statement.setString(3, book.getTitle());
		statement.setString(4, book.getEditor());
		statement.setString(5, book.getEdition());
		statement.setInt(6, book.getYear());
		statement.setDouble(7, book.getPrice());
		statement.setString(8, book.getDescription());
		statement.setString(9, book.getImagepath());
		statement.setInt(10, book.getAuthor().getAuthorid());
		//book.setAuthor(author);
		
		statement.executeUpdate();
		// check if ids are in database
		// add user, email, and address to database
	}
	
	public void addAuthor(Author author) throws SQLException, ClassNotFoundException {
		// get connection
		Connection connection = getConnection();
		// Create statement 
		PreparedStatement statement = connection.prepareStatement("insert into author values (?,?,?)");
		// assign ids to user, email, and address

		author.setAuthorid(generateId());
		
		
		statement.setInt(1, author.getAuthorid());
		statement.setString(2, author.getAuthorfirstname());
		statement.setString(3, author.getAuthorlastname());
		
		statement.executeUpdate();
		// check if ids are in database
		// add user, email, and address to database
	}

	public void deleteBook(int bookId) throws ClassNotFoundException, SQLException {
		//get connection
		Connection connection = getConnection();
		//prepare statement (needs to delete from lineItem first since it is a foreign key for book)
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE from lineItem where bookId=?");
		//set ? to bookId
		preparedStatement.setInt(1, bookId);
		//execute update
		preparedStatement.executeUpdate();
		
		//prepare another statement
		preparedStatement = connection.prepareStatement("DELETE from book where bookId=?");
		//delete from book where bookId=?
		//set ? to bookId (maybe?)
		preparedStatement.setInt(1, bookId);
		//execute update
		preparedStatement.executeUpdate();
		
	}

	public void updateBook(Book book) throws ClassNotFoundException, SQLException {
		// get connection
				Connection connection = getConnection();
				// Create statement 
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE book SET Title=?, Editor=?, Edition=?, Year=?, Price=?, "
						+ "Description=?, Imagepath=?, AuthorId=? where BookId=?");

				//Author author = new Author(); //FIX LATER
				//author = book.getAuthor();
				
				System.out.println(book.getAuthor());
				//statement.setString(2, book.getIsbn());// doesnt change
				statement.setString(1, book.getTitle());
				statement.setString(2, book.getEditor());
				statement.setString(3, book.getEdition());
				statement.setInt(4, book.getYear());
				statement.setDouble(5, book.getPrice());
				statement.setString(6, book.getDescription());
				statement.setString(7, book.getImagepath());
				statement.setInt(8, book.getAuthor().getAuthorid());
				statement.setInt(9, book.getBookid());
				statement.executeUpdate();
				// check if ids are in database
				// add user, email, and address to database
	}

}