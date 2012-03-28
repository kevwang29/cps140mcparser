package symbols.keywords;

import symbols.Symbols;

public class Size extends Keywords {

	public Size(String s) {
		super(s);
		myType = "size";
		mySymbol = "z";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Size(s);
	}

}
