package Sort;

import java.util.Arrays;

public class MergeSortWithouHelper {
	public static int[] mergeSort(int[] arr) {
		if (arr == null || arr.length == 0)
			return arr;
		mergeSort(arr, 0, arr.length - 1);
		return arr;
	}
	private static void mergeSort(int[] arr, int left, int right) {
		if (left >= right)
			return;
		int mid = left + (right - left) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);	
		mergeSort(arr, left, mid, right);
	}
	

	private static void mergeSort(int[] arr, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int[] res = new int[right - left + 1];
		int leftIndex = left;
		int rightIndex = mid + 1;
		int index = 0;
		while (leftIndex <= mid && rightIndex <= right) {
			if (arr[leftIndex] <= arr[rightIndex]) {
				res[index++] = arr[leftIndex++];
			}
			else
				res[index++] = arr[rightIndex++];
		}
		while (leftIndex <= mid) {
			res[index++] = arr[leftIndex++];
		}
		while (rightIndex <= right) {
			res[index++] = arr[rightIndex++];
		}
		System.arraycopy(res, 0, arr, left, right - left + 1);
		System.out.println(Arrays.toString(res));
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {40,20,60,10,50,30};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
