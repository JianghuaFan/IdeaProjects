package DFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 263. Two Subsets With Min Difference
Medium
Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.

Return the minimum difference(absolute value).

Assumptions:

The given integer array is not null and it has length of >= 2.
Examples:

{1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
 */
public class AllSubsetsOfSizeKWithDup {
	public List<String> subSetsIIOfSizeK(String set, int k) {
		   // Write your solution here
	 	List<String> res = new ArrayList<>();
		if(set == null || k > set.length()){
			return res;
		}
		char[] array = set.toCharArray();
		Arrays.sort(array);
		StringBuilder sb = new StringBuilder();
		DFS(res, sb, array, 0, k);
		return res;
	}
	public void DFS(List<String> res, StringBuilder sb, char[] array, int index, int k){
		if(sb.length() == k){
			res.add(sb.toString());
			return;
		}
		if(index == array.length){
			return;
		}
		sb.append(array[index]);
		DFS(res, sb, array, index + 1, k);
		sb.deleteCharAt(sb.length() - 1);
		while( index < array.length - 1 && array[index] == array[index + 1]){
			index++;
		}
		DFS(res, sb, array, index + 1, k);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllSubsetsOfSizeKWithDup allSubsetsOfSizeKWithDup = new AllSubsetsOfSizeKWithDup();		
		String input = "abc";
		int k = 2;
		List<String> res = allSubsetsOfSizeKWithDup.subSetsIIOfSizeK(input,2);
		System.out.print(res);
	}

}
