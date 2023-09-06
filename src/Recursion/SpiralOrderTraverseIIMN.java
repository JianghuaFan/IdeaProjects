package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseIIMN {
	public List<Integer> spiral(int[][] matrix) {
		   // Write your solution here
		List<Integer> list = new ArrayList<>();
		int m = matrix.length;
		// need to handle this case since if m == 0, matrix[0].length //will throw ArrayIndexOutOfBoundException
		if( m == 0){
			return list;
		}
		int n = matrix[0].length;
		int left = 0;
		int right = n - 1;
		int up = 0;
		int down = m - 1;
		// case1: there is nothing left
		// case2: there is one row left
		// case3: there is one col left
		while(left < right && up < down){
			// upper row
			for(int i = left; i <= right; i++){
				list.add(matrix[up][i]);
			}
			// right col
			for(int i = up + 1; i <= down - 1; i++){
				list.add(matrix[i][right]);
			}
			// bottom row
			for(int i = right; i >= left; i--){
				list.add(matrix[down][i]);
			}
			// left col
			for(int i = down - 1; i >= up + 1; i--){
				list.add(matrix[i][left]);
			}
			left++;
			up++;
			right--;
			down--;
		}
		if(left > right || up > down) {
			return list;
		}
		// there is one row left
		if(up == down){
			for(int i = left; i <= right; i++){
				list.add(matrix[up][i]);
			}
		}
		// there is one col left
		else{
			for(int i = up; i <= down; i++){
				list.add(matrix[i][left]);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralOrderTraverseIIMN spiral = new SpiralOrderTraverseIIMN();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//		int[][] matrix = {{1}};
		System.out.println(spiral.spiral(matrix));
	}

}
