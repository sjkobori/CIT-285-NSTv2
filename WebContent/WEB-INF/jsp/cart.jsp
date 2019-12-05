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
	<form action="booklist" method="post">
		<input type="hidden" name="source" value="cart">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Continue Shopping</button>
		</div>
	</form>
	<TABLE>
	<% ArrayList<LineItem> cart = (ArrayList<LineItem>) session.getAttribute("cart"); %>
	<% ArrayList<Book> booklist = (ArrayList<Book>) session.getAttribute("books"); %>
		<% for (int i = 0; i < cart.size(); i++) { %>
		<TR>
			<!-- Title -->
			<% Book tempbook = null;
			for (Book book: booklist){
				if (cart.get(i).getBookId() == book.getBookid()){
					tempbook = book; //sets current book to tempbook
					break;
				}
			}
			%>
			<TD> (<%= tempbook.getTitle() %>) </TD> <!-- Title -->
			<TD> (<%= cart.get(i).getQuantity() %>) </TD> <!-- Quantity -->
			<TD> (<%= tempbook.getPrice() %>) </TD> <!-- Price -->
			<TD> (<%= cart.get(i).getQuantity()*tempbook.getPrice() %>) </TD> <!-- Total -->
			<TD>  
				<form action="inspectbook" method="post">
					<input type="hidden" name="source" value="booklist">
					<input type="hidden" name="book" value=<%= i %>>
					<div id="button">
						<button type="submit" class="btn btn-primary btn-block">Inspect Book</button>
					</div>
				</form>
			</TD>
			<TD>
				<form action="addtocart" method="post">
					<input type="hidden" name="source" value="booklist">
					<input type="hidden" name="book" value=<%= i %>>
					<div id="button">
						<button type="submit" class="btn btn-primary btn-block">Remove from Cart</button>
					</div>
				</form>
			</TD>
			
		</TR>
		<% } %>
	</TABLE>
	
</body>
</html>