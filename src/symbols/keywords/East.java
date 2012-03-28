package symbols.keywords;

import symbols.Symbols;

public class East extends Keywords {

	public East(String s) {
		super(s);
		myType = "east";
		mySymbol = "e";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new East(s);
	}

}
