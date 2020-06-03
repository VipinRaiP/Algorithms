package problemInputs;

import java.util.*;
import classProblems.TurnPike;

public class TurnPikeIp {

	public static void main(String[] args) {
		TurnPike tp;
		LinkedList<Integer> list = new LinkedList<Integer>();
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(2));
		list.add(new Integer(2));
		list.add(new Integer(3));
		list.add(new Integer(3));
		list.add(new Integer(3));
		list.add(new Integer(4));
		list.add(new Integer(5));
		list.add(new Integer(5));
		list.add(new Integer(5));
		list.add(new Integer(6));
		list.add(new Integer(7));
		list.add(new Integer(8));
		list.add(new Integer(10)); 
		
/*		list.add(new Integer(1));
		list.add(new Integer(1));
		list.add(new Integer(1));
		list.add(new Integer(1));
		list.add(new Integer(1));
		list.add(new Integer(1));
		list.add(new Integer(1));
		list.add(new Integer(1));
		list.add(new Integer(1));
		list.add(new Integer(1)); */		
		
		tp = new TurnPike(list);
		
		tp.findSet();
		set = tp.getSet();
		for(Integer element:set) {
			System.out.print(element.intValue()+" ");
		}
	}
}


/* have to handle negative cases */