package problemInputs;

import java.util.*;
import classProblems.ValidParenthesis;

public class ValidParenthesisIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParenthesis vd = new ValidParenthesis();
		ArrayList<String> validAns = new ArrayList<>();
		int num =6;
		validAns = vd.getValidParentheis(num);
		
		for(String p:validAns) {
			System.out.print(p+" ");
		}
		System.out.println("\nNumber of valid parenthseis possible : "+vd.getCountOfValidParenthesis());
	}

}
