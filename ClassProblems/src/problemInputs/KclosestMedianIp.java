package problemInputs;

import classProblems.KclosestMedian;

public class KclosestMedianIp {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int arr[] = {23,5,6,17,32,4,9};
		int k = 2;
			
		KclosestMedian kc = new KclosestMedian(arr);
		
		System.out.printf("%d closest to median\n",k);	
		
		int[] k_closest = kc.getKclosest(arr, k);
		
		for (int i=0;i<k;i++) {
			System.out.print(k_closest[i]+" ");
		}
		System.out.println();
	}
}
