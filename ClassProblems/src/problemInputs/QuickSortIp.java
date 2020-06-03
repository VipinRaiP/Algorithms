package problemInputs;

import classProblems.QuickSort;
import java.util.*;

public class QuickSortIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort q;
		int[] sortedList;
		int[] list = {8,18,21,35,10,3,333,1224,38};
		
		q = new QuickSort(list);
		
		sortedList = q.sort();
		for(Integer item:sortedList) {
			System.out.print(item+" ");
		}
		
		
	}

}
