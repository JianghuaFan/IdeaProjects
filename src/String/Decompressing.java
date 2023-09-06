package String;
/*
175. Decompress String II
Hard
Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.

Assumptions

The string is not null

The characters used in the original string are guaranteed to be ‘a’ - ‘z’

There are no adjacent repeated characters with length > 9

Examples

“a1c0b2c4” → “abbcccc”
 */
public class Decompressing {
	public String decompressing(String input) {
		char[] array = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < array.length; i++) {
			char ch = array[i++];
			int count = array[i] - '0';
			for(int c = 0; c < count; c++) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	public String decompressingII(String input){
		if(input.length() <= 1){
			return input;
		}
		char[] array = input.toCharArray();
		int newLength = 0;
		for(int i = 1; i < array.length; i += 2){
			int count = array[i] - '0';
			newLength += count - 2;
		}
		char[] newArray = new char[array.length + newLength];
		int j = 0;
		for(int i = 1; i < array.length; i += 2){
			int count = array[i] - '0';
			while(count > 0){
				newArray[j++] = array[i - 1];
				count--;
			}
		}
		return new String(newArray);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Decompressing decompress = new Decompressing();
//		String input = "a6";
		String input = "x2y0i0z3";
		String result = decompress.decompressing(input);
		System.out.println(result);
		System.out.println(decompress.decompressingII(input));
	}

}
