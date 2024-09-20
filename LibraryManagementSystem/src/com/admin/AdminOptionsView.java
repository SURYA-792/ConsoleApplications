package com.admin;
import com.login.LoginView;
import com.model.Borrower;
import com.model.Repository;

public class AdminOptionsView {

	private BorrowerCRUDView borrowerview = new BorrowerCRUDView();
	Repository repository = Repository.getRepository();
	private BookCRUDView bookView = new BookCRUDView();

	public void init(Borrower borrower) {
		System.out.println(Repository.getRepository().loggedInUser.getName() + " Logged in Successfully!");

		boolean flag = true;
		while (flag) {
			System.out.println("\nPlease select the option:");
			System.out.println("\n1.Add User\n2.Add Book\n3.Show Book Details\n4.Delete Book\n5.View Users\n6.Logout");
			int option = LoginView.sc.nextInt();
			switch (option) {
			case 1:
				borrowerview.addUser();
				break;
			case 2:
				bookView.addBook();
				break;
			case 3:
				bookView.showBook();
				break;
			case 4:
				bookView.removeBook();
				break;
			case 5:
				borrowerview.showBorrowers();
				break;
			case 6:
				repository.loggedInUser = null;
				new LoginView().init();
			}
		}

	}
}
