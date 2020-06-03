package classProblems;
import java.util.*;

public class ValidParenthesis {

	public ArrayList<String> validAns;
	public int countValid;
	
	public ValidParenthesis() {
		validAns = new ArrayList<String>();
	}
	
	public ArrayList<String> getValidParentheis(int num){
		findValidParenthesis(0,0,"",num);
		return validAns;
		
	}
	
	public void findValidParenthesis(int openCount,int closeCount,String ans,int num) {
		
		if(openCount==closeCount && ans.length()==num) {
			validAns.add(new String(ans));
			this.countValid += 1;
			return;
		}
		else if(ans.length()==num) {
			return;
		}
		
		if(openCount>closeCount) {
			findValidParenthesis(openCount+1,closeCount,ans+"(",num);
			findValidParenthesis(openCount,closeCount+1,ans+")",num);
		}
		else if(openCount==closeCount) {
			findValidParenthesis(openCount+1,closeCount,ans+"(",num);
		}
	}
	
	
	public int getCountOfValidParenthesis() {
		return this.countValid;
	}
	
	
}
