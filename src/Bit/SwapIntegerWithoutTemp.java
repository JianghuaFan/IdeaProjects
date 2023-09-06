package Bit;

public class SwapIntegerWithoutTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2, b = 3;
		System.out.println("a:" + a);
		System.out.println("b:" + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a:" + a);
		System.out.println("b:" + b);
	}

}
