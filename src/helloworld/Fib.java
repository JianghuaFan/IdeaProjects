package helloworld;

public class Fib {
	public static int fibRecursion(int n) {
		if(n > 1) return fibRecursion(n-1) + fibRecursion(n-2);
		else return n;
	}
	public static int fibIterate(int n){
		int i, temp0 = 0, temp1 = 1, temp2;
		if (n == 0)
			return temp0;
		if (n == 1)
			return temp1;
		if(n <= 1)
			return 0;
		temp1 = 0;
		temp2 = 1;
		for(i = 2; i <= n; i++) {
			temp0 = temp1 + temp2;
			temp1 = temp2;
			temp2 = temp0;
		}
		return temp0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println("fibIterate:" + fibIterate(n));
//		System.out.println("fibRecursion:" + fibRecursion(n));
		
	}

}
