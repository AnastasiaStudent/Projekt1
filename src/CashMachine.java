
public class CashMachine {
	Account[] accounts;
	CashCard cashCard;
	State state;
	State statePIN;
	int zaehler;
	CashMachine()
	{
	 accounts=new Account [100];
	 cashCard=new CashCard("ACCOUNTNUMMER");
	 zaehler=0;
	 state=State.READY;
	 
	}
	
	public void insertCashCard(CashCard cashCardX) //Karteneingabe
	{
		switch (state) {
	      case READY:
	      {System.out.println("Card is successfully inserted.");
	      this.cashCard=cashCardX;
	      cashCard.setAccountNumber(cashCardX.getAccountNumber());
	      state=State.CARD_INSERTED;
	      
	      //PIN von console reden
	      int pinX=1414;
	      if (cashCardX.getPin()==pinX) 
	      {
	    	  statePIN=State.PIN_CORRECT;
	    	  
	    	  accounts[zaehler].setAccountNumber(cashCardX.getAccountNumber());
	    	  accounts[zaehler].setBankDeposit(100);
	    	  accounts[zaehler].setOverdraft(-50);
	    	  System.out.println(accounts[zaehler].getBankDeposit() );
	    	  
	      } // end of if
	      else 
	      {
	           throw new MeinException("-= PIN is not corect =-");
		    
	      } // end of if-else
	      
	          
	      }
	      break;
	      default:
	      throw new MeinException("-= Not ready. Card inserted! =-");
	    
	    }	//switch Ende
	}//Karteneingabe Ende
	
	public void withdraw(double amount) // Abheben
	{
		
		switch (state) 
		{
		case CARD_INSERTED:
		{ 
		switch (statePIN) {
		case PIN_CORRECT:
	      	    	  
	    	{if (accounts[zaehler].bankDeposit>accounts[zaehler].overdraft )
	    	{accounts[zaehler].bankDeposit=accounts[zaehler].bankDeposit-amount; 
	    	System.out.println("Ihr Kontoguthaben ist: " + accounts[zaehler].getBankDeposit());
	    		
	    	}
	    	else
	    	{ throw new MeinException("-= Impossible! Not enough money in the account =-");}
	    	{
	    	}
	      //System.out.println("Ready.");
	      //Nur im Zustand READY 
	      //können die Informationen 
	      //der eingegebenen Cashcard 
	      //im Attribute cashCard 
	      //abgespeichert werden. Bei 
	      //erfolgreicher Eingabe 
	      //wechselt der Zustand von 
	      //READY auf CARD_INSERTED. 
	      //Der Status des Automaten soll
	      //auf der Konsole protokolliert 
	      //werden.
	    	}
	    	 break;
	      default:
	    throw new MeinException("-= Impossible!PIN is not ok. =-");
	    }    
	      
		}
		break;
	    default:
	    throw new MeinException("-= Not ready. Card  is not inserted! =-");
	      
	      
	    
		}	//switch State Ende	
	}// Abheben Ende
	
	public void accountStatement() //Kontoinformationen
	{
		switch (state) {
		case CARD_INSERTED:
		switch (statePIN) {
		case PIN_CORRECT:
	    	System.out.println("Ihr Kontoguthaben ist: und weitere Info" + accounts[zaehler].getBankDeposit());
	    	//WEITERE INFO
	    
	      	      
	    	break;
	      default:
	    throw new MeinException("-= Impossible!PIN is not ok. =-");
	    }    
	      
	      break;
	      default:
	    	  throw new MeinException("-= Not ready. Card inserted! =-");
	      
	    
		}	//switch	
	} //Kontoinformationen Ende
	public void ejectCashCard() //Kartenauswurf
	{
		switch (state) {
		case CARD_INSERTED:
		switch (statePIN) {
		case PIN_CORRECT:
	      	    	  
		//das Attribute cashCard wird zur Nullreferenz. 
		state=State.READY; 
        System.out.println("Ready");
        zaehler++;
        break;
	      default:
	    throw new MeinException("-= Impossible!PIN is not ok. =-");
	    }    
	      
	      break;
	      default:
	    	  throw new MeinException("-= Not ready. Card inserted! =-");
		} // Switch State Ende
	} //Kartenauswurf Ende
	
	
	}

