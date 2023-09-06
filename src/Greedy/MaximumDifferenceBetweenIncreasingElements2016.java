package Greedy;

public class MaximumDifferenceBetweenIncreasingElements2016 {
	public static int maximumDifference(int[] nums) {
		int res = -1;
		int min = Integer.MAX_VALUE;
		for(int num : nums) {
			res = Math.max(res, num - min);
			min = Math.min(min, num);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,1,5,4};
		int[] nums1 = {6,4,2};
		System.out.println(maximumDifference(nums));
		System.out.println(maximumDifference(nums1));
	}

}
