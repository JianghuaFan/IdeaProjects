package LaiCodeBeginner;

public class AToBPower {
	public long power(int a, int b) {
		if(b == 0)
			return 1;
		if(b == 1)
			return a;
		long z = power(a, b/2);
		if( b % 2 == 0)
			return z * z;
		if(b % 2 == 1)
			return z * z * a;
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AToBPower power = new AToBPower();
		System.out.print(power.power(2, 3));
		
	}

}
