package ArrayMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeroes {
	public static int[] moveZeroes(int[] array) {
		// two pointers:
	
//		int index = 0;	
//		for(int i : array) {
//			if (i != 0) {
//				array[index++] = i;
//			}
//		}
//			while(index <= array.length - 1) {
//				array[index++] = 0;
//			}
//		
//		return array;
//		}			
		if(array == null || array.length == 1) {
			return array;
		}
		int i = 0;
		for(int j = 0; j < array.length; j++) {
			if(array[j] != 0) {
				array[i++] = array[j];
			}
		}
		while(i < array.length) {
			array[i++] = 0;
		}
		return array;
	}

		public static List<Integer> moveZeroes(List<Integer> nums) {
			List<Integer> res = new ArrayList<>();
			Integer[] array = new Integer[nums.size()];
			for(int i = 0; i < nums.size(); i++){
				array[i] = nums.get(i);
			}

			int index = 0;
			for(int j = 0; j < array.length; j++) {
				if(array[j] != 0) {
					array[index++] = array[j];
				}
			}
			while(index < array.length) {
				array[index++] = 0;
			}
			for(int i = 0; i < array.length; i++){
				res.add(array[i]);
			}
			return res;
		}

// we use leftBound and rightBound to separate all the elements into three parts, all the numbers to leftBound(not including leftBound) are non-zeros, all the numbers between leftBound and rightBound are unchecked numbers, and all the numbers right after rightBound(not including rightBound) are zeros.
//		if (array == null || array.length == 1)
//			return array;
//		int leftBound = 0;
//		int rightBound = array.length - 1;
//		while (leftBound <= rightBound) {
//			if(array[leftBound] != 0)
//				leftBound++;
//			else if (array[rightBound] == 0)
//				rightBound--;
//			else swap(array, leftBound++, rightBound--);
//		 }
//		return array;
//		 
//		}
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
		


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,3,12};
		List<Integer> list = new ArrayList<>(Arrays.asList(1,0,3,12));
		moveZeroes(nums);
		list = moveZeroes(list);
//		System.out.println("nums:" + nums);
//		System.out.println("nums:" + Arrays.toString(nums));
//		System.out.println("list:" + list);



	}
}
