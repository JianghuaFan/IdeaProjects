package String;

public class CharReplacementIIPosition {
	public String charReplacement(String input, String source, String target) {
		/**replace every String source with String target in String input
		 * case 1: no match source, just return input
		 * case 2: student -> stuXXXXt(den -> XXXX) become longer
		 * case 3: student -> stuXXt(den -> XX) become shorter
		 */
		if(input == null || input.length() == 0 || source == null || target == null) {
			return input;
		}				
		
		char[] arrayInput = input.toCharArray();
		char[] arraySource = source.toCharArray();
		char[] arrayTarget = target.toCharArray();
		//step1: calculate how long should the new String be 
		// find subString position 
		int[] position = new int[input.length() + source.length()];
		for(int i = 0; i < input.length() + source.length(); i++) {
			position[i] = -1;
		}
		int k = 0;
		int count = 0;
		//fill position array with -1. so that later we will check every position not equals -1, will be the place need to be replaced
		for(int i = arrayInput.length - 1; i >= 0; i--) {
			if(equals(input, source, i)) {
				count++;
				position[k++] = i;
			}
		}
		k = 0; 
		//case 1: no match source, just return input
		if(count == 0) {
			return input;
		}
		//case 2: become longer, target is longer than source, need to increase the size of input		
		if(source.length() < target.length()) {			
			int newLength = input.length() + (target.length() - source.length()) * count;
			char[] newArray = new char[newLength];
			int i = newLength - 1;
			int j = arrayInput.length - 1;
			//step 2: traverse String input from right to left with index j, 
			//(i, newLength - 1] would be result,(j,i] is the part processed, [0,j] is being processed
	
			while(j >= 0) {
				// from right to left, if  there is no subString or j has not arrive subString position,
				//or we have finished all the subString, copy the original character
				
				if(j > position[k]) {
					newArray[i--] = arrayInput[j--];
				}else {
					int targetLength = arrayTarget.length - 1;
					while(targetLength >= 0 && i >= 0) {
						newArray[i--] = arrayTarget[targetLength--];
					}
					j = j - arraySource.length;						
					k++;
				}				
			}	
//			if(j == 0 )
			// the whole newString is exactly what we want
			return new String(newArray);
		}
		//case 3: become shorter, target is shorter than source, no need to increase the size of input
		else {
			int i = arrayInput.length - 1;
			int j = arrayInput.length - 1;			
			while(j >= 0) {
				if(j > position[k]) {
					arrayInput[i--] = arrayInput[j--];
				}else {
					int targetLength = arrayTarget.length - 1;
					while(targetLength >= 0 && i >= 0) {
						arrayInput[i--] = arrayTarget[targetLength--];
					}
					j = j - arraySource.length;
					k++;
				}				
			}	
			// [i, end] is the part we want
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharReplacementIIPosition replace = new CharReplacementIIPosition();		
		String input = "appledogapple";
		String source = "apple";
		String target= "cat";
//		
//		String input = "laicode";
//		String source = "code";
//		String target= "offer";
////		
//		String input = "rpwkf";
//		String source = "wkf";
//		String target= "nd";
		
//		String input = "";
//		String source = "b";
//		String target= "d";
		
//		String input = "w";
//		String source = "w";
//		String target= "ab";
//		
		System.out.print(replace.charReplacement(input, source, target));
	}

}
