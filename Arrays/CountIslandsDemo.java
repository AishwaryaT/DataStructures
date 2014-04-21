package Arrays;

import java.util.Arrays;

public class CountIslandsDemo {
	public final int ROW = 5;
	public final int COL = 5;
	
	public static void main(String []args){
		CountIslandsDemo demo = new CountIslandsDemo();
		int A[][] = {{1, 1, 0, 0, 0},
					{0, 1, 1, 0, 1},
					{1, 0, 0, 1, 1},
					{0, 0, 0, 0, 0},
					{1, 0, 1, 1, 1}};
		
		System.out.println(" Number of islands: "+ demo.countIslands(A));
		
	}
	//visited[][] to keep track of visited nodes
	//A[][] the given array
	private boolean isSafe( int A[][], boolean visited[][], int row, int col){
		
		return (row >=0 && row < ROW && col >=0 && col < COL && A[row][col] == 1 && !visited[row][col]  );
	}
	
	private void DFS(int A[][], boolean visited[][], int row, int col){
		final int rowNbr[] = {-1, -1, -1,  0, 0,  1, 1, 1};
		final int colNbr[] = {-1,  0,  1, -1, 1, -1, 0, 1};	
		visited[row][col] = true;
		for(int i=0; i < 8; i++){
			if(isSafe(A, visited, row + rowNbr[i], col + colNbr[i]))
				DFS(A, visited, row + rowNbr[i], col + colNbr[i]);
		}
	}
	
	private int countIslands(int[][] A) {
		boolean visited[][] = new boolean [ROW][COL];
		//Arrays.fill(visited,false);
		for (int row = 0; row < ROW; row ++)
		    for (int col = 0; col < COL; col++)
		        visited[row][col] = false;
		
		int count = 0;
		for(int row = 0; row < ROW; row++){
			for (int col =0; col < COL; col++){
				if(A[row][col] == 1  && !visited[row][col]){
					DFS(A, visited, row, col );
					count++;
				}
			}
		}
		
		return count;
	}
}
