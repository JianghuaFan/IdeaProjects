package DP;

import java.util.Arrays;

public class LargestSubMatrix {
	public int largest(int[][] matrix) {
		   // Write your solution here
		
		int res = Integer.MIN_VALUE;
		if(matrix == null || matrix.length == 0){
			return res;
		}
		int n = matrix.length;
		int m = matrix[0].length;		
		for(int i = 0; i < n; i++) {
			int[] cur = new int[m];
			for(int j = i; j < n; j++) {
				// for each row i, we add the rows one by one for row j,
				//  to make sure each time we only introduce O(n) time
				add(cur, matrix[j]);
				// for each possible pair of rows i, j,
				// we would like to know what is the largest subMatrix sum
				// using top row as row i and bottom row j
				// we "flatten" these area to a one dimensional array
				res = Math.max(res, max(cur));
			}
			System.out.println("After adding for rows: "+ Arrays.toString(cur));
		}		
		return res;
	}
	
	private void add( int[] cur, int[] add) {
		for(int i = 0; i < cur.length; i++) {
			cur[i] += add[i];
		}
	}
	// largest subArray Sum
	private int max(int[] cur) {
		// TODO Auto-generated method stub
		int res = cur[0];
		int tmp = cur[0];
		for(int i = 1; i < cur.length; i++) {
			tmp = Math.max(cur[i],tmp + cur[i]);
			res = Math.max(res, tmp);
		}
		return res;
	}
	
	private void addRow(int[] cur, int[] add) {
		for(int i = 0; i < cur.length; i++) {
			cur[i] += add[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestSubMatrix largest = new LargestSubMatrix();
//		int[][] matrix = {  {0, 0, 0, 0},
//	  			{1, 1, 1, 1},
//	  			{0, 1, 1, 1},
//	  			{1, 0, 1, 1} };
//		int[][] matrix = {{-1,-2,-3},{-4,-3,-2},{-3,1,2}};
		int[][] matrix = {{1,2,3},{2,3,4}};
		System.out.println(Arrays.deepToString(matrix));
		
//		int[] cur = new int[matrix[0].length];
//		for(int i = 0; i < matrix.length; i++) {
//			largest.addRow(cur, matrix[i]);			
//		}
//		System.out.println("After adding for rows: "+ Arrays.toString(cur));
		System.out.println(largest.largest(matrix));
//		System.out.println(Arrays.deepToString(largest.largest(matrix, 0,1)));
	}

}
