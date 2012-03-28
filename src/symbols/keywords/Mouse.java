package symbols.keywords;

import symbols.Symbols;

public class Mouse extends Keywords {

	public Mouse(String s) {
		super(s);
		myType = "mouse";
		mySymbol = "m";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Mouse(s);
	}

}
