package DP;
/*
 * 98. Largest SubArray Product
Hard
Given an unsorted array of doubles, find the subarray that has the greatest product. Return the product.

Assumptions

The given array is not null and has length of at least 1.
Examples

{2.0, -0.1, 4, -2, -1.5}, the largest subarray product is 4 * (-2) * (-1.5) = 12
 */
public class LargestProductOfSubarray {
	public static double largest(double[] array) {
		if(array == null || array.length == 0) {
			return Integer.MIN_VALUE;
		}
		double global = array[0];
		double[] minDP = new double[array.length];
		double[] maxDP = new double[array.length];
		minDP[0] = array[0];
		maxDP[0] = array[0];
		for(int i = 1; i < array.length; i++) {
			maxDP[i] = Math.max(array[i], Math.max(maxDP[i-1] * array[i], minDP[i - 1] * array[i]));
			minDP[i] = Math.min(array[i], Math.min(maxDP[i-1] * array[i], minDP[i - 1] * array[i]));			
			global = Math.max(global, maxDP[i]);
		}
		return global;
	}

	// input:   [2,	3,	-2,	4, -5]
	// index     0	1	2	3	4
	// minDp:    2  3	-12	-48	-20
	// maxDp:    1*2 2*3 -2	 4	240
	public static double large(double[] array){
		//
		if(array == null || array.length == 0) {
			return Integer.MIN_VALUE;
		}
		// 物理意义： minDp[i] represents the smallest product of subArray ending at index i
		// 			maxDp[i] represents the largest product of subArray ending at index i
		// induction rule: minDp[i] = Math.min(
		// base case: minDp[0] = 1, maxDp[0] = 1
		double globalMax = array[0];
		double[] minDp = new double[array.length];
		double[] maxDp= new double[array.length];
		minDp[0] = Math.min(1, array[0]);
		maxDp[0] = Math.max(1, array[0]);
		for(int i = 1; i < array.length; i++){
			minDp[i] = Math.min(Math.min(minDp[i-1]* array[i], maxDp[i-1]* array[i]), array[i]);
			maxDp[i] = Math.max(Math.max(maxDp[i-1]* array[i], minDp[i-1]* array[i]), array[i]);
			globalMax = Math.max(maxDp[i], globalMax);
		}
		return globalMax;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		double[] array = {2,-1,4,-3, -4, -2};
		double[] array = {4,-2,-3,-2,3,-1,-2,6};
		double[] array1 = {2,	3,	-2,	4, -5};
		System.out.println(largest(array1));
		System.out.println(large(array1));
	}

}
