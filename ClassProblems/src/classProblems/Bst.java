package classProblems;

import java.util.*;

/* printRange implementation fails when l>root.data have to fix */


public class Bst {

	private class Node {
	    int data;
	    Node parent;
	    Node left;
	    Node right;
	    
	    public Node(int data){
	        this.data = data;
	        this.left = null;
	        this.right = null;
	        this.parent = null;      
	    }
	}
	
	private Node root;
    
    public Bst(){
        this.root = null;
    }
 
    public void insert(int data){
        this.root = insertRec(this.root,null,data);
    }
    
    private Node insertRec(Node root,Node parent,int data){
        if(root==null){
            Node temp = new Node(data);
            temp.parent = parent;
            return  temp;
        }
        if(data<=root.data){
            root.left = insertRec(root.left,root,data);
        }
        else{
            root.right = insertRec(root.right,root,data);
        }
        return root;
    }
    
    public void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    public void preorder(Node root){
        if(root==null){
            return;
        }
       
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    
    public boolean Search(Node root,int data){
        if(root==null){
            return false;
        }
        if(root.data == data)
            return true;
        if(root.data<data)
            return Search(root.right,data);
        else
            return Search(root.left,data);
    }
    
    public void levelOrder(){
        Queue<Node> q = new LinkedList<Node>();
        
        Node temp = root;
        System.out.print(root.data+" ");
        
        q.add(temp.left);
        q.add(temp.right);
        
        while(!q.isEmpty()){
            try{
            	temp = q.remove();
            	System.out.print(temp.data+" ");
            	if(temp.left!=null)
            		q.add(temp.left);
            	if(temp.right!=null)
            		q.add(temp.right);
            }
            catch(Exception e){
                System.out.println(e);
            }    
        }
    }

    public Node getRoot(){
        return root;
    }
    
    /* Find inorder predecessor */
    
    public int inorderPre(Node root) {
    	if(root.right==null) {
    		return root.data;
    	}
    	else {
    		return inorderPre(root.right);
    	}
    }
    
    public void delete(Node root,int data) {
    	if(root==null) {
    		System.out.println("Not found!!");
    		return;
    	}
    	if(root.data==data) {
    		if(root.left==null && root.right==null) {
    			if(root.parent.left==root) {
    				root.parent.left=null;
    				root = null;
    				return;
    			}
    			else {
    				root.parent.right = null;
    				root = null;
    				return;
    			}
    		}
    		else if(root.left!=null && root.right!= null) {
    			int inPre = inorderPre(root.left);
    			delete(root,inPre);
    			root.data = inPre;
    		}
    		else if(root.left!=null || root.right!=null) {
    			if(root.parent.left==root) {
        			if(root.left==null) {
        				root.parent.left=root.right;
        				root.right.parent = root.parent;
        			}
        			else {
        				root.parent.left = root.left;
        				root.left.parent = root.parent;
        			}
        			root = null;
        			return;
        		}
        		else {
        			if(root.left==null) {
        				root.parent.right=root.right;
        				root.right.parent = root.parent;
        			}
        			else {
        				root.parent.right = root.left;
        				root.left.parent = root.parent;
        			}
        			root = null;
        			return;
        		}
    		}
    	}
    	else if(root.data>=data) {
    		delete(root.left,data);
    	}
    	else {
    		delete(root.right,data);
    	}
 	
    }
    
    public void preorderStack(Node root) {
    	Stack<Node> s1 = new Stack<Node>();
    	s1.push(root);
    	
    	while(!s1.isEmpty()) {
    		Node temp = s1.pop();
        	System.out.print(temp.data+ " ");
    		if(temp.right!=null)
    			s1.push(temp.right);
    		if(temp.left!=null)
    			s1.push(temp.left);
    	}
    	System.out.println();
    }
    
    public void inorderStack(Node root) {
    	Stack<Node> s1 = new Stack<Node>();
    	Stack<Boolean> s2 = new Stack<Boolean>();
    	
    	s1.push(root);
    	s2.push(new Boolean("False"));
    	
    	while(!s1.isEmpty()) {
    		if(!s2.peek().booleanValue()) {
    			Node temp = s1.pop();
    			s2.pop();
    			if(temp.right!=null) {
    				s1.push(temp.right);
    				s2.push(new Boolean("False"));
    			}	
    			s1.push(temp);
    			s2.push(new Boolean("True"));
    			if(temp.left!=null) {
    				s1.push(temp.left);
    				s2.push(new Boolean("False"));
    			}	
    		}
    		else {
    			Node top = s1.pop();
    			s2.pop();
    			System.out.print(top.data+ " ");
    		}
    	}
    	System.out.println();
    }
    
    public void postorderStack(Node root) {
    	Stack<Node> s1 = new Stack<Node>();
    	Stack<Boolean> s2 = new Stack<Boolean>();
    	
    	s1.push(root);
    	s2.push(new Boolean("False"));
    	
    	while(!s1.isEmpty()) {
    		if(!s2.peek().booleanValue()) {
    			Node temp = s1.pop();
    			s2.pop();
    			s1.push(temp);
    			s2.push(new Boolean("True"));
    			if(temp.right!=null) {
    				s1.push(temp.right);
    				s2.push(new Boolean("False"));
    			}	
    			if(temp.left!=null) {
    				s1.push(temp.left);
    				s2.push(new Boolean("False"));
    			}	
    		}
    		else {
    			Node top = s1.pop();
    			s2.pop();
    			System.out.print(top.data+ " ");
    		}
    	}
    	System.out.println();
    }
    
    public int findLevel(Node root,int data) {
    	if(root==null) {
    		System.out.println("Not found!!!");
    		return -1;
    	}
    	else if(root.data>data) {
    		int t = findLevel(root.left,data);
    		if(t==-1)
    			return -1;
    		else
    			return 1+t;
    	}
    	else if(root.data<data) {
    		int t = findLevel(root.right,data);
    		if(t==-1)
    			return -1;
    		else
    			return 1+t;
    	}
    	else {
    		return 0;
    	}
    }
    
    /* Print the rage of nodes in l and u (code has bugs have to fix) */
   
    public Node findNode(Node root,int data) {
    	if(root==null)
    		return null;
    	else if(root.data==data)
    		return root;
    	else if(data > root.data)
    		return findNode(root.right,data);
    	else
    		return findNode(root.left,data);
    }
    
    public void printInc(Node root,int data) {
    	if(root==null) {
    		return;
    	}
    	printInc(root.left,data);
    	if(root.data<data)
    		System.out.print(root.data+" ");
    	else if(root.data==data) {
    		System.out.print(root.data+" ");
    		return;
    	}
    	printInc(root.right,data);
    }
    
    public void toRoot(Node temp,Node root) {
    	if(temp==root) {
    		return;
    	}
    	if(temp.parent.right==temp) {
    		toRoot(temp.parent,root);
    	}
    	else if(temp.parent.left==temp) {
    		System.out.print(temp.parent.data+" ");
    		if(temp.parent!=root)
    			this.inorder(temp.parent.right);
    		toRoot(temp.parent,root);
    	}
    }
   
    public void printRange(Node root,int l,int u) {
		
    	if(l>=root.data) {
    		//System.out.println("\nTesting1!!");
    		if(l==root.data) {
    			System.out.print(root.data+" ");
    		printInc(root.right,u);
    		}
    	}	
    	else if(u<=root.data) {
    		//System.out.println("\nTesting2!!");
    		Node temp = findNode(root.left,l);
    		toRoot(temp,root);
    	}
    	else if(l<root.data && u>root.data) {
    		//System.out.println("\nTesting3!!");
    		Node temp = findNode(root.left,l);
    		//System.out.println("\nTesting4!!");
    		System.out.print(temp.data+" ");
    		//System.out.println("\nTesting5!!");
    		toRoot(temp,root);
    		//System.out.println("\nTesting7!!");
    		printInc(root.right,u);
    		
    	}
    }
    
    
    /* for binary tree (for bst we can do easy way)*/
    
    /*
    public int leastCommonAncestor(int n1,int n2) {
    	Node ca = leastCA(this.root,n1,n2);
    	return ca.data;
    }
    
    public Node leastCA(Node root,int n1,int n2) {
    	
    	if(root==null)
    		return null;
    	
    	if(root.data==n1||root.data==n2)
    		return root;
    	
    	Node left = leastCA(root.left,n1,n2);
    	Node right = leastCA(root.right,n1,n2);
    	
    	if(left!=null && right!=null)
    		return root;
    	else {
    		return (left!=null)? left : right; 
    		
    	}
    }
    
    */

    public int leastCommonAncestor(int n1,int n2) {
    	Node ca = leastCA(this.root,n1,n2);
    	return ca.data;
    }
    
    public Node leastCA(Node root,int n1,int n2) {
    	
    	if(root==null)
    		return null;
    	
    	if(root.data<n1 && root.data<n2)
    		return leastCA(root.right,n1,n2);
    	else if(root.data>n1 && root.data>n2)
    		return leastCA(root.left,n1,n2);
    	else
    		return root;
    }

}
