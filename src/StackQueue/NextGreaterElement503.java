package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement503 {
	public static int[] nextGreaterElement(int[] nums) {
		int n = nums.length;
		int next[] = new int[n];
		Arrays.fill(next, -1);
		Stack<Integer> pre = new Stack<>();
		for(int i = 0; i < 2*n; i++) {
			//int num = nums[i%n];
			while(!pre.isEmpty() && nums[i%n] > nums[pre.peek()]) {
				next[pre.pop()] = nums[i%n];
			}
			if(i < n) {
			pre.add(i);
			}
		}
		return next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,1};
		System.out.println(Arrays.toString(nextGreaterElement(nums)));
	}

}
