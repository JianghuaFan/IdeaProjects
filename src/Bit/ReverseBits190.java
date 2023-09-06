package Bit;

public class ReverseBits190 {
	public static int reverseBit(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			
			if ( (n & 1) == 1)
				res = (res << 1) + 1;
			else
				res = res << 1;
			n >>>= 1; 
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseBit(5));
		System.out.println(reverseBit(2));
		System.out.println(reverseBit(43261596));
	}

}
