-- insert into User 
insert into User (UserID, Username, Password, FirstName, LastName, Companyname, isAdmin)
            values (10000001,"sbrannsinger","1234", "Sebastian", "Brann-Singer", "MemerINC", TRUE);
            
insert into User (UserID, Username, Password, FirstName, LastName, Companyname, isAdmin)
            values (10000002,"tdao","1234", "Tung", "Dao", "Unemployed", TRUE);
            
 insert into User (UserID, Username, Password, FirstName, LastName, Companyname, isAdmin)
            values (10000003,"nadir","1234", "Nadir", "Sad", "Google", TRUE);

insert into User (UserID, Username, Password, FirstName, LastName, Companyname, isAdmin)
            values (10000004,"testUser","1234", "John", "Lennon", "BHCC", FALSE);
                        
insert into User (UserID, Username, Password, FirstName, LastName, Companyname, isAdmin)
            values (10000005,"morenoAdmin","1234", "Carmelito", "Moreno", "BHCC", TRUE);

insert into User (UserID, Username, Password, FirstName, LastName, Companyname, isAdmin)
            values (10000006,"morenoUser","1234", "Carmelito", "Moreno", "BHCC", FALSE);
-- Insert data into Author table.
--
insert into Author (AuthorID,AuthorFirstName,AuthorLastName)
            values (12345670,"Samual","Simpson");
            
insert into Author (AuthorID,AuthorFirstName,AuthorLastName)
            values (12345671,"Sophia","Tyranus");
            
insert into Author (AuthorID,AuthorFirstName,AuthorLastName)
            values (12345672,"Saffron","Lin");
            
insert into Author (AuthorID,AuthorFirstName,AuthorLastName)
            values (12345673,"Deacon","Dugtrio");
            
-- Insert data into Book table.
--
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000000,"1234567890123","JAVA Textbook","Editor 1",
            "11th Edition",2014,199.99, "Good Java Book", "web/images/book_images/JAVA_book.jpg",12345670);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000001,"1234567890124","C++ Textbook","Editor 2",
            "9th Edition",2016,249.99, "Good C++ Book", "web/images/book_images/C++.jpg",12345670);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000002,"1234567890125","Javascript Manual","Editor 1",
            "4th Edition",2011,89.99, "Dont use Javascript", "web/images/book_images/Javascript.jpg",12345671);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000003,"1234567890126","Paul's SQL Guide","Editor 3",
            "1st Edition",2014,19.89, "I love SQL", "web/images/book_images/SQL.jpg",12345672);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000004,"1234567890127","Servlets for Dummies","Editor 1",
            "2nd Edition",2014,26.99, "All you need to know about Servlets in one place", "web/images/book_images/Servlet.jpg",12345672);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000005,"1234567890128","History of Memes","Editor 2",
            "7th Edition",2019,420.69, "Quality Memes", "web/images/book_images/memebook.jpg",12345672);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000006,"1234567890129","SUPER HTML","Editor 4",
            "2nd Edition",2001, 29.99, "The absolute, most comprehensive guide to HTML", "web/images/book_images/HTML_book.jpg",12345672);
