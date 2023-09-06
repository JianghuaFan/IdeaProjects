package ArrayMatrix;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate287 {
	public static int findDuplicateBinarySearch(int[] nums) {
		//方法一：二分法
		int l = 0, h = nums.length - 1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			int cnt = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid) cnt++;
			}
			if (cnt <= mid)
				l = mid + 1;
			else h = mid - 1;
		}

		System.out.println("l:" + l);
		return l;
	}
	public static int findDuplicateSet(int[] nums) {
//		方法二：哈希表，时间： O(n)，额外空间O(n)
		Set<Integer> seen = new HashSet<Integer>();
		for (int num : nums) {
			if (seen.contains(num)) {
				return num;
			}
			seen.add(num);
		}
		return -1;
	}
		//方法三： sums法 仅限于数组只有一个duplicate number
	public static int findDuplicateSum(int[] nums) {
		int sum = 0;
		int n = nums.length;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int x = sum - n * (n - 1) / 2;
		return x;
	}
		//方法四： 链表法
	public static int findDuplicateFastSlowPointer(int[] nums) {
		int slow = 0, fast = 0;
		do {
			// 快慢指针重叠时找到了交点
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		slow = 0;
		// 慢指针从头开始，快指针从交点开始，同时只走一步，相遇时就是环的入口
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
		//方法五： 相与法 仅限于数组只有一个duplicate number
	public static int findDuplicateSumII(int[] nums) {
		int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i] ^ i;
        }
        return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {2,2,1,3,4};
		System.out.print(findDuplicateFastSlowPointer(nums));
	}
}
