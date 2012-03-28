package main;

public class testProgram {
	public static void main(String args[]){
		/*for(String s :"&&".split("&", -1)){
			System.out.print(s);
			System.out.println("!");
		}
		*/
		
		MCParser parser = new MCParser("parsedata.txt", "rulesdata.txt");
	}
}
