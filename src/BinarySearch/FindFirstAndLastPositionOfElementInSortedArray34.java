package BinarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray34 {
	public static int[] search(int[] nums, int target) {
		return new int[]{firstPos(nums,target),lastPos(nums,target)};
	}

	public static int firstPos(int[] nums, int target) {
		// TODO Auto-generated method stub
		int l = 0, h = nums.length - 1;
		while (l < h) {
			int mid = l + (h - l) / 2;
			if (nums[mid] < target)
				l = mid + 1;
			else h = mid;
		}
		if (l == nums.length || nums[l] != target) return -1;
		return l;
	}
	public static int lastPos(int[] nums, int target) {
		int l = 0, h = nums.length - 1;
		while (l < h) {
			int mid = l + (h - l) / 2;
			if (nums[mid] <= target)
				l = mid + 1;
			else h = mid;
		}
		l--;// l points to the first element this is greater than target
		if (l < 0 || nums[l] != target) return -1;
		return l;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
