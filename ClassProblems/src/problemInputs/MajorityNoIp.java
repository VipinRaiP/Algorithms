package problemInputs;

import java.util.*;
import classProblems.MajorityNo;

public class MajorityNoIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {5,5,4,5,6,34,5,6,5,5,6,6,6,6,45};
		ArrayList<Integer> majNo= new ArrayList<Integer>(); 
		
		
		MajorityNo mn= new MajorityNo(arr);
		System.out.println("Majority No : "+mn.getMajority());
		
		
		majNo = mn.getMajorityGen(3);
		System.out.print("Majority no: ");
		for(int i=0;i<majNo.size();i++) {
			System.out.print(majNo.get(i).intValue()+ " ");
		}
		System.out.println();
	}

}
