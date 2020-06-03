package problemInputs;

import java.util.*;
import classProblems.FindSubsets;

public class FindSubsetsIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1,2,3,4};
		FindSubsets fs = new FindSubsets();
		ArrayList<ArrayList<Integer>> allSubsets;
		allSubsets = fs.getSubsets(arr);
		for(ArrayList<Integer> subSet:allSubsets) {
			System.out.print("[");
			for(Integer ele:subSet) {
				System.out.print(ele+",");
			}
			System.out.print("] ");
		}
		
	}

}
