package DP;

public class LargestSquareOfMatches {
	public int largestSquareOfMatches(int[][] matrix) {
	    // Write your solution here
	    if(matrix.length == 0 || matrix[0].length == 0){
	      return 0;
	    }
	    int res = 0;
	    int M = matrix.length;
	    int N = matrix[0].length;
	    // the longest right/down arm length ending at each position in the matrix
	    int[][] right = new int[M+1][N+1];
	    int[][] down = new int[M+1][N+1];
	    for(int i = M -1; i >= 0; i--) {
	    	for(int j = N-1; j >= 0; j--) {	    		
	    		if(hasRight(matrix[i][j])) {
	    			right[i][j] = right[i][j+1] +1;
	    		}
	    		if(hasDown(matrix[i][j])) {
	    			down[i][j] = down[i+1][j] +1;
	    		}
	    		if(hasBoth(matrix[i][j])) {
	    			for(int maxLength = Math.min(right[i][j], down[i][j]); maxLength >= 1; maxLength--) {	    				
	    				if(right[i+ maxLength][j] >= maxLength && down[i][j + maxLength] >= maxLength) {
	    					res = Math.max(res, maxLength);
	    					break;
	    				}
	    			}
	    		}
	    	}
	    }
	    return res;
	  }

	private boolean hasBoth(int i) {
		return i == 0b11;
	}

	private boolean hasDown(int i) {
		return ((i & 0b10) != 0);
	}

	private boolean hasRight(int i) {
		return ((i & 0b1) != 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{3, 1, 1, 3, 0, 1, 1, 0},

				 {2, 0, 0, 2, 0, 0, 0, 0},

				 {3, 1, 3, 0, 0, 0, 0, 0},

				 {2, 0, 2, 0, 0, 0, 0, 0},

				 {1, 1, 0, 0, 0, 0, 0, 0}};


		LargestSquareOfMatches largest = new LargestSquareOfMatches();
		System.out.print(largest.largestSquareOfMatches(matrix));
//		System.out.print(largest.hasRight(1));
	}

}
