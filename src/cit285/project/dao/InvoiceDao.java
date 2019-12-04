package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import cit285.project.domain.LineItem;
import cit285.project.domain.Login;

public class InvoiceDao {

	public void addToCart(LineItem item) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// get connection
		Connection connection = getConnection();
		// Create statement
		PreparedStatement statement = connection.prepareStatement("insert into lineitem values (?,?,?,?)");
		//PreparedStatement tempStatement = connection.prepareStatement("insert into invoice values (?,?,?,?,?)");
		// assign ids to user, email, and address
//insert into invoice 
		int invoiceId = 94649100;
		//tempStatement.setInt(1, invoiceId);
		//tempStatement.setInt(2, 11111113);
		//tempStatement.setDate(3, new java.sql.Date(2019, 12, 3));
		//tempStatement.setInt(4, 420);
		//tempStatement.setBoolean(5, false);
		//tempStatement.executeUpdate();
		
		statement.setInt(1, generateId());
		statement.setInt(2, invoiceId);
		statement.setInt(3, item.getBookId());
		statement.setInt(4, item.getQuantity());
		
		statement.executeUpdate();
		// check if ids are in database
		// add user, email, and address to database
	}

	public static Integer generateId() {
		int max = 99999999;
		int min = 10000000;
		Random rand = new Random();

		return rand.nextInt((max - min) + 1) + min;
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