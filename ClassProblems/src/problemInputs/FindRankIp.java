package problemInputs;


import classProblems.FindRank;
import java.util.ArrayList;
import java.util.Random;

public class FindRankIp {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(10000000);
		FindRank find;
		int inputSize = 1000000;
		int querySize = 10000;
		int[] arr = new int[inputSize];
		int [] smallIp = {35,97,3,333,8,38,224,18,101,101};
		Random rand = new Random();
		
		long startTime = System.currentTimeMillis();
		System.out.println("Started......");

				
		for(int i=0;i<inputSize;i++) {
			int number = 1+rand.nextInt(inputSize);
			arr[i] = number;
			list.add(new Integer(number));
		}
		
		find = new FindRank(smallIp);
		System.out.println(find.findRankRand(5));
		
	//	for(int k=1;k<=querySize;k++) {
	//	    System.out.println(k);
	//		int queryRank = 1+rand.nextInt(inputSize);
	//		find.findRankRand(queryRank);
	//	}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Time taken for execution = "+ (endTime-startTime) + " ms");
		
		/* Observations :  Deterministic = 198 sec Random = 8 sec , ip = 10^6 queries = 10^4 */
	}

}
