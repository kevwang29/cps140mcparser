package main;
import symbols.*;
import symbols.integers.Integers;
import symbols.keywords.*;
import symbols.parsevariables.*;
import symbols.punctuations.Semicolon;
import symbols.variables.Variables;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import exceptions.CommentException;
import exceptions.InvalidTokenException;

/**
 * Class executing the token scanning. It contains all tokens and used empty tokens to do pattern 
 * matching. When a pattern is matched, a new token of the same type is created and returned.
 * @author Kevin Wang
 *
 */


public class TokenIdentifier {
	
	List<Symbols> tokenList = new LinkedList<Symbols>();
	static TokenIdentifier tokenizer;
	
	private TokenIdentifier(){
		tokenList =new LinkedList<Symbols>(Arrays.asList(new Symbols[]{
			new Direction(""), new symbols.parsevariables.List(""), new Program(""), new Statement(""),
			new Begin(""), new Halt(""), new Cat(""), new Mouse(""), new Clockwise(""), new Move(""),
			new North(""), new South(""), new East(""), new West(""), new Hole(""), new Repeat(""), 
			new Size(""), new End(""), new Integers(""), new Semicolon(" "), new Variables(" ")
		}));
	}
	
	public static TokenIdentifier getInstance(){
		if(tokenizer == null) tokenizer = new TokenIdentifier();
		return tokenizer;
	}
	
	public Symbols generateToken(String token) throws InvalidTokenException, CommentException{
		
		if("//".equals(token)) throw new CommentException();
		
		for(Symbols symbol : tokenList){
			if(symbol.isType(token)){
				return symbol.generateNewToken(token);
			}
		}
		
		throw new InvalidTokenException(token);
	}

	
}

