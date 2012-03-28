package symbols.punctuations;

import symbols.Symbols;

/**
 * 
 * Class for punctuations that extends the Symbols class. All punctuations will extend this class to give the right string matching.
 * @author Kevin Wang
 *
 */
public abstract class Punctuations extends Symbols {


	public Punctuations(String s){
		super(s);
		myTokenType = Symbols.TYPE.PUNCTUATIONS;
	}
	
	@Override
	public String getChValue() {
		return null;
	}

	@Override
	public Integer getIntValue() {
		return null;
	}
	



}
