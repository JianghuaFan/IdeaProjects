package ArrayMatrix;

import java.util.Arrays;

public class FindErrorNums645 {
	public static int[] findErrorNums(int[] nums){
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != i+1 && nums[nums[i]-1] != nums[i]) {
				swap(nums, i, nums[i]-1);
			}
		}
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != i+1) {
				return new int[]{nums[i], i+1};
			}
		}
		return null;
	}
	private static void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args){
		int[] nums = {1,1,2,3};
		System.out.print(Arrays.toString(findErrorNums(nums)));
	}
}
