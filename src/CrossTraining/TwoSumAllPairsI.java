package CrossTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * 181. 2 Sum All Pair I
Medium
Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.

Assumptions

The given array is not null and has length of at least 2.

Examples

A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]

A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
 */
public class TwoSumAllPairsI {
	public List<List<Integer>> allPairs(int[] array, int target) {
	    // Write your solution here
	    List<List<Integer>> res = new ArrayList<>();
	   
	    Map<Integer, List<Integer>> map = new HashMap<>();

	    for(int i = 0; i < array.length; i++){  
	    	//先找map里是否有解，有解的话更新到res里,get all pairs(j,i)，with i as the larger index
	    	List<Integer> indices = map.get(target - array[i]);
	      if(indices != null){	 
	    	  for(int j : indices) {
	    		  res.add(Arrays.asList(j,i));
	    	  }	        
	      }
	      //第二步 把当前元素加到map里，分为case1 没出现过array[i] 和case 2 出现过两种情况
	      if(!map.containsKey(array[i])){// case1
	          map.put(array[i], new ArrayList<>());
	      }
	      map.get(array[i]).add(i);	        
	    }
	    System.out.println(map);
	    return res;
	  }
	public List<List<Integer>> allPairsofIndex(int[] array, int sum){
		// highlevel : use a hashmap to record the array, the key is number, value is a list of index of number
		// traverse the array check if sum - array[i] exist in map, if yes add the index pair into res,
		// add array[i] into map
		// corner case:
		List<List<Integer>> res = new ArrayList<>();
		if(array == null || array.length < 2){
			return res;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i = 0; i < array.length; i++){
			// step1: check whether sum - array[i] exist in map
			List<Integer> indices = map.get(sum - array[i]);
			if(indices != null){
				for(int j : indices){
					res.add(Arrays.asList(j, i));
				}
			}
			// put array[i] into map, case 1: array[i] already in the map, case 2 : not exists in the map
			if(!map.containsKey(array[i])){
				map.put(array[i], new ArrayList<>());
			}
			map.get(array[i]).add(i);
		}
		return res;
	}

	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSumAllPairsI twoSumI = new TwoSumAllPairsI();
		int[] array = {1,2,2,4};
		int target = 6;
		System.out.println(twoSumI.allPairs(array, target));
		System.out.println(twoSumI.allPairsofIndex(array, target));
	}
}
