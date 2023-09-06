package DP;

import java.util.Arrays;

public class LargestXWith1s {
	// TC: O(m*n)
	// SC: O(m*n)
	public int largest(int[][] matrix) {
		   // Write your solution here		
		int m = matrix.length;
		if(m == 0) {
			return 0;
		}
		int n = matrix[0].length;
		if(n == 0) {
			return 0;
		}
		//leftUp records the longest possible length for leftDown and rightDown arms ending at each cells
		int[][] leftUp = leftUp(matrix, m, n);
		//rightDown records the longest possible length for rightUp and leftUp arms starting at each cells
		int[][] rightDown = rightDown(matrix, m, n);
		// merge the two matrix by getting the min value for each cell, and among all the cells get the max value
		return merge(leftUp, rightDown, m, n);			
	 }
	
	private int merge(int[][] leftUp, int[][] rightDown, int m, int n) {
		int res = 0;
		for(int i = 0; i < m; i++){			
			for(int j = 0; j < n; j++){
				leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
				res =  Math.max(leftUp[i][j], res);
			}
		}
		return res; 
	}

	private int[][] leftUp(int[][] matrix, int m, int n) {
		int[][] left = new int[m][n];
		int[][] up = new int[m][n];
		for(int i = 0; i < m; i++){			
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 1) {
					left[i][j] = getNumber(left, i - 1, j - 1, m, n) + 1;
					up[i][j] = getNumber(up, i - 1, j + 1, m, n) + 1;
				}
			}
		}
		merge(left, up, m, n);
		return left;
	}
	
	private int getNumber(int[][] number, int i, int j, int m, int n) {
		// 要查找的位置out of bound
		if(i < 0 || j < 0 || i >= m || j >= n) {
			return 0;
		}
		return number[i][j];
	}

	private int[][] rightDown(int[][] matrix, int m, int n) {
		int[][] right = new int[m][n];
		int[][] down = new int[m][n];
		for(int i = m - 1; i >= 0; i--){			
			for(int j = n - 1; j >= 0; j--){
				if(matrix[i][j] == 1) {
					right[i][j] = getNumber(right, i + 1, j + 1, m, n) + 1;
					down[i][j] = getNumber(down, i + 1, j - 1, m, n) + 1;
				}
			}
		}
		merge(right, down, m, n);
		return right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestXWith1s largest = new LargestXWith1s();
		int[][] matrix = {  {0, 0, 0, 0},
				  			{1, 1, 1, 1},
				  			{0, 1, 1, 1},
				  			{1, 0, 1, 1} };
//		System.out.println(Arrays.deepToString(largest.leftUp(matrix, 4, 4)));
		System.out.println(Arrays.deepToString(largest.rightDown(matrix, 4, 4)));
		System.out.println(largest.largest(matrix));
	}

}
