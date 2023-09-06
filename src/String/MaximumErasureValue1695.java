package String;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue1695 {
	public static int maxiErasureValue(int[] nums) {
	Set<Integer> uniqueInteger = new HashSet<>();
    int maxScore = 0;
    int curScore = 0;
    for(int end = 0, start = 0; end < nums.length; end++){
            while(!uniqueInteger.add(nums[end])){
            	curScore -= nums[start];
            	uniqueInteger.remove(nums[start++]);       
            }  
            System.out.println("else---start:" + start +" " +"end:"+ end +" " +"maxScore:" +  maxScore +" " + "curScore:"  +" "+ curScore);
            curScore += nums[end];
            maxScore = Math.max(maxScore, curScore);
        }
        System.out.println(uniqueInteger);
    return maxScore;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int[] nums = {4,2,4,5,6};
    System.out.print("result:"  + maxiErasureValue(nums));
	}

}
