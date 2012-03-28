package main;
import symbols.Symbols;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import exceptions.CommentException;
import exceptions.InvalidTokenException;
/**
 * 
 * Scanner that uses the TokenIdentifer to generate token. Handles reading the input file and breaking
 * the input lines into individual words for tokenizer to tokenize.
 * @author Kevin Wang
 *
 */


public class MCScanner {
	private TokenIdentifier tokenizer = new TokenIdentifier();

	public void scanFile(String fileName){
		File file = new File(fileName);
		Scanner scanner = null;
		try{
			scanner = new Scanner(file);
		} catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}

		int lineNumber =0;
		List<Symbols> symbolList = new LinkedList<Symbols>();
		System.out.format("%-15s%-15s%-15s\n", "TYPE", "CH VALUE" ,"INT VALUE");
		while(scanner.hasNext()){
			lineNumber++;
			String line = scanner.nextLine();
			symbolList.addAll(convertToToken(line, lineNumber));
		}

	}

	public List<Symbols> convertToToken(String line, int lineNumber)  {

		List<Symbols> tokenList = new LinkedList<Symbols>();

		for(String token : line.split("\\s+")){
			
			if(token.length() == 0) continue;
			
			try{
				Symbols output = tokenizer.generateToken(token);
				System.out.println(output);
				tokenList.add(output);
			}
			catch(InvalidTokenException e){
				System.out.println(String.format("Error occured at line %d: %s", lineNumber, e.getMessage()));
			}
			catch(CommentException e){
				break;
			}
		}
		return tokenList;
	}
}
