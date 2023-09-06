package DP;

public class LargestSubArraySum {
	public int largestSum(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		if(array.length == 1) {
			return array[0];
		}
//		int[] cur = new int[array.length];
		int global_max = array[0];
//		cur[0] = array[0];
//		for(int i = 1; i < array.length; i++) {
//			if(cur[i-1] < array[i]&& cur[i-1] < 0) {				
//					cur[i] = array[i];				
//			}else {
//				cur[i]= cur[i-1] + array[i];
//			}			
//			max = Math.max(max, cur[i-1]);
//			System.out.println("max: " + max);
//		}
//		max = Math.max(max, cur[array.length - 1]);
//		return max;
		
		//改进cur不需要是数组，数字就可以
		int cur = array[0];
		for(int i = 1; i < array.length; i++) {
			cur = Math.max(cur + array[i], array[i]);	
			global_max = Math.max(global_max, cur);
//			System.out.println("max: " + max);
		}
		return global_max;	

	}
/*
918. Maximum Sum Circular Subarray
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

Example 1:
Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.

Example 2:
Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.


 */
	public int largestSumCircularArray(int[] array){
		if(array == null || array.length == 0){
			return 0;
		}
		// dp
		// base case:
		int curMin = 0; //min sum  of subArray ending at index i
		int globalMin = 0;
		int curMax = 0;// max sum  of subArray ending at index i
		int globalMax = 0;
		int sum = 0;
		for(int i = 0; i < array.length; i++ ){
			sum += array[i];
			curMin = Math.min(array[i], curMin + array[i]);
			globalMin = Math.min(globalMin, curMin);
			curMax = Math.max(array[i], curMax + array[i]);
			globalMax = Math.max(globalMax,curMax);
		}
		if(globalMin == sum)// case 1：所有的加起来得出全局最小，所以最大值应该在中间取，取globalMax
			return globalMax;
		else{
			return sum - globalMin;// globalMin 出现在中间，所以应该是头尾各取一段
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestSubArraySum longest = new LargestSubArraySum();
//		int[] array = {2, -1, 4, -2, 1};
//		int[] array = {-2, -1, -3};
		int[] array = {2, -2, 3, -1};
		System.out.println(longest.largestSum(array));
		System.out.print(longest.largestSumCircularArray(array));
	}

}
