package problemInputs;

import classProblems.MaxDiff;

public class MaxDiffIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxDiff md = new MaxDiff();
		int arr[] = {-2, -3, -4, -11, -12, -1, -5, -1};
		int arr2[] = {21,34,15,-32,9,-7,-15,53,5,-6};
		int arr3[] = {10,9,13,4,9,8,6,1,4,3,2,1};
		
		System.out.println("Maximum subarray sum : "+md.getMaxSubarraySum(arr));
		System.out.println("Left index : "+md.max_left+"\n"+"Right Index: "+md.max_right);

		System.out.println("Maximum diff: "+md.getMaxDiff(arr2));
		System.out.println("Left index : "+md.max_left+"\n"+"Right Index: "+md.max_right);		
		
		System.out.println("Maximum diff: "+md.getMaxDiffWithGap(arr2, 3));
		System.out.println("Left index : "+md.max_left+"\n"+"Right Index: "+md.max_right);		
		
		System.out.println("Maximum diff: "+md.getMaxDiffWindow(arr3,3));
		System.out.println("Left index : "+md.max_left+"\n"+"Right Index: "+md.max_right);		
		
		int l  = 4;
		
		System.out.println("Maximum subarray sum  of length " + l + " : "+md.getMaxSubarraySumLen(arr,l));
		System.out.println("Left index : "+md.max_left+"\n"+"Right Index: "+md.max_right);
		
		System.out.println("Maximum subarray sum  of length 4 : "+md.getMaxSubarraySumAtmost(arr,l));
		System.out.println("Left index : "+md.max_left+"\n"+"Right Index: "+md.max_right);
	}

}
