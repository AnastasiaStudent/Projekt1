package aufgabe1;


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
public void setPin(int pinX)
{
  if ( String.valueOf(pinX).length()==4)
  {
  //if richtig
  statePIN=State.PIN_CORRECT;
  System.out.println("PIN correct"+ "/n" +"Ready");
  }
  else //if falsch
  {
  statePIN=State.PIN_WRONG;
  System.out.println(statePIN);
  throw new ExceptionGeldautomat ("-= Not successfully. Format: **** =-");
   
  }
  }
public int getPin()
{
  return pin;
}
}
