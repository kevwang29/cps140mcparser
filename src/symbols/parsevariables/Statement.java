package symbols.parsevariables;

import symbols.Symbols;

public class Statement extends ParseVariables{
	public Statement(String s) {
		super(s);
		mySymbol = "S";
		myType = "S";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Statement(s);
	}
}
