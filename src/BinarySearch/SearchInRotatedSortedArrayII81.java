package BinarySearch;

public class SearchInRotatedSortedArrayII81 {
	public static boolean search(int[] nums, int target) {
//		if(nums.length == 1 && nums[0] == target)
//            return true;
//        if(nums.length == 1 && nums[0] != target)
//            return false;
//        int i = 0;
//        while (nums[i] <= nums[i + 1] && i < nums.length - 2){
//                i++;
//        }
//        boolean b1 = binarySearch(nums, target, 0, i);
//        boolean b2 = binarySearch(nums, target, i + 1, nums.length - 1);
//        if(b1 || b2) return true;
//        return false;
		int n = nums.length, left = 0, right = n - 1;
		while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1; //如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的。而如果可以有重复值，就会出现来面两种情况，[3 1 1] 和 [1 1 3 1]，对于这两种情况中间值等于最右值时，目标值3既可以在左边又可以在右边，那怎么办么，对于这种情况其实处理非常简单，只要把最右值向左一位即可继续循环，如果还相同则继续移，直到移到不同值为止
            } else if (nums[mid] > nums[right]){
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else --right;
        }
        return false;
    }
//     public static boolean binarySearch(int[] nums, int target, int start, int end) {
//         int l = start, h = end;
//         while (l <= h) {
//             int mid = l + (h - l) / 2;
//             if(nums[mid] == target)
//                 return true;
//             else if (nums[mid] < target)
//                 l = mid + 1;
//             else h = mid - 1;
//         }
//         return false;
//     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1};
		int[] nums1 = {3,1,1};
		System.out.println(search(nums,1));
		System.out.println(search(nums1,1));
		System.out.println(search(nums1,2));
	}

}
