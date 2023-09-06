package helloworld;

import java.util.Arrays;

public class ActualParameter {	

		public static void main(String[] args) {
			int num =  1;
			int[] nums = {1};
			System.out.println(num);
			System.out.println(Arrays.toString(nums));
			change(num);
			change(nums);
			System.out.println(num);
			System.out.println(Arrays.toString(nums));			
			 int[] a = nums;
			 System.out.println(Arrays.toString(nums));
			 System.out.println(Arrays.toString(a));

			 nums[0] = 2;
			 System.out.println(Arrays.toString(nums));
			 System.out.println(Arrays.toString(a));
			
}
		public static void change(int num1) {
			num1 = 10;
		}
		public static void change(int[] num1) {
			num1[0] = 10;
		}
	
}
