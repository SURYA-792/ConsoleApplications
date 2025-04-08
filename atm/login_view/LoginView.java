package atm.login_view;

import java.util.InputMismatchException;
import java.util.Scanner;

import atm.user_view.UserView;

public class LoginView {
	LoginViewModel loginViewModel;

	public LoginView() {
		loginViewModel = new LoginViewModel(this);
	}

	public void login() {
		Scanner sc = new Scanner(System.in);
		int userId;
		int pin;
		try {
			System.out.println("\nEnter User id: ");
			userId = sc.nextInt();
			System.out.println("\nEnter the PIN number");
			pin = sc.nextInt();
			if (loginViewModel.login(userId, pin)) {
				System.out.println("\nSucessfully Logged in!");
				UserView userView = new UserView();
				userView.init();
			} else {
				System.err.println("\nInvalid User id or PIN Number");
			}
		} catch (InputMismatchException e) {
			System.err.println("\nMust userId type(Integer) and PIN type(Integer)");

		}

	}
}
