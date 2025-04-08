package atm.login_view;

import atm.repository.Repository;

class LoginViewModel {
	LoginView loginView;
	Repository repository = Repository.getInstance();

	public LoginViewModel(LoginView loginView) {
		this.loginView = loginView;
	}

	public boolean login(int userId, int pin) {
		return repository.loginUser(userId, pin);
	}

}
