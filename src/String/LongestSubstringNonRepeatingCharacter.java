package String;
import java.util.Set;
import java.util.HashSet;
public class LongestSubstringNonRepeatingCharacter {
	public int longest(String input) {
		if(input == null || input.length() == 0) {
			return 0;
		}
		int slow = 0;
		int fast = 0;
		int longest = 0;
		Set<Character> set = new HashSet<>();
		while(fast < input.length()) {
			if(set.contains(input.charAt(fast))) {
				set.remove(input.charAt(slow));
				slow++;
			}else {
				set.add(input.charAt(fast++));
				longest = Math.max(fast - slow, longest);
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringNonRepeatingCharacter longest = new LongestSubstringNonRepeatingCharacter();
		String input = "BBDEB";
		System.out.print(longest.longest(input));
	}

}
