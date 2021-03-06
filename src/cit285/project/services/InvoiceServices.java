package cit285.project.services;

import java.sql.SQLException;
import java.util.ArrayList;

import cit285.project.dao.InvoiceDao;
import cit285.project.domain.LineItem;

public class InvoiceServices implements InvoiceServicesAPI {
	private InvoiceDao invoiceDao;
	
	public InvoiceServices() {
		invoiceDao = new InvoiceDao();
	}
	
	

	@Override
	public void addToCart(LineItem item) {
		try {
			invoiceDao.addToCart(item);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeFromCart(LineItem item) {
		try {
			invoiceDao.removeFromCart(item);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public int initializeInvoice(int userId) {
		// TODO Auto-generated method stub
				try {
					return invoiceDao.initializeInvoice(userId);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return 0;
	}



	@Override
	public ArrayList<LineItem> getCart(int invoiceId) {
		System.out.println("in get cart in invoice services");
		try {
			return invoiceDao.getCart(invoiceId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; //make proper error handling
	}



	@Override
	public boolean finalizeInvoice(int invoiceId, double totalAmount) {
		try {
			return invoiceDao.finalizeInvoice(invoiceId, totalAmount);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}



	@Override
	public boolean updateQuantity(int lineItemId) {
		return false;
	}
}
