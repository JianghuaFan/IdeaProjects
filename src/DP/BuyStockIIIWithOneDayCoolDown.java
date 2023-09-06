package DP;
/*
421. Best Time to Buy and Sell Stock with Cooldown
Medium
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
 */
public class BuyStockIIIWithOneDayCoolDown {
    public int maxProfit(int[] prices) {
        // Write your solution here
        // 物理意义：　hold[i]表示第i天hold one share 股票，= Math.max(case1, case2)
        //          case 1：buy at ith day: unhold[i -2] - array[i]今天buy，因为冷静期需要看 i-2这一天卖了的情况
        //          case 2: not buy at ith day: hold[i - 1]
        //          unhold[i]表示第i天不hold one share股票，= Math.max(case1, case2)
        //          case 1：sell at ith day: hold[i - 1] + array[i]
        //          case 2: not sell at ith day: unhold[i - 1]
        // base case:
        //          hold[0] = -array[0] 0 天只能买入，利润为负
        //          hold[1] = Max(-array[0],-array[1]) 要么第0天买入，要么第1天买入
        //          unhold[0] = 0
        //          unhold[1] = Max(array[1] - array[0], 0) 要么第0天买入，第1天卖出
        // result: unhold[array.length - 1]
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[] hold = new int[prices.length];
        int[] unhold = new int[prices.length];
        // base case:
        hold[0] = -prices[0];
        hold[1] = Math.max(-prices[0], -prices[1]);
        unhold[0] = 0;
        unhold[1] = Math.max(prices[1] - prices[0], 0);
        for(int i = 2; i < prices.length; i++){
            hold[i] = Math.max(unhold[i-2] - prices[i], hold[i-1]);
            unhold[i] = Math.max(hold[i-1] + prices[i], unhold[i-1]);
        }
        return unhold[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 0, 2};
        BuyStockIIIWithOneDayCoolDown buyStockIIIWithOneDayCoolDown = new BuyStockIIIWithOneDayCoolDown();
        System.out.println(buyStockIIIWithOneDayCoolDown.maxProfit(array));
    }
}
