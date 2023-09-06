package Greedy;

import java.util.Scanner;

public class JumpGameII {
	public static int jumpGame(int[] nums) {
/*		int n = nums.length;
//        int count = 1;
//        if (n == 1)
//            return 0;
//        int end = n - 1;
//        for (int i = n - 1; i >= 0; i--) {
//            if (nums[i] >= end - i)
//                continue;
//            count++;
//            end = i;
//        }
//        return count;
		*/
		//Greedy approach
//		int count = 0;
//	    if(nums.length == 1) {
//	        return count;
//	    }
//	    // 目前能跳到的最远位置
//	    int maxFar = 0;
//	    // 上次跳跃可达范围右边界（下次的最右起跳点）
//	    int end = 0;
//	    // 最后一个位置不需要访问。
//	    for(int i = 0; i < nums.length-1; i++) {
//	        maxFar = Math.max(maxFar, i + nums[i]);
//	        // 到达上次跳跃能到达的右边界了
//	        if(i == end) {
//	            // 更新右边界
//	            end = maxFar;
//	            count++;
//	        }
//	    }
//	    return count;
	    //BFS approach
	    int level = 0;
	    if(nums == null || nums.length < 2)
	    	return level;
	    int maxFar = 0;
	    int end = 0;
	    int i = 0;
	    while (end - i + 1 > 0) {
	    	level++;
	    	for (; i <= end; i++) {
	    		maxFar = Math.max(maxFar, nums[i] + i);	
	    		if(maxFar >= nums.length - 1)
	    			return level;
	    	}
	    	end = maxFar;
	    }
	    return 0;
	
	}  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {2,3,1,1,4};
		System.out.print(jumpGame(nums));
		Scanner scan = new Scanner(System.in);
		scan.hasNext();
	}

}
