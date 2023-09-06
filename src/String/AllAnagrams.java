package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
	public List<Integer> anagram(String sh, String lo){
		List<Integer> res = new ArrayList<>();
		
		if(sh.length() > lo.length()){
			return res;
		}		
		Map<Character, Integer> mapSh = new HashMap<>();
		for(char ch : sh.toCharArray()){
			mapSh.put(ch, mapSh.getOrDefault(ch, 0) + 1);
		}
				
		// Method 1: two HashMap
		Map<Character, Integer> mapLo = new HashMap<>();
		for(int j = 0 ; j < lo.length(); j++){
			// add one letter on the right side of the window
			mapLo.put(lo.charAt(j), mapLo.getOrDefault(lo.charAt(j), 0) + 1);

			// remove one letter from left side of the window
			if(j >= sh.length()){
				char ch = lo.charAt(j - sh.length());
				if(mapLo.get(ch) == 1) {
					mapLo.remove(ch);
				}
				else {
					mapLo.put(ch, mapLo.get(ch) - 1);
				}
			}
			if(mapSh.equals(mapLo)) {
				res.add(j - sh.length()+1);
			}
		}
//		return res;
//		
		// Method 2: one HashMap: this map record for each of the distinct character of in sh
		// how many characters are needed
		// e.g. sh = "abbc", mapSh = {'a':1, 'b':2,'c':1}
		// when we get an instance of 'a' in lo, we let count of 'a' decremented by 1, 
		// and only when the count is from 1 to 0, we have 'a' totally matched
		// Record how many distinct characters have been matched.
		// only when all distinct characters are matched, A.K.A
		// match == mapSh.size(), we find an anagram.
		int match = 0;
//		we have a sliding window of size sh.length(), and since the size is fixed, 
//		we only need to record the end index of the sliding window.
//		Also, when move the sliding window by one step from left to right, what we need to change is:
//		1. remove the leftmost character at the previous sliding window.
//		2. add the rightmost character at the current sliding window.
		for(int i = 0; i < lo.length(); i++) {
			//handle the new added character(rightmost) at the current sliding window.
			char tmp = lo.charAt(i);
			Integer count = mapSh.get(tmp);
			if(count != null) {
				// the number of needed count should be --.
				// and only when the count is from 1 to 0, we find an additional match of distinct character.
				mapSh.put(tmp, count - 1);
				count = count -1;
				if(count == 0) {
					match++;
				}
			}
			// handle the leftmost character at the previous sliding window.
			if(i >= sh.length()) {
				tmp = lo.charAt(i - sh.length());
				count = mapSh.get(tmp);
				if(count != null) {
					mapSh.put(tmp, count + 1);
					count = count + 1;
					if(count == 1) {
						match--;
					}
				}
			}
//			for the current sliding window, if all the distinct characters are matched.
//			the count are all zero.
			if(match == mapSh.size()) {
				res.add(i - sh.length() + 1);
			}
		}
		return res;
	}			
	public Map<Character, Integer> getMap(String sh){
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : sh.toCharArray()){
			map.put(ch, map.getOrDefault(ch,0) + 1);
		}
		return map;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllAnagrams ana = new AllAnagrams();
//		String lo = "abcbac";
//		String sh = "ab";
		String lo = "aaa";
		String sh = "a";
//		String lo = "ababacbbaac";
//		String sh = "aab";
		
		System.out.println(ana.anagram(sh, lo));
	}

}
