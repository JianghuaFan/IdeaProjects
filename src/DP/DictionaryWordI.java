package DP;

import java.util.HashSet;
import java.util.Set;

public class DictionaryWordI {
	public boolean canBreak(String input, String[] dict) {
		   // Write your solution here
		//Assumptions:
//		input is not null or empty.
//		dict is not null or empty,
//		all the strings in dict are not null or empty
		Set<String> dictSet = toSet(dict);
		if(input == null || input.length() == 0 || dict == null || dict.length == 0){
				return false;
		}		
		int n = input.length();
		boolean[] canBreak = new boolean[n+1];		
		canBreak[0] = true;	
		//Notice: sometimes it will be handy to have such index matching, 
//		canBreak[i] represents index (i-1) in input, 
//		also can represent the substring(0,i);
		for(int i = 1; i < canBreak.length; i++){
			for(int j = 0; j < i; j++){
				if(canBreak[j] && dictSet.contains(input.substring(j,i))) {
					canBreak[i] = true;
					break;
				}
			}
		}
		return canBreak[n];
		
		
//		int n = input.length();
//		boolean[] canBreak = new boolean[n + 1];
//		canBreak[0] = true;
//		Set<String> dictSet = toSet(dict);
//		for(int i = 1; i <= n; i++){
//			for(int j = 0; j < i; j++){
//				if(canBreak[j] && dictSet.contains(input.substring(j,i)))
//					canBreak[i] = true;
////					break; 
//			}
//		}
//		return canBreak[n];
	}				

	private Set<String> toSet(String[] dict) {
		// TODO Auto-generated method stub
		Set<String> dictSet = new HashSet<>();
		for(String str : dict) {
			dictSet.add(str);
		}
		return dictSet;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DictionaryWordI dic = new DictionaryWordI();
		String input = "bobcatrob";
		String[] dict = {"bob","cat","rob"};
		System.out.print(dic.canBreak(input, dict));
	}

}
