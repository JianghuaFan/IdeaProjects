package Sort;

import java.util.Arrays;

public class bubbleSortDoubleDirection {
	public static void bubbleSortDouble(int[] arr) {
		int preIndex = 0, backIndex = arr.length -1;
		while(preIndex < backIndex) {
			preSort(arr, preIndex);
			preIndex ++;
			if (preIndex >= backIndex)
				break;
			backSort(arr, backIndex);
			backIndex --;
		}
	}	
	public static void preSort(int[] arr, int preIndex) {
		for(int i = preIndex +1 ; i < arr.length; i++) {
			if (arr[preIndex] > arr[i]) {
				swap(arr, preIndex, i);
			}
		}			
	}
	public static void backSort(int[] arr, int backIndex) {
		for(int i = backIndex -1; i >= 0; i--) {
			if (arr[i] > arr[backIndex]) {
				swap(arr, i, backIndex);
			}
		}
	}
			
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,6,4,2,1};
		bubbleSortDouble(a);
		/*for(int i = 0; i < a.length; i ++) {
			System.out.print(a[i]+" ");
		}*/
		System.out.println(Arrays.toString(a));
	}

}
