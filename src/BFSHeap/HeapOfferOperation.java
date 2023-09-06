package BFSHeap;

import java.util.Arrays;

public class HeapOfferOperation {
	public int[] offerHeap(int[] array, int ele) {
		int length = array.length;
		array[length - 1] = ele;
		percolateUp(array, length - 1);
		return array;		
	}
	public void percolateUp(int[] array, int index){
		while(index > 0) {
			int indexParent = (index - 1) / 2;
			if(array[index] < array[indexParent]) {
				swap(array, index, indexParent);
			}
			index = indexParent;
		}
	}
	 public void swap(int[] array, int i, int j) {
		  int temp = array[i];
		  array[i] = array[j];
		  array[j] = temp;
	  } 


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,3,4,0};
		HeapOfferOperation h = new HeapOfferOperation();
		System.out.print(Arrays.toString(h.offerHeap(array,1)));
	}

}
