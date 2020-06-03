package problemInputs;

import java.util.*;
import classProblems.NQueen;


public class NQueenIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueen nq  = new NQueen();
		int num =4;
		int [][]board = new int[num][num];
		board = nq.getSolution(4);
		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
			
	}

}
