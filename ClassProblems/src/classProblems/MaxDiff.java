package classProblems;

public class MaxDiff {
	public int max_left,max_right;
	
	/* Returns the maximun difference max(a[j]-a[i]) such that j>i) */
	
	public int getMaxDiff(int arr[]) {
		int max=arr[1]-arr[0];
		int i = 0;
		
		for(int j=1;j<arr.length;j++) {
			if((arr[j]-arr[i])>max) {
				max = arr[j]-arr[i];
				this.max_left = i;
				this.max_right = j;
			}
			if(arr[i]>arr[j])i=j;
		}
		return max;
	}
	
	/* Returns the max diffrence with a gapperiod max(a[j]-a[i) such that j>=i+l */
	
	public int getMaxDiffWithGap(int arr[],int gapPeriod) {
		int max = arr[gapPeriod] - arr[0];
		int i=0;
		
		for(int j=gapPeriod+1;j<arr.length;j++) {
			if((arr[j]-arr[i])>max) {
				max = arr[j]-arr[i];
				this.max_left=i;
				this.max_right=j;
			}
			if(arr[j-gapPeriod]<arr[i]) 
				i = j-gapPeriod;
		}
		return max;
	}
	
	/* Returns max difference in window max(a[j]-a[i]) such that j<=i+l */
	
	public int getMaxDiffWindow(int arr[],int window) {
			int max=Integer.MIN_VALUE;
			int []ds = new int[arr.length];
			int top=0;
			int minEle=0;
			
			ds[0] = 0;
			
			for(int j=1;j<arr.length;j++) {
				if(j-ds[minEle]>window)
					minEle++;
				
				if((arr[j]-arr[ds[minEle]])>max) {
					max = arr[j]-arr[ds[minEle]];
					this.max_left = ds[minEle];
					this.max_right=j;
				}
				
				while(top>=minEle && arr[ds[top]]>arr[j]) top--;
		
				top++;
				ds[top] = j;
				
			}
		return max;
	}
	
	/* Get Maximum sum subarray */
	
	public int getMaxSubarraySum(int arr[]) {
		int max_so_far = Integer.MIN_VALUE;
		int presentSubArraySum = 0;
		int max_left=0;
		
		for(int j=0;j<arr.length;j++) {
			presentSubArraySum += arr[j];
			if(presentSubArraySum>max_so_far) {
				max_so_far = presentSubArraySum;
				this.max_right=j;
				this.max_left=max_left;
			}
			if(presentSubArraySum<0) {
				presentSubArraySum=0;
				max_left=j+1;
			}
	
		}
		return max_so_far;
	}
	
	/* Get maximum subarray of length l */
	
	public int getMaxSubarraySumLen(int arr[],int l) {
		int max_so_far = Integer.MIN_VALUE;
		int presentSubArraySum = 0;
		int max_left=0;
		int len = 0;
		
		for(int j=0;j<arr.length;j++) {
			presentSubArraySum += arr[j];
			len += 1;
			if(presentSubArraySum>max_so_far && len==l) {
				max_so_far = presentSubArraySum;
				this.max_right=j;
				this.max_left=max_left;
			}
			
			if(len>l) {
				presentSubArraySum -= arr[j-l];
				max_left++;
				len = l;
				if(presentSubArraySum>max_so_far) {
					max_so_far = presentSubArraySum;
					this.max_right=j;
					this.max_left=max_left;
				}	
				
			/*	if(presentSubArraySum<0){
					presentSubArraySum=0;
					max_left=j+1;
					len = 0;		
				}*/
			}
		}
		return max_so_far;
	}
	
	/* Get maximum subarray of length atmost l */
	
	public int getMaxSubarraySumAtmost(int arr[],int l) {
		int max_so_far = Integer.MIN_VALUE;
		int presentSubArraySum = 0;
		int max_left=0;
		int len = 0;
		
		for(int j=0;j<arr.length;j++) {
			presentSubArraySum += arr[j];
			len += 1;
			if(presentSubArraySum>max_so_far && len<=l) {
				max_so_far = presentSubArraySum;
				this.max_right=j;
				this.max_left=max_left;
			}
				
			if(len>l) {
				presentSubArraySum -= arr[j-l];
	
				max_left++;
				len = l;
				if(presentSubArraySum>max_so_far) {
					max_so_far = presentSubArraySum;
					this.max_right=j;
					this.max_left=max_left;
				}	
			}

			if(presentSubArraySum<0) {
				presentSubArraySum=0;
				max_left=j+1;
				len=0;
			}
		}
		return max_so_far;
	}
	
	
}
