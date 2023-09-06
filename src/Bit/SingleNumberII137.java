package Bit;

public class SingleNumberII137 {
	public static int singleNumber(int[] nums) {
//         int sum = 0;
        int res = 0;
        for( int i = 0; i < 32; i++) {
            int sum = 0;
            for( int num : nums) {
            	sum += (num >> i) & 1;
            }
//            for (int j = 0; j < nums.length; j++) {
//                sum += (nums[j] >> i) & 1;
//            }
            res |= (sum % 3) << i;
            
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,3,2};
		System.out.println(singleNumber(nums));
	}

}
