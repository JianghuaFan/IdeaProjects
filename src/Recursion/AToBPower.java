package Recursion;

public class AToBPower {
	public double aToBPower(int a, int b) {
		if(a == 0) {
			if(b < 0) {
				System.out.print("error");
				return -1;
			}
		}
		if(b == 0) {
			return 1;
		}
		if(b >= 0) {
			return helper(a, b);
		}
		else {
			return 1 / (double)helper(a, -b);
		}
		 
	}
	
	public int helper(int a, int b) {
		if(b == 0) {
			return 1;
		}
		int half = helper(a, b/2);
		if(b%2 == 1) {
			return half * half;
		}else {
			return half * half * a;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AToBPower power = new AToBPower();
		int a = 2; 
		int b = 2;
		System.out.print(power.aToBPower(a, b));
	}

}
