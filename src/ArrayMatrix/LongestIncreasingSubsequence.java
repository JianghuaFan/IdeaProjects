package ArrayMatrix;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public static int longestIncreasingSubsequence(int[] nums) {
		/*方法一： 动态规划 递推方式
		int n = nums.length;
		int[] dp = new int[n];
		int res = 1;
		for(int i = 0; i < n; i++) {
			int max = 1;
			for(int j = 0; j< i; j++) {
				if(nums[i] > nums[j]) {
					max = Math.max(max, dp[j] + 1);
				}
			}
			dp[i] = max;
		}
		for(int i = 0; i < n; i++) {
			res = Math.max(res, dp[i]);
		}
		System.out.println(Arrays.toString(dp));
		return res;
		以上解法的时间复杂度为 O(N2)，可以使用二分查找将时间复杂度降低为 O(NlogN)。*/
		//方法二： 空间复杂度O(n)
		/*二分插入法：定义一个 tails 数组，其中 tails[i] 存储长度为 i + 1 的最长递增子序列的最后一个元素。对于一个元素 x，
			//如果它大于 tails 数组所有的值，那么把它添加到 tails 后面，表示最长递增子序列长度加 1；
			//如果 tails[i-1] < x <= tails[i]，那么更新 tails[i] = x。
		*/
		int[] tails = new int[nums.length];
		int res = 0;
		for(int num : nums) {
			int i = 0, j = res;
			while(i < j) {//i 相当于left， j 相当于right
				int mid = i +(j - i)/2;
				if(tails[mid] < num) {
					i = mid + 1;
				}else {
					j = mid;
				}
			}
			tails[i] = num;// i 为插入位置
			if(i == res) res++;	//如果插入位置为res意味着num大于tails数组所有的值				
		}
		return res;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.print(longestIncreasingSubsequence(nums));
	}

}
