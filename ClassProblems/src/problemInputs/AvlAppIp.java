package problemInputs;

import classProblems.*;

public class AvlAppIp {

	public static void printOrder(AvlApp a) {
		System.out.print("\n\nInorder: ");
		a.inorder(a.getRoot());
		System.out.print("\nPreorder: ");
		a.preorder(a.getRoot());
		System.out.print("\nPostorder: ");
		a.postorder(a.getRoot());
		System.out.print("\nHeight of tree : "+a.getHeight());	
	}
	
	public static void printAvg(AvlApp a,int l,int r) {
		System.out.print("\n\nNumber of elements between " +l+" and " + r +" : " + a.numEle(a.getRoot(),l,r));
		
		System.out.print("\nPrefix sum of " +l+" : " + a.prefixSum(a.getRoot(),l));
		
		System.out.print("\nPrefix sum of " +r+" : " + a.prefixSum(a.getRoot(),r));
		
		System.out.print("\nSum of elements between " +l+" and " + r +" : " + a.sumEle(a.getRoot(),l,r));
	
		System.out.print("\nAvg of elements between " +l+" and " + r +" : " + a.avgEle(a.getRoot(),l,r));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AvlApp a = new AvlApp();
		//int arr[] = {50,20,60,10,8,15,32,46,11,48};
		int arr[] = {50,25,75,10,30,60,80,5,15,27,55,1};
		
		
		for(int index=0;index<arr.length;index++) {
			a.insert(arr[index]);
		}
	
		System.out.print("\nInorder: ");
		a.inorder(a.getRoot());
		System.out.print("\nPreorder: ");
		a.preorder(a.getRoot());
		System.out.print("\nPostorder: ");
		a.postorder(a.getRoot());
		
		a.delete(80);
	    a.delete(60);
	    a.insert(32);
		a.delete(50);
		a.delete(15);
		printOrder(a);	
		
		int ele = 54;
		int rank =7;
		System.out.print("\nRank of element "+ele+" : " + a.getRank(a.getRoot(),ele));
		System.out.print("\nElement with rank "+rank+" : "+ a.findRank(a.getRoot(),rank));
		
		
		
		
		int l = 8;
		int r = 75;
		printAvg(a,l,r);
		
		System.out.print("\n\nInorder : ");
		a.inorder(a.getRoot());
		System.out.print("\nMingap : "+a.minGap(a.getRoot()));
		System.out.print("\nMaxgap : "+a.maxGap(a.getRoot()));
		
		
		a.insert(28);
		a.insert(40);
		a.insert(80);
		a.delete(27);
		a.delete(32);
		l = 8;
		r = 75;
		printOrder(a);
		printAvg(a,l,r);
		
		a.delete(30);
		printOrder(a);
		System.out.print("\nMingap : "+a.minGap(a.getRoot()));
		System.out.print("\nMaxgap : "+a.maxGap(a.getRoot()));
		
		int x = 10;
		int y = 80;		

		System.out.print("\nMingap between "+x+" and "+y+" : "+a.minGapRange(a.getRoot(),x,y));
		System.out.print("\nMaxgap between "+x+" and "+y+" : "+a.maxGapRange(a.getRoot(),x,y));
	}
}
