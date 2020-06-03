package classProblems;



public class RabinKarp {
	private String text;
	private int base;
	private int prime;
	
	public RabinKarp(String text,int base,int prime) {
		this.text = text;
		this.base = base;
		this.prime = prime;
	}
	
	
	public int patternMatch(String pattern) {
		int index;
		int hashText;
		int hashPattern;
		int count = 1;
		int n = text.length();
		int m = pattern.length();
		
		hashText = text.charAt(0);//-48;
		hashPattern = pattern.charAt(0);//-48;
		
		for(int j=1;j<m;j++) {
			hashText = Math.floorMod((hashText*base + (int)(text.charAt(j))),prime);
			hashPattern = Math.floorMod((hashPattern*base + (int)(pattern.charAt(j))),prime);
			count = (count*this.base)%prime;
		}
		
		if(hashText==hashPattern) {
			if(isEqual(pattern,0))
				return 0;
		}
		
		for(index = m;index<n;index++) {
			hashText = Math.floorMod(((hashText - (count*(int)(text.charAt(index-m))))*this.base + ((int)text.charAt(index))),prime);
			if(hashText==hashPattern) {
				if(isEqual(pattern,index-m+1))
					return index-m+1;
			}
		}
		return -1;
	}
	
	private boolean isEqual(String pattern,int start) {
		int m = pattern.length();
		int k = 0;
		
		for(int i=start;i<start+m;i++) {
			if(this.text.charAt(i)!=pattern.charAt(k++))
				return false;
		}
		return true;
	}
	
	
}
