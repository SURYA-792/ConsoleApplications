package com.admin;

import java.util.ArrayList;
import java.util.List;

import com.Base;
import com.model.Book;
import com.model.Borrower;
import com.model.Repository;

public class BorrowerCRUDView extends Base {
	private BorrowerCRUDViewModel borrowerModel;

	public BorrowerCRUDView() {
		borrowerModel = new BorrowerCRUDViewModel(this);
	}

	void addUser() {
		System.out.println("Enter Borrower Name: ");

		String name = Repository.sc.next();
		System.out.println("Enter UserId: ");

		String userId = Repository.sc.next();
		System.out.println("Enter Password: ");

		String password = Repository.sc.next();
		System.out.println("(0)Borrower (1)Admin: ");

		int isAdmin = Repository.sc.nextInt();
		borrowerModel.addUser(name, userId, password, isAdmin);
		System.out.println((isAdmin == 1 ? "Admin" : "Borrower ") + " Added Successfully!");
	}

	void showBorrowers() {

		List<Borrower> borrowers = borrowerModel.getBorrowers();
		if (borrowers.size() == 0) {
			printErrorMessage("Borrowers not added");
			return;
		}
		for (int i = 0; i < borrowers.size(); i++) {

			Borrower b = borrowers.get(i);
			System.out.println(i + 1 + "." + "User Name: " + b.getName());
			List<Book> borrowedbooks = b.getBorrowedBooks();

			if (borrowedbooks == null || borrowedbooks.size() == 0) {
				System.out.println("	---No books are Borrowed");
				System.out.println("-------------------------------------");
				continue;
			}

			for (Book book : borrowedbooks) {
				System.out.println("	---" + book.getBookName());
			}

			System.out.println("-------------------------------------");
		}
	}
}
