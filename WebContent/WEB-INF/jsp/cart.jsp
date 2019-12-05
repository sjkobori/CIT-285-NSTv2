<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.project.domain.LineItem, java.util.*"%>
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
	<% ArrayList<LineItem> cart = (ArrayList<LineItem>) session.getAttribute("cart"); %>
		<% for (int i = 0; i < cart.size(); i++) { %>
		<TR>
			
			<TD> (<%= cart.get(i).getLineItemId() %>) </TD>
		<TD> (<%= cart.get(i).getInvoiceId() %>) </TD>
		<TD> (<%= cart.get(i).getBookId() %>) </TD>
		<TD> (<%= cart.get(i).getQuantity() %>) </TD>
			<TD>  
				<form action="addtocart" method="post">
					<input type="hidden" name="source" value="booklist">
					<input type="hidden" name="book" value=<%= i %>>
					<div id="button">
						<button type="submit" class="btn btn-primary btn-block">Add to Cart</button>
					</div>
				</form>
			</TD>
			<TD>  
				<form action="inspectbook" method="post">
					<input type="hidden" name="source" value="booklist">
					<input type="hidden" name="book" value=<%= i %>>
					<div id="button">
						<button type="submit" class="btn btn-primary btn-block">Inspect Book</button>
					</div>
				</form>
			</TD>
			
		</TR>
		<% } %>
	</TABLE>
	
</body>
</html>