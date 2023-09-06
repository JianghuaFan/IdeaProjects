package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
	/*
	public static int longestConsecutive(int[] nums) {
	    Map<Integer, Integer> countForNum = new HashMap<>();
	    for (int num : nums) {
	        countForNum.put(num, 1);
	    }
	    for (int num : nums) {
	        forward(countForNum, num);
	    }
	    return maxCount(countForNum);
	}

	private static int forward(Map<Integer, Integer> countForNum, int num) {
	    if (!countForNum.containsKey(num)) {
	        return 0;
	    }
	    int cnt = countForNum.get(num);
	    if (cnt > 1) {
	        return cnt;
	    }
	    cnt = forward(countForNum, num + 1) + 1;
	    countForNum.put(num, cnt);
	    return cnt;
	}

	private static int maxCount(Map<Integer, Integer> countForNum) {
	    int max = 0;
	    for (int num : countForNum.keySet()) {
	        max = Math.max(max, countForNum.get(num));
	    }
	    return max;
	}
	/*HashSet h : key
	check whether h contains key-1 or not
	if not, key is a lower bound, check key+1, key+2, until key +l is not in h, 
	key ~ key +l in h, length is l.
	Find the max of ls
	*/
	public static int longestConsecutive(int[] nums) {
		int ans = 0;
		Set<Integer> h = new HashSet<>();
		for(int num : nums) {
			h.add(num);
		}
		for(int num : nums) {
			if(!h.contains(num -1)) {
				int l = 0;
				while(h.contains((num++))) ++l;
				ans = Math.max(ans, l);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {100,4,200,1,3,2};
		System.out.println(longestConsecutive(nums));
	}

}
