package DP;

public class ArrayHopperI {
	
	public boolean arrayHpperI(int[] array) {
		if(array == null || array.length == 0) {
			return false;
		}
//		if(array.length == 1) {
//			return true;
//		}
		int n = array.length;
		boolean[] arrive = new boolean[n];
		// Method 1: from end to start
//		for(int i = n - 1; i >= 0 ; i--){
//			if(i + array[i] >= n - 1){
//				arrive[i] = true;					
//			}else {
//				for(int j = i; j <= i + array[i]; j++){						
//					if(arrive[j] == true) {
//						arrive[i] = true;
//					}				
////					System.out.println("i:  " + i);
////					System.out.println("j:  " + j);
////					System.out.println("arrive[j]:  " + arrive[j]);
//				}
//			}			
//		}		
//		return arrive[0];
		// Method 2: from start to end
		arrive[0] = true;
		for(int i = 1; i < n; i++ ) {
			for(int j = 0; j <= i; j++) {
				if(arrive[j] == true && j + array[j] >= i) {
					arrive[i] = true;
					break;
				}
			}
		}
		return arrive[n-1];
	}
	
	public static void main(String[] args) {
		ArrayHopperI hopper = new ArrayHopperI();
//		int[] array = {1,3,2,0,3};
//		int[] array = {1,2,1,0,3};
//		int[] array = {1,0,1,0,0,0,0,0,1,100,0};
		int[] array = {2,1,1,1,1,0};
		System.out.print(hopper.arrayHpperI(array));
	}
}
