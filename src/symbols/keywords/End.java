package symbols.keywords;

import symbols.Symbols;

public class End extends Keywords {

	public End(String s) {
		super(s);
		myType = "end";
		mySymbol = "d";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new End(s);
	}

}
