package atm.model;

public class Transaction {
	private static int idGenerator;
	private int transactionId;
	private TransactionType transactionType;
	private String transactionInfo;
	private double transactionAmount;

	public Transaction(TransactionType transactionType, String transactionInfo, double transactionAmount) {
		super();
		this.transactionId = idGenerator++;
		this.transactionType = transactionType;
		this.transactionInfo = transactionInfo;
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the transactionId
	 */
	public int getTransactionId() {
		return transactionId;
	}

	/**
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * @return the transactionInfo
	 */
	public String getTransactionInfo() {
		return transactionInfo;
	}

	/**
	 * @return the transactionAmount
	 */
	public double getTransactionAmount() {
		return transactionAmount;
	}

}
