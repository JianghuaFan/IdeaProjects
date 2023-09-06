package ArrayMatrix;

import java.util.Arrays;

public class FindMaxConsecutiveOnes {
	public static int findMaxConsecutiveOnes(int[] array) {
	/*int answer=0;
    int count =0;
    for(int i=0; i<= nums.length; i++){
        if(i != nums.length && nums[i] == 1){
            count++ ;
            System.out.println("i:"+i +"1"+" count:"+count+" answer:"+answer);
        }else{
            if(count == 0){
            	System.out.println(0);
                continue;                
            }
            answer=Math.max(answer,count);
            count = 0;
            System.out.println("i:"+i+"0"+" count:"+count+" answer:"+answer);
        }
    }
    return answer;*/
//		int cur = 0, max = 0;
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i]==1){
//                cur++;  
////                System.out.println("i:"+i +" count:"+cur+"+个1 " + "answer:"+ max);
//            }else{              
//                cur = 0;
////                System.out.println("i:"+i +" 个0");
//            }
//            max = Math.max(cur,max);
//            System.out.println("i:"+i +" count:0" + "answer:"+ max);
//            
//        }
//        return max;
        int max = 0;
    	int cur = 0;
    	for(int i = 0; i < array.length; i++){
    		if(array[i] == 1){
    			cur++;
    			max = Math.max(cur, max);
    }else{
    	cur = 0;
    }
    }
    	return max;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,1,0,1,1,1};
		System.out.print(findMaxConsecutiveOnes(nums));
	}

}
