package symbols.punctuations;

import symbols.Symbols;

public class Semicolon extends Punctuations {

	public Semicolon(String s) {
		super(s);
		myType = ";";
		mySymbol = ";";
	}

	@Override
	public boolean isType(String input) {
		return ";".equals(input);
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Semicolon(";");
	}

}
