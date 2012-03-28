package symbols.keywords;

import symbols.Symbols;

public class Halt extends Keywords {

	public Halt(String s) {
		super(s);
		myType = "halt";
		mySymbol = "t";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Halt(s);
	}

}
