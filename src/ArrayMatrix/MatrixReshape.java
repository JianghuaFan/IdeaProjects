package ArrayMatrix;

import java.util.Arrays;

public class MatrixReshape {
	public static int[][]matrixReshape(int[][]nums, int r, int c){
		int[][] reshapedNums = new int[r][c];
		int m = nums.length, n = nums[0].length;
		if(m * n != r * c) {
			return nums;
		}
		int index = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				reshapedNums[i][j] = nums[index/n][index%n];
				index++;
			}
		}
		return reshapedNums ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {{1,2},{3,4}};
		int[][] reshapedNums = matrixReshape(nums,4,1);
		for( int i = 0; i < reshapedNums.length; i++) {
			System.out.println(Arrays.toString(reshapedNums[i]));
		}
	}

}
