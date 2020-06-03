package problemInputs;

import classProblems.MergeSort;

public class MergeSortIp {

	public static void main(String[] args) {
		MergeSort m;
		int[] sortedList;
		int[] list = {8,18,21,35,10,3,333,1224,38};
		
		m = new MergeSort(list);
		
		sortedList = m.sort();
		System.out.print("Sorted op using Merege sort: ");
		for(int index=0;index<list.length;index++) {
			System.out.print(list[index]+" ");
		}
	}

}
