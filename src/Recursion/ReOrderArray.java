package Recursion;

import java.util.Arrays;

public class ReOrderArray {
	public int[] reorder(int[] array) {
		   // Write your solution here
		if(array == null || array.length == 0){
			return array;
		}
		if(array.length %2 == 0) {
			reorder(array, 0, array.length - 1);
		}else {
			// if array has odd number of elements, we ignore the last one
			reorder(array, 0, array.length - 2);
		}		
		return array;
	}
	
	public void reorder(int[] array, int left, int right){
		int size = right - left + 1;
		// if the subarray has 2 or less elements, we can just return as this should be the base case
		if(size <= 2){
			return;
		}		
		// calculate the important mid points:
		//0  1  2  3  4  5  6  7
		//lm: 2, m: 4, rm: 6
		//0  1  2  3  4  5  6  7  8  9
		//lm: 2, m: 5, rm: 7
		int mid = left + size/2;
		int leftMid = left + size/4;
		int rightMid = left + size* 3/4;
		reverse(array, leftMid, mid -1);// chunk 2
		reverse(array, mid, rightMid - 1);// chunk 3
		reverse(array, leftMid, rightMid -1);// chunk2+ chunk3
		reorder(array, left, left + 2 * (leftMid-left) - 1);
		reorder(array, left + 2 * (leftMid-left), right);
	}
	public void reverse(int[] array, int left, int right){		
		while(left < right){
			swap(array,left,right);
			left++;
			right--;
		}
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReOrderArray reOrder = new ReOrderArray();
		int[] array = {1,2,3,4,5,6};
		System.out.print(Arrays.toString(reOrder.reorder(array)));
	}

}
