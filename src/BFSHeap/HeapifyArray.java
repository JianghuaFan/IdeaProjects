package BFSHeap;

import java.util.Arrays;

public class HeapifyArray {
	public int[] heapify(int[] array) {
	    // Write your solution here    
			if(array == null || array.length == 0) {
			  return array;
			} 
			for(int i = array.length / 2 - 1; i >= 0; i--){
				percolateDown(i,array);
			}
			return array;
		}
	 
	public void percolateDown(int index, int[] array){
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
		int[] array = {0,-1,-2,1};
		HeapifyArray h = new HeapifyArray();
		System.out.print(Arrays.toString(h.heapify(array)));
	}

}
