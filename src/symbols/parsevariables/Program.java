package symbols.parsevariables;

import symbols.Symbols;

public class Program extends ParseVariables{

	public Program(String s) {
		super(s);
		myType = "P";
		mySymbol="s";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Program(s);
	}

}
