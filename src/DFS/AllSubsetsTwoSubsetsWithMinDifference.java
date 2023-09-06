package DFS;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
/*
 * 263. Two Subsets With Min Difference
Medium
Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.

Return the minimum difference(absolute value).

Assumptions:

The given integer array is not null and it has length of >= 2.
Examples:

{1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
 */
public class AllSubsetsTwoSubsetsWithMinDifference {
	public int minDifference(int[] array) {
	    // Write your solution here
		int sum = getSum(array);
		int[] global = new int[] {Integer.MAX_VALUE};
		int halfSize = array.length / 2;
		DFS(array, 0, global, sum, halfSize);
		return global[0];
	}
	
	public void DFS(int[] array,  int index, int[] global, int sum, int halfSize) {
		// base case: 
		if (index == halfSize) {
			//每当DFS到halfSize的时候，计算以下一半元素和另一半元素的差值，记录最小值
			int sumA = getSum(Arrays.copyOf(array, halfSize));
			global[0] = Math.min(global[0], Math.abs(sum - 2 * sumA));
//			System.out.println("sumA: " + sumA);
			return;
		}
		for (int i = index; i < array.length; i++) {
			swap(array, index, i);
			DFS(array, index + 1, global, sum, halfSize);
			swap(array, index, i);
		}
	}
	public void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
/*
Recursion Tree of Set {1,2,3}
		 SubSet A { 	 }			       Subset B {	 }
		   / 加到A           \ 加到B			      	/加到A	 	  \加到B
1	        [ 1 ]		     [ 0 ]			        [0]		       [1]
		 /         \	     /     \			   /	 \       /       \
2	   [3]        [1]	  [2]      [ 0 ]	    [ 0 ]     [2]	 [1]    [ 3 ]
       /   \     /  \	 /   \    /     \	   /    \     /  \	 /   \  /      \
3	  [6]  [3]  [4] [1]	[5]  [2] [3]   [0]	  [0]   [3] [2] [5]	 [1] [4] [3]   [6]

 */
	// 第二种 DFS
	public int minDifferenceII(int[] array){
		// highlevel: DFS to calculate two subSets, compare the diff, update the global diff
		int[] diff = new int[]{Integer.MAX_VALUE};
		int sumA = 0;
		int sumB = 0;
		DFSII(array, sumA, sumB, 0, diff, 0);
		return diff[0];
	}

	private void DFSII(int[] array, int sumA, int sumB, int index, int[] diff, int countA){
		// highlevel: traverse every element in the array, either put it in subSetA or subSetB
		// base case:
		if(index == array.length){
			if(countA == array.length / 2){
				diff[0] = Math.min(diff[0], Math.abs(sumA - sumB));
			}

			return;
		}
		// prune:如果A的size已经超过了n/2 + 1,剪枝
		if(countA > array.length / 2 + 1){
				return;
		}
		// recursive rule
		// case 1: add array[i] to subSetA, countA 是subSetA的size
		DFSII(array, sumA + array[index], sumB, index+1, diff, countA + 1);
		// case 2: add array[i] to subSetB
		DFSII(array, sumA,sumB + array[index], index + 1, diff, countA);
	}
	// 以下解法的问题在于两个set长度不定，例如array有4个数字，两个set setA和setB可能包含任意多个元素，
	public int minDifferenceIII(int[] array) {
//		if(array == null || array.length == 0){
//			return -1;
//		}
		int sum = getSum(array);
		Set<Integer> set = new HashSet<>();
		int[] global = new int[] {Integer.MAX_VALUE};
		DFSIII(array, set, 0, global, sum);
		return global[0];
	}
	
	public void DFSIII(int[] array, Set<Integer> set, int index, int[] global, int sum) {
		// base case: 
		if(index == array.length) {
			return;
		}
		// deal with the min difference of two sums of lists
		
		
		// case1 : not add the current number at index
		DFSIII(array, set, index + 1, global, sum);
		
		// case2: add the current number at index
		if(set.add(array[index])) {
			int sumA = getSum(set);
			int sumB = sum - sumA;
			int diff = Math.abs(sumA - sumB);
			global[0] = Math.min(diff, global[0]);
		}
		DFSIII(array, set, index + 1, global, sum);
		set.remove(set.size() - 1);
	}
	public int getSum(int[] array) {
		int sum = 0;
		for(int i : array){
			sum += i;
		}
		return sum;
	}
	public int getSum(Set<Integer> set) {
		int sum = 0;
		for(int i : set){
			sum += i;
		}
		return sum;
	}
//	Input: new int[]{5,-2,-10,3}
//	expected:<6> but was:<4>
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllSubsetsTwoSubsetsWithMinDifference minDiff = new AllSubsetsTwoSubsetsWithMinDifference();
//		int[] array = {5,-2,-10,3};
		int[] array = {1,1};
//		int[] array = {-2,-9,-3,-1,-1};
//		System.out.print("minDiff:  " + minDiff.minDifference(array));
		System.out.print("minDiff:  " + minDiff.minDifferenceII(array));
	}

}
