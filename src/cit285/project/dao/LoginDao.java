package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cit285.project.domain.Login;

public class LoginDao {

	public int validate(Login loginBean) throws ClassNotFoundException {
		int status = 0;
		// boolean admin =false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			while (rs.next()) {
				if (rs.getString("Username").equals(loginBean.getUsername())
						&& rs.getString("Password").equals(loginBean.getPassword())) {
					boolean isAdmin = rs.getBoolean("isAdmin");
					if (isAdmin) {
						status = 2;
						break;
					} else {
						status = 1;
						break;
					}
				} else { //no matching username and password
					status = 3;
				}
			}
			/*
			 * // Step 2:Create a statement using connection object PreparedStatement
			 * preparedStatement = connection
			 * .prepareStatement("select * from user where username = ? and password = ? "))
			 * { preparedStatement.setString(1, loginBean.getUsername());
			 * preparedStatement.setString(2, loginBean.getPassword());
			 * 
			 * System.out.println(preparedStatement); ResultSet rs =
			 * preparedStatement.executeQuery(); status = rs.next();
			 */
		} catch (SQLException e) {
			printSQLException(e);
		}

		System.out.println(status);
		return status;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	private Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded!");

		// Connect to the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/book_store",
				System.getenv("MYSQL_USER"), System.getenv("MYSQL_PW"));
		System.out.println("Database connected!");

		return connection;
	}
}