package Sort;

import java.util.Arrays;

public class InsertionSort {
	public static void InsertSort(int arr[]) {
		if(arr == null || arr.length < 2) {
			return;
		}
		
		for( int i = 0; i < arr.length; i++) {						
			for (int j = i-1; j >= 0 ; j--) {
				if(arr[j] > arr[j+1])
				swap(arr, j, j+1);				
			}			
		}
//		 int i, key, j;
//		   for (i = 1; i < arr.length; i++)
//		   {
//		       key = arr[i];
//		       j = i-1;
//		   
//		       /* Move elements of arr[0..i-1], that are
//		          greater than key, to one position ahead
//		          of their current position */
//		       while (j >= 0 && arr[j] > key)
//		       {
//		           arr[j+1] = arr[j];
//		           j = j-1;
//		       }
//		       arr[j+1] = key;
//		   }
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr [j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{2,3,1};
		InsertSort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
