package ArrayMatrix;
/*
208. Majority Number III
Hard
Given an integer array of length L, find all numbers that occur more than 1/K * L times if any exist.

Assumptions

The given array is not null or empty
K >= 2
Examples

A = {1, 2, 1, 2, 1}, K = 3, return [1, 2]
A = {1, 2, 1, 2, 3, 3, 1}, K = 4, return [1, 2, 3]
A = {2, 1}, K = 2, return []
 */

import java.util.*;

public class MajorityNumberIII {
    public List<Integer> majority(int[] array, int k) {
        // Write your solution here
        //数组中超过 1/K * L 次的元素最多有k-1个。例如超过1/2 的最多1个，超过1/3的最多2个。
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : array){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.size() >= k){
                remove(map);
            }
        }
        // corner case :
        if(map.size() == 0){
            return res;
        }
       // re count the element
        for(int num : map.keySet()){
           map.put(num, 0);
        }
        for(int num : array){
            if(map.containsKey(num)){
                map.put(num, map.getOrDefault(num, 0 ) + 1 );
            }
        }
        int length = array.length;
        for(int num : map.keySet()){
            // recheck 所有超过1/k 次的元素
            if(map.get(num) > length / k){
                res.add(num);
            }
        }
        return res;
    }
    private void remove(Map<Integer, Integer> map){
        List<Integer> removeList = new ArrayList<>();
        for(int num : map.keySet()){
            map.put(num, map.getOrDefault(num, 0) - 1);
            if(map.get(num) == 0){// 这个判断类似于擂台赛，当出现不是map里的candidate的时候，每个candidate的counter都减1，当减成0 的时候就该下台了
                removeList.add(num);
            }
        }
        for(int num : removeList){
            map.remove(num);
        }
    }
    public int majorityNumber(List<Integer> nums, int k) {
        HashMap<Integer, Integer> counters = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            counters.put(num, counters.getOrDefault(num,0) + 1);
            if (counters.size() >= k) {// 因为数组中出现次数大于k的数字最多只有k-1个，所以当size大于等于k的时候要remove
                removeKey(counters);
            }
        }
        int length = nums.size();

        // corner case
        if (counters.size() == 0) {
            return -1;
        }

        // re-count the numbers
        for (Integer num : counters.keySet()) {
            counters.put(num, 0);
        }
        for (Integer num : nums) {
            if (counters.containsKey(num)) {
                counters.put(num, counters.get(num) + 1);
            }
        }

        // find majority
        List<Integer> res = new ArrayList<>();
        int maxCounter = 0, maxKey = 0;
        for (Integer num : counters.keySet()) {
            if (counters.get(num) > maxCounter) {
                maxCounter = counters.get(num);
                maxKey = num;
            }
        }
        return maxKey;
    }

    private void removeKey(HashMap<Integer, Integer> counters) {
        Set<Integer> keySet = counters.keySet();
        List<Integer> removeList = new ArrayList<>();
        for (Integer key : keySet) {
            counters.put(key, counters.get(key) - 1);
            if (counters.get(key) == 0) {
                removeList.add(key);
            }
        }
        for (Integer key : removeList) {
            counters.remove(key);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 1, 2, 3, 3, 1};
        int[] array1 = {1, 2, 1, 2, 3, 3, 1};
        int[]A1 = {1, 2, 1, 2, 1};
        int[]A2 = {1, 2};
        int[] A3 = {1,4,3,5,2,2,1,6};
        List<Integer> nums = new ArrayList<>();
        nums = Arrays.asList(array);
//        Collections.addAll(nums, array);
        int k = 4;
        MajorityNumberIII majorityNumberIII = new MajorityNumberIII();
//        System.out.println(majorityNumberIII.majorityNumber(nums, k));
        System.out.println(majorityNumberIII.majority(array1, 3));
//        System.out.println(majorityNumberIII.majority(A1, 3));
//        System.out.println(majorityNumberIII.majority(A3, 4));
    }
}
