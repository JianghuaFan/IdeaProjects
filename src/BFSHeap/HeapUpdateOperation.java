package BFSHeap;

import java.util.Arrays;

public class HeapUpdateOperation {
	public int[] updateHeap(int[] array, int index, int ele) {
		   // Write your solution here
		if(array == null || array.length == 0)
		return array;
		int length = array.length;
		int res = array[index];
		if(res < ele) {
			array[index] = ele;
			percolateDown(array, index); 
		} else if (res > ele) {
			array[index] = ele;
			percolateUp(array, index); 
		}
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
	public void percolateDown(int[] array, int index){
		while(index < array.length/2){
			int indexLeft = index * 2 + 1;
			int indexRight = index * 2 + 2;
			int swapCandidate = indexLeft;
			if( indexRight <= array.length -1 && array[swapCandidate] > array[indexRight]) {
				swapCandidate = indexRight;
			}
			if(array[index] > array[swapCandidate]) {
				swap(array,index, swapCandidate);
			}else {
				break;
			}
			index = swapCandidate;
		}
	}
	 public void swap(int[] array, int i, int j) {
		  int temp = array[i];
		  array[i] = array[j];
		  array[j] = temp;
	  } 


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4};
		HeapUpdateOperation h = new HeapUpdateOperation();
		System.out.print(Arrays.toString(h.updateHeap(array,1,5)));

	}

}
