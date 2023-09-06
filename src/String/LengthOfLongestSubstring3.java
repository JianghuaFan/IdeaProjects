package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring3 {
	public static int lengthOfLongestSubstring(String s) {
		/*方法一：
		 * Input: s = "abcabcbb"
			Output: 3
			Explanation: The answer is "abc", with the length of 3
        int max = 0, i = 0, j = 0;
        while(j < s.length()){
            uniqueCharacter.put(s.charAt(j),uniqueCharacter.getOrDefault(s.charAt(j),0)+1);
            if(uniqueCharacter.size() == j - i + 1){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else if(uniqueCharacter.size() < j - i + 1){
                while(uniqueCharacter.size() < j - i + 1){
                uniqueCharacter.put(s.charAt(i),uniqueCharacter.get(s.charAt(i)) - 1);
                if(uniqueCharacter.get(s.charAt(i)) == 0){
                    uniqueCharacter.remove(s.charAt(i));
                }
                    i++;
                }
                j++; 
            }
            }
        return max; 
        */
		Set<Integer> integer = new HashSet<>();
		
		Set<Character> uniqueCharacter = new HashSet<>();
		int start = 0, end = 0;
		int maxLength = 0;
		if(s.equals(" ")|| s == null) {
			return 0;			
		}
		while(end < s.length()) {
			if(uniqueCharacter.add(s.charAt(end))) {
				maxLength = Math.max(uniqueCharacter.size(), maxLength);
				end++;
			}else{
				uniqueCharacter.remove(s.charAt(start));
				start++;
			}
		}
		return maxLength;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "pwkew";
		System.out.print(lengthOfLongestSubstring(s));

	}

}
