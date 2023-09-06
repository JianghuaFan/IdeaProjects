package BFSHeap;

import java.util.Arrays;

public class KthSmallestInUnsortedArrayQuickSelect {
	public int[] kthSmallest(int[] array, int k) {
		if(array == null || array.length == 0) {
			return array;
		}
		if(k == 0) {
			return new int[0];
		}
		
		quickSelect(array, 0, array.length - 1, k - 1);
		int[] res = Arrays.copyOf(array, k);
		Arrays.sort(res);		
		return res;
	}
	
	public void quickSelect(int[] array, int left, int right, int target) {
		int pivot = partition(array, left, right);
		if (pivot == target)
			return;
		else if(pivot < target) {
			quickSelect(array, pivot + 1, right, target);
		}else {
			quickSelect(array, left, pivot - 1, target);
		}
	}
	
	public int partition(int[] array, int left, int right) {
		int pivot = array[right];
		int i = left; 
		int j = right - 1;
		while(i <= j) {
//			i < right - 1 && 
			if(array[i] < pivot) {
				i++;
			}
//			j > 0 && 
			else if (array[j] > pivot) {
				j--;
			}else swap(array, i++, j--);
		}
		swap(array, i, right);
		return i;
	}
	public void swap(int[] array, int i, int j) {
		  int temp = array[i];
		  array[i] = array[j];
		  array[j] = temp;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthSmallestInUnsortedArrayQuickSelect kth = new KthSmallestInUnsortedArrayQuickSelect();
		
		int[] array = {10,8,6,4,2,1,2,3,5,7,9,};
		System.out.print(Arrays.toString(kth.kthSmallest(array, 3)));

	}

}
