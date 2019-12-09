package cit285.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cit285.project.domain.Address;
import cit285.project.domain.Email;
import cit285.project.domain.User;

public class UserDao implements Dao {

	// Read the statements from file, add to batch and send execute the batch
	public void sendBachToDb(List<String> batches) throws Exception {
		// String line = "";
		// String batch = "";
		// Scanner input = null;

		// Get database connection
		Connection connection = getConnection();

		// Check if this database support batch updates
		if (connection.getMetaData().supportsBatchUpdates()) {

			// Create statement
			Statement statement = connection.createStatement();

			// Add batch to the statement
			for (String batch : batches) {
				statement.addBatch(batch);
			}

			// Execute the batch
			statement.executeBatch();
		} else {
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
		// PreparedStatement preparedStatement = connection.prepareStatement("select *
		// from Author where AuthorID=?");

		// Iterate through the result and print
		while (resultSet.next()) {
			User user = new User();
			user.setUserid(resultSet.getInt(1));
			user.setUserName(resultSet.getString(2));
			// skip over  password
			user.setFirstName(resultSet.getString(4));
			user.setLastName(resultSet.getString(5));
			user.setCompanyName(resultSet.getString(6));
			user.setAdmin(resultSet.getBoolean(7));
			usersList.add(user);
		}
		return usersList;
	}

	public void signUp(User user, Email email, Address address) throws SQLException, ClassNotFoundException {
		// get connection
		Connection connection = getConnection();
		// Create statement
		PreparedStatement statement = connection.prepareStatement("insert into user values (?,?,?,?,?,?,?)");
		// assign ids to user, email, and address

		user.setUserid(generateId());
		email.setEmailId(generateId());
		email.setUserId(user.getUserid());
		address.setAddressId(generateId());
		address.setUserId(user.getUserid());

		statement.setInt(1, user.getUserid());
		statement.setString(2, user.getUserName());
		statement.setString(3, user.getPassword());
		statement.setString(4, user.getFirstName());
		statement.setString(5, user.getLastName());
		statement.setString(6, user.getCompanyName());
		statement.setBoolean(7, false);
		statement.executeUpdate();
		// check if ids are in database
		// add user, email, and address to database
	}

}
