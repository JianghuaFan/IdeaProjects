package BinarySearch;

public class SearchInRotatedSortedArrayII33 {
	public static int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < nums[h]) {
                if(nums[mid] < target && target <= nums[h])
                    l = mid + 1;
                else h = mid - 1;
            }
            else { 
                if (target < nums[mid] && target >= nums[l])
                    h = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		int[] nums1 = {4,5,6,7,0,1,2};		
		System.out.println(search(nums,0));
		System.out.println(search(nums1,3));
	
	}

}
