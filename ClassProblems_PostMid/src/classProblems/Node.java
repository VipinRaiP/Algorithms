package classProblems;

public class Node {
	int data;
	boolean visited;
	Node pi;
	int index;
	int discoveryTime;
	int finishTime;
	int priority;
	int color;
	Node(int data,int index){
		this.data = data;
		visited = false;
		pi = null;
		this.index = index;
		this.discoveryTime=this.finishTime=0;
		this.priority=Integer.MAX_VALUE;
		this.color = -1; // not colored
	}
}	