package problemInputs;

import classProblems.Hashing;
import java.util.*;

public class HashingIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashing<String> h = new Hashing(20);
		
		String meFname = new String("Vipin");
		String rahulFname = new String("Rahul");
		String meSname = new String("Rai");
		String rahulSname = new String("Dravid");
		
		h.add(43,meFname);
		h.add(21,rahulFname);
		h.add(43,meSname);
		h.add(21, rahulSname);
		System.out.println(h.search(43,meSname));
		h.delete(43,meFname);
		System.out.println(h.search(43,meFname));
		
/*		
		Hashtable<Integer,String> ht = new Hashtable();
		
		ht.put(1, new String("Vipin"));
		ht.put(1,new String("Rai"));
		
		
		System.out.print(ht.get(1));
		
		*/
		
	}

}
