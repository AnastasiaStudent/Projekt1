package aufgabe1;


public class Account {
	
int accountNumber;
double overdraft;
double bankDeposit;
int pin;
State statePIN;

public Account(int accountNumber,double overdraft, double bankDeposit,int pin) 
	{
		this.accountNumber=accountNumber;
		this.overdraft=overdraft;
		this.bankDeposit=bankDeposit;
		this.pin=pin;
		//this.setPin(pin) ;
				
	}
	

public void setAccountNumber(int accountNumber)
{
	this.accountNumber=accountNumber;
}
public int getAccountNumber()
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
public void setPin(int pinX) throws ExceptionGeldautomat
{
  if ( String.valueOf(pinX).length()==4)
  {
  //if richtig
  
  }
  else //if falsch
  {
  
   throw new ExceptionGeldautomat ("-= Not successfully. Format: **** =-");
   
  }
  }
public int getPin()
{
  return pin;
}
}
