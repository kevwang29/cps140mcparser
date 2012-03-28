package symbols.keywords;

import symbols.Symbols;

public class Begin extends Keywords {

	public Begin(String s) {
		super(s);
		myType = "begin";
		mySymbol = "b";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Begin(s);
	}

}
