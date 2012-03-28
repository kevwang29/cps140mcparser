package symbols.keywords;

import symbols.Symbols;

public class North extends Keywords {

	public North(String s) {
		super(s);
		myType = "north";
		mySymbol = "n";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new North(s);
	}

}
