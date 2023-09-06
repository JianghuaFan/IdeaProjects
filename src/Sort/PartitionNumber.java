package Sort;

import java.util.Arrays;

public class PartitionNumber {
	public void partition(int[] array, int pivotIndex) {
	    //
	    if (array == null || array.length == 1)
	    	return;
	    int pivot = array[pivotIndex];	    
		int leftBound = 0;
		int right = array.length - 1;
		
		int rightBound = right - 1;
		
		swap(array, right, pivotIndex);		
		while(leftBound <= rightBound) {
			if(array[leftBound] < pivot){
				leftBound++;
			}
			else if (array[rightBound] > pivot ) {
				 rightBound--;
			}else 
				 swap(array, leftBound, rightBound);			    	
			}		  
			swap(array, leftBound, right);		
	  }

	  private static void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	  }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {9,4,6,2,0,1,7};
//		int[] array = {9,4,6,2,1,0,7};
		PartitionNumber p = new PartitionNumber();
		p.partition(array,2);
		System.out.println(Arrays.toString(array));	
		
	}

}
