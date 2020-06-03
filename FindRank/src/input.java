import java.util.ArrayList;

import java.util.*;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		findRank f;
		test t;
		int [] arr = {35,97,3,333,8,38,224,18,21,10};
/*		
		list.add(new Integer(8));
		list.add(new Integer(18));
		list.add(new Integer(21));
		list.add(new Integer(35));
		list.add(new Integer(10));
		list.add(new Integer(3));
		list.add(new Integer(333));
		list.add(new Integer(224));
		list.add(new Integer(38));
		list.add(new Integer(97)); */
	
		/* Find the element  whose rank is r in an array */
		

		list.add(new Integer(333));
		list.add(new Integer(224));
		list.add(new Integer(97));
		list.add(new Integer(38));
		list.add(new Integer(35));
		list.add(new Integer(21));
		list.add(new Integer(18));
		list.add(new Integer(10));
		list.add(new Integer(8));
		list.add(new Integer(3));
		
		
	//	Collections.reverse(list);	
		
	//	f = new findRank(list);
		
		t  = new test(arr);
		
		int queryRank = 10;
		System.out.println("\n Element at rank " + queryRank +" : " + t.findRankDet(queryRank));
	}

}
