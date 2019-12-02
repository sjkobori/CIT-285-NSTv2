<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>List of books</title>
	</head>
	<body>
		<button type="submit" class="btn btn-primary btn-block">Cart</button>
		<hr />
	
		<!-- Display Books -->
		<form action="BookServlet" method="post">
			<input type="hidden" name="source" value="login">
		</form>
		<div id="bookslist" class="bookslist_format">
			<c:forEach items="${books}" var="book">
				<br />
 				${book}
			</c:forEach>
		</div>
	</body>
</html>