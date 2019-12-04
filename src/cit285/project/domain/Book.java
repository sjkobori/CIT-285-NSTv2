package cit285.project.domain;

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
		this.isbn = isbn;
	}

	// Get book Isbn number
	public String getIsbn() {
		return isbn;
	}

	// Set book title
	public void setTitle(String title) {
		this.title = title;
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
		this.year = year;
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
				+ edition + ", Year: " + year + ", Author: " + author;
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
