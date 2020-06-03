package problemInputs;

import classProblems.Avl;


public class AvlIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Avl a = new Avl();
		int arr[] = {5,2,1,0};
		//int arr[] = {50,25,75,10,30,60,80,5,15,27,55,1};
		
		
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
	//	a.delete(46);
	//	a.delete(50);
	//	a.delete(48);
		System.out.print("\n\nInorder: ");
		a.inorder(a.getRoot());
		System.out.print("\nPreorder: ");
		a.preorder(a.getRoot());
		System.out.print("\nPostorder: ");
		a.postorder(a.getRoot());
		System.out.print("\nHeight of tree : "+a.getHeight());		
	}

}
