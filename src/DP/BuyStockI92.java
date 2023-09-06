package DP;
/*
92. Buy Stock IEasy
Given an array of positive integers representing a stock’s price on each day. On each day you can only make one operation: either buy or sell one unit of stock and you can make at most 1 transaction. Determine the maximum profit you can make.

Assumptions

The given array is not null and is length of at least 2.
Examples

{2, 3, 2, 1, 4, 5}, the maximum profit you can make is 5 - 1 = 4
 */
public class BuyStockI92{
	public int maxProfit(int[] array) {
		// Write your solution here
		if(array == null || array.length == 0){
			return 0;
		}
		// 物理意义： dp[i] 表示到index为i天的最大利润
//		int[] dp = new int[array.length];
//		// base case:
//		dp[0] = 0;
//		int max = 0;
//		int smallest = array[0];
//		for(int i = 1; i < array.length; i++){
//			// case 1: sell at current day， 利润是当天价格减最小值
//			int sell = array[i] - smallest;
//			// case 2: not sell at current day， 利润和前一天一样大
//			int notSell = dp[i - 1];
//			smallest = Math.min(smallest, array[i]);
//			dp[i] = Math.max(sell, notSell);
//		}
//		return dp[array.length - 1];
		// 优化空间
//		int globalMax = 0;
//		int prev = 0;
//		// base case:
//		int smallest = array[0];
//		for(int i = 1; i < array.length; i++){
//			// case 1: sell at current day， 利润是当天价格减最小值
//			int sell = array[i] - smallest;
//			// case 2: not sell at current day， 利润和前一天一样大
//			int notSell = prev;
//			smallest = Math.min(smallest, array[i]);
//			int curMax = Math.max(sell, notSell);
//			globalMax = Math.max(globalMax, curMax);
//			prev = curMax;
//		}
//		return globalMax;

// highlevel: we will maintain two variable：
		// 1.max difference between nums[i] and nums[j]
		// 2.minimum integer of the array
		// corner case
		int minimum = array[0];
		int maximumDifference = -1;
		for(int i = 1; i < array.length; i++){
			if(array[i] > minimum){
				if(array[i] - minimum > maximumDifference){
					maximumDifference = array[i] - minimum;
				}
			}
			if(array[i] < minimum){
				minimum = array[i];
			}
		}
		return maximumDifference;
	}
	public static void main(String[] args) {
		BuyStockI92 bestITimeToBuyAndSellStock92 = new BuyStockI92();
		// TODO Auto-generated method stub
		int[] prices = {1,5,4,6};
		int[] prices1 = {6,4,2};
		int[] prices2 = {7,1,5,3,6,4};
		System.out.println(bestITimeToBuyAndSellStock92.maxProfit(prices));
//		System.out.println(maxProfit(prices1));
//		System.out.println(maxProfit(prices2));
		

	}

}
