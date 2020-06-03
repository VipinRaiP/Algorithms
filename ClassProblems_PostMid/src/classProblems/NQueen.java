package classProblems;

import java.util.*;


public class NQueen {

	private HashMap<Integer,Boolean> ld;
	private HashMap<Integer,Boolean> rd;
	public boolean isRowFree[];
	public int[][] board;
	
	public int [][] getSolution(int num){
		board = new int[num][num];
		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++)
				board[i][j] = 0;
		}
		ld = new HashMap<>();
		rd = new HashMap<>();
		isRowFree = new boolean[num];
		findSolution(0);
		return board;
	}
	
	public boolean findSolution(int col) {
		
		if(col==board.length)
			return true;
		
		int rows = board.length;
		
		for(int i=0;i<rows;i++) {
			if(isSafe(i,col)) {
				
				board[i][col] = 1;
				
				updateCells(i,col,true);
				
				if(findSolution(col+1))
					return true;
				
				board[i][col] = 0;
				updateCells(i,col,false);
			}
		}
		
		return false;
	}
	
	public void updateCells(int i,int j,boolean status) {
		ld.put(i-j,status);
		rd.put(i+j,status);
		isRowFree[i] = status;
	}
	
	public boolean isSafe(int i,int j) {
		if(!isRowFree[i]) {
			
			if(!ld.containsKey(i-j) && !rd.containsKey(i+j))
				return true;
			else if(!ld.containsKey(i-j) || !rd.containsKey(i+j)) {
				if(ld.containsKey(i-j))
					return !ld.get(i-j);
				if(rd.containsKey(i+j))
					return !rd.containsKey(i+j);
			}
			else {
				return !(ld.get(i-j)||rd.get(i+j));
			}
		}
		return false;
	}
}
