package symbols;
import main.*;


/**
 * base class for Symbols. Provide method signatures for methods that all tokens has.
 * @author Kevin Wang
 *
 */
public abstract class Symbols {
	
	public enum TYPE{
		KEYWORDS, VARIABLES, INTEGERS, PUNCTUATIONS
	}
	
	protected String myValue;
	protected String myType;
	protected TYPE myTokenType;
	protected String mySymbol;
	
	
	public Symbols(String s){
		myValue = s;
	}

	public String getValue(){
		return myValue;
	}
	
	public String getType(){
		return myType;
	}
	
	public String getSymbol(){
		return mySymbol;
	}
	
	public abstract String getChValue();
	
	public abstract Integer getIntValue();
	
	public abstract boolean isType(String input);
	
	public abstract Symbols generateNewToken(String s);
	
	public String toString(){
		return String.format("%-15s%-15s%-15d", myType, getChValue(), getIntValue());
	}
}
