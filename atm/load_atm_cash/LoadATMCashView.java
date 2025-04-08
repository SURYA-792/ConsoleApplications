package atm.load_atm_cash;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoadATMCashView {
	LoadATMCashViewModel vm = new LoadATMCashViewModel();
	Scanner sc = new Scanner(System.in);

	public boolean loadCash() {
		System.out.println("\nEnter the amount: ");
		try {
			double amount = sc.nextDouble();
			return vm.splitDenominations(amount);
		} catch (InputMismatchException e) {
			System.err.println("\nPlease give a correct amount :");
			sc.nextLine();
			return false;
		}
	}
}
