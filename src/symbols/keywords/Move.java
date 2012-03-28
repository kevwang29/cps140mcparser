package symbols.keywords;

import symbols.Symbols;

public class Move extends Keywords {

	public Move(String s) {
		super(s);
		myType="move";
		mySymbol = "o";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Move(s);
	}

}
