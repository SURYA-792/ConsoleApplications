package com.admin;

import java.util.List;

import com.Base;
import com.model.Book;
import com.model.Repository;

public class BookCRUDView extends Base {
	private Repository repository = Repository.getRepository();
	private BookCRUDViewModel bookModel;

	BookCRUDView() {
		bookModel = new BookCRUDViewModel(this);
	}

	public void addBook() {

		System.out.println("Enter the Book Name: ");
		String bookName = Repository.sc.next();

		System.out.println("Enter the ISBN: ");
		String isbn = Repository.sc.next();

		System.out.println("Enter the Author: ");
		String author = Repository.sc.next();

		bookModel.addBook(bookName, isbn, author);
	}

	public void showBook() {
		List<Book> books = bookModel.getBooksDetails();

		for (Book book : books) {
			System.out
					.println("\nBook Name: " + book.getBookName() + "\nBook ISBN: " + book.getISBN() + "\nBook Buthor: "
							+ book.getAuthor() + "\nBook Status: " + (book.isStatus() ? "Available" : "Not Available"));
			System.out.println("--------------------------------------------------");
		}
	}

	public void removeBook() {
		System.out.println("\nEnter the book name: ");
		String name = repository.sc.next();
		bookModel.removeBook(name);
	}
}
