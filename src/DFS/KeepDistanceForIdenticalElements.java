package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 264. Keep Distance For Identical Elements(C++ not ready)
Medium
Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k], such that the output integer array satisfy this condition:

Between each two i's, they are exactly i integers (for example: between the two 1s, there is one number, between the two 2's there are two numbers).

If there does not exist such sequence, return null.

Assumptions:

k is guaranteed to be > 0
Examples:

k = 3, The output = { 2, 3, 1, 2, 1, 3 }.
 */
public class KeepDistanceForIdenticalElements {
	// Method1: k levels, put one pair at a time
	public int[] keepDistance(int k) {
		int[] res = new int[2*k];
		if(DFS1(res, k)) {
			return res;
		}else {
			return null;
		}
	}	
	private boolean DFS1(int[] res, int k) {
		// 空数组，从k大到小放，例如k= 3， 从3到1 逐个放，当1放完即k=0就都放好了
		if(k == 0) {
			return true;
		}
		// 
		for(int i = 0; i < res.length - k - 1; i++) {
			// 位置i 和 位置i+K+1还没有放数字
			if(res[i] == 0 && res[i+k+1] == 0) {
				res[i] = k;
				res[i+k+1] = k;
				if(DFS1(res, k - 1)) {
					return true;
				}
				res[i] = 0;
				res[i+k+1] = 0;
			}
		}
		return false;
	}
	
	// Method2:  swap swap
	public int[] keepDistance2(int k) {
		int[] res = new int[2*k];
		for(int i = 0; i < k; i++){			
			res[2*i] = i+1;
			res[2*i+1] = i+1;
			
		}
		// used[i] == true if and only if i is used once
		boolean[] used = new boolean[k+1];
		if(DFS2(res, 0, used)) {
			return res;
		}else {
			return null;
		}
	}	
	private boolean DFS2(int[] res, int index, boolean[] used) {
		// 从大到小放，例如k= 3， 从3到1 逐个放，当1放完即k=0就都放好了
		if(index == res.length) {
			return true;
		}
		// i表示要放的位置
		for(int i = index; i < res.length; i++) {
			int cur = res[i];
			if(!used[cur] || index > cur && res[index - cur - 1] == cur) {
				swap(res, index, i);
				used[cur] = true;
				if(DFS2(res, index + 1, used)) {
					return true;
				}
				swap(res, index, i);
				used[cur] = !used[cur];
			}
		}
		return false;
	}
		
		// Method3:  类似于map记录当前数k是否放过了，用数组0表示没放过，1放过1次，
	public int[] keepDistance3(int k) {
		int[] res = new int[2*k];
		// used[i] == true if and only if i is used once
		int[] used = new int[k+1];
		if(DFS3(res, 0, used)) {
			return res;
		}else {
			return null;
		}
	}	
	private boolean DFS3(int[] res, int index, int[] used) {
		// 从大到小放，例如k= 3， 从3到1 逐个放，当1放完即k=0就都放好了
		if(index == res.length) {
			return true;
		}
		// i 表示要放的数
		for(int i = 1; i < used.length; i++) {
			
			if(used[i] == 0 || ( used[i] == 1 && index > i && res[index - i - 1] == i)) {
				res[index] = i;
				used[i]++;
				if(DFS3(res, index + 1, used)) {
					return true;
				}
				used[i]--;
			}
		}
		return false;
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeepDistanceForIdenticalElements keep = new KeepDistanceForIdenticalElements();
		System.out.println(Arrays.toString(keep.keepDistance(3)));
		System.out.println(Arrays.toString(keep.keepDistance2(3)));
		System.out.println(Arrays.toString(keep.keepDistance3(3)));
	}

}
