# CIT-285-NSTv2
Adv. Java Bookstore Project

Decription:
    This project uses modular user to database pipeline design structure to provide end-users that ability to register as users and order books from a online bookstore. 
    
Technolgies Used:
        -Java, MySQL, JSP, Servlets, Apache Tomcat, Apache Ant
  
Features:
  Login to Existing Account
  Register New Account

  As admin:
    AddBook
    AddAuthor
    UpdateBook
    UpdateAuthor
    DeleteBook

  As User:
    View Booklist
    InspectBook (edit and delete as admin)
    AddToCart(move to shopping cart)
  
  
Setting Up Project:
  Environment Variables:
    -"JAVA_HOME" - location of JDK
    -"ANT_HOME" - location of Apache Ant binaries
    -"CATALINA_HOME" - location of Tomcat
    -"MYSQL_SITE" - Address of MySQL server
    -"MYSQL_USER" - MySQL username
    -"MYSQL_PW" - MySQL password

  Initializing SQL Database:
    Run database/build.xml
    -Run "createdb" to create database
    -Run "loaddb" to load data into database
    
  Setting up github on eclipse:
    https://www.vogella.com/tutorials/EclipseGit/article.html

  Project Structure:

  Servlet will perfrom input validation

  Services will catch any other errors and provide a message to what error is

  Dao will catch errors related to database.

  Each component handles errors only within thier own scope. For example, servlet wont handle missing info from the database 
  since it has no way of knowing what is in the database at that level.



