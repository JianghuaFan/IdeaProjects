package ArrayMatrix;

import java.util.Arrays;

public class BeautifulArrangement {
	public static int[] constructArray(int n, int k) {
		int[] ret = new int[n];
		ret[0] = 1;
		//让前k+1(i从0到k)个元素构建出k个不同的差值，i从1到k，interval从k到1，第k+1 到 n-1 顺序加上剩余的数
		for(int i = 1,interval = k; i <= k; i++, interval--) {
			if(i%2 == 1) {
				ret[i] = ret[i-1] + interval;
			}else {
				ret[i] = ret[i-1] - interval;
			}
		}
		for(int i = k + 1; i < n; i++){
			ret[i] = i + 1;
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3, k = 2;
		System.out.print(Arrays.toString(constructArray(n,k)));
	}

}
