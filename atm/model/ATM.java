package atm.model;

public class ATM {
	private int thousandsCount;
	private int fiveHundredsCount;
	private int hundredsCount;
	private double balanceAmount;

	public ATM() {
		super();
	}

	/**
	 * @return the thousandsCount
	 */
	public int getThousandsCount() {
		return thousandsCount;
	}

	/**
	 * @param thousandsCount the thousandsCount to set
	 */
	public void setThousandsCount(int thousandsCount) {
		this.thousandsCount = thousandsCount;
	}

	/**
	 * @return the fiveHundredsCount
	 */
	public int getFiveHundredsCount() {
		return fiveHundredsCount;
	}

	/**
	 * @param fiveHundredsCount the fiveHundredsCount to set
	 */
	public void setFiveHundredsCount(int fiveHundredsCount) {
		this.fiveHundredsCount = fiveHundredsCount;
	}

	/**
	 * @return the hundredsCount
	 */
	public int getHundredsCount() {
		return hundredsCount;
	}

	/**
	 * @param hundredsCount the hundredsCount to set
	 */
	public void setHundredsCount(int hundredsCount) {
		this.hundredsCount = hundredsCount;
	}

	/**
	 * @return the balanceAmount
	 */
	public double getBalanceAmount() {
		return balanceAmount;
	}

	/**
	 * @param balanceAmount the balanceAmount to set
	 */
	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount += balanceAmount;
	}

}
