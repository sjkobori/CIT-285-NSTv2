<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.project.domain.Book, java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>List of books</title>
</head>
<body>
	<form action="cart" method="post">
		<input type="hidden" name="source" value="cart">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Cart</button>
		</div>
	</form>
	<form action="logout" method="post">
		<input type="hidden" name="source" value="logout">
		<div id="button">
			<button type="submit" class="btn btn-primary btn-block">Logout</button>
		</div>
	</form>
	<hr />

	<!-- Display Books -->
	<form action="BookServlet" method="post">
		<input type="hidden" name="source" value="login">
	</form>
	<TABLE>
	<% ArrayList<Book> booklist = (ArrayList<Book>) request.getAttribute("books"); %>
		<%for (int row = 1; row <= 5; row++) { %>
		<TR>
			<%      for(int col=1; col<=10; col++) { %>
			<TD>(<%=col%>, <%=row%>)
			</TD>
			<% } %>
		</TR>
		<% } %>
	</TABLE>
	<div id="bookslist" class="bookslist_format">
		<c:forEach items="${books}" var="book">
			<br />
 				${book}
			</c:forEach>
	</div>
</body>
</html>