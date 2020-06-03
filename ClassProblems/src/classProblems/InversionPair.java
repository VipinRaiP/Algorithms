package classProblems;

public class InversionPair {

	public int arr[];
	
	public InversionPair() {
		
	}
	
	/* using merge sort implementation */
	
	public int MS(int []arr,int l,int r) {
		int k;
		
		if(l>=r) return 0;
		else{
			k = (l+r)/2;
			return MS(arr,l,k)+MS(arr,k+1,r)+ Merge(arr,l,r,k);
		}
		
	}
	
	public int Merge(int []arr,int i,int j,int k) {
		
		int n = 0,s=0;
		int[] tmp = new int[j-i+1];
		int l=i,r=k+1;
		int left = i,mid=k,right=k+1,count=0;
		
		while(left<=mid && right<=j) {
			while(left<=mid && arr[left]<=arr[right])left++;
			if(left<=mid) {
				count += (mid-left+1);
				right++;
			}
		}
		
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
		
		return count;
	}
}
