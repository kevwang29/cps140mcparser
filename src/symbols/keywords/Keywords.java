package symbols.keywords;

import symbols.Symbols;

/**
 * A keyword class that extends symbols. All keywords will extend this class and implement the 
 * generateNewToken method to get the right constructor and give the right myType for string matching.
 * @author Kevin Wang
 *
 */

public abstract class Keywords extends Symbols{

	public Keywords(String s) {
		super(s);
		myTokenType = Symbols.TYPE.KEYWORDS;
	}

	@Override 
	public String getChValue(){
		return null;
	}

	@Override
	public Integer getIntValue(){
		return null;
	}

	@Override
	public boolean isType(String input) {
		if(input == null) return false;
		return input.toLowerCase().equals(myType);
	}

}
