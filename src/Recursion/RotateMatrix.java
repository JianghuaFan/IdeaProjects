package Recursion;

import java.util.Arrays;

public class RotateMatrix {
	public void rotate(int[][] matrix) {
	   // Write your solution here
		int n = matrix.length;
		if( n <= 1){
			return;
		}
		int round = n / 2;
		for(int level = 0; level < round; level++){
			for(int i = level; i <= n - 2 - level; i++){
				
				int temp = matrix[level][i];
				matrix[level][i] = matrix[n - 1 - i][level];
				matrix[n - 1 - i][level] = matrix[n - 1 - level][n - 1 - i];
				matrix[n - 1 - level][n - 1 - i] = matrix[i][n - 1 - level];
				matrix[i][n - 1 - level] = temp;
			}	
		}	
	}
//	Method 2: rotate a point by 90 degree clockwise ==
	// 1. Mirror the point according to y axis, 
	// 2. Mirror the point according to the line of y = x.
	public void rotateMirror(int[][] matrix) {
		   // Write your solution here
			int n = matrix.length;
			if( n <= 1){
				return;
			}
			mirrorY(matrix, n);
			mirrorYEX(matrix, n);
		}
	public void mirrorY(int[][] matrix, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n/2; j++) {
				swap(matrix, i, j, i, n-1-j);
			}			
		}
	}
	
	public void mirrorYEX(int[][] matrix, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; i + j < n - 1; j++) {
				swap(matrix, i, j, n - 1 - j , n - 1 - i);
			}			
		}
	}
	
	private void swap(int[][] matrix, int iRow, int iCol, int jRow, int jCol) {
		// TODO Auto-generated method stub
		int temp = matrix[iRow][iCol];
		matrix[iRow][iCol] = matrix[jRow][jCol];
		matrix[jRow][jCol] = temp;		
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateMatrix rotate = new RotateMatrix();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotate.rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
		rotate.rotateMirror(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}

}
