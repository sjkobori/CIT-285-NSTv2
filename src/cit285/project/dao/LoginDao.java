package cit285.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.security.auth.login.FailedLoginException;

import cit285.project.domain.Login;
import cit285.project.domain.User;

public class LoginDao implements Dao {

	public User validate(Login loginBean) throws ClassNotFoundException, SQLException, FailedLoginException {

		User user = new User();

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from user where username=? and password=?");
		preparedStatement.setString(1, loginBean.getUsername());
		preparedStatement.setString(2, loginBean.getPassword());

		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			user.setUserName(resultSet.getString("Username")); // username
			user.setFirstName(resultSet.getString("Firstname")); // first name
			user.setLastName(resultSet.getString("Lastname")); // last name
			user.setAdmin(resultSet.getBoolean("isAdmin")); // admin status

		} else { // no matching username and password
			throw new FailedLoginException("Incorrect Username and/or Password");
		}

		return user;
	}

	/*
	 * public int validate(Login loginBean) throws ClassNotFoundException { int
	 * status = 0; // boolean admin =false; try { Connection connection =
	 * getConnection(); Statement statement = connection.createStatement();
	 * ResultSet resultSet = statement.executeQuery("select * from user"); while
	 * (resultSet.next()) { if
	 * (resultSet.getString("Username").equals(loginBean.getUsername()) &&
	 * resultSet.getString("Password").equals(loginBean.getPassword())) { boolean
	 * isAdmin = resultSet.getBoolean("isAdmin"); if (isAdmin) { status = 2; break;
	 * } else { status = 1; break; } } else { //no matching username and password
	 * status = 3; } }
	 * 
	 * // Step 2:Create a statement using connection object PreparedStatement
	 * preparedStatement = connection
	 * .prepareStatement("select * from user where username = ? and password = ? "))
	 * { preparedStatement.setString(1, loginBean.getUsername());
	 * preparedStatement.setString(2, loginBean.getPassword());
	 * 
	 * System.out.println(preparedStatement); ResultSet rs =
	 * preparedStatement.executeQuery(); status = rs.next();
	 * 
	 * } catch (SQLException e) { printSQLException(e); }
	 * 
	 * return status; }
	 */

}