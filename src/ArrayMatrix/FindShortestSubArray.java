package ArrayMatrix;

import java.util.Arrays;

public class FindShortestSubArray {
	public static int findShortestSubArray(int[] nums) {
		int n = nums.length;
		int[] time = new int[n];
		int[] first = new int[n];
		int[] last = new int[n];
		Arrays.sort(nums);
		String str = "abc";
		time.hashCode();

		//System.out.println(time[nums[0]]++);
		for(int i = 0; i< nums.length; i++) {
			if(time[nums[i]]++ == 0) {		
				first[nums[i]] = i;
				//System.out.println("if : first[" + nums[i] + "]:"+first[nums[i]]);
			}
			else {
				last[nums[i]] = i;
				//System.out.println("else :i:"+ i +" "+ "last[" + nums[i] + "]:"+ last[nums[i]]);
			}
			//System.out.println("i:"+ i + " time[" + nums[i] + "]:" + time[nums[i]]);
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
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int i = 0;
		//if(i == 1)
			//System.out.print(1);
		//System.out.println(2);
		int[] nums = new int[] {1,2,2,3,1};
		System.out.print("result:"+findShortestSubArray(nums));
	}

}
