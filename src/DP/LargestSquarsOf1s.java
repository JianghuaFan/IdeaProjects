package DP;

public class LargestSquarsOf1s {
	public int largest(int[][] matrix) {
		   // Write your solution here
		//Assumptions: the matrix is a binary matrix(only contains 0 and 1 as the values)
//		it is not null, and has size N*N , N >= 0;
	  	int n = matrix.length;
	  	if(n == 0) {
	  		return 0;
	  	}
	  	//M[i][j] represent the max square with(i,j) as the bottom right corner

		int[][] M = new int[n][n];
		int global_max = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(i == 0){
					M[i][j] = matrix[0][j];
				}else if(j == 0){
					M[i][j] = matrix[i][0];
				}else if(matrix[i][j] == 0){
						M[i][j] = 0;
				}else{
					M[i][j] = Math.min(Math.min(M[i-1][j-1],M[i-1][j]),M[i][j-1]) + 1;
					global_max = Math.max(global_max, M[i][j]);
				}
//				System.out.println("global_max:" + global_max);
			}
		}
//		for(int i = 0; i < n; i++){
//			for(int j = 0; j < n; j++){
//				System.out.print(M[i][j]);
//			}
//			System.out.println();
//		}
		return global_max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix =
				  { {0, 0, 0, 0},
				  {1, 1, 1, 1},
				  {0, 1, 1, 1},
				  {1, 0, 1, 1}};
		LargestSquarsOf1s largeSquare = new LargestSquarsOf1s();
		System.out.print(largeSquare.largest(matrix));

	}

}
