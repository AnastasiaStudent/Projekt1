package aufgabe1;


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
	      {
	      this.cashCard=cashCardX;
	      cashCard.setAccountNumber(cashCardX.getAccountNumber());
	      
	      state=State.CARD_INSERTED;
	      System.out.println(state);
	     	          
	      }
	      break;
	      default:
	      throw new ExceptionGeldautomat("-= Not ready. Eine Karte ist schon eingegeben! Bitte entwerfen. =-");
	    
	    }	//switch Ende
	}//Karteneingabe Ende
	
	public void pinEingeben(Account accountX, int pinX) 
	{
		switch (state) {
	      case CARD_INSERTED:
	      {
	      if (accountX.getPin()==pinX) //Pin sollte früher in main mit der Hilfe von setPin methode geschpeichert werden
	      {
	    	  statePIN=State.PIN_CORRECT;
	    	  accounts[zaehler]=accountX;
	    	  accounts[zaehler].setBankDeposit(100);//zum Testen statt das mehrere male in main einzutragen
	    	  accounts[zaehler].setOverdraft(-50);//zum Testen statt das mehrere male in main einzutragen
	  	    
	    	  System.out.println(accounts[zaehler].getBankDeposit() );//zum Testen
	    	  
	      } // end of if
	      else 
	      {
	           throw new ExceptionGeldautomat("-= PIN is not corect =-");
		    
	      } // end of if-else
	      
	          
	      }
	      break;
	      default:
	      throw new ExceptionGeldautomat("-= Diese Operation ist nicht moeglich! Bitte zuerst Ihre karte eingeben. =-");
	    
	    }	//switch Ende	
		
	}
	
	
	public void withdraw(Account accountX, double amount) // Abheben
	{
		
		switch (state) 
		{
		case CARD_INSERTED:
		{ 
		switch (statePIN) {
		case PIN_CORRECT:
	      	    	  
	    	{if (accountX.bankDeposit>accountX.overdraft )
	    	{accountX.bankDeposit=accountX.bankDeposit-amount; 
	    	System.out.println("Ihr Kontoguthaben ist: " + accountX.getBankDeposit());
	    		
	    	}
	    	else
	    	{ throw new ExceptionGeldautomat("-= Unmoeglich! Nicht genug Geld auf Ihrem Konto. =-");}
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
	    throw new ExceptionGeldautomat("-= Impossible!PIN is not ok. =-");
	    }    
	      
		}
		break;
	    default:
	    throw new ExceptionGeldautomat("-= Diese Operation ist nicht moeglich! Bitte zuerst Ihre karte eingeben. =-");
	      
	        
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
	    throw new ExceptionGeldautomat("-= Impossible!PIN is not ok. =-");
	    }    
	      
	      break;
	      default:
	    	  throw new ExceptionGeldautomat("-= Not ready. Please Card inserted! =-");
	      
	    
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
	    throw new ExceptionGeldautomat("-= Impossible!PIN is not ok. =-");
	    }    
	      
	      break;
	      default:
	    	  throw new ExceptionGeldautomat("-= Not ready. Card inserted! =-");
		} // Switch State Ende
	} //Kartenauswurf Ende
	
	
	}

