package BinarySearch;

public class SingleNonDuplicate540 {
	public static int singleNonDuplicate(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int l = 0, h = nums.length ;
		while (l < h) {
			int mid = l + (h - l) / 2;
			if (mid % 2 == 1)
				mid--;//任何数字出现都是在偶数位第一次出现所以比较偶数位和偶数位后面一位是否相同
			if (nums[mid] == nums[mid+1])
				l = mid + 2;
			else h = mid ;
		}
		return nums[l];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
		System.out.print(singleNonDuplicate(nums));

	}

}
