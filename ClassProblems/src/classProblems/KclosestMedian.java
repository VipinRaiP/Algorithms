package classProblems;


import java.util.Random;

import classProblems.FindRank;

public class KclosestMedian {

	public int arr[];

	public class node{
		int value;
		int diffValue;
		
		public node(int value,int diffValue) {
			this.value = value;
			this.diffValue = diffValue;
		}
		
	}
	
	public KclosestMedian(int arr[]) {
		this.arr = arr;
	}
	
	public int [] getKclosest(int arr[],int k) {
		
		FindRank f = new FindRank(arr);
		int len = arr.length;
		int median = f.findRankRand(len/2 + 1);
		System.out.println(median);
		node[] temp = new node[len];
		
		for(int i=0;i<len;i++) {
			temp[i] = new node(arr[i],Math.abs(median-arr[i]));
		}
		
		int k_index = findEleRankRand(temp,len-k-1,0,len-1);
		System.out.println(k_index);
		int k_elements[] = new int[k];
		
		for(int i=1;i<k_index;i++) {
			k_elements[i-1] = temp[i].value;
		}
		return k_elements;
	}
	
	private int findEleRankRand(node[] list, int rank, int l, int r) {
		int p;
		int pivot;

		/* Pick a pivot at random */

		Random rand = new Random();

		pivot = rand.nextInt(10000000) % (r - l + 1) + l;

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

	public int partition(node[] list, int left, int right) {
		int l, r;
		int pivot;
		int split;
		pivot = list[left].diffValue;
		l = left + 1;
		r = right;

		while (l <= r) {
			while (l <= r && list[l].diffValue <= pivot)
				l++;
			while (l <= r && list[r].diffValue > pivot)
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

	private void Swap(node []list,int i,int j) {
		node temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
}
