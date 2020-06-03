package classProblems;

public class MaxHeap {


	private int Heapcapacity;
	private int Heap[];
	private int lastIndex;
	
	public MaxHeap(int HeapCapacity) {
		this.Heapcapacity = HeapCapacity;
		this.Heap = new int[this.Heapcapacity];
		this.lastIndex = 0;
	}	
	
	public void BuildHeap(int[] Heap) {
		int len = Heap.length;
		int index = (len/2)-1;
		this.lastIndex=Heap.length;
		for(int i=index;i>=0;i--) {
			this.topDownHeapify(Heap,i);
		}
		System.arraycopy(Heap,0,this.Heap,0,Heap.length);
	}
	
	public void Add(int[] Heap,int key) {
		Heap[this.lastIndex++] = key;
		this.bottomUpHeapify(Heap,this.lastIndex-1);
	} 
	
	public int getMax() {
		return this.Heap[0];
	}
	
	public int getSize() {
		return this.lastIndex;
	}
	
	public void DeleteMax(int []Heap) {
		swap(Heap,0,this.lastIndex-1);
		this.lastIndex--;
		topDownHeapify(Heap,0);
	}
	
	public void IncKey(int[] Heap,int key,int newValue) {
		int i;
		for(i=0;Heap[i]!=key && i<this.lastIndex;i++);
		if(newValue>key) {
			Heap[i] = newValue;
			this.bottomUpHeapify(Heap,i);
		}
	}
	
	public void DecKey(int [] Heap,int key,int newValue) {
		int i;
		for(i=0;Heap[i]!=key && i<this.lastIndex;i++);
		if(newValue<key) {
			Heap[i] = newValue;
			this.topDownHeapify(Heap,i);
		}
		
	}
	
	public void printHeap() {
		for(int i=0;i<this.lastIndex;i++) {
			System.out.print(this.Heap[i]+" ");
		}
		System.out.println();
	}
	
	public void DeleteKey(int[] Heap,int key) {
		int maxKey = this.Heap[0];
		/* Decrease the key to one less than min and call delete min */
		this.IncKey(Heap,key,maxKey+1);
		this.DeleteMax(Heap);
	}
	
	public void topDownHeapify(int[] Heap,int index) {
		int left = 2*index +1;
		int right = left+1;
		int max;
		
		while(right<this.lastIndex) {
			if(Heap[left]>Heap[right])
				max = left;
			else
				max = right;
			
			if(Heap[index]<Heap[max]) {
				swap(Heap,index,max);
				index = max;
				left  = 2*index+1;
				right = left+1;
			}
			else {
				break;
			}
		}
		if(left==(this.lastIndex-1) && Heap[left]>Heap[index]) {
			swap(Heap,index,left);
		}
	}
		
	public void bottomUpHeapify(int[] Heap,int index) {
		int parent = (index-1)/2;
		
		while(parent>=0) {	
			if(Heap[parent]<Heap[index]) {
				this.swap(Heap,index,parent);
				index = parent;
				parent = (index-1)/2;
			}
			else {
				break;
			}
		}
	}
	
	private void swap(int[] Heap,int i,int j) {
		int temp = Heap[i];
		Heap[i] = Heap[j];
		Heap[j] = temp;
	}

	public void HeapSort(int [] arr) {
		this.BuildHeap(arr);
		while(this.lastIndex!=1) {
			this.DeleteMax(arr);
		}
	}
	
	public int[] getHeap() {
		return this.Heap;
	}
	
	
	
	
	
	
	
	
	
	
	
}
