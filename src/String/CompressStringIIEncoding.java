package String;

import java.util.Arrays;

public class CompressStringIIEncoding {
	public String compress(String input) {
		//step 1: traverse the String input to find all the single character, count them to increase the size  
		if(input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		return encode(array);
	}
	public String encode(char[] array) {		
		//step1: deal with letters adjacent occur more than one time, from left to right direction
		int slow = 0;
		int fast = 0;
		int newLength = 0;
		while(fast < array.length) {
			int begin = fast;
			while(fast < array.length && array[fast] == array[begin]) {
				fast++;
			}
			array[slow++] = array[begin];
			if(fast - begin == 1) {
				//e.g. "abb",newLength need "a1bb",for"a",it need extra one space except itself
				newLength += 2;
			}else {
				int count = fast - begin;				
				int len = copyDigit(array, slow, count);
				slow += len;
				//e.g. "abb",newLength need "a1b2",for"b", it need 1("b" self) + len
				newLength += len + 1;				
			}			
		}		
		// step2: deal with letters occur only once, from right to left direction
		char[] result = new char[newLength];
		fast = slow - 1;
		slow = newLength - 1;		
		while(fast >= 0) {
			if(Character.isDigit(array[fast])) {
				while(fast >= 0 && Character.isDigit(array[fast])) {
					result[slow--] = array[fast--];
				}
			}else {
				result[slow--] = '1';
			}
			result[slow--] = array[fast--];			
		}
		return new String(result);
	}	
	
	//copy "count" as digits into "input", starting at "index"
	public int copyDigit(char[] input, int index, int count) {
		int len = 0;
		//先算count需要多少位
		for(int i = count; i >0; i /= 10) {
			len++;
			index++;
		}
		for(int i = count; i > 0; i /= 10) {
			int digit = i % 10;			
			input[--index] = (char)(digit +'0');			
		}
		return len;
	}

//	private int countSingle(String input) {
//		// TODO Auto-generated method stub
//		int count = 0;
//		int n = input.length();
//		if(input.charAt(0) != input.charAt(1)) {
//			count++;
//		}
//		for(int i = 1; i < n - 1; i++) {			
//			if(input.charAt(i) != input.charAt(i-1) && input.charAt(i) != input.charAt(i+1)) {
//				count++;
//			}
//		}
//		if(input.charAt(n - 1) != input.charAt(n - 2)) {
//			count++;
//		}
//		return count;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompressStringIIEncoding compress = new CompressStringIIEncoding();
//		System.out.println(compress.countSingle("abbcccdeee"));
//		char[] input = {'a','a','a'};
//		int index = 1;
//		int count = 12;
//		System.out.println(compress.copyDigit(input, index, count));
//		System.out.println(new String(input));
//		String input = "abc";
		String input = "accc";
		String result = compress.compress(input);
		System.out.println(result);
		
	}

}
