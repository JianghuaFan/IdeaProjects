package ArrayMatrix;

import java.util.Arrays;
/*Given an integer array(not guaranteed to be sorted), remove adjacent repeated elements. 
 * For each group of elements with the same value keep at most two of them. Do this in-place,
 *  using the left side of the original array and maintain the relative order of the elements of the array. 
 *  Return the final array.

Assumptions: The given array is not null
Examples

{1, 2, 2, 3, 3, 3} --> {1, 2, 2, 3, 3}

{2, 1, 2, 2, 2, 3} --> {2, 1, 2, 2, 3} 
 */
public class ArrayDeduplicationV {
	public int[] dedup(int[] array) {
		   // Write your solution here
	 	if(array == null || array.length <= 0){
			return array;
		}
	 	int slow = 2;
	 	int fast = 2;
	 	
	 	for(; fast < array.length; fast++) {
	 		if(array[fast] != array[slow - 2]) {
	 			array[slow++] = array[fast];
	 		}else {
	 			//虽然和两个位置前面相同，但是中间夹了个不同的，所以也要保留。因为是unsorted，会出现已经消过重复的又来了
	 			if(array[fast] != array[slow - 1]) {
	 				array[slow++] = array[fast];
	 			}else {
	 				continue;
	 			}
	 		}
	 	}
	 	return Arrays.copyOf(array, slow);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayDeduplicationV arrayDeduplicationVI = new ArrayDeduplicationV();
		int[] array = {1,2,2,3,2,2,2,3,3,3,3};
		System.out.print(Arrays.toString(arrayDeduplicationVI.dedup(array)));
	}

}
