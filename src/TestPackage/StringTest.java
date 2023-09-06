package TestPackage;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer a = 5;
//		int b = 5;
//		Integer c = 128;
//		Integer d = 128;
//		System.out.println("a == b :" + (a == b) );
//		System.out.println("c == d :" + (c == d));
//		System.out.println(a.intValue());
//		System.out.println(a.valueOf(a));
//		System.out.println("ab".compareTo("abcde"));
//		String str = "  abca  ";
//		str.trim();
//		System.out.println("str.trim():" + str.trim());
//		System.out.println("str.lastIndexOf(\"a\"):" + str.lastIndexOf("a"));
//		System.out.println("str.indexOf(\"a\"):" + str.indexOf("a"));
//		int nStart = 3;
//		System.out.println("str.indexOf(\"a\")from index nStart:" + str.indexOf("a",nStart));
////		System.out.println("lastIndexOf:" + str.lastIndexOf('a', 1));
//		String input = "dodododo";
//		String source = "dod";
//		String target= "aaaa";
//		System.out.println("input.replace(source, target)" + input.replace(source, target));
//		System.out.println("input.replaceAll(source, target)" + input.replaceAll(source, target));
//		System.out.println("input.replaceFirst(source, target)" + input.replaceFirst(source, target));
//		StringBuilder sb = new StringBuilder("abc");
////		sb.insert(0, "d");
////		sb.insert(0, 'h');
////		System.out.print(sb);
//		char c1 = 'a';
//		char d1 = 'b';
//		int n = c1;
//		int i = 2;
//		char I  = (char)i;
////				(c - '0');
//		System.out.println("n:" + n);
//		System.out.println("i: " + i);
//		System.out.println("I: " + I);
//
//		Integer j = null;
//		System.out.println(j == null);
//		System.out.println(j == 0);
		String IP = "172*.16.254.1";
		System.out.println(IP);
		System.out.println(Arrays.toString(IP.split("*")));
		String stringWithEscapes = "This is a string with \"double quotes\" and a\nnew line.";
		System.out.println(stringWithEscapes);

	}
}
