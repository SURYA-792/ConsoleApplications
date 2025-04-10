package social_media_application.login;

import java.util.InputMismatchException;
import java.util.Scanner;

import social_media_application.user_view.UserView;


public class LoginView {
	Scanner sc = new Scanner(System.in);
	LoginViewModel vm = new LoginViewModel();

	public void login() {
		String userId;
		String password;
		while (true) {
			try {
				System.out.println("\nEnter the User id: ");
				userId = sc.nextLine();
				System.out.println("\nEnter the password: ");
				password = sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.err.println("\nPlease give a valid input!");
				sc.nextLine();
				continue;
			}
		}
		if (vm.validateUser(userId, password)) {
			System.out.println("\nLogged in successfully!");
			UserView view = new UserView();
			view.init();
		} else {
			System.err.println("\nInvalid user id or password!");
		}
	}

	public void signIn() {
		String userId;
		String password;
		String name;
		while (true) {
			try {
				System.out.println("\nEnter the User id: ");
				userId = sc.nextLine();
				System.out.println("\nEnter the Password: ");
				password = sc.nextLine();
				System.out.println("\nEnter the Name: ");
				name = sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.err.println("\nPlease give a valid input!");
				sc.nextLine();
				continue;
			}
		}
		if (vm.createUser(userId, name, password)) {
			System.out.println("\nAccount Created Successfully!");
		} else {
			System.err.println("\nUser id already exists please use different user id!");
		}
	}
}
