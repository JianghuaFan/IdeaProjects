package Sort;

import java.util.Arrays;

public class RainbowSort {
	public static int[] rainbowSort(int[] array) {
		if (array == null || array.length == 0)
		  return array;
		//three bounds:
		// 1. neg:all the elements to the left of neg(exclusive) would be -1
		// 2. zero: all the elements between neg(inclusive) and zero(exclusive) would be 0
		// 3. one: all the elements between zero and one (both inclusive) need to be checked
		// 4. all the elements to the right of one(exclusive) would be 1
		int neg = 0;
		int zero = 0;
		int one = array.length - 1;
//		    while (zero <= one) {
//		      if (array[zero] == -1) {
//		        swap(array,zero++,neg++);
//		      }
//		      else if (array[zero] == 0) {
//		        zero++;
//		      }
//		      else if (array[zero] == 1) {
//		        swap(array, zero, one--);
//		      }
//		    }
		while(zero<= one){
			  if(array[zero] == -1){
				swap(array, zero, neg);
				zero++;
				neg++;
			  }else if(array[zero] == 0){
				zero++;
			  }else {
				swap(array, zero, one--);
			  }
			}
		return array;
		    
	}
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		}
		public int[] sort(int[] array){
		// highlevel: use two boundaries to separate the array into three part: left part stores -1, middle part stores 0, right prat stores 1
			// [ 1, 0, 1, -1, 0 ]
			// neg |  zero | one |  traverse the array, if we see neg swap it to the left, if we see zero, move forward, if we see one, swap it to the right
			int neg = 0;
			int zero = 0;
			int one = array.length - 1;
			while ( zero <= one){
				if(array[zero] == -1){
					swap(array, neg++, zero++);
				}else if(array[zero] == 0){
					zero++;
				}else{
					swap(array, zero, one--);
				}
			}
			return array;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, 0, 1, -1, 0};
		int[] nums2 = {1, 0, 1, -1, 0};
//		int[] nums = {1, -1};
//		rainbowSort(nums);
		System.out.print(Arrays.toString(rainbowSort(nums1)));
		System.out.print(Arrays.toString(rainbowSort(nums2)));
		
	}

}
