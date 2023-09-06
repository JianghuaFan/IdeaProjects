package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOderTraverseINN {
	 public List<Integer> spiral(int[][] matrix) {
		   // Write your solution here
		List<Integer> res = new ArrayList<>();
		if(matrix == null || matrix.length == 0){
			return res;
		} 
		// 每次偏移量为offset， 递增1
		int offset = 0;
		helper(matrix, res, matrix.length, offset);		
			
		return res;
	}
	public void helper(int[][] matrix, List<Integer> res, int size, int offset){
		//base case: when there is only 0 or 1 element left
		if(size <= 1){
			if(size == 1){
				res.add(matrix[offset][offset]);	
			}
			return;
		}
		for(int i = 0; i < size - 1; i++){
		// upper row
			res.add(matrix[offset][offset + i]);
		}
		for(int i = 0; i < size - 1; i++){
		// right col
			res.add(matrix[offset + i][size - 1 + offset]);
		}
		for(int i = size - 1; i > 0; i--){
		// bottom row
			res.add(matrix[size - 1 + offset][i + offset]);
		} 
		for(int i = size - 1; i > 0; i--){
		// left col
			res.add(matrix[i + offset][offset]);
		}  
		helper(matrix, res, size - 2, offset + 1);
	}
// Method 2: Interative traversal
	public List<Integer> spiralII(int[][] matrix){
		List<Integer> list = new ArrayList<>();
		int size = matrix.length;
		int start = 0;
		int end = size - 1;
		while(start < end) {
			//upper row
			for(int i = start; i <= end; i++) {
				list.add(matrix[start][i]);
			}
			//right bol
			for(int i = start + 1; i  <= end - 1; i++) {
				list.add(matrix[i][end]);
			}
			// bottom row
			for(int i = end; i >= start; i--) {
				list.add(matrix[end][i]);
			}
			// left col
			for(int i = end - 1; i >= start + 1; i--) {
				list.add(matrix[i][start]);
			}
			start++;
			end--;
		}
		//if at last there is one element left, we need to traverse it as well
		if(start == end) {
			list.add(matrix[start][end]);
		}
		return list;
	}
	
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralOderTraverseINN spiral = new SpiralOderTraverseINN();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		System.out.println(spiral.spiral(matrix));
		System.out.println(spiral.spiralII(matrix));
	}

}
