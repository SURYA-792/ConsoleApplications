package com.model;

import java.util.ArrayList;
import java.util.List;

public class Borrower {

	private String  name;
	private String  userId;
	private String  password;
	private boolean isAdmin;

	private List<Book> borrowedBooks;

	public Borrower() {
		super();
	}

	public void addBook(Book book) {
		if (borrowedBooks == null)
			borrowedBooks = new ArrayList<>();
		borrowedBooks.add(book);
	}

	public void removeBook(Book book) {
		borrowedBooks.remove(book);
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public Borrower(String name, String userId, String password, boolean isAdmin) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Borrower [name=" + name + ", userId=" + userId + ", password=" + password + ", isAdmin=" + isAdmin
				+ ", borrowedBooks=" + borrowedBooks + "]";
	}
	
}
