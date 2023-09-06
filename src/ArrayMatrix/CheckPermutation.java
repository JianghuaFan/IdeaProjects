package ArrayMatrix;

import java.util.Arrays;

public class CheckPermutation {
	public static boolean checkPermutation(String s, String t) {
		if(s.length() != t.length())
			return false;
		
		if (sort(s).equals(sort(t)))
			return true;
		return false;
	}
	public static String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
		}

	public static void main(String[] arg) {
		String s = "abc";
		String t = "bca ";
		System.out.print(checkPermutation(s,t));
//		int[] a = new int[3] {};
	}
}
