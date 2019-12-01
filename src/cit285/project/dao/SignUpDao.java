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

public class SignUpDao {
	
	// Read the statements from file, add to batch and send execute the batch
	public void sendBachToDb(List<String> batches) throws Exception {
		//String line = "";
		//String batch = "";
		//Scanner input = null;
		
		// Get database connection
		Connection connection = getConnection();
		
		// Check if this database support batch updates
		if(connection.getMetaData().supportsBatchUpdates()) {
			
			// Create statement
			Statement statement = connection.createStatement();
			
			// Add batch to the statement
			for (String batch: batches) {
				statement.addBatch(batch);
			}
			
			// Execute the batch
			statement.executeBatch();
		}else {
			System.out.println("Batch updates not supported.");
		}
		System.out.println("Batch sent successfully.");
	}
	
	public void signUp(User user, Email email, Address address) 
			throws SQLException, ClassNotFoundException{
		//get connection
		Connection connection = getConnection();
		// Create statement
		PreparedStatement statement = 
				connection.prepareStatement("insert into user values (?,?,?,?)");
		//assign ids to user, email, and address
	
		user.setUserid(generateId());
		email.setEmailId(generateId());
		email.setUserId(user.getUserid());
		address.setAddressId(generateId());
		address.setUserId(user.getUserid());
		
		statement.setInt(1, user.getUserid());
		statement.setString(2, user.getFirstName());
		statement.setString(3, user.getLastName());
		statement.setString(4, user.getCompanyName());
		
		statement.executeUpdate();
			//check if ids are in database
		//add user, email, and address to database
	}
	
	public static Integer generateId() {
		Random rand = new Random();
		
		return rand.nextInt();		
	}
	
	public List<Book> getBooks() 
			throws SQLException, ClassNotFoundException {
		List<Book> booksList = new ArrayList<>();
		
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
			book.setBookid(resultSet.getInt(1));
			book.setIsbn(resultSet.getString(2));
			book.setTitle(resultSet.getString(3));
			book.setEditor(resultSet.getString(4));
			book.setEdition(resultSet.getString(5));
			book.setYear(resultSet.getInt(6));
			
			// Get the author for this book
			preparedStatement.setInt(1,resultSet.getInt(7));
			ResultSet rset = preparedStatement.executeQuery();
			if(rset.next()) {
				Author author = new Author();
				
				author.setAuthorid(rset.getInt(1));
				author.setAuthorfirstname(rset.getString(2));
				author.setAuthorlastname(rset.getString(3));
				book.setAuthor(author);
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
				.getConnection("jdbc:mysql://localhost/book_store","root","tvLCMr7mVRh!jK5");
		System.out.println("Database connected!");
		
		return connection;
	}
}
