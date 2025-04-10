package social_media_application.login;

import social_media_application.repository.Repository;

public class LoginViewModel {

	Repository repository = Repository.getInstance();

	public boolean validateUser(String userId, String password) {

		return repository.validateUser(userId, password);
	}

	public boolean createUser(String userId, String name, String password) {
		return repository.addNewUser(userId, password, name);
	}

}
