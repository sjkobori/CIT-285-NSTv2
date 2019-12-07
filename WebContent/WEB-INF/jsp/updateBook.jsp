<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
           pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.project.domain.Book, java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Update Book</title>
	</head>
	<body>
        <form action="RedirectServlet" method="post">
			<input type="hidden" name="source" value="inspectBook">
			<div id="button">
				<button type="submit" class="btn btn-primary btn-block">Return home</button>
			</div>
		</form>
           <hr />
           <form action="updatebook" method="post">
			<input type="hidden" name="source" value="updateBook">
           <TABLE>
                      <% Book book = (Book) session.getAttribute("book"); %>
                      <TR>
                      	<TD>Title: <%= book.getTitle()%></TD>
                      	<TD> <img src="images/book_images/default_book.png" 
                      	alt="*Add Title Here*" width="250" height="250"/> </TD>
                      </TR>
                      <TR>
                      	<TD>BookID:</TD>
                      	<TD> <%= book.getBookid() %><input type="hidden" name="bookid" value="<%= book.getBookid() %>"></TD>                 	
                      </TR>
                      <TR>
                      	<TD>Title:</TD>
                      	<TD> <input type="text" name="title" value="<%= book.getTitle() %>"> </TD>
                      </TR>
                      <TR>
                      	<TD>ISBN:</TD>
                      	<TD> <input type="text" name="isbn" value="<%= book.getIsbn() %>"> </TD>
                      </TR>
                      <TR>
                      <!-- Make drop down menu for selecting -->
                      	<TD>Author First Name:</TD>
                      	<TD> <input type="text" name="authorfirstname" value="<%= book.getAuthor().getAuthorfirstname() %>"> </TD>
                      </TR>
                      <TR>
                      	<TD>Author Last Name:</TD>
                      	<TD> <input type="text" name="authorlastname" value="<%= book.getAuthor().getAuthorlastname() %>"> </TD>
                      </TR>
                      <TR>
                      	<TD>Year:</TD>
                      	<TD> <input type="text" name="year" value=<%= book.getYear() %>> </TD>
                      </TR>
                      <TR>
                      	<TD>Edition:</TD>
                      	<TD> <input type="text" name="edition" value="<%= book.getEdition() %>" > </TD>
                      </TR>
                      <TR>
                      	<TD>Editor:</TD>
                      	<TD> <input type="text" name="editor" value="<%= book.getEditor() %>"> </TD>
                      </TR>
                      <TR>
                      	<TD>Price:</TD>
                      	<TD> <input type="text" name="price" value="<%= book.getPrice() %>"> </TD>
                      </TR>
                      <TR>
                      	<TD>Description:</TD>
                      	<TD> <input type="text" name="description" value="<%= book.getDescription() %>"> </TD>
                      </TR>
                      <TR>
                      	<TD>Imagepath:</TD>
                      	<TD> <input type="text" name="imagepth" value="<%= book.getImagepath() %>"> </TD>
                      </TR>
           </TABLE>
           
			<div id="button">
				<button type="submit" class="btn btn-primary btn-block">Update Book</button>
			</div>
			</form>
 
</body>
</html>