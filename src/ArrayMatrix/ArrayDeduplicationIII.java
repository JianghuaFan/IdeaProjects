package ArrayMatrix;

import java.util.Arrays;
/*
 * Given a sorted integer array, remove duplicate elements. 
 * For each group of elements with the same value do not keep any of them. 
 * Do this in-place, using the left side of the original array and and maintain the relative order of the elements of the array. 
 * Return the array after deduplication.

Assumptions

The given array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1}
 */
public class ArrayDeduplicationIII {
	public int[] dedup(int[] array) {
		   // Write your solution here
	 	if(array == null || array.length <= 0){
			return array;
		}
	 	//Method 2： 快慢指针加 flag
//	 	use flag to see if there is any duplication of array
	 	boolean flag = false;
	 	int end = 0;
	 	for(int i = 1; i < array.length; i++) {
	 		if(array[i] == array[end]) {
	 			flag = true;
	 		}else if(flag == true) {
//	 			if array[i] != array[end], and flag is set, means array[end] should not be included
//	 			we can just replace it with array[i]
	 			array[end] = array[i]; 
//	 			reset flag to false since we are processing next element
	 			flag = false;
	 		}else {
//	 			if array[i] != array[end], and flag is not set, means array[end] should be included
	 			array[++end] = array[i];
	 		}
	 	}
	 	//do not forget to check if there is any duplication for the last element 
	 	return Arrays.copyOf(array, flag == true ? end :end + 1);
	 }
	
	public int[] dedupII(int[] array) {
		   // Write your solution here
	 	if(array == null || array.length <= 0){
			return array;
		}
	 	int slow = 0;
	 	int fast = 0;
	 	int fast2 = 0;
	 	while(fast < array.length) {
	 		// after the below while loop, fast2 points to the first character after fast 
	 		//that doesn't equal array[fast]
	 		while(fast2 < array.length && array[fast2] == array[fast]) {
	 			fast2++;
	 		}
	 		//fast2 可能刚好出界，不影响这句话的判断
	 		if(fast2 - fast == 1) {
				array[slow++] = array[fast++];
			}else {
				fast = fast2;
			}		 		
	 	}
	 	return Arrays.copyOf(array, slow);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array = {};
//		int[] array = {0};
//		int[] array = {0,0};
//		int[] array = {0,0,0,1,1,2,2,2};
//		int[] array = {1,2,2,3,3,3};
		int[] array = {1,1,2,2,3,3,3,2,1,4};
		ArrayDeduplicationIII dedup = new ArrayDeduplicationIII();
		System.out.println(Arrays.toString(dedup.dedup(array)));
	}

}
