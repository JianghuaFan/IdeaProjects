package String;

public class AbbreviationMatching {
	public boolean match(String input, String pattern) {
//		//Method 1: iterate
//		//corner case 1: both are null, true
//		if(input == null && pattern == null) {
//			return true;
//		}//corner case 2： only one is null or input is shorter than pattern, false
//		else if( input == null || pattern == null || pattern.length() > input.length() ) {
//			return false;
//		}
//		//corner case 3: both are empty
//		if(pattern.length() == 0 && input.length() == 0) {
//			return true;
//		}else if ( pattern.length() == 0 || input.length() == 0) {
//			return false;
//		}
//		char[] inputArray = input.toCharArray();
//		char[] patternArray = pattern.toCharArray();
//		int i = 0;
//		int j = 0;
//		while(i < inputArray.length && j < patternArray.length) {
//			// case 1: if pattern is letter, input must be same as pattern
//			if(!Character.isDigit(patternArray[j]) && ((inputArray[i]) !=  patternArray[j] ) ) {
//				return false;
//			} 
//			//case 2 : both are letter and same, continue
//			else if(!Character.isDigit(patternArray[j]) && ((inputArray[i]) ==  patternArray[j] )) {
//				i++;
//				j++;
//			}
//			// case 3: pattern is number, must find the same count of letters in input
//			else{
//				int number = 0;
//				while(j < pattern.length() && Character.isDigit(pattern.charAt(j))) {
//					number = number * 10 + (pattern.charAt(j) - '0');
//					j++;
//				}
//				i += number;
//			}			
//		}
//		return i == inputArray.length &&  j == patternArray.length;
//	}
//	Method 2: recursion
		// assumption: input pattern are not null	
		return match(input, pattern, 0, 0);
	}
	public boolean match(String input, String pattern, int i, int j) {
		//base case:
		if(i == input.length() && j == pattern.length()) {
			return true;
		}
		if(i >= input.length() || j >= pattern.length()) {
			return false;
		}
		if(pattern.charAt(j) < '0' || pattern.charAt(j) > '9') {
			if(pattern.charAt(j)  != input.charAt(i)) {
				return false;
			}
			i++;
			j++;
			return match(input, pattern, i,j);
		}		
		int number = 0;
		while(j < pattern.length() && pattern.charAt(j) >= '0' && pattern.charAt(j) <= '9') {
			number = number *10 + (pattern.charAt(j) - '0');
			j++;
		}
		i = i + number;
		return match(input, pattern, i, j);
		
	}
	public int getNumberInString(String pattern, int j) {
		int number = 0;
		while(j < pattern.length() && Character.isDigit(pattern.charAt(j))) {
			number = number * 10 + (pattern.charAt(j) - '0');
			j++;
		}
		return number;
	}
	
	public void testIfElseInWhile() {
		int i = 0;
		while(i < 2) {
			if(i == 0) {
				System.out.println("i0: " + i);
				i++;
			}
			else if (i == 1){
				System.out.println("i1: " + i);
				i++;
			}else {
				System.out.println("i2: " + i);
				i++;
			}			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbbreviationMatching match = new AbbreviationMatching();
//		String input = "book";
//		String pattern = "b2k";
		String input = "apple";
		String pattern = "2p2";
//		String input = "soood";
//		String pattern = "s111d";
//		String input = "laioffercom";
//		String pattern = "l10";
		
		System.out.println(match.match(input, pattern));
		
//		match.testIfElseInWhile();		
//		System.out.println(match.getNumberInString(pattern, 1));
		
	}

}
