package String;

public class LongestPalindromicSubstring409 {
	private static int cnt =0;
	public static int longestPalindromicSubstring(String s) {
		for(int i = 0; i < s.length(); i++) {
			extendSubString(s, i, i);
			extendSubString(s,i,i+1);
		}
		return cnt;		
	}
	

	private static void extendSubString(String s, int start, int end) {
		// TODO Auto-generated method stub
		while( start >= 0 && end <s.length() && (s.charAt(start) == s.charAt(end))) {
			start --;
			end ++;
			cnt++;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(longestPalindromicSubstring("aaa"));

	}

}
