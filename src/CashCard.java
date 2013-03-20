
public class CashCard  {
	String accountNumber;
	int pin;
	
	CashCard(String accountNumber )
	{
		this.accountNumber=accountNumber;
	}
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber=accountNumber;
	}
	public String getAccountNumber()
	{
		return accountNumber;
	}
	public void setPin(int pin)
	{
		this.pin=pin;
	}
	public int getPin()
	{
		return pin;
	}
}
