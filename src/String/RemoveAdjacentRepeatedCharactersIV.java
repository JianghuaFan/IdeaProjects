package String;
import java.util.Deque;
import java.util.ArrayDeque;

public class RemoveAdjacentRepeatedCharactersIV {
	public String removeAdjacentDeduplicate(String input) {
		if(input == null || input.length() == 0) {
			return new String();
		}
		char[] inputArray = input.toCharArray();
//		Deque<Character> stack = new ArrayDeque<>();
//		int fast = 0;			
//		while(fast < inputArray.length) {
////			改进以下逻辑：把offer的两种情况合并
//			char curChar = inputArray[fast];
//			if(!stack.isEmpty()&& curChar == stack.peekFirst()) {
//				while(fast < inputArray.length && inputArray[fast] == curChar) {
//					fast++;
//				}
//				stack.pollFirst();
//			}else {
//				stack.offerFirst(inputArray[fast++]);
//			}
		// 改进之前：
////			if(stack.isEmpty()) {
////				stack.offerFirst(inputArray[fast++]);
////			}else {
////				if(inputArray[fast] != stack.peekFirst()) {
////					stack.offerFirst(inputArray[fast++]);
////				}else {
////					while(fast < inputArray.length && inputArray[fast] == stack.peekFirst()) {
////						fast++;
////					}
////					stack.pollFirst();
////				}	
////			} 		
//		}
//		return output(stack);
		
		// two pointers:
		int slow = 1;
		for(int fast = 1; fast < inputArray.length; ) {
			if(slow == 0 || inputArray[fast] != inputArray[slow -1]) {
				inputArray[slow++] = inputArray[fast++];
			}else {
				while(fast < inputArray.length && inputArray[fast] == inputArray[slow-1]) {
					fast++;
				}
				slow = slow -1;
			}
		}
		return new String(inputArray, 0, slow);
		
	}
	public String output(Deque<Character> stack) {
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveAdjacentRepeatedCharactersIV deDup = new RemoveAdjacentRepeatedCharactersIV();
		String input = "a";
		System.out.print(deDup.removeAdjacentDeduplicate(input));
//		deDup.removeAdjacentDeduplicate(input);
	}

}
