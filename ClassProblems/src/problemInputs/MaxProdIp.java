package problemInputs;

import classProblems.MaxProduct;;

public class MaxProdIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,-7,0,-6,3,5};
		
		MaxProduct m = new MaxProduct();
		
		System.out.println("Maximum Product : " + m.getMaxProduct(arr));
		System.out.printf("Left Index : %d\nRight Index : %d",m.maxLeft,m.maxRight);
	}

}
