package problemInputs;

import classProblems.CoinProblem;
public class CoinProblemIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		CoinProblem cp = new CoinProblem();
		
		int [] denominations = {1,7,10};
		int amount  = 36;
		
		System.out.println("Min coins required: "+cp.getMinCoins(denominations, amount));
		
		System.out.println("Denominations chosen");
		int []x = cp.getOptmisedCoins(denominations, amount);
		for(int i=0;i<denominations.length;i++) {
			System.out.println(denominations[i]+" * "+x[i]);
		}
		
		
	}

}
