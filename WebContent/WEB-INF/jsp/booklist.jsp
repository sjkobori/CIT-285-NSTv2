<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.project.domain.*, java.util.*, java.text.DecimalFormat"%>

<jsp:useBean id = "book" scope = "request"
 class = "cit285.project.domain.Book"> </jsp:useBean>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Book List</title>
<link rel="stylesheet" href="web/css/default.css">
</head>
<body>
	Welcome, ${user.getFirstName()} ${user.getLastName()} !
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
		<TR>
			<TH></TH> <!-- Move to next column -->
			<TH>Title</TH>
			<TH>Author</TH>
			<TH>Year</TH>
			<TH>Price</TH>
			<TH></TH>
			<TH></TH>
		</TR>
	<% ArrayList<Book> booklist = (ArrayList<Book>) session.getAttribute("books"); %>
		<% for (int i = 0; i < booklist.size(); i++) { %>
		<TR>
			<TD><img src="<%= booklist.get(i).getImagepath() %>" 
                      	alt="*Add Title Here*" width="75" height="75"/> </TD>
			<TD><%= booklist.get(i).getTitle() %></TD>
			<TD><%= booklist.get(i).getAuthor().getAuthorfirstname() + 
			" " + booklist.get(i).getAuthor().getAuthorlastname()  %></TD>
			<TD><%= booklist.get(i).getYear() %></TD>
			<TD><%= new DecimalFormat("$###,##0.00").format(booklist.get(i).getPrice()) %></TD>
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