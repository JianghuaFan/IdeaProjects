package BinarySearch;
/*
68. Missing Number I
Medium
Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.

Assumptions

The given array is not null, and N >= 1
Examples

A = {2, 1, 4}, the missing number is 3
A = {1, 2, 3}, the missing number is 4
A = {}, the missing number is 1
 */

import java.util.*;

public class MissingNumber268 {
//	方法一： 位异或 TC: O(n) SC : O(1)
	public int missingNumberXor(int[] array) {
		int res = 0;
		for(int n = 1; n < array.length + 2; n++){
			res = res ^ n;
		}
		for(int num : array){
			res = res ^ num;
		}
		return res;
	}
	//	方法二： 排序找array[i] != (i+1) TC: O(n) SC : O(1)
	public int missingSorted(int[] array){
		for(int i = 0; i < array.length; i++){
			if(array[i] != (i+1)){
				return i+1;
			}
		}
		return array.length + 1;
	}

	public int missingNumberSum(int[] array) {
//		方法四： 求和法（1） TC: O(n) SC : O(1)
		int n = array.length + 1;
		long sum = (n + 0L) * (n + 1) / 2;
		long actualSum = 0L;
		for (int i : array) {
			actualSum += i;
		}
		return (int) (sum - actualSum);
	}
//		方法五：数组set法 TC: O(n) SC : O(n)
public int missingNumberArraySet(int[] array) {
	int n = array.length;
	int[] cnt = new int[n + 1];
	for (int num : array) {
		cnt[num]++;
	}
	for (int i = 0; i <= array.length; i++) {
		if (cnt[i] == 0)
			return i;
	}
	return -1;
}
		
//		方法6：Boolean数组法 TC: O(n) SC : O(n)
public int missingNumberBoolean(int[] array) {
		boolean[] missing = new boolean[array.length + 2];
		for(int i : array){
			missing[i] = true;
		}
		for(int i = 1; i <= array.length+1; i++){
			if(missing[i] == false){
				return i;
			}
		}
		return -1;
	}
		// method 7: set 法 TC: O(n) SC : O(n)
		public int missingNumberSet(int[] array) {
		Set<Integer> set = new HashSet<>();
		for(int i : array) {
			set.add(i);
		}
		for(int i = 1; i <= array.length; i++) {
			if(!set.contains(i))
				return i ;
		}
		return array.length + 1;
    }
	// Binary Search TC: O(logn) SC : O(1)
	public int missingNumber(int[] array){
		// high level: binary search
		// array:    0 1 2 3 4 6
		// index:    0 1 2 3 4 5
		// dif       0 0 0 0 0 1
		// find the position where index diff is 2
		// use a mid number to check its diff, if diff is 0 then go to the right part, if diff is 2 go to the left part
		int left = 0;
		int right = array.length - 1;

		while(left < right){// post process one element
			int mid = left + (right - left) / 2;
			if(array[mid] - mid == 0){
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		return array[right] - 1;
	}
	public int missingNumberBinarySearch(int[] array) {
//		方法三：二分法
		Arrays.sort(array);
		// binary search
		int left = 0;
		int right = array.length - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(array[mid] - mid - 1 < 1){
				// 参考错题集都吃里的kth missing number讲解
				left = mid + 1; // left 之前少了一个number，所以找到left后 + 1就是missing的数。例如{1, 2, 4}， left 是2，说明4之前少了1个数，少的数就是left + 1
			}else{
				right = mid - 1;
			}
		}
		return left + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array = {1,3,2};
//		int[] array = {1,2,3};
//		int[] array = {3,0,1};
		int[] array = {0,2,4,5,6};
		MissingNumber268 missingNumber268 = new MissingNumber268();
//		System.out.println(missingNumber268.missingNumber(array));
		System.out.println(missingNumber268.missingNumberBinarySearch(array));
//		System.out.println(missingNumber268.missingNumber(array));
	}
}

