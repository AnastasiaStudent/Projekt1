package aufgabe1;
import java.lang.Exception;
public class CardInsertedException extends Exception {
static String text="nnn";
	//String messageX = "-= Not ready. Eine Karte ist schon eingegeben! Bitte entwerfen. =-";
	public CardInsertedException () 
	{
        super(text);

}
}
