package Sort;

import java.util.Arrays;

public class SelectSortDouble {
	public static void SelectionSortDouble(int[] arr) {
		int left = 0;
		int right = arr.length-1;
		while(left < right) {
			int min = left;
			int max = right;
			for(int j = left +1; j <= right; j++) {
			if(arr[j] < arr[min]) {
				min = j;
			}
			if(arr[j] > arr[max]) {
				max = j;
			}
			}
			swap(arr,right,max);
			if (min == right) {
				min = max;
			}
			swap(arr,left,min);
			left++;
			right--;
		}
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr [j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,5,2,6,5,6,8};
		SelectionSortDouble(arr);
		System.out.print(Arrays.toString(arr));

	}

}
