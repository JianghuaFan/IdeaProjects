package Sort;

import java.util.Arrays;

public class SortColor {
	public static void sortColor(int nums[]) {
		int zero = 0, one = 0, two = nums.length;
		while(one < two) {
			if(nums[one] == 0) {
				swap(nums,++zero,one++);
				//zero++;
				//one++;
			}else if(nums[one] == 2) {
				swap(nums,one,--two);
			}else {
				one++;
			}
		}		
	}
	private static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= new int[]{2,0,2,1,1,0};
		sortColor(nums);
		System.out.println(Arrays.toString(nums));
		
	}

}
