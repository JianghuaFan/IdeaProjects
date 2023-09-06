package DP;

public class MaxProductOfCuttingRope {
	public int maxProduct(int length) {
		//Method 1: 左大段，右小段
		// assumptions: n >= 2
//		if(length == 0 || length == 1) {
//			return length;
//		}
		int[] Max = new  int[length + 1];
		Max[1] = 0;
		for(int i = 2; i <= length; i++) {
			// pick the rightmost partition
			int curMax = 0;
			for(int j = 1; j < i; j++) {
				//For left part, we can choose not cutting it or cutting it,
				// so the max number we can get is either j or Max[j]
				int bigger = Math.max(j,Max[j]) * (i - j);
				curMax = Math.max(curMax, bigger);
			}
			Max[i] = curMax;
		}
		return Max[length];			
	}
	//TC: O(n^2)
	//SC: O(n)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxProductOfCuttingRope max = new MaxProductOfCuttingRope();
		System.out.print(max.maxProduct(5));
	
	}

}
