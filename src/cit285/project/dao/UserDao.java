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
import cit285.project.domain.User;

public class UserDao {
	
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
	
	public ArrayList<User> getUsers() throws SQLException, ClassNotFoundException {
		ArrayList<User> usersList = new ArrayList<>();
		
		Connection connection = getConnection();
		// Create statement
		Statement statement = connection.createStatement();
		
		// Execute statement
		ResultSet resultSet = statement.executeQuery("select * from User");
		
		// Create prepared statement to get Author.
		PreparedStatement preparedStatement = connection.prepareStatement("select * from Author where AuthorID=?");
		
		// Iterate through the result and print
		while(resultSet.next()) {
			User user = new User();
			user.setUserid(resultSet.getInt(1));
			user.setFirstName(resultSet.getString(2));
			user.setLastName(resultSet.getString(3));
			user.setCompanyName(resultSet.getString(4));
			
			usersList.add(user);
		}
		return usersList;
	}
	
	public List<Author> getAuthors() 
			throws SQLException, ClassNotFoundException {
		List<Author> authorList = new ArrayList<>();
		
		Connection connection = getConnection();
		// Create statement
		Statement statement = connection.createStatement();
		
		// Execute statement
		ResultSet resultSet = statement.executeQuery("select * from Author");
		
		// Create prepared statement to get Author.
		//PreparedStatement preparedStatement = connection.prepareStatement("select * from Author where AuthorID=?");
		
		// Iterate through the result and print
		while(resultSet.next()) {
			Author author = new Author();
			author.setAuthorid(resultSet.getInt(1));
			author.setAuthorfirstname(resultSet.getString(2));
			author.setAuthorlastname(resultSet.getString(3));
			
			authorList.add(author);
		}
		return authorList;
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
