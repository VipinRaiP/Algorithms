
import java.util.*;
import java.lang.*;

/* find rank using integer array as data structure ( reduces runtime compared to arraylist ) */ 


public class test {
	private int[] list;

	public test(int[] list) {
		this.list = list;
	}

/* Deterministic Findrank */
	
	public int findRankDet(int rank) {
		int index;
		index  = findEleRankDet(this.list,0,list.length-1,rank);
		return list[index];
	}

	private int findEleRankDet(int[] list,int left,int right,int rank) {
		int pivot;
		int k;
		if(left>right) {
		   System.out.println("I am out");
		   return -9999;
		}
		if(left==right && rank ==1) {
				return left;
		}
		else if(left<right) {
			pivot = findPivot(list,left,right);
			this.Swap(list,pivot,left);
		
			k = this.partition(list,left,right);
		
			if((right-k+1)==rank) 
				return k;
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
	
	private void bubbleSort(int[] list,int left,int right) {
		int itr=0;
		boolean flag = false;
		
		for(int i=left;i<right;i++) {
			for(int j=left;j<=right-1-itr;j++) {
				if(list[j]>list[j+1]) {
					this.Swap(list,j,j+1);
					flag = true;
				}
			}
			itr += 1;
			if(!flag) return;
			flag = false;
		}
	}
		
	public int findPivot(int[] list,int left,int right) {
	
		/* Divide the list into groups of 5*/
		
		/* Sort each group to find the median */
		
		int index;
		int len = list.length;
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
			this.Swap(list,medianIndex,i);
			medianIndex += 5;
		}

		/* Find the median of first n/5 elements (median of medians) */
		
		return findEleRankDet(list,left,left+(noele/5)-1,(int)Math.ceil((double)noele/10));
	}
	
	

	
	/* Randomised findrank */

	public int findRankRand(int r) {
		int index;
		index = findEleRankRand(this.list, r, 0, list.length - 1);
		return list[index];
	}

	private int findEleRankRand(int[] list, int rank, int l, int r) {
		int p;
		int pivot;

		/* Pick a pivot at random */

		Random rand = new Random();

		pivot = rand.nextInt(1000) % (r - l + 1) + l;

		/* Place the pivot in the begining */

		this.Swap(list, pivot, l);
		p = this.partition(list, l, r);

		if (rank == (r - p + 1))
			return p;
		else if (rank < (r - p + 1))
			return findEleRankRand(list, rank, p + 1, r);
		else {
			return findEleRankRand(list, rank - (r - p + 1), l, p - 1);
		}
	}

	/* Partition algorithm */

	public int partition(int[] list, int left, int right) {
		int l, r;
		int pivot;
		int split;
		pivot = list[left];
		l = left + 1;
		r = right;

		while (l <= r) {
			while (l <= r && list[l] <= pivot)
				l++;
			while (l <= r && list[r] > pivot)
				r--;
			if (l < r) {
				this.Swap(list, l, r);
				l++;
				r--;
			}
		}
		split = l - 1;
		this.Swap(list, split, left);
		return split;
	}

	private void Swap(int []list,int i,int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	/* A quicksort implementation */

}
