package classProblems;

public class CoinProblem {

	int denominations[];
	public int [][]dp;


	public int getMinCoins(int []denominations,int amount) {
		
		int m = denominations.length+1;
		int n = amount+1;
		
		dp = new int[m][n]; 
		
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(j==0) {
					dp[i][j] = 0;
					continue;
				}	
				if(i==0) {
					dp[i][j] = Integer.MAX_VALUE;
					continue;
				}
				if(j<denominations[i-1]) {
					dp[i][j] = dp[i-1][j];
				}
				else if(dp[i][j-denominations[i-1]]!=Integer.MAX_VALUE && dp[i-1][j]>(1+dp[i][j-denominations[i-1]])){
					dp[i][j] = 1+dp[i][j-denominations[i-1]];
					
				}
				else
					dp[i][j] = dp[i-1][j];
				
			}
		}
		return dp[m-1][n-1];
	}
	
	/* using 1d array space */
	
	public int getMinCoinsOptimised(int []denominations,int amount)
	{
		int [] dp = new int[amount+1];
		
		dp[0] = 0;
		
		for(int i=1;i<=amount;i++)
			dp[i] = Integer.MAX_VALUE;
		
		for(int i=1;i<=denominations.length;i++) {
			for(int j=1;j<=amount;j++) {
				if(j>=denominations[i-1]) {
					int res  = dp[j-denominations[i-1]];
					if(res !=Integer.MAX_VALUE && dp[j]>1+res)
						dp[j] = 1+dp[j-denominations[i-1]];
				}
			}
		}
		return dp[amount];
	}
	
	/* backtracking to find the coins chosen */
	
	public int[] getOptmisedCoins(int []denominations,int amount) {
		
		int i=denominations.length;
		int j=amount;
		
		int x[] = new int[i];
		
		for(int k=0;k<x.length;k++)
			x[k] = 0;
		
		while(i>1 && j>0) {
			
			if((j>=denominations[i-1]) && (dp[i][j]==1+dp[i][j-denominations[i-1]])) {
				x[i-1] += 1;
				j = j-denominations[i-1];
			}
			else {
				i -= 1; 
			}
			
		}
		if(j>0) {
			x[0] = j/(denominations[0]);
		}
		
		return x;
		
	}
}
