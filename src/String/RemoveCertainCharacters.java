package String;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
	public String remove(String input, String t) {
		if(t == null) {
			return input;
		}
//		char[] tCharArray = t.toCharArray();
//		char[] inputArray = input.toCharArray();
//		Set<Character> tCharSet = new HashSet<>();
//		for(char ch : tCharArray) {
//			tCharSet.add(ch);
//		}
//		int slow = 0;
//		int fast = 0;			
//		for(char inputCh : inputArray) {			
//			while(fast < inputArray.length) {
//				if(tCharSet.contains(inputArray[fast])) {
//					fast++;
//				}else {
//					inputArray[slow] = inputArray[fast];
//					slow++;
//					fast++;
//				}
//			}			
//		}		
//	
//		return new String(inputArray,0,slow);	
		char[] inputCharArray = input.toCharArray();
	    char[] tCharArray = t.toCharArray();
	    int slow = 0;
	    
	    Set<Character> tCharSet = new HashSet<>();
	    for(char tChar : tCharArray){
	      tCharSet.add(tChar);
	    }
//	    for(char inputChar : inputCharArray){
//	      if(fast < inputCharArray.length){
//	        if(tCharSet.contains(inputChar)){
//	          fast++;
//	        }else{
//	          inputCharArray[slow] = inputCharArray[fast];
//	          slow++;
//	          fast++;
//	        }
//	      }
//	    }
	    for( int fast = 0; fast < inputCharArray.length; fast++) {
	    	if(!tCharSet.contains(inputCharArray[fast])){
	    		inputCharArray[slow++] = inputCharArray[fast];
	    	}	    
	    }
	    return new String(inputCharArray, 0, slow);
	}
	    


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveCertainCharacters remove = new RemoveCertainCharacters();
		String input = "abcdefg";
		String t = "af";
		System.out.print(remove.remove(input, t));
	}

}
