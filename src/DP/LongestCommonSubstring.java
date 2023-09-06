package DP;
/*
176. Longest Common Substring
Medium
Find the longest common substring of two given strings.

Assumptions

The two given strings are not null
Examples

S = “abcde”, T = “cdf”, the longest common substring of S and T is “cd”
 */
import java.util.Arrays;

public class LongestCommonSubstring {
    // 以下答案是错误解，因为StringBuilder加东西时候并没有连续，所以不满足subString要求
    public String longestCommonWrong(String source, String target) {
        // Write your solution here
        // base case: source is empty or target is empty
        if(source.length() == 0 || target.length() == 0){
            return new String();
        }
        int globalMax = 0;
        StringBuilder sb = new StringBuilder();
        // off by one trick
        int[][] dp = new int[source.length()+1][target.length()+1];
        dp[0][0] = 0;
        for(int i = 0; i <= source.length(); i++){
            for(int j = 0; j <= target.length(); j++){
                // base case: source is empty or target is empty
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(source.charAt(i-1) == target.charAt(j-1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 如果出现更大的dp意味着更长的subString出现，更新dp同时更新StringBuilder
                if(dp[i][j] > globalMax){
                    globalMax = dp[i][j];
                    sb.append(source.charAt(i-1));
                }
            }
        }
        return sb.toString();
    }
    public String longestCommon(String source, String target) {
        // Write your solution here
        // base case: source is empty or target is empty
        if (source.length() == 0 || target.length() == 0) {
            return new String();
        }
        char[] sa = source.toCharArray();
        char[] ta = target.toCharArray();
        // record the longest common subString's start position in s
        int start = 0;
        int longest = 0;
        int[][] dp = new int[sa.length][ta.length];
        for (int i = 0; i < sa.length; i++) {
            for (int j = 0; j < ta.length; j++) {
                // case 1: 当前字母相同，继承前面的 。否则不需要讨论继续比较下一个
                if(sa[i] == ta[j]){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if(longest < dp[i][j]){
                        longest = dp[i][j];
                        start = i - longest + 1;
                    }
                }
            }
        }
//        return new String(sa, start, longest);
        return source.substring(start, start + longest);
    }
    public static void main(String[] args) {
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
//        String S = "abcdefg";
//        String T = "bbcefgh";
        String S = "abcde";
        String T = "cdf";
        System.out.println(longestCommonSubstring.longestCommon(S,T));
    }
}
