package String;

public class IsPalindromeNumber {
	public static boolean isPalindromeNumber(int n) {
		if(n == 0) return true;
		else if(n < 0 || n % 10 == 0) return false;
		/* 方法二int originNum = n;
		int reverseNum = 0;
		int remainder;
		while(n != 0) {
			remainder = n % 10;
			reverseNum = reverseNum *10 + remainder;
			n /= 10;
		}
		return (reverseNum == originNum);
		*/
		int right = 0;
		while(n > right) {
			right = right*10 + n%10;
			n /= 10;
		}
		return(n==right || n/10 == right);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isPalindromeNumber(12321));

	}

}
