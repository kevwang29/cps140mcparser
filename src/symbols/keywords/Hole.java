package symbols.keywords;

import symbols.Symbols;

public class Hole extends Keywords {

	public Hole(String s) {
		super(s);
		myType = "hole";
		mySymbol = "h";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Hole(s);
	}

}
