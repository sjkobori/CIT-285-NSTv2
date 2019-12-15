package cit285.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cit285.project.domain.Address;
import cit285.project.domain.Email;
import cit285.project.domain.User;

public class UserDao implements Dao {

	//gets list of users for admin to use
	public ArrayList<User> getUsers() throws SQLException, ClassNotFoundException {
		//array to hold list of users
		ArrayList<User> usersList = new ArrayList<>();
		//connects to database
		Connection connection = getConnection();
		// Create statement
		Statement statement = connection.createStatement();
		// Execute statement
		ResultSet resultSet = statement.executeQuery("select * from User");
		
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
		resultSet.close(); //closes resultset
		
		return usersList;
	}

	public void signUp(User user, Email email, Address address) throws SQLException, ClassNotFoundException {
		// get connection
		Connection connection = getConnection();
		// Create statement
		PreparedStatement statement = connection.prepareStatement(
				"insert into user values (?,?,?,?,?,?,?)");
		// assign ids to user, email, and address
		user.setUserid(generateId());
		email.setEmailId(generateId());
		email.setUserId(user.getUserid());
		address.setAddressId(generateId());
		address.setUserId(user.getUserid());
		
		//adds to user table
		statement.setInt(1, user.getUserid());
		statement.setString(2, user.getUserName());
		statement.setString(3, user.getPassword());
		statement.setString(4, user.getFirstName());
		statement.setString(5, user.getLastName());
		statement.setString(6, user.getCompanyName());
		statement.setBoolean(7, false); //admin set to false
		statement.executeUpdate();
		
		//adds to address table
		statement = connection.prepareStatement("insert into address values (?,?,?,?,?,?,?)");
		
		statement.setInt(1, address.getAddressId()); //address id
		statement.setInt(2, address.getUserId()); //user id
		statement.setString(3, address.getStreet()); //address (street)
		statement.setString(4, address.getCity()); //City
		statement.setString(5, address.getState()); //State
		statement.setString(6, address.getZipcode()); //Zipcode
		statement.setString(7, address.getCountry()); //Country
		statement.executeUpdate();
		
		
		//adds to email table
		statement = connection.prepareStatement("insert into email values (?,?,?)");
		
		statement.setInt(1, email.getEmailId()); //email id
		statement.setInt(2, email.getUserId()); //user id
		statement.setString(3, email.getEmailAddress()); //email address

		statement.executeUpdate();		
	}

}
