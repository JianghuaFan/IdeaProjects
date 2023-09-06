package BinarySearch;

import java.util.Arrays;

public class SearchInSortedMatrix {
	public static int[] search(int[][] matrix, int target) {
	    // Write your solution here
		int[] res = new int[]{-1,-1};
	    if( matrix == null || matrix.length == 0){
	      return res;
	    }
	    int m = matrix.length;
	    int n = matrix[0].length;
	    int left = 0;
	    int right = m * n-1;
	    while(left <= right) {
	      int mid = left + (right - left) / 2;
	      int row = mid / n;
	      int col = mid % n;
	      if(matrix[row][col] == target) {
	        return new int[]{row, col};
	      }else if(matrix[row][col] < target) {
	        left = mid + 1;
	      }else {
	        right = mid - 1;
	      }
	    }
	    return res;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,5,7},{8,9,10}}; 
		System.out.println(Arrays.toString(search(matrix,7)));
	}

}
