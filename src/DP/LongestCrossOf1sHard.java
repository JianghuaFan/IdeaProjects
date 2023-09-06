package DP;

import java.util.Arrays;

public class LongestCrossOf1sHard {
	public int largest(int[][] matrix) {
		   // Write your solution here		
		int m = matrix.length;
		int n = matrix[0].length;
		//leftUp records the longest possible length for left and up arms ending at each cells
		int[][] leftUp = leftUp(matrix, m, n);
		//rightDown records the longest possible length for right and down arms starting at each cells
		int[][] rightDown = rightDown(matrix, m, n);
		// merge the two matrix by getting the min value for each cell, and among all the cells get the max value
		return merge(leftUp, rightDown, m, n);			
	 }
	
	// calculate the max possible length of left and up arms for each of the cells in the matrix
	private int[][] leftUp(int[][] matrix, int m, int n){
		int[][] left = new int[m][n];
		int[][] up = new int[m][n];
		for(int i = 0; i < m; i++){			
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 1) {
					if(i == 0 && j == 0) {
						left[i][j] = 1;
					}else if(i == 0) {
						up[i][j] = 1;
						left[i][j] = left[i][j - 1] + 1;
					}else if(j == 0) {
						left[i][j] = 1;
						up[i][j] = up[i - 1][j] + 1;
					}else {
						left[i][j] = left[i][j - 1] + 1;
						up[i][j] = up[i - 1][j] + 1;
					}
				}else {
					left[i][j] = 0;
					up[i][j] = 0;
				}
			}
		}
		// merge left and up, store the result in left, return the merged matrix
		merge(left, up, m, n);
		return left;		
	}
	
	// calculate the max possible length of right and down arms for each of the cells in the matrix
	private int[][] rightDown(int[][] matrix, int m, int n) {
		// TODO Auto-generated method stub
		int[][] right = new int[m][n];
		int[][] down = new int[m][n];
		for(int i = m - 1; i >= 0; i--){			
			for(int j = n - 1; j >= 0; j--){
				if(matrix[i][j] == 1) {
					if(i == m - 1 && j == n - 1) {
						right[i][j] = 1;
						down[i][j] = 1;
					}else if(i == m - 1) {
						right[i][j] = right[i][j + 1] + 1;
						down[i][j] = 1;
					}else if(j == n - 1) {
						right[i][j] = 1;
						down[i][j] = down[i + 1][j] + 1;
					}else {
						right[i][j] = right[i][j + 1] + 1;
						down[i][j] = down[i + 1][j] + 1;
					}
				}
			}
		}
		// merge right and down, store the result in right, return the merged matrix
		merge(right, down, m, n);
		return right;
	}

	//merge two matrix, use leftUp record the merged matrix, 
	//the value of each cell is the min value of the corresponding cells  in the two matrix
	//also return the max value among all the cells as res record the largest arms 
	private int merge(int[][] leftUp, int[][] rightDown, int m, int n) {
	// TODO Auto-generated method stub
		int res = 0;
		for(int i = 0; i < m; i++){			
			for(int j = 0; j < n; j++){
				leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
				res =  Math.max(leftUp[i][j], res);
			}
		}
		return res;
	}
	
	public int[][] dp1(int[][] matrix, int m, int n){
		int[][] M1 = new int[m][n];
		
		for(int i = 0; i < m; i++){
			int cur = 0;
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 0){
					M1[i][j] = 0;
				}else{
					M1[i][j] = ++cur;
				}
			}
		}
		return M1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCrossOf1sHard longest = new LongestCrossOf1sHard();
		int[][] matrix = {  {0, 0, 0, 0},
				  			{1, 1, 1, 1},
				  			{0, 1, 1, 1},
				  			{1, 0, 1, 1} };
//		System.out.println(Arrays.deepToString(longest.leftUp(matrix, 4, 4)));
//		System.out.println(Arrays.deepToString(longest.rightDown(matrix, 4, 4)));
		System.out.println(longest.largest(matrix));
	}

}
