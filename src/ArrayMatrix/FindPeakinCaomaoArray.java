package ArrayMatrix;

public class FindPeakinCaomaoArray {
	public static int findPeak(int[] nums) {
		int j = 0;
		for(int i = 0; i < nums.length - 1; i++ ) {
			if(nums[i] < nums[i + 1]) {
				j = i + 1;				
			}
			else continue;
		}
		return j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,2,1};
		System.out.print(findPeak(nums));
	}

}
