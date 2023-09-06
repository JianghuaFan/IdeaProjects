package String;

public class RightShiftByNCharacters {
	public String rightShift(String input, int n) {
		if(input == null ||input.length() == 0 || n == 0) {
			return input;
		}
		if(n > input.length()) {
			n = n % input.length();
		}
		char[] inputArray = input.toCharArray();
		//Step 1: reverse the whole sentence
		reverse(inputArray, 0, inputArray.length - 1);
		//Step 2: reverse separate word [0,n-1] and [n,input.length()] 
		reverse(inputArray, 0, n - 1);
		reverse(inputArray, n, inputArray.length - 1);
		return new String(inputArray);		
	}
	public void reverse(char[] inputArray, int left, int right){	
		while(left <= right){
			swap(inputArray,left++, right--);
		}
	}
	public void swap(char[] inputArray, int i, int j){
		char temp = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RightShiftByNCharacters reverse = new RightShiftByNCharacters();
		String input = "";
		System.out.print(reverse.rightShift(input,2));
	}

}
