package symbols.parsevariables;

import symbols.Symbols;

public class List extends ParseVariables{

	public List(String s) {
		super(s);
		myType = "L";
		mySymbol = "L";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new List(s);
	}

}
