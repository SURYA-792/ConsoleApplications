package com.borrower;

import com.login.LoginView;
import com.model.Repository;

public class BorrowerOptionsView {
	Repository repository = Repository.getRepository();
	private BookCRUDView bookView = new BookCRUDView();

	public void init() {
		System.out.println(Repository.getRepository().loggedInUser.getName() + " Logged in Successfully!");
		boolean flag = true;

		while (flag) {
			System.out.println("\nPlease select the option:");
			System.out.println("\n1.Borrow Book\n2.View books details\n3.Return Book\n4.View Borrowed Books\n5.Logout");
			int option = LoginView.sc.nextInt();

			switch (option) {
			case 1:
				bookView.borrowBook();
				break;
			case 2:
				bookView.showBooks();
				break;
			case 3:
				bookView.returnBook();
				break;
			case 4:
				bookView.viewBorrowedBooks();
				break;
			case 5:
				flag = false;
				repository.loggedInUser = null;
				new LoginView().init();
			}
		}
	}
}
