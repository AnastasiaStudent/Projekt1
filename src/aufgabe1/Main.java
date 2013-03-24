package aufgabe1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception, PinWrongException,
			CardInsertedException {

		CashMachine cashMachine1 = new CashMachine();
		Account account = new Account(12345678, -10, 20584, 1235);
		CashCard cashCard = new CashCard(12345678);
		//account.setAllerParameter(-152, 150, 1255);

		cashMachine1.accountStatement(account);
		cashMachine1.insertCashCard(cashCard);

		cashMachine1.pinEingeben(account, 1235);
		cashMachine1.accountStatement(account);
		cashMachine1.withdraw(account, 152);
		cashMachine1.ejectCashCard(cashCard);

	}

}
