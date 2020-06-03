package classProblems;

import java.util.*;

public class FindSubsets {

	public ArrayList<ArrayList<Integer>> ans;
	
	public FindSubsets() {
		ans = new ArrayList<ArrayList<Integer>>();
	}
	
	public ArrayList<ArrayList<Integer>> getSubsets(int []arr){
		findSubsets(new ArrayList<Integer>(),arr,0);
		return ans;
	}
	
	private void findSubsets(ArrayList<Integer> runList,int []arr,int index) {
		if(index==arr.length) {
			ans.add((ArrayList<Integer>)runList.clone());
			return;
		}
		
		findSubsets(runList,arr,index+1);
		runList.add(arr[index]);
		findSubsets(runList,arr,index+1);
		runList.remove(runList.size()-1);
	}
	
}
