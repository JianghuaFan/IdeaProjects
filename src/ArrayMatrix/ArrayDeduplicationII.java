package ArrayMatrix;

import java.util.Arrays;
/*
 * 116. Array Deduplication II
Medium
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep at most two of them. Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}
 */


public class ArrayDeduplicationII {
	public int[] dedup(int[] array) {
		if(array == null || array.length <= 2){
			return array;
		}  
		int slow = 1;
		for(int fast = 2; fast < array.length; fast++){
			if(array[fast] != array[slow] || array[fast] != array[slow-1]){
			array[++slow] = array[fast];
		}
		}
		return Arrays.copyOf(array, slow + 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array = {};
//		int[] array = {0};
//		int[] array = {0,0};
		int[] array = {0,0,0,1,1,2,2,2};
//		int[] array = {1,2,2,3,3,3};
		ArrayDeduplicationII dedup = new ArrayDeduplicationII();
		System.out.println(Arrays.toString(dedup.dedup(array)));
	}

}
