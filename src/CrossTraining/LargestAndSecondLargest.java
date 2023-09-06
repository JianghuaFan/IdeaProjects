package CrossTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 120. Largest And Second Largest
Medium
Use the least number of comparisons to get the largest and 2nd largest number in the given integer array. Return the largest number and 2nd largest number.

Assumptions

The given array is not null and has length of at least 2
Examples

{2, 1, 5, 4, 3}, the largest number is 5 and 2nd largest number is 4.
 */
public class LargestAndSecondLargest {
	public class Element{
		int value; 
		List<Integer> comparedList = new ArrayList<>();
		public Element(int value) {
			this.value = value;
			this.comparedList = new ArrayList<>();
		}
	}
	
	public int[] largestAndSecond(int[] array) {
	    // Write your solution here
		// step 1: store the array into the Element array
		Element[] helper = convertArray(array);
	
		// step2: compare and swap for the whole array, decrease the size until we got only one largest element 
//		int the helper array
		int largerLength = array.length;
		while(largerLength > 1) {
			compareAndSwap(helper, largerLength);
			largerLength = (largerLength + 1) / 2;
		}
		// step3: return the first element of the helper and the largest value of its comparedList
		return new int[] {helper[0].value, largest(helper[0].comparedList)};
	}
	// compare each of the indices pairs( i, length - i - 1), swap the larger value on the left side if necessary
	// and put the smaller value into the larger value's compare values list
	public void compareAndSwap(Element[] helper, int length) {
		for(int i = 0; i < length / 2; i++) {
			if(helper[i].value < helper[length - i - 1].value) {
				swap(helper, i, length - i - 1);
			}
			helper[i].comparedList.add(helper[length - i - 1].value);
		}
	}
	public static void swap(Element[] helper, int i, int j) {
		Element temp = helper[i];
		helper[i] = helper[j];
		helper[j] = temp;
	}
	public int largest(List<Integer> list) {
		int max = list.get(0);
		for(int i : list) {
			max = Math.max(max, i);
		}
		return max;
		
	}
	public Element[] convertArray(int[] array) {
		Element[] helper = new Element[array.length];
		for(int i= 0 ; i < array.length; i++) {
			helper[i] = new Element(array[i]);
		}
		return helper;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestAndSecondLargest largestAndSecondLargest = new LargestAndSecondLargest();
		int[] array = {2, 1, 5, 4};
		System.out.print(Arrays.toString(largestAndSecondLargest.largestAndSecond(array)));
	}

}
