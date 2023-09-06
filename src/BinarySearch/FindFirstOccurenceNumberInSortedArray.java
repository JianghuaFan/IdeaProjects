package BinarySearch;

import java.util.Arrays;

public class FindFirstOccurenceNumberInSortedArray {
	public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        return new int[]{firstPos(nums,target),lastPos(nums,target)};
    }
    public static int firstPos(int[] nums, int target) {
        int res = -1;
        int l = 0, h = nums.length - 1;
        while (l <= h ) {
            int mid = l + (h - l) / 2;
            // if(nums[mid] == target)
            //     h = mid;//do not stop here, keep checking to left
            if(nums[mid] >= target) // even nums[mid] == target still look for leftmost target
                h = mid-1;
            else l = mid + 1;
            if(target == nums[mid]) 
            res = mid;
        }
        return res;
        
    }
    public static int lastPos(int[] nums, int target) {
        int res = -1;
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            // if(nums[mid] == target)
            //     l = mid;//do not stop here, keep checking to right
            if(nums[mid] <= target)// even nums[mid] == target still look for rightmost target
                l = mid + 1;
            else h = mid-1;
            if(target == nums[mid]) 
            res = mid;
        }        
        return res;
    }
    public static int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length - 1; // 注意 h 的初始值
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] nums = {5,7,7,8,8,10};
		 int[] nums2 = {1};
		 System.out.println(firstPos(nums,8));
//		 System.out.println(lastPos(nums,8));
//		 System.out.println(Arrays.toString(searchRange(nums1,8)));
		 System.out.println(Arrays.toString(searchRange(nums2,0)));
		 int[] nums3 = {2,2};
		 System.out.println(findFirst(nums3,3));

	}

}
