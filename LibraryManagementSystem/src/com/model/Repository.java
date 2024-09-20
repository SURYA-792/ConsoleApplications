package com.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Base;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Repository extends Base {

	public Borrower loggedInUser;
	private static Repository repository;
	private List<Borrower> users = new ArrayList<>();
	private List<Book> books = new ArrayList<>();
	Borrower sample = new Borrower("surya", "surya", "123", true);

	public static Scanner sc = new Scanner(System.in);

	private Repository() {

	}

	public List<Borrower> getUsers() {
		users = readUsersFromJsonFile();
		return users;
	}

	public List<Borrower> getBorrowers() {
		users = readUsersFromJsonFile();
		List<Borrower> borrowers = new ArrayList<>();
		for (Borrower b : getUsers()) {
			if (!b.isAdmin())
				borrowers.add(b);
		}
		return borrowers;
	}

	public List<Book> getBooks() {
		books = readBooksFromJsonFile();
		return books;
	}

	public void addUser(Borrower b) {
		users.add(b);
		addUserToJsonFile();
	}

	public void addBook(Book book) {
		books.add(book);
		addBookToJsonFile();
	}

	public static Repository getRepository() {

		if (repository == null)
			repository = new Repository();
		return repository;
	}

	public Borrower validateUser(String userId, String password) {
		users = readUsersFromJsonFile();
		if (users != null)
			for (Borrower user : users) {
				if (user.getUserId().equals(userId) && user.getPassword().equals(password)) {
					loggedInUser = user;
					break;
				}
			}
		return loggedInUser;
	}

	public Book getBookIfAvailable(String bookName) {
		books = readBooksFromJsonFile();
		for (Book book : books) {
			if (book.getBookName().equals(bookName) && book.isStatus()) {
				book.setStatus(false);
				addBookToJsonFile();
				return book;
			}
		}
		return null;
	}

	public void removeBook(String bookName) {
		books = readBooksFromJsonFile();
		for (Book book : books) {
			if (book.getBookName().equals(bookName)) {
				if (book.isStatus()) {
					books.remove(book);
					addBookToJsonFile();
					printMessage("\nBook removed successfully!");
				} else {
					printErrorMessage("\nBook is borrowed by someone.");
				}
				return;
			}
		}
		printErrorMessage("Entered Book is not available!");
	}

	public void addUserToJsonFile() {
		
		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();
		Gson gson = gb.create();

		String jsonString = gson.toJson(users);

		FileWriter file;
		try {
			file = new FileWriter("Users.json");
			file.write(jsonString);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addBookToJsonFile() {
		GsonBuilder gb = new GsonBuilder();
		gb.setPrettyPrinting();
		Gson gson = gb.create();

		String jsonString = gson.toJson(books);

		FileWriter file;
		try {
			file = new FileWriter("Books.json");
			file.write(jsonString);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	List<Borrower> readUsersFromJsonFile() {
		List<Borrower> users = null;
		Gson gson = new Gson();
		try (FileReader reader = new FileReader("Users.json")) {
			java.lang.reflect.Type bookListType = new TypeToken<List<Borrower>>() {
			}.getType();

			users = gson.fromJson(reader, bookListType);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	public List<Book> readBooksFromJsonFile() {
		List<Book> books = null;
		Gson gson = new Gson();
		try (FileReader reader = new FileReader("Books.json")) {
			java.lang.reflect.Type bookListType = new TypeToken<ArrayList<Book>>() {
			}.getType();
			books = new ArrayList<>(gson.fromJson(reader, bookListType));
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return books;
	}
}
