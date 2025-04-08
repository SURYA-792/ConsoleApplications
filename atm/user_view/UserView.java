package atm.user_view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserView {
	Scanner sc = new Scanner(System.in);
	TransactionView view = new TransactionView();

	public void init() {
		boolean flag = true;
		while (flag) {
			int option = -1;
			System.out.println(
					"\nEnter the option:\n1.Withdraw\n2.Check Account Balance.\n3.Transfer Money\n4.Mini Statement\n5.View ATM Details\n6.Logout");
			try {
				option = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("\nPlease give a valid Input!");
				sc.nextLine();
			}

			switch (option) {
			case 1: {
				view.withdraw();
			}
				break;
			case 2: {
				view.printBalance();
			}
				break;
			case 3: {
				view.transferMoney();
			}
				break;
			case 4: {
				view.printMiniStatement();
			}
				break;
			case 5: {
				view.printATMDetails();
			}
				break;
			case 6: {
				return;
			}
			default: {
				System.err.println("\nPlease enter a valid option!");
			}
			}
		}
	}
}
