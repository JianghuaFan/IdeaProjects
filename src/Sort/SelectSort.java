package Sort;

import java.util.Arrays;

public class SelectSort {
	public static int[] SelectionSort(int[] array) {
//		if(arr == null || arr.length < 2) {
//			return;
//		}
//		for(int i = 0; i < arr.length-1; i++) {
//			int min = i;
//			for(int j = i+1; j<arr.length; j++) {
//				if(arr[j] < arr[min]) {
//					min = j;
//				}
//				swap(arr,i,min);
//			}
//		}
//	}
//	public static void swap(int[] arr, int i, int j) {
//		int temp = arr[i];
//		arr[i] = arr [j];
//		arr[j] = temp;
//	}
		if (array == null || array.length == 1)
		     return array;
		   for (int i = 0; i < array.length; i++) {
		     for (int j = i + 1; j < array.length; j++) {
				int min = array[i];
				if (array[j] < min) {
					min = array[j];
					swap (array, i, j);
				}		
		     }
		   }
			return array;

		}
		private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//static void selectSort(int[] arr) {}
		int[] arr = new int[] {3,5,2,6,5,6,8};
		SelectionSort(arr);
		System.out.print(Arrays.toString(arr));

	}

}
