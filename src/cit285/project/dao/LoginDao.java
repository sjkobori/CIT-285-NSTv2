package cit285.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.login.FailedLoginException;

import cit285.project.domain.Login;
import cit285.project.domain.User;

public class LoginDao implements Dao {

	public User validate(Login loginBean) throws ClassNotFoundException, SQLException, FailedLoginException {

		User user = new User(); //creates user to hold user data from database

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from user where username=? and password=?");
		preparedStatement.setString(1, loginBean.getUsername()); //sets username and password to ?
		preparedStatement.setString(2, loginBean.getPassword());

		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) { //if match is found
			//fill user with data from set (not password)
			user.setUserName(resultSet.getString("Username")); // username
			user.setFirstName(resultSet.getString("Firstname")); // first name
			user.setLastName(resultSet.getString("Lastname")); // last name
			user.setAdmin(resultSet.getBoolean("isAdmin")); // admin status

		} else { // no matching username and password
			throw new FailedLoginException("Incorrect Username and/or Password");
		}

		return user; //sends back user data
	}

}