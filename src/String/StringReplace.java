package String;

import java.util.ArrayList;
import java.util.List;

public class StringReplace {
//	public String replace(String input, String source, String target) {
//		   // Write your solution here
//		/**replace every String source with String target in String input		 	*/
//		if(input == null || input.length() == 0 || source == null || target == null) {
//			return input;
//		}   
//		char[] arrayInput = input.toCharArray();
//		   
//		// Method 1:  Not use any String/StringBuilder utility, and use char[] to do it "in place"
//		if(source.length() < target.length()) {
//		   return becomeLonger(arrayInput, source, target);
//		}
//		else{
//		   return becomeShorter(arrayInput, source, target);
//		}
//	}
//	//case 1: student -> stuXXXXt(den -> XXXX) become longer
//	public String becomeLonger(char[] arrayInput, String source, String target){
//		//case 1: target is longer than source, need to increase the size of input    
//		// find all the matches end positions in the inputArray 	
//		
//		List<Integer> matches = getAllMatches(arrayInput, source);	
//		
//		//step1: calculate how long should the new String be	
//		int newLength = arrayInput.length + matches.size() * (target.length()- source.length());
//		char[] newArray = new char[newLength];
//		
//		// fast and slow pointers both from right to left.
//		// slow: the position when traversing the new length
//		// fast: the position when traversing the old length
//		// lastIndex : the rightmost matching end positions's index
//		
//		int lastIndex = matches.size() - 1;
//		int slow = newLength - 1;
//		int fast = arrayInput.length - 1;
//		
//		while(fast >= 0) {
//			// only when we still have some matches and 
//			//fast is in the position of rightmost matching end position, we should copy target
//			if(lastIndex >= 0 && fast == matches.get(lastIndex)) {
//				copyString(newArray, slow - target.length() + 1 ,target);
//				fast = fast - source.length();
//				slow = slow - target.length();
//				lastIndex--;
//			}else {
//				newArray[slow--] = arrayInput[fast--];
//			}
//		}				
//		return  new String(newArray);
//	}
//	
//	// We reuse the input char array since the number of characters needed is less
//	// both left and right pointers from left to right direction
//	//case 2: student -> stuXXt(den -> XX) become shorter
//	public String becomeShorter(char[] arrayInput, String source, String target){
//		int slow = 0;
//		int fast = 0;
//		while(fast < arrayInput.length){
//			if(fast <= arrayInput.length - source.length() && equals(arrayInput, source, fast)){
//				copyString(arrayInput, slow, target);
//				slow = slow + target.length();
//				fast = fast + source.length();
//			}
//			else{
//				arrayInput[slow++] = arrayInput[fast++];
//			}
//		}
//		return new String(arrayInput, 0, slow);
//  }
//	
//	//check whether source exists in arrayInput at index start
//	public boolean equals(char[] arrayInput, String source, int start){
//		for(int i = 0; i < source.length(); i++){
//			if(arrayInput[start + i] != source.charAt(i)){
//			return false;
//			}
//		}
//		return true;		
//	}
//	
//	// copy the string target to result at fromIndex
//	public void copyString(char[] result, int fromIndex, String target) {
//		for(int i = 0; i < target.length(); i++){
//			result[fromIndex+i] = target.charAt(i);
//		}
//	}
//	
//	//get all the matches of source end positions in input
//	private List<Integer> getAllMatches(char[] arrayInput, String source) {
//		// TODO Auto-generated method stub
//		List<Integer> allMatches = new ArrayList<>();
//		int i = 0;
//		while(i <= arrayInput.length - source.length()){
//			if(equals(arrayInput, source, i)) {
//				allMatches.add(i+source.length()-1);
//				i = i + source.length();
//			}else {
//				i++;
//			}
//			
//		}
//		return allMatches;
//	}
	
	//Method 2: Using Java's StringBuilder utility and String's indexof().
	// not using String's replace()
	public String replace(String input, String source, String target) {
		// Assumptions: input, source, target are not null, source is not empty
		StringBuilder sb = new StringBuilder();
		// We check if there exsits a substring same as source in the substring of input starting at fromIndex
		int fromIndex = 0;
		int matchIndex = input.indexOf(source, fromIndex);
		while(matchIndex != -1) {
			//把input里从fromIndex到matchIndex（exclusive）添加到sb上，再添加target
			sb.append(input, fromIndex, matchIndex).append(target);
			//next time we need to start from matchIndex + source.length() to find if we have later matches
			fromIndex = matchIndex + source.length();
			matchIndex = input.indexOf(source,fromIndex);		
		}
		sb.append(input, fromIndex, input.length());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringReplace replace = new StringReplace();		
//		String input = "appledogapple";
//		String source = "apple";
//		String target= "catcat";
		String input = "aaaaa";
		String source = "aa";
		String target= "bbb";
		System.out.print(replace.replace(input, source, target));
	}

}
