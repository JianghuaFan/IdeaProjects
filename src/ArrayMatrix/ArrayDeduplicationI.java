package ArrayMatrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
 * Given a sorted integer array, remove duplicate elements. 
 * For each group of elements with the same value keep only one of them. 
 * Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. Return the array after deduplication.

Assumptions

The array is not null
Examples

{1, 2, 2, 3, 3, 3} → {1, 2, 3}
 */
public class ArrayDeduplicationI {

	public int[] deduplicate(int[] array){
		int slow = 0;
		int fast = 1;
		while(fast < array.length){
			if(array[slow] == array[fast]){
				fast++;
			}else{
				array[++slow] = array[fast++];
			}
		}
		return Arrays.copyOf(array,slow+1);
	}
	 public int[] dedup(int[] array) {
		   // Write your solution here
//		 if(array == null || array.length == 0){
//		      return array;
//		    }
		Set<Integer> set = new HashSet<>();
		int slow = 0;
//		//Method 1: set
//		for(int fast = 0; fast < array.length; fast++){
//			if(set.add(array[fast])){
//				array[slow++] = array[fast];
//			}
//		} 
//		return Arrays.copyOf(array, slow);
		//Method 2: array in-place
		for(int fast = 1; fast < array.length; fast++) {
			if(array[fast] != array[slow]) {
				array[++slow] = array[fast];
			}
		}
//		System.out.println(Arrays.toString(Arrays.copyOf(array, slow+1)));
		return Arrays.copyOf(array, slow+1);
	}

	public int findDuplicate(int[] array){
		 for(int i = 0; i < array.length; i++){
			 int index = array[i] - 1;
			 if(array[index] < 0){
				 return Math.abs(array[index]);
			 }
			 array[index] = -array[index];
		 }
		 return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,2,2,1,3};
		int[] array1 = {1,2,2,3};
		ArrayDeduplicationI dedup = new ArrayDeduplicationI();
		System.out.println("array:" + Arrays.toString(dedup.deduplicate(array)));
		System.out.println(dedup.findDuplicate(array1));
	}

}
