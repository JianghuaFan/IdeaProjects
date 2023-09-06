package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {
	public static String frequencySort(String s) {
		//count the frequency for each character in the string
		Map<Character,Integer> frequencyForChar = new HashMap<>();
		for(char c: s.toCharArray()) {
			frequencyForChar.put(c, frequencyForChar.getOrDefault(c, 0)+1);
		}
		//initialize a list, index is frequency and value is the list of characters 
		List<Character>[] buckets = new ArrayList[s.length()+1];
		for(char c: frequencyForChar.keySet()) {
			int f = frequencyForChar.get(c);
			if(buckets[f]==null) {
				buckets[f] = new ArrayList<>();
			}
			buckets[f].add(c);
		}
		//output the string according to the frequencies of the characters
		StringBuilder str = new StringBuilder();
		for(int i = buckets.length-1; i>=0; i--) {
			if(buckets[i] == null) {
				continue;
			}
		for(char c: buckets[i]) {
			for(int j = 0; j < i; j++) {
				str.append(c);
			}
			}
		}
		return str.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "tree";
		String s = frequencySort(str);
		System.out.println(s);

	}

}
