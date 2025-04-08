package atm.user_view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import atm.model.ATM;
import atm.model.Transaction;
import atm.model.TransactionType;

public class TransactionView {
	TransactionViewModel vm = new TransactionViewModel();
	Scanner sc = new Scanner(System.in);

	public void checkBalance() {
		System.out.println("\nBalance Amount is: " + vm.getBalance());
	}

	public void printMiniStatement() {
		Queue<Transaction> statement = vm.getMiniStatement();
		if (statement.size() == 0) {
			System.err.println("\nNo transactions found!");
			return;
		}
//		statement.add(new Transaction(TransactionType.CREDIT, "Credited From 101", 1000));
		System.out.println("--------------------------------------------------------------------------");
		System.out.println(String.format("%-25s %-20s %-20s", "   Transaction", " Type", "Amount"));
		System.out.println("--------------------------------------------------------------------------");
		for (Transaction transaction : statement) {
			System.out.println(String.format("\n%-25s %-20s %-20s", transaction.getTransactionInfo(),
					transaction.getTransactionType(), transaction.getTransactionAmount()));
		}
		System.out.println("--------------------------------------------------------------------------");

	}

	public void withdraw() {
		double amount = -1;
		try {
			System.out.println("\nEnter the Amount: ");
			amount = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.err.println("\nPlease give a valid Input!");
			sc.nextLine();
			return;
		}
		if (amount < 100 || amount > 10000) {
			System.err.println("\nWithdrawl Amount should be 100 to 10000!");
		} else if (!vm.checkBalance(amount)) {
			System.err.println("\nInsufficient Balance!");
		} else if (!vm.checkDenominations(amount)) {
			System.err.println("\n!Denominations not available");
		} else {
			System.out.println("\nWithdrawl is Successfull!");
		}
	}

	public void printBalance() {
		System.out.println("\nAccount Balance is: " + vm.getBalance());
	}

	public void transferMoney() {
		int userId = -1;
		double amount = -1;

		try {
			System.out.println("\nEnter user id to transfer: ");
			userId = sc.nextInt();
			System.out.println("\nEnter the Amount to transfer: ");
			amount = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.err.println("\nPlease give a valid Input!");
			sc.nextLine();
			return;
		}
		if (!vm.hasSufficientBalance(amount)) {
			System.err.println("\nInsufficient Balance!");
		} else if (!vm.isValidUser(userId)) {
			System.err.println("\nUser is not found!");
		} else {
			vm.transferMoney(userId, amount);
			System.out.println("\nAmount transferd successfully!");
		}
	}

	public void printATMDetails() {
		ATM atm = vm.getATMDetails();

		System.out.println("\n-------------------------------");
		System.out.println("\nThousands: " + atm.getThousandsCount() * 1000);
		System.out.println("\nFive Hundreds: " + atm.getFiveHundredsCount() * 500);
		System.out.println("\nHundreds: " + atm.getHundredsCount() * 100);
		System.out.println("\nAvailable Balance: " + atm.getBalanceAmount());
		System.out.println("\n-------------------------------");

	}
}
