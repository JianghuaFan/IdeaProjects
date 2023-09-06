package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
You are given an integer array nums and two integers indexDiff(k) and valueDiff(d),
Find a pair of indices(i,j) such that:
i != j
abs(i - j) <= indexDiff
abs(nums[i] - nums[j] <= valueDiff
Return true if such pair exists or false otherwise
 */
public class ContainsDuplicateIII {
    public boolean containsDuplicateIIIMap(int[] array, int k, int d){
        // highlevel:
        // method 1 bruteforce: for every number in array, look forward k elements to see if there is a number that valueDiff <= d
        // TC: O(n * k) SC: O(1)
        if(array == null || array.length == 0){
            return false;
        }

        // method 2: use a map store the value and index, check is there is a number with current number:
        // such that indexDiff <= k, and valueDiff <= d
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            //step 2: update result
            for(Integer integer : map.keySet()) {
                if (integer != null) {
                    if (Math.abs(integer - array[i]) <= d) {
                        if (Math.abs(map.get(integer) - i) <= k) {
                            return true;
                        }
                    }
                }
            }
            map.put(array[i], i);// step 1: add fast
        }
        return false;
    }

//     for sliding window of size k,
    public boolean containsDuplicateIIITreeSet(int[] array, int k, int d){
        // method 3 : use a treeSet to store the value, check is there is a number with current number:
        //     valueDiff <= d, 因为 treeSet 底层是BST，所以已经排好序的，只要值和自己最相近的的两个值的绝对值 <= d
        // TC: O(nlogk) SC: O(k)  TreeSet 的add , remove, floor, ceiling 等都是logk
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < array.length; i++){

            // step 1: update result
            Integer min = treeSet.floor(array[i]);
            Integer max = treeSet.ceiling(array[i]);
            if(min != null && Math.abs(array[i] - min) <= d){
                return  true;
            }
            if(max != null && Math.abs(array[i] - max) <= d){
                return  true;
            }
            // step 2: add fast
            treeSet.add(array[i]);
            // step 3: remove slow
            if(i >= k){
                treeSet.remove(array[i - k]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicateIII containsDuplicateIII = new ContainsDuplicateIII();
        int[] array = {1,2,3,1,2,3};
        System.out.println(containsDuplicateIII.containsDuplicateIIIMap(array,3,0));
        System.out.println(containsDuplicateIII.containsDuplicateIIITreeSet(array,3,0));
    }
}
