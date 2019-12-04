<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
This is AddBook.jsp
	<form action="addBook" method="post">
			<input type="hidden" name="source" value="addBook">
			<label for="text">ISBN</label>
			<input type="text" name="isbn">
			<label for="Title">Title</label>
			<input type="text" name="title">
			<label for="Editor">Editor</label>
			<input type="text" name="editor">
			<label for="Edition">Edition</label>
			<input type="text" name="edition">
			<label for="Year">Year</label>
			<input type="text" name="year">
			<input type = "submit" value = "Submit" />
			</div>
		</form>
</body>
</html>