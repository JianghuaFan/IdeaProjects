package Sort;

import java.util.Arrays;

public class MergeSortThirdTime {
	public int[] mergeSort(int[] nums) {
//		if(array == null || array.length == 0) {
//			return array;
//		}
//		System.out.println("array.length" + array.length);
//		int[] helper = new int[array.length];
//		mergeSort(array, helper, 0, array.length - 1);
//		return array;
//	}
//
//	public void mergeSort(int[] array, int[] helper, int left, int right){
//		if( left >= right) {
//			return;
//	}
//	int mid = left + (right - left) / 2;
//	mergeSort(array, helper, left, mid);
//	mergeSort(array,helper, mid+1, right);
//	merge(array,helper, left, mid, right);
//	}
//	public void merge(int[] array, int[] helper, int left, int mid, int right){
//		for(int i = left; i <= right; i++){
//			helper[i] = array[i];
//		}
//		int leftIndex = left;
//		int rightIndex = mid + 1;
//		while( leftIndex <= mid && rightIndex <= right){
//			if(helper[leftIndex] <= helper[rightIndex]){
//				array[left++] = helper[leftIndex++];
//			}else {
//				array[left++] = helper[rightIndex++];
//			}
//		}
//		while(leftIndex <= mid) {
//			array[left++] = helper[leftIndex++];
//		}
//	}
	if(nums == null || nums.length == 0){
		return nums;
	}
	int[] helper = new int[nums.length];
	helperFunction(nums, helper, 0, nums.length -1);
    return nums;
}

	private void helperFunction(int[] nums, int[] helper, int left, int right){
		// base case:
		if(left >= right){
			return;
		}
		int mid = left + (right - left) / 2;
		helperFunction(nums, helper, left, mid);
		helperFunction(nums, helper, mid + 1, right);
		merge(nums, helper, left, mid, right);
	}

	private void merge(int[] nums, int[] helper, int left, int mid, int right){
		for(int i = left; i <= right; i++){
			helper[i] = nums[i];
		}
		int leftIndex = left;
		int rightIndex = mid + 1;

		while(leftIndex <= mid && rightIndex <= right){
			if(helper[leftIndex] <= helper[rightIndex]){
				nums[left++] = helper[leftIndex++];
			}else{
				nums[left++] = helper[rightIndex++];
			}
		}
		while(leftIndex <= mid){
			nums[left++] = helper[leftIndex++];
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {40,20,60,10,50,30};
		MergeSortThirdTime merge = new MergeSortThirdTime();
		merge.mergeSort(arr);
		System.out.println(Arrays.toString(merge.mergeSort(arr)));
	}

}
