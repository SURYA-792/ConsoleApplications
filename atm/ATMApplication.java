package atm;

import java.util.InputMismatchException;
import java.util.Scanner;

import atm.load_atm_cash.LoadATMCashView;
import atm.login_view.LoginView;

public class ATMApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\nEnter the option:\n1.Load Cash to ATM\n2.Login");
			int option;
			// to avoid program crash if user enters invalid input
			try {
				option = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("\nPlease give a valid Input!");
				sc.nextLine();
				continue;
			}

			switch (option) {
			case 1: {
				LoadATMCashView view = new LoadATMCashView();
				if(view.loadCash()) {
					System.out.println("\nCash Loaded Successfully!");
				}else {
					System.err.println("\nCash cannot be loaded invalid demoninations Only accepts 1000, 500, 100!");
				}
			}
				break;
			case 2: {
				LoginView loginView = new LoginView();
				loginView.login();

			}
				break;
			default: {
				System.err.println("Please enter the valid option!");
			}
			}
		}
	}
}
