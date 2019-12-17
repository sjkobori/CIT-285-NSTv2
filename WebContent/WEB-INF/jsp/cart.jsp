<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.project.domain.*, java.util.*, java.text.DecimalFormat"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>List of books</title>
<link rel="stylesheet" href="web/css/default.css">
</head>
<body>
	${user.getUserName()}'s Cart
	<form action="redirect" method="post">
		<input type="hidden" name="source" value="cart">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Continue Shopping</button>
		</div>
	</form>
	<TABLE>
		<TR> 
			<TH>Title</TH>
			<TH>Author</TH>
			<TH>Quantity</TH>
			<TH>Price</TH>
			<TH>Total</TH>
			<TH></TH>
			<TH></TH>
		</TR>
	<% ArrayList<LineItem> cart = (ArrayList<LineItem>) session.getAttribute("cart"); %>
	<% ArrayList<Book> booklist = (ArrayList<Book>) session.getAttribute("books"); %>
	<% DecimalFormat moneyFormat = new DecimalFormat("$###,##0.00"); %>
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
			<TD><%= tempbook.getTitle() %></TD> <!-- Title -->
			<TD><%= cart.get(cartIndex).getQuantity() %></TD> <!-- Quantity -->
			<TD><%= moneyFormat.format(tempbook.getPrice()) %></TD> <!-- Price -->
			<TD><%= moneyFormat.format(itemTotal) %></TD> <!-- Total -->
			
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
			<TD><%= moneyFormat.format(grandTotal) %></TD>
		</TR>
	</TABLE>
	<form action="finalizeinvoice" method="post">
		<input type="hidden" name="source" value="cart">
		<input type="hidden" name="cartTotal" value="<%= grandTotal %>">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Buy Now!</button>
		</div>
		<label><c:if test="${not empty confirmation}">${confirmation}</c:if></label>
	</form>
</body>
</html>