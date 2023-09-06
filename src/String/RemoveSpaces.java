package String;

public class RemoveSpaces {
//	Given a string, remove all leading/trailing/duplicated empty spaces.
//	Assumptions:
//	The given string is not null.
//	Examples:
//	“  a” --> “a”
//	“   I     love MTV ” --> “I love MTV”
	public String removeSpaces(String input) {
		   // Write your solution here
		if(input == null){
			return new String();
		}
		char[] inputArray = input.toCharArray(); 
		int slow = 0;		 
		 
		for(int fast = 0; fast < inputArray.length; fast++){
//			laiCode 答案：
			if(inputArray[fast] == ' ' && (fast == 0 || inputArray[fast - 1] == ' ')) {
				continue;
			}
			inputArray[slow++] = inputArray[fast];
//			//case 1: space in the leading
//			if(inputArray[fast] == ' '&& slow == 0){
//				continue;	
//			}
//			//case 2: character
//			else if(inputArray[fast] != ' '){
//				inputArray[slow] = inputArray[fast];
//				slow++;
//			}
//			//case 3: space after a character
//			else if(inputArray[fast] == ' ' && (fast - 1) >= 0 && inputArray[fast-1] != ' '){
//				inputArray[slow] = inputArray[fast];
//				slow++;	
//			}	
		}
		if(slow  > 0 && inputArray[slow -1] == ' '){
			slow = slow - 1;
		}
		return new String(inputArray, 0, slow);		 
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String input = "  I  love MTV ";
//		String input = "";
		String input = "  I LOVE  YAHOO  ";
		RemoveSpaces remove = new RemoveSpaces();
		System.out.print(remove.removeSpaces(input) + "test");

	}

}
