package DP;

public class ArrayHopperII {
	public int minJump(int[] array) {
		   // Write your solution here
		int[] M = new int[array.length];
	// Method1: from right to left direction
//		M[array.length -1] = 0;
////		
////		if there is any M[j],which is not -1, 
////		then calculate a  minimum of all the M[j], plus 1
//		for(int i = array.length - 2; i >= 0; i-- ){
//			M[i] = -1;
//			// if position i can jump to the end, than M[i] is 1, meaning one step to jump out
//			if(i + array[i] >= array.length - 1){
//				M[i] = 1;
//				continue;
//			}
//			
//			int min = 10;
//			for(int j = i; j <= i + array[i]; j++){
//				
//				if(M[j] != -1) {
//					min = Math.min(min, M[j]);
//					M[i] = min + 1;
//				}			
//			}	
//		}
//		return M[0];
		//Method 2: from left to right
		M[0] = 0;
		for(int i = 1; i < array.length; i++) {			
			M[i] = -1;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j <= i; j++) {
//				if there is any position j, from 0 to j+M[j],
//				M[j] != -1(reachable), 	calculate the min of all the M[j],plus 1
//				is the current minStep
				if(M[j] != -1 && j + array[j] >= i) {
					min = Math.min(min, M[j]);
					M[i] = min + 1;
				}
			}
		}
		return M[array.length - 1];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayHopperII hopper = new ArrayHopperII();
		int[] array = {3,1,1,0,4};
		System.out.print(hopper.minJump(array));
//		
//		int i = 0;
//		for(int j = 0; j <= i; j++){
//			System.out.println("i:" + i);
//			System.out.println("j:" + j);
//		}
	}

}
