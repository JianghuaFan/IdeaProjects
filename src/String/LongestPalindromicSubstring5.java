package String;

public class LongestPalindromicSubstring5 {
	public static String longestPalindrome(String s) {
        /*方法一：遍历法
         int start = 0, end = 0;
         for(int i = 0; i < s.length(); i ++){
            int len1 = PalindromeExtend(s,i,i);
            int len2 = PalindromeExtend(s,i,i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
               start = i - (len-1)/2;
               end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
        
    }
    public static int PalindromeExtend(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
        	--start;
            ++end;
        }
        System.out.println("start:" + start + "end:" +end);
        return end - start - 1;
        */
		//方法二：DP法https://leetcode.com/problems/longest-palindromic-substring/discuss/2156691/Simple-DP-Solution-or-JAVA-Explained
		int start = 0, end = 0;
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		for(int len = 0; len < n; len++) {// len是最长回文子字符串的长度
			for(int i = 0; i+len < n; i++) {
				dp[i][i+len] = s.charAt(i) == s.charAt(i+len) && (len <2 || dp[i+1][i+len-1]);
				if(dp[i][i+len] && len > end - start) {
					start = i;
					end = i + len;
				}
			}
		}
		System.out.println("start:" + start + "end:" +end);
		return s.substring(start,end+1);
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "babad";
		System.out.print(longestPalindrome(s));

	}

}
