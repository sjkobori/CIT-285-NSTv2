package cit285.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cit285.project.domain.Author;
import cit285.project.domain.Book;
import cit285.project.domain.LineItem;

public class InvoiceDao implements Dao {

	public void addToCart(LineItem item) throws SQLException, ClassNotFoundException {
		// get connection
		Connection connection = getConnection();

		// if item is already in table
		PreparedStatement statement = connection
				.prepareStatement("SELECT * from lineItem where invoiceId=? and bookId=?");
		// set invoiceID to ?, bookId to ?
		statement.setInt(1, item.getInvoiceId());
		statement.setInt(2, item.getBookId());

		// make a result set
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) { // if there is a match
			// add one to quantity
			statement = connection.prepareStatement("UPDATE lineItem set quantity=? where lineItemId=?");
			statement.setInt(1, resultSet.getInt(4) + 1); // getting old quantity and increasing it
			statement.setInt(2, resultSet.getInt(1)); // update the line it with matching invoiceId and bookId
			// set ? to resultset+1, ? to resultset.getInt(1) (lineItemID)
			statement.executeUpdate(); // updates lineItem with increased quantity
		} else {

			// Create statement
			PreparedStatement newLineItemStatement = connection
					.prepareStatement("insert into lineitem values (?,?,?,?)");
			// add check for if line item exists already
			// if it does, increase quantity by new amount
			// generate id
			newLineItemStatement.setInt(1, generateId());
			newLineItemStatement.setInt(2, item.getInvoiceId());
			newLineItemStatement.setInt(3, item.getBookId());
			newLineItemStatement.setInt(4, 1); // initialize with 1 quantity

			newLineItemStatement.executeUpdate();
		}

	}

	public int initializeInvoice(String username) throws ClassNotFoundException, SQLException {
		int invoiceId, userId = 0; // make proper error
		Connection connection = getConnection();
		// Create statement
		// gets this users id
		PreparedStatement statement = connection.prepareStatement("select userId from User where Username=?");
		statement.setString(1, username);
		// gets this users id
		// Execute query
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			userId = resultSet.getInt(1);
		}

		statement = connection.prepareStatement("select * from invoice where userId=?");
		statement.setInt(1, userId); // makes ? userId
		resultSet = statement.executeQuery();
		while (resultSet.next()) {
			// check if date is null
			// if found invoice with null date
			// return that invoice because it has not been submitted
			if (resultSet.getDate(3) == null) {
				invoiceId = resultSet.getInt(1); // gets unfinished cart
				return invoiceId;
			}
		}
		// generate new invoice id
		// create id
		// add to invoice table with userID and null date
		// insert into invoice (invoiceId, userId) values (?, ?);
		invoiceId = generateId();
		statement = connection.prepareStatement("insert into invoice (invoiceId, userId, IsProcessed) values (?, ?, ?)");
		statement.setInt(1, invoiceId); // makes ? invoiceId
		statement.setInt(2, userId); // makes ? userId
		statement.setBoolean(3, false);
		statement.executeUpdate(); // stores new id
		return invoiceId;
	}

	public ArrayList<LineItem> getCart(int invoiceId) throws ClassNotFoundException, SQLException {
		// list to hold lineItems
		ArrayList<LineItem> cart = new ArrayList<>();

		Connection connection = getConnection();

		// Create prepared statement to get lineItems to create cart.
		PreparedStatement preparedStatement = connection.prepareStatement("select * from lineItem where InvoiceID=?");
		preparedStatement.setInt(1, invoiceId); // set ? to invoiceId
		ResultSet resultSet = preparedStatement.executeQuery();
		// Iterate through the result and print
		while (resultSet.next()) {

			LineItem item = new LineItem();
			item.setLineItemId(resultSet.getInt(1)); // gets lineItem id from first column
			item.setInvoiceId(resultSet.getInt(2));
			item.setBookId(resultSet.getInt(3));
			item.setQuantity(resultSet.getInt(4));

			cart.add(item);
		}
		return cart;
	}

	public void removeFromCart(LineItem item) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();

		// Create prepared statement to get lineItems to create cart.
		PreparedStatement preparedStatement = connection
				.prepareStatement("delete from lineItem where InvoiceID=? AND BookID=?");
		preparedStatement.setInt(1, item.getInvoiceId()); // set ? to invoiceId
		preparedStatement.setInt(2, item.getBookId()); // set ? to invoiceId

		preparedStatement.executeUpdate();

	}

	public boolean finalizeInvoice(int invoiceId, double totalAmount) throws ClassNotFoundException, SQLException {
		
		//get connection
		Connection connection = getConnection();
		//prepare statement
		PreparedStatement statement = connection.prepareStatement(
				"UPDATE invoice SET InvoiceDate=?, totalAmount=? where invoiceId=?");
		//UPDATE invoice SET date=?, totalAmount=? where invoiceId=?
		statement.setDate(1, new java.sql.Date(new java.util.Date().getTime())); //hopefully this works
		statement.setDouble(2, totalAmount); //sets total
		statement.setInt(3, invoiceId); //update the invoice that matches
		//set ? new java.sql.Date(), ? totalAmount, ? invoiceId
		
		if (statement.executeUpdate() == 1) {
			return true;
		}
		return false;		
	}

}