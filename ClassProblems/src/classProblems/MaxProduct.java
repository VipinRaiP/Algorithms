package classProblems;

public class MaxProduct {
	public int maxLeft,maxRight;
	
	public MaxProduct() {
		
	}
	
	public int getMaxProduct(int arr[]) {
		
		int product_so_far = 1;
		int len = arr.length;
		int left = 0;;
		int maxProd = Integer.MIN_VALUE;
		
		for(int i=0;i<len;i++) {
			product_so_far *= arr[i];
			if(product_so_far==0) { 
				product_so_far = 1;
				left = i+1;
			}
			else {
				if(product_so_far>maxProd) {
					maxProd = product_so_far;
					this.maxLeft = left;
					this.maxRight = i;
				}
			}
			
		}
	
		
		if(product_so_far<0) {
			int firstNegativeLeft = findNegativeLeft(arr,left,len-1); 
			int firstNegativeRight = findNegativeRight(arr,left,len-1);
			int leftMax = (product_so_far/arr[firstNegativeLeft]);
			int rightMax = (product_so_far/arr[firstNegativeRight]);
			
			
			if((leftMax)>(rightMax)) {
				if(leftMax>maxProd) {
					maxProd = leftMax;
					this.maxLeft = firstNegativeLeft+1;
					this.maxRight = len-1;
				}	
			}
			else {
				if(rightMax>maxProd) {
					maxProd = rightMax;
					this.maxRight = len-1;
					this.maxLeft = firstNegativeRight+1;
				}
			}
			return maxProd;
		}
		
		return maxProd;
		
	}
	
	
	public int findNegativeLeft(int arr[],int l,int r) {
		
		for(int j=l;j<=r;j++) {
			if(arr[j]>0)
				j++;
			else
				return j;
		}
		return -1;
	}
	
	public int findNegativeRight(int arr[],int l,int r) {
		
		for(int j=r;j>=l;j--) {
			if(arr[j]>0)
				j--;
			else
				return j;
		}
		return -1;
	}
}
