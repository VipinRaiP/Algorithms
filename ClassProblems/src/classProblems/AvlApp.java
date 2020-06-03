package classProblems;

public class AvlApp {

	private class Node {
	    int data;
	    Node parent;
	    Node left;
	    Node right;
	    int height;
	    int num; // numbers of nodes in subtree including node 
	    int sum; // sum of all elements in subtree including node  	
	    int min; // min element in the subtree including node 
	    int max; // max element in the subtree including node 
	    int mingap; // minimum difference between the element in subtree including node
	    
	    public Node(int data){
	    	this.data = data;
	    	this.left = null;
	    	this.right = null;
	    	this.parent = null;
	    	this.height = 0;
	    	this.num = 1;  
	    	this.sum = data;
	    	this.min = data;
	    	this.max = data;
	    	this.mingap = Integer.MAX_VALUE;
	    }
	    
	}
	
	private Node root;
	
	public AvlApp() {
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
        updateData(root);
        
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
    	updateData(root);
    	
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
        updateData(root);
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
	  	
	   updateData(medianNode.left);
	   updateData(medianNode.right);
	   
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
		   
	   updateData(medianNode.left);
	   updateData(medianNode.right);
	   
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
	  
    /* update the data in the node after every tree operation */
	
	public void updateData(Node root) {
		int temp1,temp2;
		if(root.left!=null && root.right!=null) {
			root.num = root.left.num+root.right.num+1;
			root.sum = root.left.sum+root.right.sum+root.data;
			root.max = Math.max(Math.max(root.left.max,root.right.max),root.data);
			root.min = Math.min(Math.min(root.left.min,root.right.min),root.data);
			temp1 = Math.min(root.left.mingap,root.right.mingap);
			temp2 = Math.min(root.data-root.left.max,root.right.min-root.data);
			root.mingap = Math.min(temp1,temp2);
		}	
		else if(root.right!=null || root.left!=null) {
			if(root.left!=null) {
				root.num = root.left.num+1;
				root.sum = root.left.sum+root.data;
				root.max = Math.max(root.left.max,root.data);
				root.min = Math.min(root.left.min,root.data);
				root.mingap = Math.min(root.left.mingap,root.data-root.left.max);
			}	
			else {
				root.num = root.right.num+1;
				root.sum = root.right.sum+root.data;
				root.max = Math.max(root.right.max,root.data);
				root.min = Math.min(root.right.min,root.data);
				root.mingap = Math.min(root.right.mingap,root.right.min-root.data);
			}	
		}	   
		else {
			root.num=1;
			root.sum=root.data;
			root.max = root.data;
			root.min = root.data;
			root.mingap = Integer.MAX_VALUE;
		}	
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

	/* Applications of AVL tree */
	
	/* Find rank of element x */
	 
	public int getRank(Node root,int x) {
		
		int rank = 0;
		
		if(root==null) return -1;
		
		while(root!=null) {
			if(x==root.data) {
				if(root.right!=null)
					return rank+root.right.num+1;
				else
					return rank+1;
			}
			else if(x<root.data) {
				if(root.right!=null)
					rank += root.right.num + 1;
				else
					rank += 1;
				root = root.left;
			}
			else {
				root = root.right;
			}
		}
		return 1+rank;
	}

	/* Find element in avl with rank r */
	
	public int findRank(Node root,int rank) {
		
		while(root!=null) {
			if(root.right!=null) {	
				if(rank==(1+root.right.num))
					return root.data;
				else if(rank>(1+root.right.num)) {
					rank -= (1+root.right.num);
					root = root.left;
				}
				else {
					root = root.right;
				}
			}
			else {
				if(rank==1)
					return root.data;
				else {
					rank = rank-1;
					root = root.left;
				}	
			}
		}
		return -99999;
	}
	
	/* find number of elements between l and r excluding them */
	
	public int numEle(Node root,int l,int r) {
		
		if(l==r) return 0;
		
		if(isExists(root,r)){
			return getRank(root,l)-getRank(root,r)-1;
		}
		else {
			return getRank(root,l)-getRank(root,r);
		}
		
	}
	
	public boolean isExists(Node root,int key) {
		
		if(root==null)
			return false;
		
		if(root.data==key)
			return true;
		else if(key>root.data)
			return isExists(root.right,key);
		else
			return isExists(root.left,key);
		
	}
	
	/* Find prefix sum of x (sum of all elements less than x) */
	
	public int prefixSum(Node root,int x) {
		int psum = 0;
		if(root==null) return 0;
		
		while(root!=null) {
			if(x==root.data) {
				if(root.left!=null)
					return psum+root.left.sum;
				else
					return psum;
			}
			else if(x>root.data) {
				if(root.left!=null)
					psum += root.left.sum + root.data;
				else
					psum += root.data;
				root = root.right;
			}
			else {
				root = root.left;
			}
		}
		return psum;
	}
	
    /* find sum of elements between l and r excluding them */
	
	public int sumEle(Node root,int l,int r) {
		
		if(isExists(root,l)){
			return prefixSum(root,r)-prefixSum(root,l)-l;
		}
		else {
			return prefixSum(root,r)-prefixSum(root,l);
		}
	}
	
	/* Avg of elements between l and r excluding them */
	
	public float avgEle(Node root,int l,int r) {
		return (float)sumEle(root,l,r)/numEle(root,l,r);
	}
	
	/* Find the minimum difference among all elements in avl */
	
	public int minGap(Node root) {
		return root.mingap;
	}
	
	/* Find the max difference among all elements in avl */
	
	public int maxGap(Node root) {
		return root.max-root.min;
	}
	
	/* Find the minimum difference of elements between x and y */
	
	public int minGapRange(Node root,int x,int y) {
		
		int minGap;
		int temp1,temp2;
		
		if(root==null)
			return -1;
		
		while(root!=null) {
			
			if(x>root.data) {
				root = root.right;
			}
			else if(y<root.data) {
				root = root.left;
			}	
			else {
				
				int min_x,max_x,mingap_x;
				int min_y,max_y,mingap_y;
				
				min_x=min_y=mingap_y=mingap_x=Integer.MAX_VALUE;
				max_x=max_y=Integer.MIN_VALUE * (-1);
				
				if(x!=root.data) {
					Node temp = root.left;
					int t1,t2;
					while(temp!=null) {
						if(x==temp.data) {
							if(temp.right!=null) {
								mingap_x = Math.min(mingap_x,Math.min(temp.right.mingap,temp.right.min-temp.data));
								if(min_x!=Integer.MAX_VALUE)
									mingap_x = Math.min(mingap_x,min_x-temp.right.max);// min_x - max.right 
								min_x = Math.min(min_x,Math.min(x,temp.right.min));
								max_x = Math.max(max_x,Math.max(x,temp.right.max));
								
							}
							else {
								if(min_x!=Integer.MAX_VALUE)
									mingap_x = Math.min(mingap_x,min_x-temp.data);
								min_x = Math.min(min_x,x);
								max_x = Math.max(max_x,x);		
							}
							break;
						}
						else if(x<temp.data) {
							if(temp.right!=null) {
								mingap_x = Math.min(mingap_x,Math.min(temp.right.mingap,temp.right.min-temp.data));
								if(min_x!=Integer.MAX_VALUE)
									mingap_x = Math.min(mingap_x,min_x-temp.right.max); // check  this
								min_x = Math.min(min_x,Math.min(temp.data,temp.right.min));
								max_x = Math.max(max_x,Math.max(temp.data,temp.right.max));
							}
							else {
								if(min_x!=Integer.MAX_VALUE)
									mingap_x = Math.min(mingap_x,min_x-temp.data);
								min_x = Math.min(min_x,temp.data);
								max_x = Math.max(max_x,temp.data);
							}
							temp = temp.left;
						}
						else {
							temp = temp.right;
						}
					}
				}
				
				if(y!=root.data) {
					Node temp = root.right;
					int t1,t2;
					while(temp!=null) {
						if(y==temp.data) {
							if(temp.left!=null) {
								mingap_y = Math.min(mingap_y,Math.min(temp.left.mingap,temp.data-temp.left.max));
								if(max_y!=Integer.MIN_VALUE)
									mingap_y = Math.min(mingap_y,temp.left.min-max_y);
								min_y = Math.min(min_x,Math.min(x,temp.left.min));
								max_y = Math.max(max_x,Math.max(x,temp.left.max));
							}
							else {
								if(max_y!=Integer.MIN_VALUE)
									mingap_y = Math.min(mingap_y,temp.data-max_y);
								min_y = Math.min(min_y,y);
								max_y = Math.max(max_y,y);		
							}
							break;
						}
						else if(y>temp.data) {
							if(temp.left!=null) {
								mingap_y = Math.min(mingap_y,Math.min(temp.left.mingap,temp.data-temp.left.max));
								if(max_y!=Integer.MIN_VALUE)
									mingap_y = Math.min(mingap_y,temp.left.min-max_y);
								min_y = Math.min(min_y,Math.min(temp.data,temp.left.min));
								max_y = Math.max(max_y,Math.max(temp.data,temp.left.max));
							}
							else {
								if(max_y!=Integer.MIN_VALUE)
									mingap_y = Math.min(mingap_y,temp.data-max_y);
								min_y = Math.min(min_y,temp.data);
								max_y = Math.max(max_y,temp.data);		
							}
							temp = temp.right;
						}
						else {
							temp = temp.left;
						}
					}
				}
				
				System.out.println("\n"+min_x+" "+max_x+" "+mingap_x);
				System.out.println("\n"+min_y+" "+max_y+" "+mingap_y);
				
				
				temp1 = Math.min(mingap_x,mingap_y);
				
				if(max_x!=Integer.MIN_VALUE && min_y!=Integer.MAX_VALUE)
					temp2 = Math.min(root.data-max_x,min_y-root.data);
				else if(max_x==Integer.MIN_VALUE || min_y==Integer.MAX_VALUE) {
					if(max_x==Integer.MIN_VALUE)
						temp2 = min_y-root.data;
					else
						temp2 = root.data-max_x;
				}
				else 
					temp2 = Integer.MAX_VALUE;
				minGap = Math.min(temp1,temp2);
				return minGap;
			}
		}
		return 0;
	}

	/* find the maximum difference of elements between x and y */
	
	public int maxGapRange(Node root,int x,int y) {
		
		if(x>root.max || y<root.min) {
			return 0;
		}
		else {
			return inorderPre(root,y)-inorderSucc(root,x);
		}
	}
	
	public int inorderSucc(Node root,int x) {
		
		Node temp = root;
		Node parent = null;
		
		while(temp!=null)
		{
			if(temp.data==x) {
				return x;
			}
			else if(x>temp.data) {
				parent = temp;
				temp = temp.right;
			}	
			else {
				parent = temp;
				temp = temp.left;
			}
		}
		
	    temp = parent;
	 
	    if(parent.data>x)
	    	return parent.data;
	    
	    while(temp!=null) {
	    	
	    	if(temp.parent.right==temp)
	    		temp = temp.parent;
	    	else
	    		return temp.parent.data;
	    }
	    return Integer.MIN_VALUE;
	}
	
	public int inorderPre(Node root,int y) {
		

		Node temp = root;
		Node parent = null;
		
		while(temp!=null)
		{
			if(temp.data==y) {
				return y;
			}
			else if(y>temp.data) {
				parent = temp;
				temp = temp.right;
			}	
			else {
				parent = temp;
				temp = temp.left;
			}
		}
		
	    temp = parent;
	    
	    if(parent.data<y)
	    	return parent.data;
	    
	    while(temp!=null) {
	    	
	    	if(temp.parent.left==temp)
	    		temp = temp.parent;
	    	else
	    		return temp.parent.data;
	    }
	    return Integer.MAX_VALUE;
	}

}


