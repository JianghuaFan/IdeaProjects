package DP;
/*
93. Buy Stock II
Easy
Given an array of positive integers representing a stock’s price on each day. On each day you can only make one operation: either buy or sell one unit of stock, you can make as many transactions you want, but at any time you can only hold at most one unit of stock. Determine the maximum profit you can make.

Assumptions

The give array is not null and is length of at least 2
Examples

{2, 3, 2, 1, 4, 5}, the maximum profit you can make is (3 - 2) + (5 - 1) = 5
 */
public class BuyStockII93 {
    public int maxProfit(int[] array) {
        // Write your solution here
        // 物理意义： 在第i天，hold一支股票或者不hold一支股票，
        // hold[i] = Math.max(case1, case 2)
        //           case 1: 买当天股票 =  unhold[i-1] - array[i],
        //           case 2: 不卖前一天股票 =  hold[i-1]
        // unhold[i] = Math.max(case1, case 2)
        //           case 1: 卖当天股票 =  hold[i-1] + array[i],
        //           case 2: 不买当天股票 =  unhold[i-1]
        // result: unhold 最后一天股票
        if(array == null || array.length == 0){
            return 0;
        }
        int[] hold = new int[array.length];
        int[] unhold = new int[array.length];
        // base case:
        hold[0] = -array[0];
        unhold[0] = 0;
        for(int i = 1; i < array.length; i++){
            hold[i] = Math.max(unhold[i-1] - array[i], hold[i-1]);
            unhold[i] = Math.max(hold[i-1] + array[i], unhold[i-1]);
        }
        return unhold[array.length - 1];
    }
    public int buyStock(int[] array){
        // highlevel: DP
        // use two dp array to maintain hold or unHold a stock on day i
        // siginature: hold[i] represents hold stock on day i
        // unhold[i] represents unhold stock on day i
        // base case: on day 1
        int  res = 0;
        int[] hold = new int[array.length];
        int[] unhold = new int[array.length];
        hold[0] = -array[0];
        unhold[0] = 0;
        for(int i = 1; i < array.length; i++){
            hold[i] = Math.max(unhold[i-1] - array[i], hold[i-1]);
            unhold[i] = Math.max(hold[i - 1] + array[i], unhold[i-1]);

        }
        res = unhold[array.length -1];
        return res;
    }
    public static void main(String[] args) {
        int[] array = {2, 3, 2, 1, 4 };
        BuyStockII93 buyStockII93 = new BuyStockII93();
//        System.out.println(buyStockII93.maxProfit(array));
        System.out.println(buyStockII93.buyStock(array));
    }
}
