package DP;

public class PrefixSum {
	public int prefixSum(int[] array, int start, int end) {
		if(array == null || array.length == 0) {
			return -1;
		}
		int[] prefixSum = new int[array.length];
		prefixSum[0] = array[0];
		for(int i = 1; i < array.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + array[i];
		}
		return prefixSum[end] - prefixSum[start] + array[start];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrefixSum prefixSum = new PrefixSum();
		int[] array = {1,2,3,4,5};
		System.out.println(prefixSum.prefixSum(array, 1, 2));
	}

}
