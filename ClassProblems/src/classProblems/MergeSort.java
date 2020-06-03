package classProblems;

public class MergeSort {

	private int [] arr;
	
	public MergeSort(int [] arr) {
		this.arr = arr;
	}
	
	public int[] sort() {
		MS(this.arr,0,arr.length-1);
		return this.arr;
	}
	
/* using merge sort implementation */
	
	public void MS(int []arr,int l,int r) {
		int k;
		
		if(l>=r) return;
		else{
			k = (l+r)/2;
			MS(arr,l,k);
			MS(arr,k+1,r);
			Merge(arr,l,r,k);
		}
		
	}
	
	public void Merge(int []arr,int i,int j,int k) {
		
		int n = 0,s=0;
		int[] tmp = new int[j-i+1];
		int l=i,r=k+1;
		
		while(l<=k && r<=j) {
			if(arr[l]<=arr[r])
				tmp[n++] = arr[l++];
			else
				tmp[n++] = arr[r++];
		}
		
		while(l<=k) tmp[n++] =arr[l++];
		while(r<=j) tmp[n++] =arr[r++];
		
		for(int index=i;index<=j;index++) {
			arr[index]=tmp[s++];
		}
		
	}
}
