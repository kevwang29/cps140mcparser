package symbols.parsevariables;

import symbols.Symbols;

public class Direction extends ParseVariables{
	
	
	public Direction(String s) {
		super(s);
		mySymbol = "D";
		myType = "D";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Direction(s);
	}
}
