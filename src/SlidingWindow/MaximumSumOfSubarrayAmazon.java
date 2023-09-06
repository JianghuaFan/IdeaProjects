package SlidingWindow;

import ArrayMatrix.MaximumSumSubarray;

import java.util.HashSet;
import java.util.Set;

/*
Our company is delivering packages for our customers. Each deliver is picking k consecutive packages from the warehouse,
Each package's weight is measured by kilogram, and it is listed on the table,
Find the maximum total weight that a deliverer could take such that every parcel he takes is in a different weight
input: [1,5,4,2,9,9,9]  k = 3
output: 15, is sum of 4,2,9
 */
public class MaximumSumOfSubarrayAmazon {
    public int maximumSumSubarray(int[] array, int k){
        // highlevel: for sliding window size of k, we will check whether there are duplicate, if yes remove the duplicate numbers,
        // update the result for every sliding window meets the condition no duplicate
        Set<Integer> set = new HashSet<>();
        int end = 0;
        int start = 0;
        int sum = 0;
        int max = 0;
        for(; end < array.length; end++){
            // step 1: before adding end, we need to check dup first, in the meantime remove start if sliding window size > k
            int val = array[end];
            while(set.contains(val) || end - start >= k ){
                sum -= array[start];
                set.remove(array[start++]);
            }
            // step 2: add end
            sum += val;
            set.add(array[end]);
            if(end - start + 1 == k){
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1,5,4,2,9,9,9};
        MaximumSumOfSubarrayAmazon maximumSumSubarray = new MaximumSumOfSubarrayAmazon();
        System.out.println(maximumSumSubarray.maximumSumSubarray(array, 3));
    }
}

