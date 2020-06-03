package MinHeap;

public class Input {
	public static void main(String []args) {
		MinHeap minheap = new MinHeap(1000);
		int[] arr = {13,23,45,67,2,7,16,34,97,10};
		minheap.BuildHeap(arr);
		minheap.Add(minheap.getHeap(),5);
		minheap.Add(minheap.getHeap(),1);
		minheap.DecKey(minheap.getHeap(),34,-2);
		minheap.Add(minheap.getHeap(),34);
		minheap.DeleteMin(minheap.getHeap());
		minheap.DeleteKey(minheap.getHeap(),7);
		minheap.printHeap();
		
		MinHeap heapsort = new MinHeap(1000);
		int numbers[] = {23,12,54,32,18,99,6,17,47,21};
		heapsort.HeapSort(numbers);
		for(int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i]+" ");
		}
		System.out.println();
	}
	
}
