package DP;

public class LongestAscendingSubArray {
	// TC: O(n)  SC:Ｏ(n)
	public int longest(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int max = 1;
		int cur = 1;
		for(int i = 1; i < array.length; i++){
			if(array[i] >= array[i-1]){
				cur++;
				max = Math.max(max, cur);
		}else{
			cur = 1;
		}
		}
		return max; 

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestAscendingSubArray longest = new LongestAscendingSubArray();
		int[] array = {7, 2, 3, 1, 5, 8, 9, 6};
		System.out.print(longest.longest(array));
	}

}
