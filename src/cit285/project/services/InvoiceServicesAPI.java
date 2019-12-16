package cit285.project.services;

import java.util.ArrayList;

import cit285.project.domain.LineItem;

public interface InvoiceServicesAPI {
	
	public int initializeInvoice(int userId);
	
	//fills out invoice (gives it a Date + total) 
	public boolean finalizeInvoice(int invoiceId, double totalAmount); 
	
	public void addToCart(LineItem item);
	
	public void removeFromCart(LineItem item); //change to work with just id
	
	public boolean updateQuantity(int lineItemId);
	
	public ArrayList<LineItem> getCart(int invoiceId);
	
}
