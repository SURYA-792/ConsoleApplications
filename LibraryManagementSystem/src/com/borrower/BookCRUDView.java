package com.borrower;

import java.util.List;

import com.model.Book;
import com.model.Borrower;
import com.model.Repository;

public class BookCRUDView {
	Repository repository = Repository.getRepository();
	private BookCRUDViewModel bookViewModel;

	BookCRUDView() {
		bookViewModel = new BookCRUDViewModel(this);
	}

	void borrowBook() {
		System.out.println("Enter the book name: ");
		String bookName = repository.sc.next();
		bookViewModel.borrowBook(bookName);
	}

	void showBooks() {
		List<Book> books = bookViewModel.showBooks();
		if (books.size() == 0)
			System.out.println("Books are not available!");
		for (Book book : books) {
			System.out
					.println("\nBook Name: " + book.getBookName() + "\nBook ISBN: " + book.getISBN() + "\nBook Author: "
							+ book.getAuthor() + "\nStatus : " + (book.isStatus() ? "Available" : "Not Available"));

			System.out.println("----------------------------------------------");
		}
	}

	void returnBook() {
		System.out.println("Enter the book name: ");
		String bookName = repository.sc.next();
		bookViewModel.returnBook(bookName);

	}

	void viewBorrowedBooks() {
		Repository repository = Repository.getRepository();
		List<Book> borrowedBooks = repository.loggedInUser.getBorrowedBooks();

		if (borrowedBooks == null || borrowedBooks.size() == 0) {
			System.out.println("Borrowed list is empty");
			return;
		}
		for (Book book : borrowedBooks) {
			System.out.println("    --Book Name: " + book.getBookName());
		}
	}

}
