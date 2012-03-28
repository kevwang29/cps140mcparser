package symbols.keywords;

import symbols.Symbols;

public class West extends Keywords {
	
	
	public West(String s) {
		super(s);
		myType = "west";
		mySymbol = "w";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new West(s);
	}

}
