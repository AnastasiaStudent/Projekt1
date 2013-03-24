package aufgabe1;
import java.lang.Exception;
public class CardNotInsertedException extends Exception {
static String text="Please insert your Card! =-";
			//String messageX = "-= Not ready. Eine Karte ist schon eingegeben! Bitte entwerfen. =-";
public CardNotInsertedException () 
	{
 super(text);

	}
}
