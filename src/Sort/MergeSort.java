package Sort;

import java.util.Arrays;

public class MergeSort {
	
	public static int[] mergeSort(int[] nums) {
//		check null array first
		if (nums == null || nums.length == 0)
			return nums;
//		allocate helper array to help merge step, so that we guarantee no more than O(n) space is used
//		The space complexity is O(n) in this case
		int[] helper = new int[nums.length];
		mergeSort(nums, helper, 0, nums.length - 1);
		return nums;
	}
	
	private static void mergeSort(int[] nums, int[] helper, int left, int right) {
		// TODO Auto-generated method stub
		
		if(left >= right){
			return;
		}
		int mid = left + (right - left)/2;
		mergeSort(nums,helper,left,mid);
		mergeSort(nums,helper,mid+1,right);
		merge(nums,helper,left,mid,right);
	}
	
	private static void merge(int[] nums, int[] helper, int left,int mid, int right) {
//		copy the content to helper array, and we will merge from the helper array
//
		for(int i = left; i <= right; i++) {
			helper[i] = nums[i];
		}
		int leftIndex = left;
		int rightIndex = mid+1;
		while (leftIndex <= mid && rightIndex <= right) {
			if (helper[leftIndex] <= helper[rightIndex]) {
				nums[left++] = helper[leftIndex++];
			}else
				nums[left++] = helper[rightIndex++];
		}
//		if we still have some elements at left side, we need to copy them
		while (leftIndex <= mid) {
			nums[left++] = helper[leftIndex++];
		}
//		if there are some elements at right side, we do not need to copy them
//		because they are already in their position			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {40,20,60,10,50,30};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
