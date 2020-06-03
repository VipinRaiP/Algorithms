package classProblems;

public class FindMedian {

	MaxHeap H1;
	MinHeap H2;
	
	public FindMedian(int arr[]){
		int medGreater;
		medGreater = arr.length/2; //Elements greater than median
		H1 = new MaxHeap(10000);
		H2 = new MinHeap(10000);
		H1.BuildHeap(arr);
		for(int i=1;i<=medGreater;i++) {
			int key;
			key = H1.getMax();
			H1.DeleteMax(H1.getHeap());
			H2.Add(H2.getHeap(),key);
		}
	}
	
	public int getMedian() {
		return H1.getHeap()[0];
	}
	
	public void add(int key) {
		int med = this.getMedian();
		int totalEle = H1.getSize()+H2.getSize();
		if(key<=med) {
			if(totalEle%2==0) {
				H1.Add(H1.getHeap(),key);
			}
			else {
				H1.Add(H1.getHeap(),key);
				H2.Add(H2.getHeap(), H1.getMax());
				H1.DeleteMax(H1.getHeap());
			}
		}
		else {
			if(totalEle%2==0) {
				H2.Add(H2.getHeap(),key);
				H1.Add(H1.getHeap(), H2.getMin());
				H2.DeleteMin(H2.getHeap());
			}
			else {
				H2.Add(H2.getHeap(),key);
			}
		}
	
		
	}
	
	public void deleteMedian() {
		
		int totalEle = H1.getSize()+H2.getSize();
		
		if(totalEle%2==0) {
			H1.DeleteMax(H1.getHeap());
			H1.Add(H1.getHeap(), H2.getMin());
			H2.DeleteMin(H2.getHeap());
		}
		else {
			H1.DeleteMax(H1.getHeap());
		}
	}
}
