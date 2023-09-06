package DP;

import java.util.Arrays;

public class LargestSquareSurroundedByOne {
	public int largestSquareSurroundedByOneII(int[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int res = 0;
		int n = matrix.length;
		int m = matrix[0].length;
		
		int[][] rightToLeft = rightToLeft(matrix, n, m);
		int[][] bottomToTop = bottomToTop( matrix, n, m);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int length = Math.min(rightToLeft[i][j], bottomToTop[i][j]); length >= 1; length--) {
					if(rightToLeft[i+length-1][j] >= length && bottomToTop[i][j+length - 1] >= length) {
						res = Math.max(res, length);
						break;
					}
				}
			}
		}	
		return res;
	}
	public int[][] rightToLeft(int[][] matrix, int n, int m){
		int[][] M = new int[n][m];
		// i is row number, j is col number
		for(int i = 0; i < n; i++) {
			for(int j = m - 1; j >= 0; j--) {
				if(matrix[i][j] == 1) {
					if(j == m - 1) {
						M[i][j] = 1;
					}else {
						M[i][j] = M[i][j+1] + 1;
					}
				}
			}
		}
		return M;		
	}
	public int[][] bottomToTop(int[][] matrix, int n, int m){
		int[][] M = new int[n][m];
		// i is col number, j is row number
		for(int i = 0; i < m; i++) {
			for(int j = n - 1; j >=0; j--) {
				if(matrix[j][i] == 1) {
					if(j == n - 1) {
						M[j][i] = 1;
					}else {
						M[j][i] = M[j+1][i] + 1;
					}
				}
			}
		}
		return M;		
	}
	
	public int largestSquareSurroundedByOne(int[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int res = 0;
		int n = matrix.length;
		int m = matrix[0].length;
		// the longest left arm length ending at each position in the matrix, 
		// here we apply a trick for ease of later processing:
		// left[i + 1][j + 1] is actually mapped to matrix[i][j];
		// that will reduced the corner cases
		int[][] left = new int[n+1][m+1];
		int[][] up = new int[n+1][m+1];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(matrix[j][i] == 1) {
					left[i + 1][j + 1] = left[i + 1][j] +1;	
					up[i + 1][j + 1] = up[i][j + 1] +1;
				}
				//the maximum length of a surrounded by 1 matrix with rightbottom position at
				//matrix[i][j] is determined by the min value of left[i+1][j+1] and up[i+1][j+1]
				//we check one by one all the possible lengths, we only need to check longest left arm length
				// of righttop cell and longest up arm length of leftbottom cell
				for(int length = Math.min(left[i+1][j+1], up[i+1][j+1]); length >= 1; length--) {
					if(left[i+1 - length + 1][j+1] >= length && up[i+1][j+1 -length + 1] >= length) {
						res = Math.max(res, length);
						break;
					}
				}
			}
		}	
		return res;
	}
	public int[][] left(int[][] matrix, int n, int m){
		int[][] left = new int[n+1][m+1];		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(matrix[j][i] == 1) {
					left[i + 1][j + 1] = left[i + 1][j] +1;					
				}
			}			
		}
		return left;
	}
	public int[][] up(int[][] matrix, int n, int m){		
		int[][] up = new int[n+1][m+1];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(matrix[j][i] == 1) {					
					up[i + 1][j + 1] = up[i][j + 1] +1;
				}
			}			
		}
		return up;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestSquareSurroundedByOne largest = new LargestSquareSurroundedByOne();
		int[][] matrix ={{1, 0, 1, 1, 1},
				 {1, 1, 1, 1, 1},
				 {1, 1, 0, 1, 0},
				 {1, 1, 1, 1, 1},
				 {1, 1, 1, 0, 0}};
		System.out.println(largest.largestSquareSurroundedByOne(matrix));
		System.out.println(largest.largestSquareSurroundedByOneII(matrix));
//		System.out.println(Arrays.deepToString(largest.rightToLeft(matrix, 5,5)));
//		System.out.println(Arrays.deepToString(largest.bottomToTop(matrix, 5,5)));
//		System.out.println(Arrays.deepToString(largest.left(matrix, 5,5)));
//		System.out.println(Arrays.deepToString(largest.up(matrix, 5,5)));
		
	}

}
