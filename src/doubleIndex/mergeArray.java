package doubleIndex;

import java.util.Arrays;

public class mergeArray {

	public static void merge(int[] nums1,int m, int[] nums2, int n) {
		int index1 = m - 1, index2 = n - 1;
	    int indexMerge = m + n -1;
	    //System.out.println(indexMerge);
	    while (index2 >= 0) {
	        if (index1 < 0) {
	            nums1[indexMerge--] = nums2[index2--];
	        } else if (index2 < 0) {
	            nums1[indexMerge--] = nums1[index1--];
	        } else if (nums1[index1] > nums2[index2]) {
	            nums1[indexMerge--] = nums1[index1--];
	        } else {
	            nums1[indexMerge--] = nums2[index2--];
	        }
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[] {1,2,3};
		int[] nums2 = {4,5};
		merge(nums1,nums1.length,nums2,nums2.length);
		System.out.print(Arrays.toString(nums1));
	}

}
