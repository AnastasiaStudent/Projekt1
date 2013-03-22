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
	private Account[] accounts = new Account[]{
		      new Account(12345678, 1234, -1000.0, 2000.0),
		      new Account(90874561, 2222, 0.0, 400.0),
		      new Account(55487565, 5555, -500.0, 1000.0),
		      new Account(12000002, 9911, -1200.0, 3875.0)
		  }; //Fake Database
	
		  private CashCard cardA = new CashCard(12345678, "Steve"); //never used because of change of main()
		  private CashCard cardB = new CashCard(90874561, "Mike");
		  private CashCard cardC = new CashCard(55487565, "Dave");
		  private CashCard cardD = new CashCard(12000002, "Jeff");
		 // private CashCard currentCard = null;  //inserted Card
	
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
	      if (accountX.getPin()==pinX) //Pin sollte fr�her in main mit der Hilfe von setPin methode geschpeichert werden
	      {
	    	  statePIN=State.PIN_CORRECT;
	    	  accounts[zaehler]=accountX;
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
	      //k�nnen die Informationen 
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
	
	public void accountStatement(Account accountX) //Kontoinformationen
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

