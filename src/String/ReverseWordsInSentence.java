package String;

import java.util.Arrays;

public class ReverseWordsInSentence {
	public String reverseWords(String input) {
		if(input == null || input.length() == 0) {
			return input;
		}
		char[] inputArray = input.toCharArray();
		//step 1: reverse the whole sentence
		reverse(inputArray, 0, inputArray.length - 1);
		/**Method 1: use two pointers to find the start and end: start would be i, end would be j-1
		Method 1 is better as it can deal with several spaces in front and in end of the sentence
		*/
//		int i = 0;
//		int j = 0;	
//		while(i < inputArray.length){
//			while(j < inputArray.length && inputArray[j] != ' '){
//				j++;
//			}
//			reverse(inputArray, i, j - 1);
//			System.out.println("i:" + i + "   " + "j:" + j +Arrays.toString(inputArray));
//
//			// next circle would be starting at j+1
//			i = j+1;
//			j = j+1;
//		}
		int left = 0;
		for(int right = 0; right < inputArray.length; right++) {
			if(inputArray[right] == ' ') {
				reverse(inputArray, left, right -1);
				left = right + 1;
			}
//			System.out.println("right:" + right + Arrays.toString(inputArray));
			if(right == inputArray.length - 1) {
				reverse(inputArray, left, right);
			}
		}
		
//		Mehod 2: use one point to find start and end index
//		for(int i = 0; i < inputArray.length; i++) {
//			int start = 0;
//			//reverse each word, step 1: find start index of a word
//			if(inputArray[i] != ' ' && (i == 0) || inputArray[i-1] == ' ') {
//				start = i;
//			}
//			// find end
//			if(inputArray[i] != ' ' && (i == inputArray.length - 1) || inputArray[i + 1] == ' ') {
//				reverse(inputArray, start, i);
//			}
//		}
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
		ReverseWordsInSentence reverse = new ReverseWordsInSentence();
		String input = "me love yahoo";
		input.trim();
//		String input = "It is a good day";
		System.out.println(reverse.reverseWords(input));
	}

}
