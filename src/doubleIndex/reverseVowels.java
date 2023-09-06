package doubleIndex;
import java.util.HashSet;
import java.util.Arrays;

public class reverseVowels {
	public static HashSet<Integer> n = new HashSet<Integer>('1','0');
	//n.add('0');
	//Arrays.asList('0','1')
	private static final HashSet<Character> vowels = new HashSet<>(
			Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
	public static String reverseVowels1(String s) {
		if(s == null) return null;
		int i = 0, j = s.length()-1;
		char[] result = new char[s.length()];
		while(i <= j ) {
			char ci = s.charAt(i);
			char cj = s.charAt(j);
			if(!vowels.contains(ci)) {
				result[i++] = ci;
				
			}
			else if(!vowels.contains(cj)) {
				result[j--] = cj;
				
			}else {
				result[i++] = cj;
				result[j--] = ci;
			}
		}
		System.out.print('c'+"\n");
		System.out.print(result);
		return new String(result);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println('a');
		String s = "leetcode";
		System.out.println('b');
        reverseVowels1(s);
        //System.out.println(s);
        System.out.print('d');       
        
	}

}
