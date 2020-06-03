package classProblems;

public class Avl {

	private class Node {
	    int data;
	    Node parent;
	    Node left;
	    Node right;
	    int height;
	
	    public Node(int data){
	    	this.data = data;
	    	this.left = null;
	    	this.right = null;
	    	this.parent = null;
	    	this.height = 0;
	    }
	    
	}
	
	private Node root;
	
	public Avl() {
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
       
        if(root.left!=null && root.right!=null) {
        	if(Math.abs(root.left.height-root.right.height)>1) {
        		/* Height is imbalance */
        		root = Balance(root,data);
        	}
        }
        else if(root.right!=null || root.left!=null) {
        	
        	if(root.right==null) {
        		if(root.left.height+1>1) {
        			root = Balance(root,data);
        		}
        	}
        	
        	if(root.left==null) {
        		if(root.right.height+1>1) {
        			root = Balance(root,data);
        		}
        	}
        }
       
        updateHeight(root);
        
        return root;
    }
	
    /* Delete node in avl tree */
    
    public void delete(int data){
        this.root = deleteRec(this.root,data);
    }
    
    public Node deleteRec(Node root,int data) {
    	int zData;
    	Node y = null;
    	if(root==null) {
    		System.out.println("Not found!!");
    		return null;
    	}
    	if(root.data==data) {
    		if(root.left==null && root.right==null) {
    			root = null;
    			return root;
    		}
    		else if(root.left!=null && root.right!= null) {
    			int inPre = inorderPre(root.left);
    			root.left = deleteRec(root.left,inPre);
    			root.data = inPre;
    		}
    		else if(root.left!=null || root.right!=null) {
        		if(root.left==null) {
        			root.right.parent = root.parent;
        			return root.right;
        		}
        		else {
        			root.left.parent = root.parent;
        			return root.left;
        		}
    		}
    	}
    	else if(root.data>=data) {
    		root.left = deleteRec(root.left,data);
    	}
    	else {
    		root.right = deleteRec(root.right,data);
    	}
 	
    	/* Check imbalance */
    	
    	updateHeight(root);
    	
    	if(root.left!=null && root.right!=null) {
        	if(Math.abs(root.left.height-root.right.height)>1) {
        		/* Height is imbalance */
        		root = Balance(root);
        	}
        }
        else if(root.right!=null || root.left!=null) {
        	
        	if(root.right==null) {
        		if(root.left.height+1>1) {
        			/* Height is imbalance */	
        			root = Balance(root);
        		}
        	}
        	
        	if(root.left==null) {
        		if(root.right.height+1>1) {
        			/* Height is imbalance */
        			root = Balance(root);
        		}
        	}
        }
    	
        updateHeight(root);
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
 
    /* Balance tree */
    
    public Node Balance(Node root,int data) {
    	
    	Node x;
		Node y=null;
		Node z=null;
		Node median;
		int iszigzig;
		Node []xyz = new Node[3];
		
		x= root;
		xyz[0] = x;
		iszigzig = findxyz(x,xyz,data);
		y = xyz[1];
		z=xyz[2];

		if(iszigzig!=0) {
			root = zigzig(x,y,z);
		}
		else {
			root = zigzag(x,y,z);
		}
		return root;
    }
    
 /* Balance tree in case of delete operation */
    
    public Node Balance(Node root) {
    	
    	Node x;
		Node y=null;
		Node z=null;
		Node median;
		int iszigzig;
		Node []xyz = new Node[3];
		
		x= root;
		xyz[0] = x;
		iszigzig = findxyzDel(x,xyz);
		y = xyz[1];
		z=xyz[2];

		if(iszigzig!=0) {
			root = zigzig(x,y,z);
		}
		else {
			root = zigzag(x,y,z);
		}
		return root;
    }
     
	/* returns 0 if zigzag else nonzero for zigzig */
    
   public int findxyz(Node x,Node[] xyz,int data) {
	   int flag = 0;
	   Node y;
	   Node z;
	   
	   if(x.data>data) {
			y=x.left;
			flag += 1;
		}
		else {
			flag -= 1;
			y=x.right;
		}
		if(y.data>data) {
			flag += 1;
			z = y.left;
		}
		else {
			flag -= 1;
			z = y.right;
		}
		xyz[0] = x;
		xyz[1] = y;
		xyz[2] = z;
		return flag;
   }
   
   public int findxyzDel(Node x,Node[] xyz) {
	   int flag = 0;
	   Node y=null;
	   Node z=null;
	   
	   if(x.left==null || x.right==null) {
		   if(x.left==null) { 
			   y = x.right;
			   flag-=1;
		   }   
	       else if(x.right==null) {
			   y = x.left;
			   flag +=1;
		   } 
	   }
	   else if(x.left.height>x.right.height) {
			y=x.left;
			flag += 1;
		}
		else {
			flag -= 1;
			y=x.right;
		}
	   
	   if(y.left==null || y.right==null) {
		   if(y.left==null) {
			   z = y.right;
			   flag -= 1;
		   }   
		   else if(y.right==null) {
			   z = y.left;
			   flag += 1;
		   }   
	   }
	   else if(y.left.height>y.right.height) {
			flag += 1;
			z = y.left;
	   }
	   else {
			flag -= 1;
			z = y.right;
	   }
		xyz[0] = x;
		xyz[1] = y;
		xyz[2] = z;
		return flag;
   }
   
   public Node zigzag(Node x,Node y,Node z) {
	   
	   Node medianNode;
	   Node medLeft;
	   Node medRight;
	   Node []sorted;	   
	   //sorted[0]=sorted[1]=sorted[2]=null;
	   
	   sorted = findMedianNode(x,y,z);
	   medianNode = sorted[1];
	   medLeft = medianNode.left;
	   medRight = medianNode.right;
	   medianNode.parent = x.parent;
	   medianNode.left = sorted[0];
	   medianNode.right = sorted[2];
	   
	   medianNode.left.right = medLeft;
	   medianNode.right.left = medRight;
	   
	   medianNode.left.parent = medianNode;
	   medianNode.right.parent = medianNode;
	   if(medLeft!=null)
		   medLeft.parent = medianNode.left;
	   if(medRight!=null)
		   medRight.parent = medianNode.right;
	   
	   updateHeight(medianNode.left);
	   updateHeight(medianNode.right);
	  	   
	   return medianNode;
   }
   
   public Node zigzig(Node x,Node y,Node z) {
		   
	   Node medianNode;
	   Node medLeft;
	   Node medRight;
	   Node []sorted;	   
	   
	   sorted = findMedianNode(x,y,z);
	   medianNode = sorted[1];
	   medLeft = medianNode.left;
	   medRight = medianNode.right;
	   medianNode.parent = x.parent;
	   medianNode.left = sorted[0];
	   medianNode.right = sorted[2];
	   
	   if(medLeft==z) {
		   /*LL imbalance */
		   medianNode.right.left = medRight;
		   if(medRight!=null)
			   medRight.parent = medianNode.right;
	   }
	   else if(medRight==z) {
		   /* RR imbalance */
		   medianNode.left.right = medLeft;
		   if(medLeft!=null)
			   medLeft.parent = medianNode.left;
	    }
		   
	   medianNode.left.parent = medianNode;
	   medianNode.right.parent = medianNode;
		 
	   updateHeight(medianNode.left);
	   updateHeight(medianNode.right);
		   
	   return medianNode; 
   }
  
	public void updateHeight(Node root) {
		if(root.left!=null && root.right!=null)
			root.height = Math.max(root.left.height,root.right.height)+1;
		else if(root.right!=null || root.left!=null) {
			if(root.left!=null)
				root.height = root.left.height+1;
			else
				root.height = root.right.height+1;
		}	   
		else
			root.height=0;
	 }
	  
	
	public Node[] findMedianNode(Node x,Node y,Node z) {
		
		Node[] sorted = new Node[3];
		
		if(x.data>y.data) {
			if(y.data>z.data) {
				sorted[2] = x;
				sorted[1] = y;
				sorted[0]= z;
			}
			else {
				if(x.data>z.data) {
					sorted[2] = x;
					sorted[1] = z;
					sorted[0]= y;
				}
				else {
					sorted[2] = z;
					sorted[1] = x;
					sorted[0]= y;
				}
			}	
		}	
		else {
			if(x.data>z.data) {
				sorted[2] = y;
				sorted[1] = x;
				sorted[0]= z;
			}
			else {
				if(y.data>z.data) {
					sorted[2] = y;
					sorted[1] = z;
					sorted[0]= x;
				}
				else {
					sorted[2] = z;
					sorted[1] = y;
					sorted[0]= x;
				}
			}
		}
		
		return sorted;
	}

	
	/* Find the inorder traversal of the tree */
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
		
	public Node getRoot() {
		return this.root;
	}
		
	public int getHeight() {
		return this.root.height;
	}
}
