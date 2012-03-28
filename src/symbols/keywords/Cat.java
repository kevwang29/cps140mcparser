package symbols.keywords;

import symbols.Symbols;

public class Cat extends Keywords {

	public Cat(String s) {
		super(s);
		myType = "cat";
		mySymbol = "c";
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Cat(s);
	}

}
