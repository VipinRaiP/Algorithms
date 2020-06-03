package classProblems;

import java.util.*;

public class MajorityNo {
	public class CandidateBucket {
		public int candidate;
		public int count;
	}

	private int[] arr;
	
	public MajorityNo(int arr[]) {
		this.arr = arr;
	}
	
	/* Here majority no is that repeats more than n/2 + 1 times */
	
	public int getMajority() {
		int count = 1;
		int candidate = arr[0];
		int index;
		
		for(index=1;index<arr.length-1;index++) {
			if(arr[index]==candidate) {
				count++;
			}
			else if(count>0) {
				count--;
			}
			else {
				candidate = arr[index];
				count = 1;
			}
		}
		
	
		if(isMajority(candidate,2))
			return candidate;
		else
			return -999999;			
	}
	
	/* Majority no in general that repeats more than n/k + 1 */
	
	public ArrayList<Integer> getMajorityGen(int k) {
		CandidateBucket[] cb = new CandidateBucket[k-1];
		ArrayList<Integer> majNo = new ArrayList<Integer>();
		int index=0;

		for(int j=0;j<arr.length;j++) {
			if((index=Search(cb,arr[j]))!=-1) {
				cb[index].count++;	
			}
			else if((index=isEmpty(cb))!=-1) {
				cb[index] = new CandidateBucket();
				cb[index].candidate=arr[j];
				cb[index].count=1;
			}
			else {
				int i=0;
				while(i<cb.length) {
					cb[i].count--;
					if(cb[i].count<=0) {
						cb[i]=null;
						cb[i] = new CandidateBucket();
						cb[i].candidate=arr[j];
						cb[i].count=1;
					}	
					i++;
				}
			}
		}
		
		for(int j=0;j<cb.length && cb[j]!=null;j++) {
			if(isMajority(cb[j].candidate,k)) {
				majNo.add(new Integer(cb[j].candidate));
			}
		}
		return majNo;
		
	}
	
	public boolean isMajority(int candidate,int k) {
		int count = 0;
		int n = arr.length;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==candidate)count++;
		}
		if(count >=((n/k)+1))
			return true;
		else
			return false;
	}
	
	
	public int isEmpty(CandidateBucket []cb) {
		for(int i=0;i<cb.length;i++) {
			if(cb[i]==null) {
				return i;
			}
		}
		return -1;
	}
		
	public int Search(CandidateBucket []cb,int j) {
		int i=0;
		
		while(i<cb.length && cb[i]!=null && cb[i].candidate!=j)i++;
	
		if(i>=cb.length)  
			return -1;
		else if(cb[i]==null)
			return -1;
		else  
			return i;
	}
}	
	
	