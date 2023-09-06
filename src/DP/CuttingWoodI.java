package DP;
/*
137. Cutting Wood I
Hard
There is a wooden stick with length L >= 1, we need to cut it into pieces, where the cutting positions are defined in an int array A. The positions are guaranteed to be in ascending order in the range of [1, L - 1]. The cost of each cut is the length of the stick segment being cut. Determine the minimum total cost to cut the stick into the defined pieces.

Examples

L = 10, A = {2, 4, 7}, the minimum total cost is 10 + 4 + 6 = 20 (cut at 4 first then cut at 2 and cut at 7)
 */
public class CuttingWoodI {
    public int minCost(int[] cuts, int length) {
        // Write your solution here
        // corner case
        if(cuts == null || cuts.length == 0){
            return 0;
        }
        int n = cuts.length;
        // 首先把原数组补齐，主要是头和尾
        int[] helper = new int[n + 2];
        helper[0] = 0;
        for(int i = 0; i < n; i++){
            helper[i + 1] = cuts[i];
        }
        helper[helper.length - 1] = length;

        // dp[j][i]代表从array[j] 到array[i] 中间下刀的min cost， j 和 i是对应的input
        int[][] dp = new int[helper.length][helper.length];
        // base case1:
        dp[0][0] = 0;
        for(int i = 1; i < helper.length; i++){
            for(int j = i - 1; j >= 0; j--){// j 从 i - 1到0表示size从一段到更长，直到i到最后，j到最前就达到最大原始长度
                // base case2: 每一段不能再分割的cost
                if(j + 1 == i){
                    dp[j][i] = 0;
                }else{// 找到j 到i 之间所有可以下刀的位置k， 左半断加有半段再加j 到 i的cost。找期中最小的。最后返回全长度的最低cost
                    int minCost = Integer.MAX_VALUE;
                    for(int k = j + 1; k <= i - 1; k++ ){
                        minCost = Math.min ( minCost, dp[j][k] + dp[k][i] + helper[i] - helper[j] ) ;
                    }
                    dp[j][i] = minCost;
                }
            }
        }
        return dp[0][helper.length - 1];
    }

    public static void main(String[] args) {
        int[] cuts = {2,4,7};
        int length = 10;
        CuttingWoodI cuttingWoodI = new CuttingWoodI();
        System.out.println(cuttingWoodI.minCost(cuts, length));
    }
}
