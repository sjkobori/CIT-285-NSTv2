<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
           pageEncoding="ISO-8859-1"%>
<%@ page import="cit285.project.domain.Book, java.util.*, java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Book Details</title>
	</head>
	<body>
        <form action="getbooks" method="post">
			<input type="hidden" name="source" value="inspectBook"  >
			<div id="button">
				<button type="submit" class="btn btn-primary btn-block">Return to list</button>
			</div>
		</form>
           <hr />
           <TABLE>
                      <% Book book = (Book) session.getAttribute("book"); %>
                      <TR>
                      	<TD>Title: <%= book.getTitle()%></TD>
                      	<TD><img src="<%= book.getImagepath() %>" 
                      		alt="*Add Title Here*" width="125" height="125"/> </TD>
                      </TR>
                      <TR>
                      	<TD> Author: <%= book.getAuthor().getAuthorfirstname() + 
                    		" " + book.getAuthor().getAuthorlastname() %> </TD>
                      </TR>
                      <TR>
                      	<TD> Year: <%= book.getYear() %> </TD>
                      </TR>
                      <TR>
                      	<TD> Edition: <%= book.getEdition() %> </TD>
                      </TR>
                      <TR>
                      	<TD> Editor:  <%= book.getEditor() %> </TD>
                      </TR>
                      <TR>
                      	<TD> Price:  <%= new DecimalFormat("$###,###.00").format(book.getPrice()) %> </TD>
                      </TR>
           </TABLE>
           <form action="addtocart" method="post">
			<input type="hidden" name="source" value="inspectBook">
			<div id="button">
				<button type="submit" class="btn btn-primary btn-block">Add to Cart</button>
			</div>
			</form>
			<div> <%= book.getDescription() %> </div>
 
</body>
</html>