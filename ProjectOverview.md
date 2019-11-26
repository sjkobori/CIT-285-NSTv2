# CIT-285-NSTv2
Adv. Java Bookstore Project

Setting up github on eclipse
https://www.vogella.com/tutorials/EclipseGit/article.html

Some notes from professor:

Servlet will perfrom input validation

Services will catch any other errors and provide a message to what error is

Dao will catch errors related to database

Each components handles errors only within thier own scope. For example, servlet wont handle missing info from the database 
since it has no way of knowing

Add to GitHub:
  WebContent
    META-INF:
      MANIFEST.md
    WEB-INF
      css
        welcome.css
      jsp
        error.jsp
        welcome.jsp
      lib
        (look in school folder, just libraries to use sql and servlets)
      web.xml
  database
    build.xml (tool to run .sql files)
    createdb.sql
    dropdb.sql
    loaddb.sql
    showdb.sql
  lib
    (more libraries, ask preofessor)
  src/cit285/project
    config
      SystemConfig.java 
    dao
      UserDao.java
    domain
     User.java (all domain constraints)
     ...
    presentation/web
      UserServlet.java
      DispatcherServlet.java (not sure what this is for)
    services
      UserServicesAPI.java (interface)
      UserServices.java
    
  build.xml



jsp pages:
  AddBook.jsp
  RegisterUser.jsp

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
  CheckBook 
  SelectBook (edit and delete as admin)
  AddToCart(move to shopping cart)
  EditUserInfo
  

