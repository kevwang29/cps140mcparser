package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import exceptions.CommentException;
import exceptions.InvalidTokenException;

import symbols.Symbols;

public class MCParser {
	
	
	String startState = "0";
	String myCurrentState;
	int myIndex=0;
	Map<String, HashMap<String,String>> myParseMap;
	List<Rule> myRules;
	
	private class Rule{
		private String RHS;
		private String LHS;
		
		public Rule(String rule){
			String[] parsedRule = rule.split("->");
			if(parsedRule.length == 2){
				RHS = parsedRule[0];
				LHS = parsedRule[1];
			}
		}
		
		public String getRHS(){
			return RHS;
		}
		
		public String getLHS(){
			return LHS;
		}
		
		public String toString(){
			return String.format("%s --> %s", getRHS(), getLHS());
		}
		
	
	}
	public MCParser(){
		this("parsedata.txt", "rulesdata.txt");
	}
	
	public MCParser(String parseDataFile, String rulesDataFile){
		initializeParseMap(parseDataFile);
		initializeRules(rulesDataFile);
	}
	
	private void initializeRules(String string) {
		myRules = new LinkedList<Rule>();
		Scanner rulesData = null;
		try {
			rulesData = new Scanner(new File(string));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		while(rulesData.hasNext()){
			myRules.add(new Rule(rulesData.nextLine()));
		}
		
		for(Rule rule : myRules){
			System.out.println(rule.toString());
		}
	}

	private void initializeParseMap(String string) {
		Scanner parseData = null;
		try {
			parseData = new Scanner(new File(string));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (parseData == null){
			return;
		}

		myParseMap = new HashMap<String, HashMap<String, String>>();
		try {
			//repeat twice because table format is folded into two rows
			fillData(myParseMap, parseData);
			fillData(myParseMap, parseData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//printContentOfParseMap(myParseMap);

	}

	private void printContentOfParseMap(
			Map<String, HashMap<String, String>> parseMap) {
		for(String state : parseMap.keySet()){
			System.out.print(state+"|");
			Map<String, String> stateMap = parseMap.get(state);
			for(String inputSymbol : stateMap.keySet()){
				System.out.print(stateMap.get(inputSymbol)+"|");
			}
			System.out.println("");
		}
		
	}

	private void fillData(
			Map<String, HashMap<String, String>> parseMap,
					Scanner parseData) throws IOException {
		String[] tokenOrder = parseData.nextLine().split("&", -1);
		int numStates = 38;

		
		for(int i=0; i<numStates; i++){
			
			HashMap<String,String> tokenMap = new HashMap<String, String>();
			
			String[] stateMapping = parseData.nextLine().split("&", -1);
			
			//extract state number
			String stateValue = stateMapping[0];
			
			//iterate row to extract state transitions
			for(int j=1; j<stateMapping.length; j++){
				if(stateMapping[j]!= null){
					tokenMap.put(tokenOrder[j], stateMapping[j]);
				}
			}
			
			//save transitions in map
			if(parseMap.containsKey(stateValue)){
				parseMap.get(stateValue).putAll(tokenMap);
			} else{
				parseMap.put(stateValue, tokenMap);
			}
			
		}	
	}

	public void parse(List<Symbols> input) throws Exception{
		resetInitialStates();
		
		while(true){
			Symbols nextSymbol = input.get(myIndex);
			String transition = myParseMap.get(myCurrentState).get(nextSymbol.getSymbol());
			if(transition == null) throw new Exception();
			char firstChar = transition.charAt(0);
			if(firstChar == 'r' || firstChar == 's'){
				if(firstChar == 's') {
					parseShift(transition, input);
				}
				if(firstChar == 'r'){
					parseReduce(transition, input);
				}
			} else{
				myCurrentState = transition;
			}
		}
	}

	private void parseReduce(String transition, List<Symbols> input) {
		Rule rule = myRules.get(Integer.parseInt(transition.substring(1)));
		int backtrackCount = rule.getRHS().split(" ").length;
		myIndex-=backtrackCount;
		while(backtrackCount>0){
			input.remove(myIndex);
		}
		
		try {
			input.add(myIndex, TokenIdentifier.getInstance().generateToken(rule.RHS));
		} catch (InvalidTokenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CommentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resetInitialStates();
		
	}

	private void parseShift(String transition, List<Symbols> input) {
		myIndex++;
		myCurrentState = transition.substring(1);
		
		
	}

	private void resetInitialStates() {
		myCurrentState = new String(startState);
		myIndex = 0;		
	}
	
}
