package DP;

public class BestTimetoBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] array, int fee) {
        // Write your solution here
        // Write your solution here
        // 物理意义： 在第i天，hold一支股票或者不hold一支股票，
        // hold[i] = Math.max(case1, case 2)
        //           case 1: 买当天股票 =  unhold[i-1] - array[i],
        //           case 2: 不卖前一天股票 =  hold[i-1]
        // unhold[i] = Math.max(case1, case 2)
        //           case 1: 卖当天股票 =  hold[i-1] + array[i] - fee,
        //           case 2: 不买当天股票 =  unhold[i-1]

        // base case: hold[0] = -array[0]
        //            unhold[0] = 0;
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
            unhold[i] = Math.max(hold[i-1] + array[i] - fee, unhold[i-1]);
        }
        return unhold[array.length - 1];
    }
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 8, 4, 9 };
        BestTimetoBuyandSellStockwithTransactionFee bestTimetoBuyandSellStockwithTransactionFee = new BestTimetoBuyandSellStockwithTransactionFee();
        System.out.println(bestTimetoBuyandSellStockwithTransactionFee.maxProfit(array,2));
    }
}
