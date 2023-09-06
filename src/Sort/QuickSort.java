package Sort;

import java.util.Arrays;

public class QuickSort {
	public static void  quickSort(int[] arr, int left, int right){
		//System.out.println("d");
		if(left >= right) return;
		int pivot = partition(arr,left,right);
		quickSort(arr, left,pivot-1);
		quickSort(arr, pivot+1,right);
	}
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left;
		int j = right-1;
		while(true) {
			while(i < right && arr[i] <= pivot) {
				i++;
			}
			while(j >= left && arr[j] > pivot) {
				j--;
			}

			if(i>j) break;
			swap(arr,i,j);
			}
		swap(arr,i,right);
		return i;
		
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = new int[] {3,5,2,6,5,6,8};
//		int[] arr1 = new int[] {5,2,6,5,6,8};
		int[] arr = new int[] {1,2,6,5,3,4};

//		
		QuickSort.quickSort(arr, 0, arr.length-1);
		quickSort(arr,0,arr.length-1);
		//System.out.println(arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
