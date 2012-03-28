package symbols.variables;

import symbols.Symbols;

/**
 * 
 * Variables class that extends the symbols class. It contains the logic to identify a token as 
 * a valid variable.
 * @author Kevin Wang
 *
 */
public class Variables extends Symbols {

	public Variables(String s){
		super(s.toLowerCase());
		myTokenType = Symbols.TYPE.VARIABLES;
		myType = "variables";
		mySymbol = "v";
	}
	
	@Override
	public String getChValue() {
		return myValue;
	}

	@Override
	public Integer getIntValue() {
		return 0;
	}

	@Override
	public boolean isType(String input) {
		if(input.matches(".*\\W.*")) return false;
		if(input.length()>3) return true;
		
		input = input.toLowerCase();
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i)<='z' && input.charAt(i)>='a') return true;
		}
		return false;
	}

	@Override
	public Symbols generateNewToken(String s) {
		return new Variables(s);
	}

}
