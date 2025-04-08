package atm.model;

import java.util.LinkedList;
import java.util.Queue;

public class User {
	private int userId;
	private int pin;
	private String userName;
	private double accountBalance;
	private Queue<Transaction> recentTransactions;

	public User(int userId, int pin, String userName, double accountBalance) {
		super();
		this.userId = userId;
		this.pin = pin;
		this.userName = userName;
		this.accountBalance = accountBalance;
		this.recentTransactions = new LinkedList<>();
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public int getPin() {
		return pin;
	}

	public double getAccountBalance() {
		return accountBalance;
	}
	public void updateAccountBalance(double amount) {
		this.accountBalance += amount;
	}
	public Queue<Transaction> getRecentTransactions() {
		return recentTransactions;
	}

	public void addRecentTransactions(Transaction recentTransaction) {
		if (this.recentTransactions.size() == 5) {
			this.recentTransactions.poll();
		}
		this.recentTransactions.add(recentTransaction);
	}

}
