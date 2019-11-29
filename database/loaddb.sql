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
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,AuthorID)
            values (1230,"123-456-789-0123","Messier book 1","Editor 1","First  Edition",2014,12345670);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,AuthorID)
            values (1231,"123-456-789-0124","Messier book 2","Editor 2","First  Edition",2018,12345670);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,AuthorID)
            values (1232,"123-456-789-0125","Smith   book 1","Editor 1","Second Edition",2019,12345671);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,AuthorID)
            values (1233,"123-456-789-0126","Bono    book 1","Editor 1","First  Edition",2011,12345672);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,AuthorID)
            values (1234,"123-456-789-0127","Bono    book 2","Editor 2","Second Edition",2015,12345672);
            
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,AuthorID)
            values (1235,"123-456-789-0128","Bono    book 3","Editor 3","Third  Edition",2019,12345672);
