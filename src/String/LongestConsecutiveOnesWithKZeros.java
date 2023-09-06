package String;

public class LongestConsecutiveOnesWithKZeros {
	public int longestConsecutiveOnes(int[] nums, int k) {
		if(nums == null || nums.length == 0)
			return -1;
		int slow = 0;
		int fast = 0;
		int count = 0;
		int longest = 0;
		while(fast < nums.length) {
			if(nums[fast] == 1) {
				fast++;
				longest = Math.max(fast - slow, longest);
			}else if(count < k) {
				fast++;
				count++;
				longest = Math.max(fast - slow, longest);
			}else {
				if (nums[slow] == 0) {
					count--;
				} 
				slow++;				
			}
		}
		return longest;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutiveOnesWithKZeros longestOnes = new LongestConsecutiveOnesWithKZeros();
		int[] nums = {0,0,1,1,1,0,1};
		int k = 2;
		System.out.println(longestOnes.longestConsecutiveOnes(nums, k));
	}

}
