package cit285.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cit285.project.domain.Author;
import cit285.project.domain.Book;
import cit285.project.domain.LineItem;

public class InvoiceDao implements Dao{

	public void addToCart(LineItem item) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		// get connection
		Connection connection = getConnection();
		// Create statement
		PreparedStatement statement = connection.prepareStatement("insert into lineitem values (?,?,?,?)");
		//PreparedStatement tempStatement = connection.prepareStatement("insert into invoice values (?,?,?,?,?)");

		
		
		
		//add check for if line item exists already
		//if it does, increase quantity by new amount
		
		statement.setInt(1, generateId());
		statement.setInt(2, item.getInvoiceId());
		statement.setInt(3, item.getBookId());
		statement.setInt(4, item.getQuantity());
		
		statement.executeUpdate();
		// check if ids are in database
	}

	public int initializeInvoice(String username) throws ClassNotFoundException, SQLException {
		int invoiceId, userId = 0; //make proper error
		Connection connection = getConnection();
		// Create statement
		//gets this users id
		PreparedStatement statement = connection.prepareStatement("select userId from User where Username=?");
		statement.setString(1, username);
		//gets this users id
		// Execute query
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			userId = resultSet.getInt(1);
		}
		
		statement = connection.prepareStatement("select * from invoice where userId=?");
		statement.setInt(1, userId); //makes ? userId
		resultSet = statement.executeQuery();
		while(resultSet.next()) {
			//check if date is null
			//if found invoice with null date
			//return that invoice because it has not been submitted
			if(resultSet.getDate(3) == null) {
				invoiceId = resultSet.getInt(1); //gets unfinished cart
				return invoiceId;
			}
		}
		//generate new invoice id
		//create id
		//add to invoice table with userID and null date
		//insert  into invoice (invoiceId, userId) values (?, ?); 
		invoiceId = generateId();
		statement = connection.prepareStatement("insert  into invoice (invoiceId, userId) values (?, ?)");
		statement.setInt(1, invoiceId); //makes ? invoiceId
		statement.setInt(2, userId); //makes ? userId
		
		statement.executeUpdate(); //stores new id
		return invoiceId;
	}

	public ArrayList<LineItem> getCart(int invoiceId) throws ClassNotFoundException, SQLException {
		//list to hold lineItems
		ArrayList<LineItem> cart = new ArrayList<>();

		Connection connection = getConnection();
		
		// Create prepared statement to get lineItems to create cart.
		PreparedStatement preparedStatement = connection.prepareStatement("select * from lineItem where InvoiceID=?");
		preparedStatement.setInt(1, invoiceId); //set ? to invoiceId
		ResultSet resultSet = preparedStatement.executeQuery();
		// Iterate through the result and print
		while (resultSet.next()) {
			
			LineItem item = new LineItem();
			item.setLineItemId(resultSet.getInt(1)); //gets lineItem id from first column
			item.setInvoiceId(resultSet.getInt(2));
			item.setBookId(resultSet.getInt(3));
			item.setQuantity(resultSet.getInt(4));
			
			

			cart.add(item);
		}
		return cart;
	}

}