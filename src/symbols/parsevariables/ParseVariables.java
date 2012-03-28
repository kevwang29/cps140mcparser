package symbols.parsevariables;

import symbols.Symbols;

public abstract class ParseVariables extends Symbols{

	public ParseVariables(String s) {
		super(s);
	}

	@Override
	public String getChValue() {
		return null;
	}

	@Override
	public Integer getIntValue() {
		return null;
	}

	@Override
	public boolean isType(String input) {
		return false;
	}

}
