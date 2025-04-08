package atm.user_view;

import java.util.List;
import java.util.Queue;

import atm.model.ATM;
import atm.model.Transaction;
import atm.model.TransactionType;
import atm.repository.Repository;

class TransactionViewModel {
	private Repository repository = Repository.getInstance();

	public double getBalance() {
		return repository.getCurrentUser().getAccountBalance();
	}

	public Queue<Transaction> getMiniStatement() {
		return repository.getMiniStatements();
	}

	public boolean hasSufficientBalance(double amount) {
		return repository.userHasSufficientBalance(amount);
	}

	public boolean isValidUser(int userId) {
		return repository.isUser(userId);
	}

	public void transferMoney(int userId, double amount) {
		Transaction sentTransaction = new Transaction(TransactionType.DEBIT, ("Transfered to " + userId), amount);
		Transaction receivedTransaction = new Transaction(TransactionType.CREDIT,
				("Received from " + repository.getCurrentUser().getUserId()), amount);

		repository.addRecentTransaction(repository.getCurrentUser().getUserId(), sentTransaction);
		repository.addRecentTransaction(userId, receivedTransaction);

		repository.updateAccountBalance(-amount, repository.getCurrentUser().getUserId());
		repository.updateAccountBalance(amount, userId);
	}

	public ATM getATMDetails() {

		return repository.getATMDetails();
	}

	public boolean checkBalance(double amount) {
		return repository.getCurrentUser().getAccountBalance() >= amount;
	}

	public boolean checkDenominations(double amount) {
		ATM atm = repository.getATMDetails();
		double tempAmount = amount;

//		int atmThousands = 10;
//		int atmFiveHundreds = 8;
//		int atmHundreds = 10;

		int atmThousands = atm.getThousandsCount();
		int atmFiveHundreds = atm.getFiveHundredsCount();
		int atmHundreds = atm.getHundredsCount();

		int maximumThousands = 1;
		int maximunFiveHundreds = 6;
		int maximumHundreds = 10;

		if (tempAmount <= 5000) {
			maximumThousands = 1;
			maximunFiveHundreds = 6;
			maximumHundreds = 10;

			while (tempAmount > 0) {
				// for thousands
				while (tempAmount >= 1000 && maximumThousands >= 1 && atmThousands >= 1) {
					tempAmount -= 1000;
					maximumThousands--;
					atmThousands--;
				}
				// if thousands not available when amount is greater that 1000.
				if (tempAmount >= 1000 && maximumThousands == 1) {
					return false;
				}
				// for Five hundreds
				while (tempAmount >= 500 && maximunFiveHundreds > 0 && atmFiveHundreds > 0) {
					tempAmount -= 500;
					maximunFiveHundreds--;
					atmFiveHundreds--;
				}

				while (tempAmount >= 100 && maximumHundreds >= 1 && atmHundreds >= 1) {
					tempAmount -= 100;
					maximumHundreds--;
					atmHundreds--;
				}
				if (tempAmount > 0)
					return false;
			}
			// for Above five thousands
		} else {
			maximumThousands = 3;
			int minimumFiveHundreds = 6;
			maximumHundreds = 10;

			while (tempAmount >= 1000 && maximumThousands >= 1 && atmThousands >= 1) {
				tempAmount -= 1000;
				maximumThousands--;
				atmThousands--;
				if (maximumThousands == 0)
					break;
			}
			// if thousands not available when amount is greater that 1000.
			if (maximumThousands >= 1) {
				return false;
			}
			// for Five hundreds
			while (tempAmount >= 500 && atmFiveHundreds > 0) {
				tempAmount -= 500;
				minimumFiveHundreds--;
				atmFiveHundreds--;
//				System.out.println("500: " + tempAmount);
			}
			// minimum six five hundred should be used
			if (minimumFiveHundreds > 0) {
				return false;
			}

			while (tempAmount >= 100 && maximumHundreds >= 1 && atmHundreds >= 1) {
				tempAmount -= 100;
				maximumHundreds--;
				atmHundreds--;
			}
			if (tempAmount > 0)
				return false;

		}
		atm.setBalanceAmount(-amount);
		atm.setFiveHundredsCount(atmFiveHundreds);
		atm.setThousandsCount(atmThousands);
		atm.setHundredsCount(atmHundreds);
		repository.getCurrentUser().updateAccountBalance(-amount);
		Transaction transaction = new Transaction(TransactionType.DEBIT, ("Withdrawal from ATM"), amount);
		repository.getCurrentUser().addRecentTransactions(transaction);
		return true;
	}

	public static void main(String[] args) {
//		System.out.println(checkDenominations(7100));
	}

}
