package classProblems;

//import classProblems.LinkList.Node;

public class LinkList {
	private class Node{
		private int data;
		private Node next;
		 
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node Head;
	
	public LinkList(int data) {
		Node temp = new Node(data);
		this.Head = temp;
	}
	
	public void addBegin(int data) {
		Node temp = new Node(data);
		temp.next = Head;
		Head = temp;
	}
	
	public void addEnd(int data) {
		Node temp = new Node(data);
		Node itr = Head;
		
		while(itr.next!=null) {
			itr = itr.next;
		}
		itr.next = temp;
	}
	
	public void delBegin() {
		Node temp = Head;
		Head = Head.next;
		temp=null;
	}
	
	public void delEnd() {
		Node temp;
		Node itr = Head;
		
		while(itr.next.next!=null) {
			itr = itr.next;
		}
		itr.next=null;
	}
	
	public void delNode(int data) {
		Node itr = Head;
		
		while(itr.next.data!=data) {
			itr = itr.next;
		}
		itr.next = itr.next.next;
	}
	
	public int getFirst() {
		return Head.data;
	}
	
	public int getLast() {
		Node itr = Head;
		while(itr.next!=null) {
			itr = itr.next;
		}
		return itr.data;
	}
	
	public int getLen() {
		Node itr = Head;
		int count = 0;
		while(itr!=null) {
			itr = itr.next;
			count++;
		}
		return count;
	}
	
	public void addAfter(int data,int afterNode) {
		
		Node itr=Head;
		Node temp = new Node(data);
		
		while(itr.data!=afterNode) {
			itr = itr.next;
		}
		
		temp.next = itr.next;
		itr.next = temp;
	}
	
	public void print() {
		Node itr = Head;
		while(itr!=null) {
			System.out.print(itr.data);
			itr = itr.next;
			if(itr!=null)
				System.out.print("-->");
			else
				System.out.println();
		}	
	}
}	

