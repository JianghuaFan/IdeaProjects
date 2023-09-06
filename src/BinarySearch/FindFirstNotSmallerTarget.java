package BinarySearch;

public class FindFirstNotSmallerTarget {
	public static int findFirstNotSmallerTarget(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] <= target)
				left = mid + 1;
			else right = mid;
		}
		System.out.println("right:" + right);
		return nums[right];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,4,4,4,6,9};
		System.out.print(findFirstNotSmallerTarget(nums, 8));
	}

}
