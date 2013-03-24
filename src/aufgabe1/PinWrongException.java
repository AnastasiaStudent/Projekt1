package aufgabe1;

import java.lang.Exception;

public class PinWrongException extends Exception {
	static String text = "-= Pin is wrong! =-";

	// String messageX =
	// "-= Not ready. Eine Karte ist schon eingegeben! Bitte entwerfen. =-";
	public PinWrongException() {
		super(text);

	}
}
