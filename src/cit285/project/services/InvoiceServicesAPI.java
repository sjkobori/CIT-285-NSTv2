package cit285.project.services;

import cit285.project.domain.LineItem;

public interface InvoiceServicesAPI {
	
	public void addToCart(LineItem item, int userId);
	
	public void removeFromCart(LineItem item, int userId);
}
