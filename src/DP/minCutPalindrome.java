package DP;

public class minCutPalindrome {
    public int minCuts(String input) {
        // Write your solution here
        if(input == null || input.length() == 0){
            return Integer.MAX_VALUE;
        }
        int[] minCut = new int[input.length()];
        // base case:
        minCut[0] = 0; // index == 0 meaning only one letter
        boolean[][] dp = new boolean[input.length()][input.length()];
        for(int i = input.length() - 1; i >= 0; i--){
            for(int j = i; j < input.length(); j++){
                if(i == j){
                    dp[i][j] = true;
                }else if(j == i + 1){
                    dp[i][j] = input.charAt(i) == input.charAt(j);
                }
                else{
                    if(input.charAt(i) == input.charAt(j)){
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        for(int i = 0; i < input.length(); i++){
            minCut[i] = Integer.MAX_VALUE;
            if(dp[0][i]){
                minCut[i] = 0;
            }else{
                for(int j = 0; j < i; j++){
                    if(minCut[j] != Integer.MAX_VALUE && dp[j + 1][i]){
                        minCut[i] = Math.min(minCut[i], minCut[j] + 1);
                    }
                }
            }
        }
        return minCut[input.length() - 1];
    }
    public static void main(String[] args){
        minCutPalindrome min = new minCutPalindrome();
        String str = "abc";
        System.out.println(min.minCuts(str));
//		System.out.println(Arrays.deepToString(min.getBoolean(str)));
    }
}
