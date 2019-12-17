package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

public interface Dao {
	//range for id generation
	static int MIN = 10000000;
	static int MAX = 99999999;
	
	//default functionality for get connection in db
	public default Connection getConnection() 
			throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		//System.out.println("Driver loaded!");
		
		// Connect to the database
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost/book_store",
						System.getenv("MYSQL_USER"), System.getenv("MYSQL_PW"));
		//System.out.println("Database connected!");
		
		return connection;
	}
	
	//generates id number between max and min
	public default Integer generateId() {
		Random rand = new Random();

		return rand.nextInt((MAX - MIN) + 1) + MIN;
	}
}
