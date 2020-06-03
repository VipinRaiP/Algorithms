package classProblems;

import java.util.*;

/* have to handle negative cases */

public class TurnPike {
	private LinkedList <Integer> dist  = new LinkedList<Integer>();
	private ArrayList<Integer> s  = new ArrayList<Integer>();
	private int maxElement;
	
	public TurnPike(LinkedList <Integer> dist) {
		this.dist = dist;
		this.dist.sort(null);
		this.maxElement = this.dist.getLast();
		this.s.add(0);
		
	}
	
	public void findSet() {
		if(!findS(this.dist,this.maxElement)){
			System.out.println("Not possible to construct");
		}
	}
	
	public boolean findS(LinkedList<Integer> dist,int d) {
		int pos1,pos2;
		int element = d;
		boolean  status = true;
		int index = dist.size()-1;
		LinkedList<Integer> copyDist;
		
		if(dist.isEmpty()) {
			System.out.println("End");
			return true;
		}
		
		pos2 = this.maxElement-dist.get(index-1).intValue();
		pos1 = dist.get(index-1).intValue();
		
		if(dist.get(index)==this.maxElement) {
			this.s.add(new Integer(this.maxElement));
			dist.remove(new Integer(this.maxElement));
		}
		else{
			dist.remove(new Integer(d));
			for(Integer item:this.s) {
				int ele = item.intValue();
				if(ele==0) continue;
				int diff = Math.abs(element - ele); 
				
				if(dist.contains(new Integer(diff))) {
					dist.remove(new Integer(diff));
				}
				else {
					return false;
				}
			}
			this.s.add(new Integer(element));
		}
		
		if(dist.contains(new Integer(pos1))) {
			 copyDist = (LinkedList<Integer>) dist.clone();
			 //dist.remove(new Integer(pos1));
			 status = findS(dist,pos1);
			 if(status) return true;
			 dist = (LinkedList<Integer>) copyDist.clone();
		}
		
		if(dist.contains(new Integer(pos2))) {
			 //dist.remove(new Integer(pos2));
			 status = findS(dist,pos2);
			 if(!status) this.s.remove(new Integer(d));
		}
		
		return status;
	}

	public ArrayList<Integer> getSet(){
		return s;
	}
	
}
