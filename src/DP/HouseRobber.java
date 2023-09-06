package DP;
/*
You are a skilled robber planing to rob houses along a street.
Each house has a certain amount of gold in it, but if you rob two adjacent houses the security system will automatically contact the police.
Given a list of non-negative integers representing the amount of gold in each house,
return the maximum amount of gold you can rob without being caught.

Example:
Input: [1,5,6,7]
Output: 12
Explanation: You can either rob house 0 and house 2 (1 + 6 = 7) or you can rob house 1 and 3 (5 + 7 = 12)
 */
public class HouseRobber {
    public int rob(int[] num) {
        // Write your solution here
        if(num == null || num.length == 0){
            return 0;
        }
        if(num.length < 2){
            return num[0];
        }
        // dp: dp[i] represents maximum amount of gold you can rob for i houses
        int[] dp = new int[num.length];
        // if only one element, must rob
        dp[0] = num[0];
        // if two elements, consider rob which one
        dp[1] = Math.max(num[0], num[1]);
        for(int i = 2; i < num.length; i++){
            int robCur = dp[i - 2] + num[i];
            int notRobCur = dp[i - 1];
            dp[i] = Math.max(robCur, notRobCur);
        }
        return dp[num.length - 1];
    }
    public int robII(int[] nums) {
        // Write your solution here
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length < 2){
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    private int helper(int[] nums, int left, int right){
        if(left > right){
            return 0;
        }
        if(left == right){
            return nums[left];
        }

        int prev2 = nums[left];// 相当于 dp[0]
        int pre = Math.max(nums[left], nums[left + 1]);// 相当于 dp[1]
        int[] dp = new int[nums.length - 1];
        for(int i = left + 2; i <= right; i++){
            int robCur = prev2 + nums[i];
            int notRobCur = pre;
            int cur = Math.max(robCur, notRobCur);
            prev2 = pre;
            pre = cur;
        }
        return pre;
    }
    public static void main(String[] args) {
        int[] num = {1,5,6,7};
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(num));
        int[] nums = {1,2,3};
        System.out.println(houseRobber.robII(nums));
    }
}
