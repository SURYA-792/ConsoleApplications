package atm.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;

import atm.model.ATM;
import atm.model.Transaction;
import atm.model.User;

public class Repository {
	private static Repository repository;
	private HashMap<Integer, User> users;
	private User currentUser;
	private ATM atm = new ATM();

	private Repository() {
		users = new HashMap<>();
		loadUsers();
	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	private void loadUsers() {
		users.put(101, new User(101, 2343, "Surya", 33412));
		users.put(102, new User(101, 1323, "Ram", 10023));
		users.put(103, new User(101, 3145, "Kumar", 50400));
		users.put(104, new User(101, 7898, "Naveen", 4500));
		users.put(105, new User(101, 2091, "Balaji", 700));
	}

	public boolean loginUser(int userId, int pin) {
		if (users.containsKey(userId) && users.get(userId).getPin() == pin) {
			currentUser = users.get(userId);
			return true;
		}
		return false;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public Queue<Transaction> getMiniStatements() {
		return currentUser.getRecentTransactions();
	}

	public boolean isUser(int userId) {
		return users.containsKey(userId) ? true : false;
	}

	public boolean userHasSufficientBalance(double amount) {

		return currentUser.getAccountBalance() >= amount;
	}

	public void addRecentTransaction(int userId, Transaction transaction) {
		users.get(userId).addRecentTransactions(transaction);

	}

	public void updateAccountBalance(double amount, int userId) {
		users.get(userId).updateAccountBalance(amount);
	}

	public ATM getATMDetails() {
		// TODO Auto-generated method stub
		return atm;
	}
}
