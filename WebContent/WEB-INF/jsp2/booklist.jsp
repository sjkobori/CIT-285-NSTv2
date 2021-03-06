<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.project.domain.Book, java.util.*"%>
<jsp:useBean id = "book" scope = "request"
 class = "cit285.project.domain.Book"> </jsp:useBean>
<!DOCTYPE html>
<html lang="en">
<head>
<title>List of books</title>
</head>
<body>
	<form action="cart" method="post">
		<input type="hidden" name="source" value="booklist">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Cart</button>
		</div>
	</form>
	<form action="logout" method="post">
		<input type="hidden" name="source" value="booklist">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Logout</button>
		</div>
	</form>
	<hr />

	<!-- Display Books -->
	<TABLE>
	
	<% ArrayList<Book> booklist = (ArrayList<Book>) session.getAttribute("books"); %>
		<% for (int i = 0; i < booklist.size(); i++) { %>
		<TR>
			
			<TD> (<%= booklist.get(i).getTitle() %>) </TD>
			<TD> (<%= booklist.get(i).getAuthor().getAuthorfirstname() + 
			" " + booklist.get(i).getAuthor().getAuthorlastname()  %>) </TD>
			<TD> (<%= booklist.get(i).getYear() %>) </TD>
			<TD> (<%= booklist.get(i).getPrice() %>) </TD>
			<TD>  
				<form action="addtocart" method="post">
					<input type="hidden" name="source" value="booklist">
					<input type="hidden" name="bookNumber" value=<%= i %>>
					<div id="button">
						<button type="submit" class="btn btn-primary btn-block">Add to Cart</button>
					</div>
				</form>
			</TD>
			<TD>  
				<form action="inspectbook" method="post">
					<input type="hidden" name="source" value="booklist">
					<input type="hidden" name="bookNumber" value=<%= i %>>
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