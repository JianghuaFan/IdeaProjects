package SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
find number of distinct contiguous subarrays with at most k odd elements



Algo:   TC: O(N^2)           SC: O(N^2)

 */
public class DistinctContiguousSubarrayWithAtMostKOddElements {
    public int distinctSubarrayWithMostKOddElements(int[] array, int k){
        if(array == null || array.length == 0){
            return 0;
        }
        Set<String> set = new HashSet<>();
        int slow = 0;
        for(int fast = 0; fast < array.length; fast++){
            // add fast
            if(array[fast] %2 == 1){
                k--;
            }
            // remove slow, 因为求最多，所以while条件不满足
            while(k < 0){

                if(array[slow++] %2 == 1){
                    k++;
                }
            }
            // update result: 因为要去重，求得是distinct的subarray， 所以用set来完成， set里不能存数组，把数组cast成string
            for(int i = slow; i <= fast; i++){
                int[] subArray = Arrays.copyOfRange(array, i, fast+1);
                set.add(Arrays.toString(subArray));
            }
        }
        for(String str: set){
            System.out.println(str.toString());
        }
        return  set.size();
    }

    public static void main(String[] args) {
        DistinctContiguousSubarrayWithAtMostKOddElements distinctContiguousSubarrayWithAtMostKOddElements = new DistinctContiguousSubarrayWithAtMostKOddElements();
        int[] array = {3,2,3,2};
        int k = 1;
        System.out.println(distinctContiguousSubarrayWithAtMostKOddElements.distinctSubarrayWithMostKOddElements(array, k));
    }
}
