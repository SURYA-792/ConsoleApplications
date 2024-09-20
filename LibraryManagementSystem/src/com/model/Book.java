package com.model;

public class Book {
	private String ISBN;
	private String bookName;
	private String author;
	private boolean status;
	
	public Book() {
		super();
	}

	public Book(String iSBN, String bookName, String author, boolean status) {
		super();
		ISBN = iSBN;
		this.bookName = bookName;
		this.author = author;
		this.status = status;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", bookName=" + bookName + ", author=" + author + ", status=" + status + "]";
	}
	
}
