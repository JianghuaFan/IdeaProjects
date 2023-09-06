package ArrayMatrix;

import java.util.Arrays;

public class IsToeplitzMatrix {
	public static boolean isToeplitzMatrix(int[][] matrix) {		
	        int m = matrix.length, n = matrix[0].length;
	        for(int r = 0; r < m-1; r++) {
	        	for(int c = 0; c < n-1; c++) {
	        		if(matrix[r][c] != matrix[r+1][c+1])
	        			return false;
	        	}
	        }	        	
	        return true;	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		System.out.print(isToeplitzMatrix(matrix));

	}

}
