package LaiCodeBeginner;

import java.util.Arrays;

public class PartitioinPivot {
	public static void partition(int[] array, int pivotIndex) {
	  	  
	  if (array == null || array.length == 1)
		    return;
	    int i = 0;
		  int j = array.length - 1;
		  if(j == pivotIndex)
			  j = pivotIndex - 1;
		  while (true) {		  
			  while ( array[i] < array[pivotIndex] && i < array.length - 1) {
				  i++;				  
			  }
			  while( array[j] > array[pivotIndex] && j >= 0) {
				  j--;
			  }
			  if (i > j)
				  break;
	      swap(array, i, j);      
		  }
		  swap(array, i, pivotIndex);	  			
	}
		
	  private static void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array = {9,4,6,2,0,1,7};
		int[] array = {9,4,6,2,1,0,7};
		
		partition(array,6);
		System.out.print(Arrays.toString(array));
	}

}
