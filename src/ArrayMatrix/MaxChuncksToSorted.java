package ArrayMatrix;

public class MaxChuncksToSorted {
	public static int maxChuncksToSorted(int[] nums) {
		int ans = 0;
		int right = 0;
		for(int i = 0; i < nums.length; i++) {
			right = Math.max(right, nums[i]);
			if(right == i) {
				ans++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,2,3};
		System.out.print(maxChuncksToSorted(nums));

	}

}
