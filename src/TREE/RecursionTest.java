package TREE;

public class RecursionTest {
	static int i = 0;
	public static int xToThePowerofn(int x, int n) {
		if(n == 0)
			return x = 1;
		int t = xToThePowerofn(x, n/2);		 
		i++;
		System.out.println("i:" + i);
		if(n % 2 == 1) {
			System.out.println("n:" + n);
			System.out.println("jishu:" + t*t*x);
			int jishu = t*t*x;
			return jishu;
		}
		System.out.println("oushu:" + t*t);
		int oushu = t*t;
		return oushu;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 2, n = 5;
		xToThePowerofn(x,n);

	}

}
