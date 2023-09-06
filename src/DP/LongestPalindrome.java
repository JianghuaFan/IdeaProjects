package DP;
/*
input: YABCCBAZ
output: ABCCBA
input: ABC
output: None
 */
public class LongestPalindrome {
    public String longestPalindrome(String input) {
        int n = input.length();
        int[][] dp = new int[n][n];
        int[][] start = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    start[i][j] = i;
                } else if (input.charAt(i) == input.charAt(j) && dp[i + 1][j - 1] == j - i - 1) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    start[i][j] = i;
                } else {
                    if (dp[i + 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i + 1][j];
                        start[i][j] = start[i + 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                        start[i][j] = start[i][j - 1];
                    }

                }
            }
        }
        int subStart = start[0][n - 1];
        if (subStart == 1) {
            return "None";
        }
        return input.substring(subStart, subStart + dp[0][n - 1]);
    }
}
