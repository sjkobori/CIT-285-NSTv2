<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
           pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.project.domain.Book, java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Book Details</title>
	</head>
	<body>
        <form action="booklist" method="post">
			<input type="hidden" name="source" value="inspectBook">
			<div id="button">
				<button type="submit" class="btn btn-primary btn-block">Return to list</button>
			</div>
		</form>
           <hr />
           Book
           <TABLE>
                      <% Book book = (Book) session.getAttribute("book"); %>
                      <TR>
                      	<TD><%= book.getTitle()%></TD>
                      </TR>
                      <TR>
                      	<TD><%= book.getAuthor().getAuthorfirstname() %> </TD>
                      </TR>
                      <TR>
                      	<TD><%= book.getAuthor().getAuthorlastname() %> </TD>
                      </TR>
                      <TR>
                      	<TD> <%= book.getYear() %> </TD>
                      </TR>
                      <TR>
                      	<TD><%= book.getEdition() %> </TD>
                      </TR>
                      <TR>
                      	<TD> <%= book.getEditor() %> </TD>
                      </TR>
           </TABLE>
           <form action="addtocart" method="post">
			<input type="hidden" name="source" value="inspectBook">
			<input type="hidden" name="book" value=<%= book %>>
			<div id="button">
				<button type="submit" class="btn btn-primary btn-block">Add to Cart</button>
			</div>
			</form>
           <!-- <form action="" method="post">
                      <input type="hidden" name="source" value="showDetails"> -->
                      <div id="button">
                                 <button type="submit" class="btn btn-primary btn-block">Add
                                            to cart</button>
                      </div>
           <!--</form> -->
           <% %>
 
</body>
</html>