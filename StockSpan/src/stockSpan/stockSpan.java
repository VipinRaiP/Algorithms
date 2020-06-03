package stockSpan;

import java.util.*;

public class stockSpan {
	int span[];
	int stockValue[];
	
	public stockSpan(int []stockValue) {
		this.stockValue = stockValue;
		this.span = new int[this.stockValue.length];
	}
	
	public void findSpan() {
		int len = this.stockValue.length;
		int h;
		Stack<Integer> stack = new Stack<Integer>();
		//boolean done = false;
		
		for(int i=0;i<len;i++) {
			
			while( !stack.isEmpty() && this.stockValue[i]>=this.stockValue[stack.peek().intValue()]) {
				stack.pop();
			}
		
			if(stack.isEmpty()) 
				h = -1;
			else 
				h = stack.peek().intValue();
			
			stack.push(new Integer(i));
			
			if(h==-1)
					this.span[i] = -1;
			else		
				this.span[i] = i - h;
 		}
	}
	
	public int[] getSpan(){
		return span;
	}
}