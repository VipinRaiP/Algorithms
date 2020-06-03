package problemInputs;

import classProblems.InversionPair;

public class InversionPairIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1,3,5,7};
		int arr[] = {97,43,23,54,4};//{6,43,56,32,19};
		InversionPair ip = new InversionPair();
		System.out.println("No of inversion pairs: "+ ip.MS(arr1,0,arr1.length-1));
		
	}

}
