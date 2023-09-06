package String;

public class RemovePalindromeSubSequence1332 {
	public static int removePalindromeSubSequence(String s) {
		//You are given a string s consisting only of letters 'a' and 'b'. In a single step you can remove one palindromic subsequence from s.
		//Return the minimum number of steps to make the given string empty.
		int start = 0, end = s.length()-1;
		if(s.length() == 0) {
			return 0;
		}
		while(start < end){
			if(s.charAt(start) == s.charAt(end)) {
				start++;
				end --;
			}
			else return 2;			
		}
		return 1;		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		String t = "abba";
		String r = "aaba";
		System.out.println(removePalindromeSubSequence(s));
		System.out.println(removePalindromeSubSequence(t));
		System.out.println(removePalindromeSubSequence(r));

	}

}
