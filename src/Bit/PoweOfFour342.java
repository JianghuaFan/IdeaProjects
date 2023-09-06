package Bit;

public class PoweOfFour342 {
	public static boolean isPowerOfFour(int n) {
//		return n > 0 && (n &(n - 1)) == 0 && (n & 0b01010101010101010101010101010101) != 0;
		return Integer.toString(n, 4).matches("10*");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 16, m = 1;
		System.out.println("16 is power of four:" + isPowerOfFour(n));
		System.out.println("1 is power of four:" + isPowerOfFour(m));
		System.out.println("32 toString(n, 4):" + Integer.toString(n, 4));
	}

}
