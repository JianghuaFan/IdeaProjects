package String;

public class DetermineIfOneStringIsAnotherSubstring {
	public int subString(String large, String small) {
		if(large == null || small == null || small.length() > large.length()){
		     return -1;
		   }
		if(small.length() > large.length()) {
			return -1;
		}
		if(small.length() == 0) {
			return 0;
		}		
		char[] smallArray = small.toCharArray();
		char[] largeArray = large.toCharArray();	
		
		for(int i = 0; i <= largeArray.length - smallArray.length; i++) {
//			int j;
			//case 1: largeArray[i] != smallArray[j] 
//			for(j = 0; j < smallArray.length; j++) {
//				if(largeArray[i+j] != smallArray[j]) {				
//					break;
//				}// case2: largeArray[i] == smallArray[j]
//			}
//			if(j == smallArray.length) {
//				return i;
//			}
//		}
		//或者这样写：
		int j = 0;
		while(j < smallArray.length && largeArray[i+j] == smallArray[j] ) {
			j++;
		}
		if(j == smallArray.length) {
			return i;
		}
				
		}
		return -1;
	}

	public boolean equals(String large, String small, int start){
		for(int j = 0; j < small.length(); j++){
			if(small.charAt(j) != large.charAt(start + j)){
				return false;
			}
		}
		return  true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetermineIfOneStringIsAnotherSubstring subString = new DetermineIfOneStringIsAnotherSubstring();
		String large = "abc";
		String small = "bc";
		System.out.print(subString.subString(large, small));
	}

}
