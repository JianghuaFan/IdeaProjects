package ArrayMatrix;

import java.util.Arrays;
/*
 * Given an unsorted integer array, remove adjacent duplicate elements repeatedly, 
 * from left to right. For each group of elements with the same value do not keep any of them.
Do this in-place, using the left side of the original array. 
Return the array after deduplication.

Assumptions:
The given array is not null
Examples

{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}
 */
public class ArrayDeduplicationIV {
	public int[] dedup(int[] array) {
		   // Write your solution here
	 	if(array == null || array.length <= 0){
			return array;
		}
	 	//Method 1： 快慢指针
	 	int slow = 0;
	 	int fast = 1;
	    while(fast < array.length) {
	    	// 当打头几个都重复的情况下去重复后slow= slow-1， 变成了-1，需要找fast重新开始，赋给slow
	 		if(slow < 0) {
	 			array[++slow] = array[fast++];
	 		}
	 		else if(array[fast] == array[slow]) {
	 			while(fast < array.length  && array[fast] == array[slow]) {
	 				fast++;
	 			}
	 			slow--;
	 		}else {
	 			array[++slow] = array[fast++];
	 		}
	 	}	 	
	 	return  Arrays.copyOf(array, slow + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayDeduplicationIV arrayDeduplicationIV = new ArrayDeduplicationIV();
		int[] array = {1,1,1,2,3,3,2,4,2};
		System.out.print(Arrays.toString(arrayDeduplicationIV.dedup(array)));
		
	}

}
