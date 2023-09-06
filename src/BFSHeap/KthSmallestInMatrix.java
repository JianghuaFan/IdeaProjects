package BFSHeap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInMatrix {
	public int kthSmallest(int[][] matrix, int k) {
	    // Write your solution here
	    if(matrix == null || matrix.length == 0) {
			     return -1;
			   }
			//Method 1: minHeap:
			int rowL = matrix.length;
			int colL = matrix[0].length;
	    //Best First Search, need a minHeap on the value of each cells    
			PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(new Comparator<Cell>() {
				 @Override
				 public int compare(Cell c1, Cell c2) {
					 if(c1.key == c2.key) return 0;
					 return c1.key < c2.key ? -1 : 1;
				 }			 
			 });
	     //all the generated cells will be marked true, to avoid being generated more than once
	    boolean[][] visited = new boolean[rowL][colL];
			minHeap.offer(new Cell(0,0,matrix[0][0]));
	    visited[0][0] = true;
	    // Iterate k-1 rounds, and BFS the smallest k-1 cells
			for(int i = 0; i < k - 1; i ++) {
				Cell cur = minHeap.poll();
	      // the neighbor cell will be inserted back to the minHeap only if 
	      //1. it is not out of boundary.
	      //2. it is not been generated before.  
				if(cur.row + 1 < rowL && !visited[cur.row+1][cur.col]) {
					visited[cur.row+1][cur.col] = true;
					minHeap.offer(new Cell(cur.row+1,cur.col,matrix[cur.row+1][cur.col]));
				}
				if(cur.col + 1 < colL && !visited[cur.row][cur.col+1]) {
					visited[cur.row][cur.col+1] = true;
					minHeap.offer(new Cell(cur.row,cur.col+1,matrix[cur.row][cur.col+1]));
				}
			}
			return minHeap.peek().key; 
	  }
	public class Cell {
		int row;
		int col;
		int key;
		public Cell(int row, int col, int key){
			this.row = row;
			this.col = col;
			this.key = key;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthSmallestInMatrix small = new KthSmallestInMatrix();
//		int[][] matrix = {{1,2},{2,5}};	
//		int[][] matrix = {{1},{}};
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};			
		System.out.println(small.kthSmallest(matrix,8));
		System.out.println(Arrays.deepToString(matrix));
//		System.out.println(Arrays.toString(matrix[1]));
		
		
	}
}
