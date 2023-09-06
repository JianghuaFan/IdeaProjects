package DP;
/*
177. Longest Common Subsequence
Medium
Find the length of longest common subsequence of two given strings.

Assumptions

The two given strings are not null
Examples

S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.
 */
public class LongestCommonSubsequence {
    public int longest(String source, String target) {
        // Write your solution here
        if (source.length() == 0 || target.length() == 0) {
            return 0;
        }
        int[][] longest = new int[source.length() + 1][target.length() + 1];
        // using off by one trick make the base case easier to handle, 第0行和0列全部为0
        for (int i = 1; i <= source.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)){
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                }else{
                    longest[i][j] = Math.max(longest[i - 1][j], longest[i][j - 1]);
                }
            }
        }
        return longest[source.length()][target.length()];
    }
    // 以下解法Corner case处理太麻烦
    public int longest1(String source, String target) {
        // Write your solution here
        if (source.length() == 0 || target.length() == 0) {
            return 0;
        }
        char[] sa = source.toCharArray();
        char[] ta = target.toCharArray();
        int longest = 0;
        int[][] dp = new int[sa.length][ta.length];
        for (int i = 0; i < sa.length; i++) {
            for (int j = 0; j < ta.length; j++) {
                // case 1: 如果当前字母相同，则看左上角
                if (sa[i] == ta[j]) {
                    // 判断Corner case
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        longest = Math.max(longest,dp[i][j]);
                    }
                }else{
                    // case 2: 如果当前字母不相同，则看左边和上边，选其中大的
                    if(i == 0 && j != 0){
                        dp[i][j] = dp[i][j - 1];
                    }else if(i != 0 && j == 0){
                        dp[i][j] = dp[i -1][j];
                    }else if(i == 0 || j == 0){
                        dp[i][j] = 0;
                    }else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        longest = Math.max(longest, dp[i][j]);
                    }
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
//        String S = "abcdefg";
//        String T = "bbcefgh";
        String S = "abcdefg";
        String T = "babcgfegh";
        System.out.println(longestCommonSubsequence.longest(S,T));
    }
}
