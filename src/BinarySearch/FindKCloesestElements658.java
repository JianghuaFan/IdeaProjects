package BinarySearch;

import java.util.*;

/*
19. K Closest In Sorted Array
Medium
Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A. If there is a tie, the smaller elements are always preferred.

Assumptions

A is not null
K is guranteed to be >= 0 and K is guranteed to be <= A.length
Return

A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.
Examples

A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 */
public class FindKCloesestElements658 {
	public static List<Integer> findClosestElements(int[] arr, int x, int k) {
//      //方法一： 二分法  
		Arrays.sort(arr);
		List<Integer> res = new ArrayList<>();
		int count = 0;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (x < arr[mid])
            	right = mid - 1;
            else
            	left = mid + 1;
        }
//		int left = 0;
//		int right = arr.length - 1;
//		while (left < right - 1) {
//			int mid = left + (right - left) / 2;
//			if (arr[mid] < x)
//				left = mid;
//			else right = mid;
//		}
		System.out.println("left:" + left + " right:" + right);
		while (count < k && count < arr.length) {
			if (left < arr.length && right >= 0) {
				if (x - arr[left] < arr[right] - x) {
					res.add(arr[left++]);
				} else res.add(arr[right--]);
			} else if (left < arr.length)//right pointer out of bond
				res.add(arr[left++]);
			else res.add(arr[right--]);// left pointer out of bond
			count++;
		}
		Collections.sort(res);
		return res;
	}
        public static List<Integer> findClosestElementsII(int[] arr, int x, int k) {
//		方法二： slide window O(log（n-k））
			List<Integer> res = new ArrayList<>();
			int left = 0, right = arr.length - k;
			while (left < right) {
				int mid = left + (right - left)/2;
				if ( x - arr[mid] <= arr[mid + k] - x )
					right = mid;
				else
					left = mid + 1;
			}
		        System.out.println("left:" + left + " right:" + right);

			for(int i = left; i < left + k; i++){
				res.add(arr[i]);
			}
			return res;
	}
	public int[] kClosest(int[] array, int target, int k) {
		int[] res = new int[k];
		Arrays.sort(array);
//		Arrays.sort(array, new Comparator<Integer>(){
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o1 - o2;
//			}
//		});
//		Arrays.sort(array, Integer::compare);
		// high level: use a window [mid,mid+k] to compare the diff of target - array[mid] and array[mid + k] - target,
		// if small then move left, right = mid, else left = mid
		int left = 0;
		int right = array.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (target - array[mid] == array[mid + k] - target) {
				res = getResult(array, mid, k);
			} else if (target - array[mid] < array[mid + k] - target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return res;
	}
	public int[] getResult(int[] array, int mid , int k){
		int[] res = new int[k];
		for(int i = 0; i < k; i++){
			res[i] = array[mid + i];
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,8};		
		int target = 8;
		int k = 3;
		System.out.print(findClosestElements(arr,target,k));
		System.out.print(findClosestElementsII(arr,target,k));
	}

}
