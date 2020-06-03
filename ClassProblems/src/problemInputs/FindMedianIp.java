package problemInputs;

import classProblems.FindMedian;

public class FindMedianIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12,3,7,17,32,4,44};
		FindMedian f = new FindMedian(arr);
		System.out.println("Median : "+f.getMedian());
		f.deleteMedian();
		f.deleteMedian();
		f.add(14);
		System.out.println("Median : "+f.getMedian());
	}

}
