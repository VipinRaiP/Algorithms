
import java.util.*;
import java.lang.*;

public class findRank {
	private ArrayList<Integer> list;
	
	public findRank(ArrayList<Integer> list)
	{
		this.list = list;
	}
	
	/* Deterministic Findrank */
	
	public int findRankDet(int rank) {
		return findEleRankDet(this.list,0,list.size()-1,rank);
	}

	private int findEleRankDet(ArrayList<Integer> list,int left,int right,int rank) {
		int pivot;
		int k;
		if(left>right) {
		   System.out.println("I am out");
		   return -9999;
		}
		if(left==right && rank ==1) {
				return list.get(left).intValue();
		}
		else if(left<right) {
			pivot = findPivot(list,left,right);
			Collections.swap(list,pivot,left);
		
			k = this.partition(list,left,right);
		
			if((right-k+1)==rank) 
				return list.get(k).intValue();
			else if(rank<(right-k+1)) {
				return findEleRankDet(list,k+1,right,rank);
			}
			else {
				return findEleRankDet(list,left,k-1,rank-(right-k+1));
			}
		}
		else
			return -9999;
	}	
	
	private void bubbleSort(ArrayList<Integer> list,int left,int right) {
		int itr=0;
		boolean flag = false;
		
		for(int i=left;i<right;i++) {
			for(int j=left;j<=right-1-itr;j++) {
				if(list.get(j).intValue()>list.get(j+1).intValue()) {
					Collections.swap(list,j,j+1);
					flag = true;
				}
			}
			itr += 1;
			if(!flag) return;
			flag = false;
		}
	}
		
	public int findPivot(ArrayList<Integer> list,int left,int right) {
	
		/* Divide the list into groups of 5*/
		
		/* Sort each group to find the median */
		
		int index;
		int len = list.size();
		int pivotEle;
		int noele = (right-left)+1;
		
		if(noele<5) {
			/* if the element is less than five then choose any element as pivot*/
			return left+noele/2;
		}
		
		for(index=0;index<noele;index+=5) {
			/* Sort the groups containing 5 elements discard the remaining if n is not multiple of 5 */
			if(index+4<noele)
				bubbleSort(list,index,index+4);
		}
		
		/* Pick the median of each group and place in n/5 positions from beginning */
		
		int medianIndex = 2;
		
		for(int i = 0;i<noele/5;i++) {
			Collections.swap(list,medianIndex,i);
			medianIndex += 5;
		}
		
		
		/* Find the median of first n/5 elements (median of medians) */
		
		pivotEle = findEleRankDet(list,left,left+(noele/5)-1,(int)Math.ceil((double)noele/10));
		return list.indexOf(new Integer(pivotEle));
	}
	
	/* Randomised findrank */
	
	public int findRankRand(int r) {
		return findEleRankRand(list,r,0,list.size()-1);
	}
	
	private int findEleRankRand(ArrayList<Integer> list,int rank,int l,int r) {
		int p;
		int pivot;
		
		/* Pick a pivot at random */
		
		Random rand = new Random();
		
		pivot = rand.nextInt(1000)%(r-l+1)+l;
		
		/* Place the pivot in the begining */
		
		Collections.swap(list,pivot,l);
		p = this.partition(list,l,r);
		
		if(rank==(r-p+1)) return list.get(p);
		else if(rank<(r-p+1)) 
			return findEleRankRand(list,rank,p+1,r);
		else {
			return findEleRankRand(list,rank-(r-p+1),l,p-1);
		}
	}
	
	/* Partition algorithm */
	
	public int partition(ArrayList<Integer> list,int left,int right) {
		int l,r;
		int pivot;
		int split;
		pivot = list.get(left);
		l=left+1;
		r = right;
		
		while(l<=r) {
			while(l<=r && list.get(l)<=pivot)l++;
			while(l<=r && list.get(r)>pivot)r--;
			if(l<r) {
				Collections.swap(list,l,r);
				l++;
				r--;
			}	
		}
		split = l-1;
		Collections.swap(list,split,left);
		return split;
	}
	
	/* A quicksort implementation */
	
	
	
}
