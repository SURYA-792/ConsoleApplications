package com.admin;

import java.util.ArrayList;
import java.util.List;

import com.model.Borrower;
import com.model.Repository;

class BorrowerCRUDViewModel {

	BorrowerCRUDView borrowerView;
	private Repository repository = Repository.getRepository();

	BorrowerCRUDViewModel(BorrowerCRUDView view) {
		this.borrowerView = view;
	}

	void addUser(String name, String userId, String password, int isAdmin) {
		Borrower borrower = new Borrower(name, userId, password, isAdmin == 1 ? true : false);
		repository.addUser(borrower);
	}

	List<Borrower> getBorrowers() {
		return repository.getBorrowers();
	}

}
