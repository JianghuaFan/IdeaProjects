package Bit;

public class CountingBits338 {
	public static int[] countBits(int n) {
		int res[] = new int[n + 1];
		if(n == 0)
			res[0] = 0;
		//方法一：一个一个傻算
//		for(int i = 1; i < n + 1; i++) {
//			int j = 0;
//			int a = i;
//			while(a != 0) {
//				if((a & 1) == 1) j++;
//				a >>= 1;
//			}
//			res[i] = j;
//		}
//		方法二：动态规划
		for(int i = 1; i < n + 1; i++) {
			if (i%2 == 0)
				res[i] = res[i / 2];
			else
				res[i] = res[i / 2] + 1;
		}
//		方法三：动态规划二:对于数字 6(110)，它可以看成是 4(100) 再加一个 2(10)，
//		因此 dp[i] = dp[i&(i-1)] + 1; i&(i-1)去掉一位再加上1位
		for(int i = 1; i < n + 1; i++) {
			res[i] = res[i & (i - 1)] + 1;
		}
		return res;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
//		countBits(n);
		for( int i = 0; i <= n; i++) {
			System.out.print(countBits(n)[i]);
		}
		
	}

}
