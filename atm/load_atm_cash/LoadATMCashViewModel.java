package atm.load_atm_cash;

import atm.model.ATM;
import atm.repository.Repository;

public class LoadATMCashViewModel {

	private Repository repository = Repository.getInstance();

	public boolean splitDenominations(double amount) {
		double temp = amount;
		int thousands = 0;
		int fiveHundreds = 0;
		int hundreds = 0;

		fiveHundreds = (int) ((temp * 50) / 100) / 500;
		temp -= fiveHundreds * 500;

		thousands = (int) ((temp * 20) / 100) / 1000;
		temp = temp - thousands * 1000;

		hundreds = (int) (temp / 100);
		temp -= hundreds * 100;

		if (temp > 0) {
			return false;
		} else {
			ATM atm = repository.getATMDetails();
			atm.setBalanceAmount(amount);
			atm.setFiveHundredsCount(fiveHundreds);
			atm.setThousandsCount(thousands);
			atm.setHundredsCount(hundreds);
			return true;
		}

	}

//	public static void main(String[] args) {
//		System.out.println(splitDenominations(100000));
//		System.out.println(splitDenominations(200000.1));
//		System.out.println(splitDenominations(200010));
//	}

}
