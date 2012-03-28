package symbols.keywords;

import symbols.Symbols;

public class Clockwise extends Keywords {

	public Clockwise(String s) {
		super(s);
		myType = "clockwise";
		mySymbol = "l";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Clockwise(s);
	}

}
