package DP;
/*
0 1 1 2 3 5
 */
public class Fibonacci {
	public long fibonacci(int K) {
		if(K < 0){
			return 0;
		}
//		long[] array = new long[K+1];
//		array[1] = 1;
//		for(int i = 2; i <= K; i++){
//			array[i] = array[i-1] + array[i-2];
//		}
//		return array[K];
		long a = 0;
		long b = 1;
		long res = 0;
		for(int i = 2; i <= K; i++) {
			res = a + b;
			a = b;
			b = res;
		}
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci f = new Fibonacci();
		int K = 4;
		System.out.print(f.fibonacci(K));
	}

}
