package stockSpan;

public class input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []stockValue = {25,30,15,12,20,10};
		
		stockSpan sp = new stockSpan(stockValue);
		sp.findSpan();
		
		int []span = sp.getSpan();
		
		for(int i=0;i<span.length;i++) {
			System.out.print(span[i]+" ");
		}
		System.out.println();
		
	}

}
