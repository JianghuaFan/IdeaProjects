package CrossTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 119. Largest And Smallest
Medium
Use the least number of comparisons to get the largest and smallest number in the given integer array. Return the largest number and the smallest number.

Assumptions

The given array is not null and has length of at least 1
Examples

{2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].
 */
public class LargestAndSmallest {
	public int[] largestAndSmallest(int[] array) {
	    // Write your solution here
		int n = array.length;
		for(int i = 0; i < n/2; i++) {//compare by pairs, larger elements in left half of the array,
			// smaller elements in right half
			if(array[i] < array[n-1 - i]) {
				swap(array, i, n-1-i);
			}
		}
		return new int[] {largest(array, 0, n / 2 - 1), smallest(array, n / 2, n-1)};				
		}

	private int smallest(int[] array, int left, int right) {
		// TODO Auto-generated method stub
		int smallest = array[left];
		for(int i = left + 1; i < array.length; i++) {
			smallest = Math.min(smallest, array[i]);
		}
		return smallest;
	}

	private int largest(int[] array, int left, int right) {
		// TODO Auto-generated method stub
		int largest = array[left];
		for(int i = left + 1; i < array.length; i++) {
			largest = Math.max(largest, array[i]);
		}
		return largest;
	}

	private void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestAndSmallest largestAndSmallest = new LargestAndSmallest();
		int[] array = {2, 1, 5, 4};
		System.out.print(Arrays.toString(largestAndSmallest.largestAndSmallest(array)));
//		largestAndSmallest(array);
		
		
		
	}

}
