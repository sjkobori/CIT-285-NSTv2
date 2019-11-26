-- CIT-285 Group Project
-- Script to create book_store database
-- and the Author and Book tables.
-- Sebastian Brann-Singer created
-- User, Phone, Email, Address, Invoice, LineItem
-- The script for the rest of tables for project should be
-- developed by each group.
--
-- To run this script on the command line use the following syntax:
-- MySql>> source patheToThisSqlFile
--
-- For example, if the bookstore.sql is located in C:\Users\Desktop\BHCC\CLASSES\CIT-285\projects, 
-- then run it as follow:
-- MySql>> source C:/Users/Desktop/BHCC/CLASSES/CIT-285/projects/bookstore.sql
--
--
--
DROP DATABASE IF EXISTS book_store;
--
-- Create a new database.
CREATE DATABASE IF NOT EXISTS book_store;
--
-- Change the database to book_store.
USE book_store;
--
-- Change delimiter
DELIMITER //
--
-- Create tables in book_store database.
--resetting if tables exist already
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Author;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Phone;
DROP TABLE IF EXISTS Email;
DROP TABLE IF EXISTS Address;
DROP TABLE IF EXISTS Invoice;
DROP TABLE IF EXISTS LineItem;
-- creates Author table
create table Author(AuthorID BIGINT NOT NULL,
                    AuthorFirstName VARCHAR(20),
                    AuthorLastName VARCHAR(20),
                    PRIMARY KEY (AuthorID));
--
-- creates Book table
create table Book(BookID BIGINT NOT NULL,
                  ISBN VARCHAR(30) NOT NULL,
                  Title VARCHAR(100) NOT NULL,
                  Editor VARCHAR(50),
                  Edition VARCHAR(20),
                  Year INT,
                  AuthorID BIGINT NOT NULL,
                  PRIMARY KEY (BookID),
                  FOREIGN KEY(AuthorID) REFERENCES Author(AuthorID));
-- creates User table
create table User(UserID BIGINT NOT NULL,
                  Firstname VARCHAR(20) NOT NULL,
				  Lastname VARCHAR(20) NOT NULL,
                  CompanyName VARCHAR(50),
				  
                  PRIMARY KEY (UserID));
--
-- creates Phone table
create table Phone(PhoneID BIGINT NOT NULL,
				  UserID BIGINT NOT NULL,
				  PhoneNumber BIGINT NOT NULL,
				  
                  PRIMARY KEY (PhoneID),
				  FOREIGN KEY(UserID) REFERENCES User(UserID));
--
-- creates Email table
create table Email(EmailID BIGINT NOT NULL,
				  UserID BIGINT NOT NULL,
				  EmailAddress VARCHAR(50) NOT NULL,
				  
                  PRIMARY KEY (EmailID),
				  FOREIGN KEY(UserID) REFERENCES User(UserID));
--
-- creates Address table
create table Address(AddressID BIGINT NOT NULL,
				  UserID BIGINT NOT NULL,
				  Address1 VARCHAR(50) NOT NULL,
				  Address2 VARCHAR(50),
				  City VARCHAR(20) NOT NULL,
				  State CHAR(2) NOT NULL,
				  Zipcode CHAR(5) NOT NULL,
				  Country VARCHAR(20) NOT NULL,
				  
                  PRIMARY KEY (AddressID),
				  FOREIGN KEY(UserID) REFERENCES User(UserID));
--
-- creates Invoice table
create table Invoice(InvoiceID BIGINT NOT NULL,
				  UserID BIGINT NOT NULL,
				  InvoiceDate CHAR(6) NOT NULL,
				  TotalAmount INT NOT NULL,
				  IsProcessed BOOLEAN,
				  
                  PRIMARY KEY (InvoiceID),
				  FOREIGN KEY(UserID) REFERENCES User(UserID));
--
-- creates LineItem table
create table LineItem(LineItemID BIGINT NOT NULL,
				  InvoiceID BIGINT NOT NULL,
				  BookID BIGINT NOT NULL,
				  Quantity INT NOT NULL,
				 
                  PRIMARY KEY (LineItemID),
				  FOREIGN KEY(InvoiceID) REFERENCES Invoice(InvoiceID),
				  FOREIGN KEY(BookID) REFERENCES Book(BookID));				  
				  

-- Insert data into Author table.
--
insert into Author (AuthorID,AuthorFirstName,AuthorLastName)
            values (12345670,"Lori","Messier");
--
-- Insert data into Book table.
--
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,AuthorID)
            values (1230,"123-456-789-0123","Messier book 1","Editor 1","First  Edition",2014,12345670);
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,AuthorID)
            values (1231,"123-456-789-0124","Messier book 2","Editor 2","First  Edition",2018,12345670);
--
--
-- Insert data into Author table.
--
insert into Author (AuthorID,AuthorFirstName,AuthorLastName)
            values (12345671,"John","Smith");
--
-- Insert data into Book table.
--
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,AuthorID)
            values (1232,"123-456-789-0125","Smith   book 1","Editor 1","Second Edition",2019,12345671);
--
--
-- Insert data into Author table.
--
insert into Author (AuthorID,AuthorFirstName,AuthorLastName)
            values (12345672,"Amy","Bono");
--
-- Insert data into Book table.
--
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,AuthorID)
            values (1233,"123-456-789-0126","Bono    book 1","Editor 1","First  Edition",2011,12345672);
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,AuthorID)
            values (1234,"123-456-789-0127","Bono    book 2","Editor 2","Second Edition",2015,12345672);
insert into Book (BookID,ISBN,Title,Editor,Edition,Year,AuthorID)
            values (1235,"123-456-789-0128","Bono    book 3","Editor 3","Third  Edition",2019,12345672);
--
//
--
-- Change delimiter to ;
DELIMITER ;
