package doubleIndex;

public class Palindrome {
	public static boolean palindrome(String s) {
		
		for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if(s.charAt(i)!= s.charAt(j)) {
			return isPalindrome(s,i,j-1) || isPalindrome(s,i+1,j);
			}
		}
		return true;
	}
	public static boolean isPalindrome(String s , int i , int j) {
		while(i < j) {
			if( s.charAt(i++) != s.charAt(j--) ) {
				return false;
				}			
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//palindrome("abcba");
		System.out.print(palindrome("abdgba"));
	}

}
