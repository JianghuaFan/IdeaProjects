package String;

public class CharReplacement {
	
	public String charReplacement(String input, String source, String target) {
		/**replace every String source with String target in String input
		 * case 2: student -> stuXXXXt(den -> XXXX) become longer
		 * case 1: student -> stuXXt(den -> XX) become shorter
		 */
		if(input == null || source == null || target == null || input.length() == 0) {
			return input;
		}		
		char[] arrayInput = input.toCharArray();
		char[] arraySource = source.toCharArray();
		char[] arrayTarget = target.toCharArray();
				 
		//case 1: become longer, target is longer than source, need to increase the size of input		
		if(source.length() < target.length()) {
			//step1: calculate how long should the new String be 
			int count = 0;
			for(int i = arrayInput.length - 1; i >= source.length() - 1; i--) {
				if(equals(input, source, i)) {
					count++;					
				}
			}			
			int newLength = input.length() + (target.length() - source.length()) * count;
			char[] newArray = new char[newLength];
			int i = newLength - 1;
			int j = arrayInput.length - 1;
			//step 2: traverse String input from right to left with index j, 
			//(i, newLength - 1] would be result,(j,i] is the part processed, [0,j] is being processed
			while(j >= 0) {				
				if(!equals(input,source,j) && i >= 0) {
					newArray[i--] = arrayInput[j--];					
				}else {
					int targetLength = arrayTarget.length - 1;
					while(targetLength >= 0 && i >= 0) {
						newArray[i--] = arrayTarget[targetLength--];
					}
					j = j - arraySource.length;
				}
			}					
			// the whole newString is exactly what we want
			return new String(newArray);
		}
		//case 2: case 2: become shorter, target is shorter than source, no need to increase the size of input
		else {
			int i = arrayInput.length - 1;
			int j = arrayInput.length - 1;
			while(j >= 0) {				
				if(!equals(input,source,j) && i >= 0) {
					arrayInput[i--] = arrayInput[j--];
				}else {
					int targetLength = arrayTarget.length - 1;
					while(targetLength >= 0 && i >= 0) {
						arrayInput[i--] = arrayTarget[targetLength--];
					}
					j = j - arraySource.length;
				}				
			}
			// (i, end] is the part we want
			return new String(arrayInput, i+1, arrayInput.length - i -1);
		}		
	}

	public boolean equals(String input, String source, int start) {
		for(int j = source.length() - 1; j >= 0; j--) {
			if(start < source.length() - 1) {
				return false;
			}
			int indexInInput = start -(source.length()-1 - j);
			if(indexInInput >= 0 && input.charAt(indexInInput) != source.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
	public int subString(String input, String source) {		
		int count = 0;
		int i = input.length() - 1;		
		for(; i >= source.length() - 1; i--) {
			if(equals(input, source, i)) {				
				count++;
				System.out.println("match position:" + i);
				System.out.println("count:" + count);
				return i;
			}
		}		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharReplacement replace = new CharReplacement();
//		String input = "appledogapple";
//		String source = "apple";
//		String target= "cat";
		
//		String input = "laicode";
//		String source = "code";
//		String target= "offer";
		
//		String input = "rpndrudwkfeqyr";
//		String source = "wkfeqyr";
//		String target= "nd";
//		
//		String input = "aaaaa";
//		String source = "aa";
//		String target= "bbb";
		
		String input = "dodododo";
		String source = "dod";
		String target= "aaaa";		
//		System.out.println(replace.charReplacement(input, source, target));
		
		System.out.println(replace.subString(input, source));
//		System.out.println(new String(testA, 1,1));
	}

}
