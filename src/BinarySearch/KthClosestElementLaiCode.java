package BinarySearch;

import java.util.Arrays;

public class KthClosestElementLaiCode {
	public int[] kthClosest(int[] array, int target, int k) {
		
		 if(array == null || array.length == 0){
			 return array;
		 }
		 if(k == 0) {
			 return new int[0];
		 }
		 int[] res = new int[k];
		 //sliding window 		
		int left = 0;
	    int right = array.length - 1;
	    while (left < right - 1) {
	      int mid = left + (right - left) / 2;
	      if (array[mid] < target)
	        left = mid;
	      else right = mid;
	    }
	    System.out.println("left:" + left + " right:" + right);
	    
	 
//	    for(int index = 0; index < k; index++) {
//	    	if(right > array.length -1 || left >= 0 && target - array[left] <= array[right] - target) {
//	    		res[index] = array[left--];
//	    	}else {
//	    		res[index] = array[right++];
//	    	}
//	    }
	    //复杂版本
	    for(int index = 0; index < k; index++) {
	    	if(right < array.length && left >= 0) {
	    		if (target - array[left] <= array[right] - target){
	    			res[index] = array[left--];
		    	}else{
		    		res[index] = array[right++];
		    	}
	    	}else if(left>=0) {
	    		res[index] = array[left--];
	    	}else {
	    		res[index] = array[right++];
	    	}
	    }
	    Arrays.sort(res);
		return res;
		 
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,8};		
		int target = 2;
		int k = 3;
		KthClosestElementLaiCode kth = new KthClosestElementLaiCode();
		System.out.print(Arrays.toString(kth.kthClosest(arr,target,k)));

	}

}
