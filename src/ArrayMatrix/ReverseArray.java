package ArrayMatrix;

import java.util.Arrays;

public class ReverseArray {
	public static int[] reverse(int[] array) {
	    // Write your solution here
	    if (array == null || array.length == 0)
	      return array;
	    
	    for (int i = 0; i < array.length / 2; i++) {
	      swap(array, i, array.length - 1 - i);
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
		int[] array = {2,3,5,7,11};
		System.out.print(Arrays.toString(reverse(array)));

	}

}
