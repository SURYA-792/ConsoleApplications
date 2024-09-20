package com.borrower;

import java.util.List;

import com.Base;
import com.model.Book;
import com.model.Borrower;
import com.model.Repository;

class BookCRUDViewModel extends Base {
	private BookCRUDView bookView;
	Repository repository = Repository.getRepository();

	public BookCRUDViewModel(BookCRUDView bookView) {
		this.bookView = bookView;
	}

	void borrowBook(String bookName) {
		Book book = repository.getBookIfAvailable(bookName);

		if (book == null) {
			printErrorMessage("Entered Book is not available!");
		} else {
			printMessage("Book Borrowed Successfully!");
			book.setStatus(false);
			repository.loggedInUser.addBook(book);
			repository.addBookToJsonFile();
			repository.addUserToJsonFile();

		}
	}

	void returnBook(String bookName) {
		List<Book> borrowedBooks = repository.loggedInUser.getBorrowedBooks();

		if (borrowedBooks == null || borrowedBooks.size() == 0) {
			printErrorMessage("\nNo books borrowed from this account!.");
		} else {
			for (Book book : borrowedBooks) {
				if (book.getBookName().equals(bookName)) {
					book.setStatus(true);
					repository.addBookToJsonFile();
					repository.loggedInUser.removeBook(book);
					repository.addUserToJsonFile();

					printMessage("\nBook returned Successfully!");
					return;
				}
			}
			printErrorMessage("\nInvalid book name");
		}
	}

	List<Book> showBooks() {
		List<Book> books = repository.readBooksFromJsonFile();
		return books;
	}
}
