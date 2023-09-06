package String;

public class ReverseString {
	public String reverse(String input) {
		int left = 0;
		int right = input.length()- 1;
		char[] inputArray = input.toCharArray();
		while(left <= right) {
			swap(inputArray, left++, right--);
		}
		return new String(inputArray);		
	}
	
	public String reverseStringRecursion(String input) {		
		char[] inputArray = input.toCharArray();
		helper(inputArray, 0, input.length() - 1);
		return new String(inputArray);
	}
	
	public void helper(char[] inputArray, int start, int end) {
		if(start >= end) {
			return;
		}
		swap(inputArray, start, end);
		helper(inputArray, start + 1, end - 1);
	}
	public void swap(char[] inputArray, int i, int j) {
		char ch = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = ch;		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseString reverse = new ReverseString();
		String input = "abc";
		System.out.println(reverse.reverse(input));
		System.out.println(reverse.reverseStringRecursion(input));
	}

}
