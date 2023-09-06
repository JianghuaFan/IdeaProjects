package String;

public class RemoveAdjacentDuplicate {
	public String removeAdjacentRepeat(String input){
		// corner case : 
		if(input == null){
			return new String();
		}
		char[] inputArray = input.toCharArray();
//		int slow = 0;
//		for(int fast = 0; fast < inputArray.length; fast++) {
//			if(fast == 0 || inputArray[fast] != inputArray[slow - 1]) {
//				inputArray[slow++] = inputArray[fast];
//			}
//		}
		int slow = 0;
		for( int fast = 0; fast < inputArray.length; fast++){
			
			//case 1: we meet duplicate letter, move fast
			if(fast == 0 || inputArray[fast] != inputArray[slow - 1]){
				inputArray[slow++] = inputArray[fast];
			}
			
		}
		return new String(inputArray, 0, slow);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveAdjacentDuplicate remove = new RemoveAdjacentDuplicate();
		String input = "a";
		System.out.print(remove.removeAdjacentRepeat(input));

	}

}
