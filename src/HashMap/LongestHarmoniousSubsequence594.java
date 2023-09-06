package HashTable;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class LongestHarmoniousSubsequence594 {
	public static int longestHarmoniousSubsequence(int[] nums) {
		int longest = 0;
		Map<Integer,Integer> countForNum = new HashMap<>();
		for(int num : nums) {
			countForNum.put(num,countForNum.getOrDefault(num, 0) + 1);
			System.out.println(countForNum);
			}
		for(int num : countForNum.keySet()) {
			if(countForNum.containsKey(num + 1)) {
				longest = Math.max(longest, countForNum.get(num+1) + countForNum.get(num));
			}
		}
		return longest;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,2,2,5,2,3,7};
		System.out.println(longestHarmoniousSubsequence(nums));

	}

}
