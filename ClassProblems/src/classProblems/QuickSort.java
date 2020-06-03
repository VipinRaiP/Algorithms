package classProblems;


import java.util.*;

public class QuickSort {
	private int[] list;
	
	public QuickSort(int[] list) {
		this.list = list;
	}
	
	public int[] sort() {
		this.sortList(list,0,list.length-1);
		return list;
	}
	
	private void sortList(int[] list,int left,int right) {
		Random rand = new Random();
		int p;
		int split;
		/* randomised quick sort as the pivot is picked at a random position and placed in the begining of the list */
		
		if(left<right) {
			p = rand.nextInt(1000)%(right-left+1)+left;
			this.Swap(list,left,p);
			split = this.partition(list,left,right);
			sortList(list,left,split-1);
			sortList(list,split+1,right);
		}
	}
	
	public int partition(int[] list,int left,int right) {

		int l,r;
		int pivot;
		int split;
		pivot = list[left];
		l=left+1;
		r = right;
		
		while(l<=r) {
			while(l<=r && list[l]<=pivot)l++;
			while(l<=r && list[r]>pivot)r--;
			if(l<r) {
				this.Swap(list,l,r);
				l++;
				r--;
			}	
		}
		split = l-1;
		this.Swap(list,split,left);
		return split;
	}

	private void Swap(int [] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
}
