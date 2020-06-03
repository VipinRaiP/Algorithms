package problemInputs;

import classProblems.SubsetSum;

public class SubsetSumIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubsetSum sb = new SubsetSum();
		
		int arr[] = {3,34,4,12,5,2};
		int sum = 12;
		
		System.out.println(sb.isSubsetSum(arr, sum));
		int []subset = sb.getSubset(arr, sum);
		System.out.print("One of the Subset : ");
		for(int i=0;i<subset.length;i++) {
			System.out.print(subset[i]+" ");
		}
	}

}
