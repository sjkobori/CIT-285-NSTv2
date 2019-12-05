package cit285.project.services;

import java.util.ArrayList;

import cit285.project.domain.LineItem;

public interface InvoiceServicesAPI {
	
	public int initializeInvoice(String username);
	
	public void addToCart(LineItem item);
	
	public void removeFromCart(LineItem item);
	
	public ArrayList<LineItem> getCart(int invoiceId);
	
}
