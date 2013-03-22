package aufgabe1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		
		
		CashCard CC = new CashCard("1258");
		CC.setPin(1414);
		//CC.setAccountNumber(accountNumber);
		System.out.println(CC.getAccountNumber());
		
		
		CashMachine CM= new CashMachine();
		CM.insertCashCard(CC);
		CM.withdraw(21);
		
	
	}

}

