package cit285.project.domain;

import java.time.Year;

public class Book {
	private int bookid; // Book id
	private String isbn; // Book ISBN
	private String title; // Book Title
	private String editor; // Book Editor
	private String edition; // Book Edition
	private double price;
	private String description;
	private String imagepath;
	private int year; // Book Year
	private Author author; // Book Author ID

	// Set book id
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	// Get book id
	public int getBookid() {
		return bookid;
	}

	// Set book Isbn number
	public void setIsbn(String isbn) {
	// Return true if the input is anything other than digits
		boolean hasNonDigits = isbn.matches("\\d+");
	// Check if input has non-digits
		if (hasNonDigits) {
	// Check if input is 13 digits
			if (isbn.length() == 13) {
	//-> Assign isbn
				this.isbn = isbn;
	// Check if input is less than 13 digits
			} else if (isbn.length() < 13) {
	//-> Set error message when its less than 13 digits
				throw new NumberFormatException("ISBN cannot have less than 13 digits");
	// Check if input is not 13 nor less than 13 (=> More than 13)
			} else
	//-> Clip the input and take the first 13 digits
				this.isbn = isbn.substring(0, 13);
		} else {
	//-> Set error message when input contains non-digits character 
			throw new NumberFormatException("ISBN cannot have non-digits characters");
		}
	}

	// Get book Isbn number
	public String getIsbn() {
		return isbn;
	}

	// Set book title
	public void setTitle(String title) {
	// Check if title length is less than or equal to 100 characters
		if (title.length() <= 100) {
	// If title has less than or equal to 100 character then set title
			this.title = title;
		} else {
	// If title has more than 100 characters, throw Exception and set message
			throw new IllegalArgumentException("Title cannot be longer than 100 characters");
		}
	}

	// Get book title
	public String getTitle() {
		return title;
	}

	// Set book editor
	public void setEditor(String editor) {
		this.editor = editor;
	}

	// Get book editor
	public String getEditor() {
		return editor;
	}

	// Set book edition
	public void setEdition(String edition) {
		this.edition = edition;
	}

	// Get book edition
	public String getEdition() {
		return edition;
	}

	// Set book publication year
	public void setYear(int year) {
	// Find current year
		int currentYear = Year.now().getValue();
	//Check if input year is later than current year
		if (year <= currentYear) {
	//If input year is not later than current year then set year
			this.year = year;
		} else {
	//If input year is later than current year then throw exception and set error message
			throw new IllegalArgumentException("Published year cannot be later than current year " + currentYear);
		}
	}

	// Get book publication year
	public int getYear() {
		return year;
	}

	// Set book author
	public void setAuthor(Author author) {
		this.author = author;
	}

	// Get book author
	public Author getAuthor() {
		return author;
	}

	public String toString() {
		return "BookId: " + bookid + ", ISBN: " + isbn + ", Title: " + title + ", Editor: " + editor + ", Edition: "
				+ edition + ", Year: " + year + ", Price: " + price + ", Description: " + description + ", Author: "
				+ author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
}
