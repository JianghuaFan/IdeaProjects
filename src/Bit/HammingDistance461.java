package Bit;

public class HammingDistance461 {
	public static int hammingDistance(int x, int y) {
		int z = x^y;
		int cnt = 0;
//		方法一 移位操作 与1，统计多少个1
		while(z != 0) {
			if ((z & 1) == 1) cnt++;
			z = z >> 1;
		}
//		方法二 ： z & (z - 1) 去除最低位的1
//		while(z != 0) {
//			z &= z-1;
//			cnt++;
//		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = 8, b = 1;
//		System.out.println(a.byteValue());
//		System.out.println(Integer.bitCount(a));
		System.out.println(Integer.highestOneBit(a));
		System.out.println(hammingDistance(a, b));
		System.out.println(Integer.bitCount(a ^ b));
		System.out.println(Integer.toBinaryString(-5));

	}

}
