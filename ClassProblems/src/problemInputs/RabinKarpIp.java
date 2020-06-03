package problemInputs;

import classProblems.RabinKarp;

public class RabinKarpIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prime = 101;	
		int matchIndex;
		String text = "vipin rai parari mtech cse iiitb";
		
		RabinKarp p = new RabinKarp(text,256,prime);
		matchIndex  = p.patternMatch("iit");
		
		if(matchIndex==-1) {
			System.out.println("No match found!!!");
		}
		else {
			System.out.println("Match found at index: "+ matchIndex);
		}		
	}
}
