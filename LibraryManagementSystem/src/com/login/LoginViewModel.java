package com.login;

import com.admin.AdminOptionsView;
import com.borrower.BorrowerOptionsView;
import com.model.Borrower;
import com.model.Repository;

public class LoginViewModel {

	private LoginView loginView;

	public LoginViewModel(LoginView view) {
		loginView = view;
	}

	public void validateUser(String userId, String password) {
		Repository repo = Repository.getRepository();
		Borrower user = repo.validateUser(userId, password);
		
		if (user == null) {
			System.err.println("\nInvalid user name or password Please Try Again");
			loginView.init();
		} else if (user.isAdmin()) {
			AdminOptionsView aov = new AdminOptionsView();
			aov.init(user);
		} else {
			BorrowerOptionsView bov = new BorrowerOptionsView();
			bov.init();
		}
	}
}
