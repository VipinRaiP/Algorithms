package classProblems;

import java.util.*;

public class SubsetSum {

	public boolean[][] dp;
	
	/* check is there a s subset with given sum */
	public boolean isSubsetSum(int []arr,int sum) {
		dp= new  boolean[arr.length+1][sum+1];
		
		for(int i=0;i<=arr.length;i++) {
			for(int j=0;j<=sum;j++) {
				if(j==0) {
					dp[i][j] = true;
				}
				else if(i==0) {
					dp[i][j] = false;
				}
				else {
					if(arr[i-1]<=(j))
						dp[i][j] = (dp[i-1][j])||(dp[i-1][j-arr[i-1]]);
					else
						dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[arr.length][sum];
	}
	
	public int[] getSubset(int arr[],int sum) {
		ArrayList<Integer> a= new ArrayList<Integer>();
		
		int i=arr.length;
		int j=sum;
		
		while(i>=1 && j>0) {
			if(j>=arr[i-1] && dp[i][j]==dp[i-1][j-arr[i-1]]) {
				a.add(arr[i-1]);
				j = j-arr[i-1];
			}
			i = i-1;
		}
		//if(i==1 && j==arr[i-1])
			//a.add(arr[i-1]);
		
		
		int []ans = new int[a.size()];
		int k=0;
		for(int b:a) {
			ans[k++] = b;
		}
		return ans;
	}
	

}

