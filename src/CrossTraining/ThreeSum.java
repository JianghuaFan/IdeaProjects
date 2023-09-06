package CrossTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
/*
 * 186. 3 Sum
Medium
Determine if there exists three elements in a given array that sum to the given target number. Return all the triple of values that sums to target.

Assumptions

The given array is not null and has length of at least 3
No duplicate triples should be returned, order of the values in the tuple does not matter
Examples

A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
 */
	public List<List<Integer>> allTriples(int[] array, int target) {
		   // Write your solution here
		// TC: O(n ^2)  SC: O(1) (not counting the storage for result)
	 	List<List<Integer>> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		Arrays.sort(array);
		for(int i = 0; i < array.length - 2; i++){
			// Our gola is to find i<j<k, such that 
			// array[i] + array[j] + array[k] == target
			// to make sure there is no duplicate tuple,
			// we ignore all the duplicate possible i 
			if(i > 0 && array[i] == array[i-1]){
				continue;
			}
			int target1 = target - array[i];
			int left = i+1;
			int right = array.length - 1;
			while(left < right){
				//ignore all the duplicate possible i
				
				if(array[left] + array[right] == target1){
					res.add(Arrays.asList(array[i], array[left], array[right]));
					left++;
					while(left < right && array[left] == array[left - 1]){
						left++;
					}
				}else if(array[left] + array[right] < target1){
					left++;
				}else{
					right--;
				}
			}
		}
		return res;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum threeSum = new ThreeSum();
		int[] array = {1, 2, 2, 3, 2, 4};
		int target = 8;
		System.out.println(threeSum.allTriples(array, target));
	}

}
