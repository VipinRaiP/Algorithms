package problemInputs;

import classProblems.NearestLargeAvl;

public class NearestLargeAvlIp {
	public static void main(String args[]) {
		int arr[] = {43,33,58,12,6,4,8,13,60,51,63};
		NearestLargeAvl nl = new NearestLargeAvl(arr);
		
		System.out.print("\nInorder : ");
		nl.inorder(nl.getRoot());
		System.out.print("\nPostorder : ");
		nl.postorder(nl.getRoot());
		int j = 2;
		System.out.println("\nquery "+j+" : "+nl.query(nl.getRoot(),j));
	}
}
