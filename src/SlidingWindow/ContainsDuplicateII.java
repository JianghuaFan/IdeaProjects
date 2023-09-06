package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
that nums[i] == nums[j] and abs(i - j) <= k */
public class ContainsDuplicateII {
    public boolean containsDuplicateDistanceLessThanKBruteForce(int[] array, int k){
        // highlevel:
        // Method 1: bruteforce for every i to look forward k steps to see if there is a num equal to itself
        // TC: O(n*k)
        if(array == null || array.length == 0){
            return false;
        }
        for(int i = 0; i < array.length - k; i++){
            for( int j = i + 1; j <= i + k; j++){
                if(array[i] == array[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsDuplicateDistanceLessThanKFixedSlidingWindow(int[] array, int k){
        // highlevel: fixed sliding window for size k, check are there duplicate numbers with a set
        // TC: O(n)  SC:(k)
        Set<Integer> set = new HashSet<>();
        int slow = 0;
        for(int fast = 0; fast < array.length; fast++){
            if(!set.add(array[fast])){// step1: add fast
                return true;// step2: update result
            }
            if(fast >= k){
                // step 3: remove slow
                set.remove(array[fast - k]);
            }
        }
        return false;
    }

    public boolean containsDuplicateDistanceLessThanKUseMap(int[] array, int k) {
        // highlevel: fixed current number to check if is has been appeared in the map, if yes check the index diff
        // use a map to store value and index
        // TC: O(n)  worst case SC:(n)
        Map<Integer,Integer> map = new HashMap<>();
        for(int fast = 0; fast < array.length; fast++){
            // step 1: update result
            Integer index = map.get(array[fast]);
            if(index != null){
                if(fast - index <= k){
                    return true;
                }
            }
            map.put((array[fast]), fast);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,1,2,3};
        ContainsDuplicateII containsDuplicate = new ContainsDuplicateII();
        System.out.println(containsDuplicate.containsDuplicateDistanceLessThanKBruteForce(array,3));
        System.out.println(containsDuplicate.containsDuplicateDistanceLessThanKUseMap(array,3));
        System.out.println(containsDuplicate.containsDuplicateDistanceLessThanKFixedSlidingWindow(array,3));
    }
}
