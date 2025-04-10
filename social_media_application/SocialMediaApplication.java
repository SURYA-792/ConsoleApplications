package social_media_application;

import java.util.InputMismatchException;
import java.util.Scanner;

import social_media_application.login.LoginView;

public class SocialMediaApplication {
	public static void main(String[] args) {

		LoginView view = new LoginView();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nEnter the option:\n1.Login\n2.Create New Account");
			int option;
			try {
				option = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.err.println("\nPlease give a valid input!");
				sc.nextLine();
				continue;
			}

			switch (option) {
			case 1: {
				view.login();
			}
				break;

			case 2: {
				view.signIn();
			}
				break;

			default: {
				System.err.println("\nPlease select a valid option!");
			}
			}
		}
	}
}
