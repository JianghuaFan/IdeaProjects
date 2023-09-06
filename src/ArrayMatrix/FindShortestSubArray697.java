package ArrayMatrix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindShortestSubArray697 {
	public static int findShortestSubArray(int [] nums) {
		//找出和原数组有相同度（某个数字出现的最多次数）的最短子数组 的长度，子数组要求是连续的子数组
		Map<Integer, Integer> degree = new HashMap<>();
		Map<Integer, Integer> firstIndex = new HashMap<>();
		Map<Integer, Integer> lastIndex = new HashMap<>();
		for(int i= 0; i < nums.length; i++){	
			int num = nums[i];
			degree.put(num, degree.getOrDefault(num, 0) + 1);			
			
			if(!firstIndex.containsKey(num)) {
				firstIndex.put(num, i);
			}else {
				lastIndex.put(num,i);
			}
			System.out.println("firstIndex of " + nums[i] + ":" + firstIndex.get(i));
			System.out.println("lastIndex of " + nums[i] + ":" + lastIndex.get(i));			
		}
		int maxFrequency = 0;
		for(int num : nums) {
			maxFrequency = Math.max(degree.get(num), maxFrequency);
		}
		System.out.println("maxFrequency:" + maxFrequency);
		int ans = nums.length;
		for(int i= 0; i< nums.length; i++){	
			int num = nums[i];
			if(degree.get(num) != maxFrequency) continue;
			ans = Math.min(ans,lastIndex.get(num) - firstIndex.get(num)+1 );
			System.out.println(num);
		}
		return ans;				
		/*方法二：数组哈希表，统计数组中不同数字出现的次数，第一次以及最后一次出现的下标即位置
		 * for(int i = 0; i< nums.length; i++) {
			if(time[nums[i]]++ == 0) {		
				first[nums[i]] = i;
				System.out.println("if : first[" + nums[i] + "]:"+first[nums[i]]);
			}
			else {
				last[nums[i]] = i;
				System.out.println("else :i:"+ i +" "+ "last[" + nums[i] + "]:"+ last[nums[i]]);
			}
			System.out.println("i:"+ i + " time[" + nums[i] + "]:" + time[nums[i]]);
			}
			int maxTime = 0, ans = Integer.MAX_VALUE;
			for(int t : time) {
				maxTime = Math.max(maxTime, t);
			}
			for(int i = 0; i < nums.length; i++) {
				if(time[i] == maxTime) {
					ans = Math.min(ans, last[i] - first[i] + 1);
				}
			}
			return ans;			
		 */	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,1,3,2,1};
		System.out.print("result:" + findShortestSubArray(nums));

	}

}
