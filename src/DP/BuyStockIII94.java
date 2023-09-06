package DP;
/*
94. Buy Stock III
Medium
Given an array of positive integers representing a stock’s price on each day. On each day you can only make one operation: either buy or sell one unit of stock, at any time you can only hold at most one unit of stock, and you can make at most 2 transactions in total. Determine the maximum profit you can make.

Assumptions

The give array is not null and is length of at least 2
Examples

{2, 3, 2, 1, 4, 5, 2, 11}, the maximum profit you can make is (5 - 1) + (11 - 2) = 13
 */
public class BuyStockIII94 {
    public int maxProfit(int[] array) {
        if(array == null || array.length <= 1){
            return 0;
        }
        // Write your solution here
        // 物理意义： 左右两段加起来
        //          left[i]: 从第一天到i天最大利润，
        //          right[i]: 从第i天到最后一天最大利润
        // induction rule:
        //  for left:  Math.max(case1, case2)
        //          case 1: sell at index ith day
//                              dp[i] = price[i] - smallest until now
//                   case 2: not sell at index ith day
        //                  dp[i] = dp[i - 1]
        //  for right:  Math.max(case1, case2)
        //          case 1: buy at index ith day
//                              dp[i] = largest(后面某一天最大值卖出的) - price[i]
//                   case 2: not buy at index ith day
        //                      dp[i] = dp[i + 1]
        // base case: dp[0] = 0; smallest = array[0]; dp[array.length - 1]; largest = 0;
        int[] leftDp = new int[array.length];
        int[] rightDp = new int[array.length];
        // deal with left
        leftDp[0] = 0;
        int smallest = array[0];
        for(int i = 1; i < array.length; i++){
            int sell = array[i] - smallest;
            smallest = Math.min(smallest, array[i]);
            int notSell = leftDp[i - 1];
            leftDp[i] = Math.max(sell, notSell);
        }

        // deal with right
        rightDp[array.length - 1] = 0;
        int largest = array[array.length - 1];
        for(int i = array.length - 2; i >= 0 ; i--){
            int buy = largest - array[i];
            largest = Math.max(largest, array[i]);
            int notBuy = rightDp[i + 1];
            rightDp[i] = Math.max(buy, notBuy);
        }

        // merge
        int profit = 0;
        for(int i = 0; i < array.length; i++){
            profit = Math.max(profit,leftDp[i] + rightDp[i]);
        }
        return profit;
    }

    public int maxProfitState(int[] array) {
        if(array == null || array.length <= 1){
            return 0;
        }
        // Write your solution here
        // 物理意义： hold 和unhold 两种状态
        //          hold[i][j]: represent the max profit hold one share in ith day with at most j transaction
        //          unhold[i][j]: represent the max profit unhold one share in ith day with at most j transaction
        // induction rule:
        //  case hold at ith day:  hold[i] = Math.max(case1, case2)
        //          case 1: buy at index ith day
//                              hold[i][j] = unhold[i][j - 1] - price[i - 1]
//                   case 2: not buy at index ith day
        //                  hold[i][j] = hold[i - 1][j]
        //  case unhold at ith day:  unhold[i] = Math.max(case1, case2)
        //          case 1: sell at index ith day
//                              unhold[i][j] = hold[i - 1][j] + price[i - 1] 我在第i - 1天hold with j交易情况下，今天sell一次
//                                    之前买入时候算过一次交易，这里不重复计算
//                   case 2: not sell at index ith day
        //                      unhold[i][j] = unhold[i - 1][j]
        // base case:
        // for all 0 <= i <= len: hold[i][0] = Integer.MIN_VALUE; unhold[i][0] = 0
        // 第i天想要hold但是0次交易，利润MIN，
        // 第i天想要unhold但是0次交易，利润0
        // for all 0 <= j <= 3: hold[0][j] = Integer.MIN_VALUE; unhold[0][j] = 0
        // 第0天, j次交易，想要hold，因为off by one 第0天不存在，利润MIN，
        // 第0天, j次交易，unhold因为off by one 第0天不存在，利润0
        // result: unhold[array.length][2]: 最后一天hold with最多两次交易
        int[][] hold = new int[array.length + 1][3];
        int[][] unhold = new int[array.length + 1][3];
        for(int i = 0; i <= array.length; i++) {
            hold[i][0] = Integer.MIN_VALUE;
        }
        for(int j = 0; j < 3; j++) {
            hold[0][j] = Integer.MIN_VALUE;
        }
        for(int i = 1; i <= array.length; i++){
            for(int j = 1; j < 3; j++) {
                unhold[i][j] = Math.max(hold[i - 1][j] + array[i - 1], unhold[i - 1][j]);
                hold[i][j] = Math.max(unhold[i][j - 1] - array[i - 1], hold[i - 1][j]);
            }
        }
        return unhold[array.length][2];
    }

    public static void main(String[] args) {
        int[] array = {1,7,3,8};
        BuyStockIII94 buyStockIII94 = new BuyStockIII94();
        System.out.println(buyStockIII94.maxProfit(array));
        System.out.println(buyStockIII94.maxProfitState(array));
    }

}
