package String;

public class AToI {
	public int aToI(String str) {
		//case 1: null or empty
		if(str == null || str.length() == 0) {
			return 0;
		}
		// case 2: leading or trailing spaces 
//		str = str.trim();
		//或者用以下方法：
		int i = 0;
		while(i < str.length() && str.charAt(i) == ' ') {
			i++;
		}
		boolean positive = true;
		long number = 0;
		
		// case 3: sign + or -
		
		if(i< str.length() &&  str.charAt(i) == '-' || str.charAt(i) == '+') {
			positive = (str.charAt(i) == '+');
			i++;
		}		
			// case 4: non number, if after number just ignore, if before number
//			if(str.charAt(i) < '0' ||  str.charAt(i) > '9' ) {
//				if(seenNumber) {
//					break;
//				}
//			}
//			// case 4.1: space, if after number juststop, if before number continue
//			if(str.charAt(i) == ' ' && seenNumber) {				
//					break;				
//			}
			// case 5: number
		while(i < str.length() && str.charAt(i) >= '0' &&  str.charAt(i) <= '9' ) {
			number = number * 10 + (str.charAt(i) - '0');										
			if(!positive && -number < (long)Integer.MIN_VALUE) {//case 5.1: overflow an integer
				return Integer.MIN_VALUE;
			}
			if(positive && number > (long)Integer.MAX_VALUE) {//case 5.2: overflow an integer
				return Integer.MAX_VALUE;
			}
			i++;
		}		
		number = positive ? number : -number;
		return (int)number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AToI aToI = new AToI();
//		String str = " -1 23b";
//		String str = "  -12345678901234567";
		String str = "  56+67 ";
		System.out.print(aToI.aToI(str));
	}

}
