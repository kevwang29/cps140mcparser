package symbols.keywords;

import symbols.Symbols;

public class Repeat extends Keywords {

	public Repeat(String s) {
		super(s);
		myType = "repeat";
		mySymbol = "r";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Repeat(s);
	}

}
