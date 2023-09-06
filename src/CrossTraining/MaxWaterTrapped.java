package CrossTraining;
/*/
 * 199. Max Water Trapped I
Medium
Given a non-negative integer array representing the heights of a list of adjacent bars. Suppose each bar has a width of 1. Find the largest amount of water that can be trapped in the histogram.

Assumptions

The given array is not null
Examples

{ 2, 1, 3, 2, 4 }, the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and index 3, 1 unit of water can be trapped)
 */
public class MaxWaterTrapped{
	// Method 2 ： 两个值替代 两个 DP array
	public int maxTrapped(int[] array) {
	    // Write your solution here
		int res = 0;
		int leftMax = 0;
		int rightMax = 0;
		int i = 0;
		int j = array.length - 1;
		while(i < j) {
			leftMax = Math.max(leftMax, array[i]);
			rightMax = Math.max(rightMax, array[j]);
			if(leftMax < rightMax) {// 能确定左边界
				res += leftMax - array[i];
				i++;
			}else {
				res += rightMax - array[i];
				j--;
			}
		 }
		return res;
	}
	

	    // Method 1 ：笨办法 两个DP array
	public int maxTrappedII(int[] array) {
		int res = 0;
		int leftMax = 0;
		int rightMax = 0;
		int[] DPLeft = new int[array.length];
		int[] DPRight = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			DPLeft[i] = leftMax < array[i]  ? 0 : leftMax - array[i];
			leftMax = Math.max(leftMax, array[i]);
		}
		for(int i = array.length - 1; i >= 0; i--) {
			DPRight[i] = rightMax < array[i]  ? 0 : rightMax - array[i];
			rightMax = Math.max(rightMax, array[i]);
		}
		for(int i = 0; i < array.length; i++) {
			res += Math.min(DPLeft[i], DPRight[i]);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 2, 1, 3, 2, 4 };
		MaxWaterTrapped water = new MaxWaterTrapped();
		System.out.print(water.maxTrapped(array));
	}

}
