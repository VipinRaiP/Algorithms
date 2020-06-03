package problemInputs;

import classProblems.Bst;

public class BstIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 // TODO code application logic here
        Bst t = new Bst();
        
        t.insert(50); 
        t.insert(30); 
        t.insert(20); 
        t.insert(40); 
        t.insert(70); 
        t.insert(60); 
        t.insert(80); 
        System.out.print("Inorder : ");
        t.inorder(t.getRoot());
        System.out.print("\nPreorder : ");
        t.preorder(t.getRoot());
        System.out.print("\nPostorder : ");
        t.postorder(t.getRoot());
        System.out.print("\n");
        System.out.println("Is 19 Present : " + t.Search(t.getRoot(),13));
        System.out.print("Level order : ");
        t.levelOrder();
        t.insert(23);
        t.insert(5);
        t.delete(t.getRoot(),50 );
        System.out.print("\nInorder : ");
        t.inorder(t.getRoot());
        System.out.print("\nPreorder using stack : ");
        t.preorderStack(t.getRoot());
        System.out.print("\nInorder using stack : ");
        t.inorderStack(t.getRoot());
        System.out.print("\nPostorder using stack : ");
        t.postorderStack(t.getRoot());
        System.out.print("\nLevel of node 20 : ");
        System.out.println(t.findLevel(t.getRoot(),20));
        System.out.print("Number in the range: ");
        t.printRange(t.getRoot(),20,60);
        System.out.println("\n----------------------------------------------\n");
     
        int n1=30,n2=66;
        System.out.printf("Least common ancestor of %d and %d : %d\n",n1,n2,t.leastCommonAncestor(n1, n2));
       
       /* 
        Bst t2 = new Bst();
        
        t2.insert(36);
        t2.insert(30);
        t2.insert(24);
        t2.insert(33);
        t2.insert(19);
        t2.insert(27);
        t2.insert(32);
        t2.insert(35);
        t2.insert(50);
        t2.insert(40);
        t2.insert(70);
        t2.insert(38);
        t2.insert(45);
       
        System.out.print("Preorder: ");
        t2.preorder(t2.getRoot());
        System.out.print("\nIorder: ");
        t2.inorder(t2.getRoot());
        System.out.print("\nNumber in the range 27 to 40 : ");
        t2.printRange(t2.getRoot(),38,45);
        */
        
        
        
        
	}

}
