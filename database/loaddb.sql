-- insert into User 
insert into User (UserID, Username, Password, FirstName, LastName, Companyname, isAdmin)
            values (11111111,"sbrannsinger","1234", "Sebastian", "Brann-Singer", "MemerINC", TRUE);
            
insert into User (UserID, Username, Password, FirstName, LastName, Companyname, isAdmin)
            values (11111112,"tdao","1234", "Tung", "Dao", "Unemployed", TRUE);

insert into User (UserID, Username, Password, FirstName, LastName, Companyname, isAdmin)
            values (11111113,"testUser","1234", "John", "Lennon", "BHCC", FALSE);
-- Insert data into Author table.
--
insert into Author (AuthorID,AuthorFirstName,AuthorLastName)
            values (12345670,"Lori","Messier");
            
insert into Author (AuthorID,AuthorFirstName,AuthorLastName)
            values (12345671,"John","Smith");
            
insert into Author (AuthorID,AuthorFirstName,AuthorLastName)
            values (12345672,"Amy","Bono");
            
-- Insert data into Book table.
--
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000000,"123-456-789-0123","JAVA Textbook","Editor 1",
            "11th Edition",2014,199.99, "Good Java Book", "fix later",12345670);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000001,"123-456-789-0124","C++ Textbook","Editor 2",
            "9th Edition",2016,249.99, "Good C++ Book", "fix later",12345670);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000002,"123-456-789-0125","Javascript Manual","Editor 1",
            "4th Edition",2011,89.99, "Dont use Javascript", "fix later",12345671);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000003,"123-456-789-0126","Paul's SQL Guide","Editor 3",
            "1st Edition",2014,19.89, "I love SQL", "fix later",12345672);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000004,"123-456-789-0127","Servlets for Dummies","Editor 1",
            "2nd Edition",2014,26.99, "All you need to know about Servlets in one place", "fix later",12345672);
            
            insert into Book (BookID,ISBN,Title,Editor,Edition,Year,Price,Description, Imagepath, AuthorID)
            values (10000005,"123-456-789-0128","History of Memes","Editor 2",
            "7th Edition",2019,420.69, "Quality Memes", "fix later",12345672);
