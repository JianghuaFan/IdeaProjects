package DP;
// Method 1 : TC: O(n) SC: O(1)
public class LongestConsecutive1s {

	public int longest(int[] array) {
		int max = 0;
		int cur = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 1) {
				cur++;
				max = Math.max(max, cur);
			}else {
				cur = 0;
			}			
		}
		return max;		
	}
	// Method 1 : TC: O(n) SC: O(n)
	public int longestConsecutiveOne(int[] array){

		// dp[i] represents  number of Consecutive ones ending at index i
		// base case: dp[0] = array[0] == 0 ? 0 : 1
		// induction rule: dp[i] = array[i] == 0 ? 0 : dp[i-1] + 1

		int[] dp = new int[array.length];
		int res = array[0] == 0 ? 0 : 1;
		dp[0] = array[0];
		for(int i = 1; i < array.length; i++){
			dp[i] = array[i] == 0 ? 0 : dp[i-1] + 1;
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutive1s longest = new LongestConsecutive1s();
		int[] array = {1,1,1,1,1,0};
		System.out.println(longest.longest(array));
		System.out.println(longest.longestConsecutiveOne(array));
	}

}
