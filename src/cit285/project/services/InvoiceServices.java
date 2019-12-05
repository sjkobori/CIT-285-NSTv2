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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}



	@Override
	public int initializeInvoice(String username) {
		// TODO Auto-generated method stub
				try {
					return invoiceDao.initializeInvoice(username);
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
	
}
