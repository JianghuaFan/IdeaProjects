package Bit;

public class NumberComplement {
	public static int numberComplement(int n) {
		if(n == 0) return 1;
//		可以利用 Java 的 Integer.highestOneBit() 方法来获得含有首 1 的数
		int mask = Integer.highestOneBit(n);
//		int mask = 1 << 30;
//	    while ((num & mask) == 0) mask >>= 1;
		mask = (mask << 1) - 1;
		return n ^ mask;
		
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.highestOneBit(5));
		System.out.print(numberComplement(5));
	}

}
