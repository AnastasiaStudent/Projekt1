
public class Account {
	
String accountNumber;
double overdraft;
double bankDeposit;
int pin;
State statePIN;
	public Account(String accountNumber)
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
public void setOverdraft(double overdraft)
{
	this.overdraft=overdraft;
}
public double getOverdraft()
{
  return overdraft;
}
public void setBankDeposit(double bankDeposit)
{
	this.bankDeposit=bankDeposit;
}
public double getBankDeposit()
{
  return bankDeposit;
}

public void enterPin(int pin)
{
	//if richtig
	statePIN=State.PIN_CORRECT;
	System.out.println("PIN correct"+ "/n" +"Ready");
	//else
	statePIN=State.PIN_WRONG;
	System.out.println("PIN wrong");
	//Im Zustand PIN_WRONG, ist das Ausf�hren von weiteren Methoden nicht m�glich. 
//case	
}

}
