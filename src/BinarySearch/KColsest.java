package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KColsest {
	public static int[] kClosest(int[] array, int target, int k) {
	    // Write your solution here
		if (array == null || array.length == 0) {
			return array;
		}
		if (k == 0)
			return new int[0];
//		 left， right will be the closest elments to the target
//	    int left = 0;
//	    int right = array.length - 1;
//	    while (left < right - 1) {
//	      int mid = left + (right - left) / 2;
//	      if (array[mid] < target)
//	        left = mid;
//	      else right = mid;
//	    }
		int left = largestSmallerEqual(array,target);
		int right = left + 1;
		
        System.out.println("left:" + left + " right:" + right);

	    //this is a typical merge operation
	    // 1. right pointer is already out of bound.
	    // 2. right point is not out of bound, left pointer is not out of bound, 
	    //    and array[left] is closer to target.
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
          if (right >= array.length || left >= 0 && target - array[left] <= array[right] - target)
            res[i] = array[left--];
          else
            res[i] = array[right++];      
          }    
	    
	    return res; 
	   
	}
	private static int largestSmallerEqual(int[] array, int target) {
		// TODO Auto-generated method stub
		int left = 0;
	    int right = array.length - 1;
	    while (left < right - 1) {
	      int mid = left + (right - left) / 2;
	      if (array[mid] < target)
	        left = mid;
	      else right = mid;
	    }
		return left;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,8};		
		int target = 8;
		int k = 3;
		System.out.print(Arrays.toString(kClosest(arr,target,k)));
	}

}
