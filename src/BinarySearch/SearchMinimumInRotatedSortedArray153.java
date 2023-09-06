package BinarySearch;

public class SearchMinimumInRotatedSortedArray153 {
	public static int findMin(int[] nums) {
        // brute force
        // if(nums.length == 1) return nums[0];
        // if (nums[0] < nums[nums.length - 1]) return nums[0];
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] > nums[i + 1])
        //         return nums[i + 1];
        // }
        // return -1;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= nums[h])
                h = mid;
            else l = mid + 1;
        }
        return nums[l];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,3,1};
		System.out.print(findMin(nums));
	}

}
