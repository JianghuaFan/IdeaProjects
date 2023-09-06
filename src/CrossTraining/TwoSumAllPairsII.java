package CrossTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
 * 182. 2 Sum All Pair II
Medium
Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.

Assumptions

The given array is not null and has length of at least 2
The order of the values in the pair does not matter
Examples

A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]

 
 */
public class TwoSumAllPairsII {

	public List<List<Integer>> allPairs(int[] array, int target) {
	    // Write your solution here
		// TC: O(n)  SC: O(n)
	    List<List<Integer>> res = new ArrayList<>();
	    
	    //map to store the element and its number of existence
	    Map<Integer, Integer> map = new HashMap<>();
	    
	    for(int num : array){  
	    	Integer count = map.get(num);
	    	// Two cases : when we need to make the pair of solution:
	    	//1. if 2*x == target, we need to make sure there is no duplications.
	    	//2. if x+y == target, this is the first time both x and y present, so we
	    	// can make sure there is no duplications.
	    	if(num * 2 == target && count != null && count == 1) {
	    		res.add(Arrays.asList(num,num));
	    	} else if(map.containsKey(target - num)) {
	    		if(count == null ) {
	    			res.add(Arrays.asList(num,target - num));
	    		}	    		
	    	}    	
	    	
	    	//第二步 把当前元素加到map里，更新出现次数
		    if(count == null){// case1
		    	map.put(num, 1);
		    }else {
		    	map.put(num, count + 1);
		    }		           
	    }
	    return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSumAllPairsII twoSumII = new TwoSumAllPairsII();
		int[] array = {2, 1, 3, 2, 4, 3, 4, 2};
		int target = 6;
		System.out.println(twoSumII.allPairs(array, target));		
	}

}
