package problemInputs;

import classProblems.MinHeap;
import classProblems.MaxHeap;

public class HeapIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] arr = {13,23,45,67,2,7,16,34,97,10};
		
		/*
		MinHeap minheap = new MinHeap(1000);
		minheap.BuildHeap(arr);
		minheap.Add(minheap.getHeap(),5);
		minheap.Add(minheap.getHeap(),1);
		minheap.DecKey(minheap.getHeap(),34,-2);
		minheap.Add(minheap.getHeap(),34);
		minheap.DeleteMin(minheap.getHeap());
		minheap.DeleteKey(minheap.getHeap(),7);
		minheap.printHeap();
		minheap.IncKey(minheap.getHeap(),1,19);
		minheap.printHeap();
		*/
		/*
		MaxHeap maxheap = new MaxHeap(1000);
		maxheap.BuildHeap(arr);
		maxheap.printHeap();
		maxheap.Add(maxheap.getHeap(),5);
		maxheap.Add(maxheap.getHeap(),1);
		maxheap.IncKey(maxheap.getHeap(),34,43);
		maxheap.Add(maxheap.getHeap(),34);
		maxheap.DeleteMax(maxheap.getHeap());
		maxheap.DeleteKey(maxheap.getHeap(),7);  
		maxheap.printHeap();
		maxheap.DecKey(maxheap.getHeap(),67,17);
		maxheap.printHeap();
		*/
		
		
		int numbers[] = {23,12,54,32,18,99,6,17,47,21};
		MinHeap heapsort = new MinHeap(1000);
		heapsort.HeapSort(numbers);
		System.out.println("Min Heap Sort");
		for(int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i]+" ");
		}
		System.out.println();
			
		MaxHeap heapsort_max = new MaxHeap(1000);
		heapsort_max.HeapSort(numbers);
		System.out.println("Max Heap Sort");
		for(int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i]+" ");
		}
		System.out.println();
	}

}
