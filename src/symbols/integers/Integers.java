package symbols.integers;

import symbols.Symbols;
/**
 * Integer class that extends the Symbols class. Allows identification of intigers and returns the correct values.
 * @author Kevin Wang
 *
 */
public class Integers extends Symbols {

	public Integers(String s){
		super(s);
		myTokenType = Symbols.TYPE.INTEGERS;
		myType = "integer";
		mySymbol = "i";
	}

	@Override
	public String getChValue() {
		return myValue;
	}

	@Override
	public Integer getIntValue() {
		return Integer.parseInt(myValue);
	}

	@Override
	public boolean isType(String input) {
		if(input == null) return false;

		Integer number = null;
		try{
			number = Integer.parseInt(input);
		}
		catch(NumberFormatException e){
			return false;
		}
		
		if(number<0) return false;
		if(number != 0 && input.charAt(0)=='0') return false;
		if(input.length()>3 || input.length()==0) return false;
		if(number == 0 && input.length()>1) return false;
		
		return true;

	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Integers(s);
	}

}
