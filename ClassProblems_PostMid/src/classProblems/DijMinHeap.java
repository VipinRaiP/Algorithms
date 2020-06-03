package classProblems;

public class DijMinHeap {

	private int Heapcapacity;
	private Node Heap[];
	private int lastIndex;
	
	public DijMinHeap(int HeapCapacity) {
		this.Heapcapacity = HeapCapacity;
		this.Heap = new Node[this.Heapcapacity];
		this.lastIndex = 0;
	}	
	
	public void BuildHeap(Node[] Heap) {
		int len = Heap.length;
		int index = (len/2)-1;
		this.lastIndex=Heap.length;
		for(int i=index;i>=0;i--) {
			this.topDownHeapify(Heap,i);
		}
		System.arraycopy(Heap,0,this.Heap,0,Heap.length);
	}
	
	public void Add(Node[] Heap,Node item) {
		Heap[this.lastIndex++] = item;
		this.bottomUpHeapify(Heap,this.lastIndex-1);
	}
	
	public Node getMin() {
		return this.Heap[0];
	}
	
	public int getSize() {
		return this.lastIndex;
	}
	
	public void DeleteMin(Node []Heap) {
		swap(Heap,0,this.lastIndex-1);
		this.lastIndex--;
		topDownHeapify(Heap,0);
	}
	
	public void DecKey(Node[] Heap,int index,int newValue) {
		int i;
		for(i=0;Heap[i].index!=index && i<this.lastIndex;i++);
		if(newValue<Heap[i].priority) {
			Heap[i].priority = newValue;
			this.bottomUpHeapify(Heap,i);
		}
	}
	
	public void IncKey(Node[] Heap,int index,int newValue) {
		int i;
		for(i=0;Heap[i].index!=index && i<this.lastIndex;i++);
		if(newValue>Heap[i].priority) {
			Heap[i].priority = newValue;
			this.topDownHeapify(Heap,i);
		}
	}
		
	public void printHeap() {
		for(int i=0;i<this.lastIndex;i++) {
			System.out.print(this.Heap[i].priority+" ");
		}
		System.out.println();
	}
	
	public void DeleteKey(Node[] Heap,int key) {
		int minKey = this.Heap[0].priority;
		/* Decrease the key to one less than min and call delete min */
		this.DecKey(Heap,key,minKey-1);
		this.DeleteMin(Heap);
	}
	
	public void topDownHeapify(Node[] Heap,int index) {
		int left = 2*index +1;
		int right = left+1;
		int min;
		
		while(right<this.lastIndex) {
			if(Heap[left].priority<Heap[right].priority)
				min = left;
			else
				min = right;
			
			if(Heap[index].priority>Heap[min].priority) {
				swap(Heap,index,min);
				index = min;
				left  = 2*index+1;
				right = left+1;
			}
			else {
				break;
			}
		}
		if(left==(this.lastIndex-1) && Heap[left].priority<Heap[index].priority) {
			swap(Heap,index,left);
		}
	}
		
	public void bottomUpHeapify(Node[] Heap,int index) {
		int parent = (index-1)/2;
		
		while(parent>=0) {	
			if(Heap[parent].priority>Heap[index].priority) {
				this.swap(Heap,index,parent);
				index = parent;
				parent = (index-1)/2;
			}
			else {
				break;
			}
		}
	}
	
	private void swap(Node[] Heap,int i,int j) {
		Node temp = Heap[i];
		Heap[i] = Heap[j];
		Heap[j] = temp;
	}

	public void HeapSort(Node [] arr) {
		this.BuildHeap(arr);
		while(this.lastIndex!=1) {
			this.DeleteMin(arr);
		}
	}
	
	public Node[] getHeap() {
		return this.Heap;
	}
}
