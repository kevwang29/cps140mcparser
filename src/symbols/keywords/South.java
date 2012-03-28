package symbols.keywords;

import symbols.Symbols;

public class South extends Keywords {

	public South(String s) {
		super(s);
		myType = "south";
		mySymbol = "s";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new South(s);
	}

}
