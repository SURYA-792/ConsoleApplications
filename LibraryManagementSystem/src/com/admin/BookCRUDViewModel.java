package com.admin;

import java.util.List;

import com.Base;
import com.model.Book;
import com.model.Repository;

public class BookCRUDViewModel extends Base {

	private BookCRUDView bookView;
	Repository repository = Repository.getRepository();

	public BookCRUDViewModel(BookCRUDView bookView) {
		this.bookView = bookView;
	}

	void addBook(String bookName, String isbn, String author) {
		Book book = new Book(isbn, bookName, author, true);
		repository.addBook(book);

	}

	public List<Book> getBooksDetails() {
		if (repository.getBooks().size() == 0) {
			printErrorMessage("No books are Added");
		}
		return repository.getBooks();
	}

	public void removeBook(String bookName) {
		repository.removeBook(bookName);

	}

}
