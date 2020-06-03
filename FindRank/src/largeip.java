
import java.util.*;

public class largeip {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(10000000);
		findRank f;
		test t;
		long startTime = System.currentTimeMillis();
		System.out.println("Started......");
		int inputSize = 1000000;
		int querySize = 1000;
		
		int[] arr = new int[inputSize];
		Random rand = new Random();
		
		for(int i=1;i<inputSize;i++) {
			int number = 1+rand.nextInt(inputSize);
			arr[i-0] = number;
			list.add(new Integer(number));
		}
		
		//System.out.print(list.get(100).intValue());
		
		f = new findRank(list);
		
		t = new test(arr);
		
		for(int k=1;k<=querySize;k++) {
			//System.out.println(k);
			int queryRank = 1+rand.nextInt(inputSize);
			t.findRankDet(queryRank);
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Time taken for execution = "+ (endTime-startTime) + " ms");
		
		/* Observations :  Deterministic = 198 sec Random = 1933 sec , ip = 10^6 queries = 10^4 */
 		
		
	}

}
