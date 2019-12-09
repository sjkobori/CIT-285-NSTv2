<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.project.domain.*, java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>List of books</title>
</head>
<body>
	This is the cart.jsp
	<form action="redirect" method="post">
		<input type="hidden" name="source" value="cart">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Continue Shopping</button>
		</div>
	</form>
	<TABLE>
		<TR> 
			<TD>(Title)</TD>
			<TD>(Author)</TD>
			<TD>(Quantity)</TD>
			<TD>(Price)</TD>
			<TD>(Total)</TD>
		</TR>
	<% ArrayList<LineItem> cart = (ArrayList<LineItem>) session.getAttribute("cart"); %>
	<% ArrayList<Book> booklist = (ArrayList<Book>) session.getAttribute("books"); %>
	<% double itemTotal = 0, grandTotal = 0; %>
		<% for (int cartIndex = 0; cartIndex < cart.size(); cartIndex++) { %>
		
		<TR>
			<!-- Title -->
			<% Book tempbook = null;
				int tempbookIndex = 0;
			for (int booklistIndex = 0; booklistIndex < booklist.size(); booklistIndex++){
				if (cart.get(cartIndex).getBookId() == booklist.get(booklistIndex).getBookid()){
					tempbook = booklist.get(booklistIndex); //sets current book to tempbook
					tempbookIndex = booklistIndex;
					break;
				}
			}
			%>
			<% itemTotal = cart.get(cartIndex).getQuantity()*tempbook.getPrice(); %>
			<TD><img src="<%= tempbook.getImagepath() %>" 
                      	alt="*Add Title Here*" width="75" height="75"/> </TD>
			<TD> (<%= tempbook.getTitle() %>) </TD> <!-- Title -->
			<TD> 
			<!--<form action="updatequantity" method="post" id="quantityform">
					<input type="submit">
					<input type="hidden" name="source" value="cart">
					<input type="hidden" name="book" value=<%= cartIndex %>>
					<div id="button">
					<select form = "quantityform"> 
  					<option value="0">0 (Delete)</option>
  					<option value="1">1</option>
 	 				<option value="2">2</option>
 	 				<option value="3">3</option>
 	 				<option value="4">4</option>
					</select>
					</div>
				</form> -->
			
			
			
			
			  (<%= cart.get(cartIndex).getQuantity() %>) </TD> <!-- Quantity -->
			<TD> (<%= tempbook.getPrice() %>) </TD> <!-- Price -->
			<TD> (<%= itemTotal %>) </TD> <!-- Total -->
			
			<TD>  
			<% grandTotal += itemTotal; %>
				<form action="inspectbook" method="post">
					<input type="hidden" name="source" value="cart">
					<input type="hidden" name="bookNumber" value=<%= tempbookIndex %>>
					<div id="button">
						<button type="submit" class="btn btn-primary btn-block">Inspect Book</button>
					</div>
				</form>
			</TD>
			<TD>
				<form action="removefromcart" method="post">
					<input type="hidden" name="source" value="cart">
					<input type="hidden" name="book" value=<%= cartIndex %>>
					<input type="hidden" name="total" value=<%= cartIndex %>>
					<div id="button">
						<button type="submit" class="btn btn-primary btn-block">Remove from Cart</button>
					</div>
				</form>
			</TD>
			
		</TR>
		<% } %>
		<TR> 
			<TD></TD>
			<TD></TD>
			<TD></TD>
			<TD>Grand Total:</TD>
			<TD>(<%= grandTotal %>)</TD>
		</TR>
	</TABLE>
	<form action="finalizeinvoice" method="post">
		<input type="hidden" name="source" value="cart">
		<input type="hidden" name="cartTotal" value="<%= grandTotal %>">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Buy Now!</button>
		</div>
	</form>
</body>
</html>