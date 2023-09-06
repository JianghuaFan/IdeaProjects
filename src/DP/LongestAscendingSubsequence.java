package DP;

import java.util.Arrays;

/*
1. Longest Ascending Subsequence
Medium
Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.

Assumptions

A is not null
Examples
Input: A = {5, 2, 6, 3, 4, 7, 5}
Output: 4
Because [2, 3, 4, 5] is the longest ascending subsequence.
input: 5, 2, 6, 3, 4, 7, 5
M[i]:  1  1  2  2  3  4  4
 */
public class  LongestAscendingSubsequence {
    public int longest(int[] array) {
        // Write your solution here
        // TC: O(n * n)  SC: O(n)
         // corner case: a is empty
        if(array.length == 0){
            return 0;
        }
        // step 1: dp 的物理意义 ：M[i] represents Longest Ascending Subsequence ends at index i(不丢解，每个都考虑到)
        int[] M = new int[array.length];
        // base case: only one letter
        M[0] = 1;
        int globalMax = 1;
        // step 2: induction rule : if a[i] > a[j], M[i] is maximum of all the a[j] + 1(1是我自己对于结果的贡献)
        // 如果左边都比我大，东山再起dp[i] = 1
        for(int i = 1; i < array.length; i++){// 遍历每一个独立的状态，由小到大的累计过程
            int curMax = 1;// 保证初始值满足所有左边都比我大的情况下
            for(int j = 0; j < i; j++){
                if(array[i] > array[j]){
                    curMax = Math.max(curMax, M[j] + 1);
                }
            }
            M[i] = curMax;
            globalMax = Math.max(globalMax, M[i]);
        }
        // step 3: result 是 global
        return globalMax;
    }

    public int[] longestSubsequence(int[] a) {
        // Write your solution here
        // TC: O(n * n + n)  SC: O(n)
        // corner case: a is empty
        if(a.length == 0){
            return new int[]{};
        }
        // step 1: dp 的物理意义 ：M[i] represents Longest Ascending Subsequence ends at index i
        int[] M = new int[a.length];
        int[]  prev = new int[a.length];
        Arrays.fill(prev, -1);
        // base case: only one letter
        M[0] = 1;
        int globalMax = 1;
        int longestEndIndex = 0;
        // step 2: induction rule : if a[i] > a[j], M[i] is maximum of all the a[j] + 1(1是我自己对于结果的贡献)
        // 如果左边都比我大，东山再起dp[i] = 1, 每次更新curMax，如果用了当前j那么就把j加到i 的prev 数组里
        for(int i = 1; i < a.length; i++){
            int curMax = 1;
            for(int j = 0; j < i; j++){
                if(a[i] > a[j]){
                    if(curMax < M[j] + 1){
                        curMax = M[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            M[i] = curMax;
            // 如果当前i是新的globalMax， 那么新的subsequence的结尾就是i
            if(globalMax < curMax){
                globalMax = curMax;
                longestEndIndex = i;
            }
        }
        int[] res = new int[globalMax];
        for(int i  = longestEndIndex; i >= 0; i = prev[i]){
            res[--globalMax] = a[i];
        }
        // step 3: res 是 global
        return res;
    }

    public int longestAscendingSubarrayGreedy(int[] array){
        // highlevel: maintain an array lowestEnding[], where lowestEnding[i] represents the smallest value
        // of all ascending subSequence with length of i.
        // step 1: initiate the lowestEnding[], lowestEnding[1] is 0,
        // step 2: for every a[i] find the smallest element that is greater than a[i], replace it with a[i],
        // if there is not such element, increase the length with a[i] as the ending element
        // finally return the last index of lowestEnding array
        // array:           [0  3  1  6  2  2  7]
        // length: 0 1 2 3 4
//                 X 0 1 2 7
        // lowestEnding[i]:  X  0  1  2  7
        // index (length)    0  1  2  3  4
        if(array.length == 0){
            return 0;
        }
        int[] lowestEnding = new int[array.length + 1];
        lowestEnding[1] = array[0];
        // at the very beginning, the longest ascending subsequence we have has length 1(a[0] itself)
        // while we traverse the array, we will update the existing lowestEnding[i] and find new longer ascending subsequence
        int result = 1;
        for(int i = 1; i < array.length; i++){
            // case 1: we can possibly form a longer ascending subsequence than whatever we have before,
            // if a[i] is larger than all values in lowestEnding
            if(array[i] > lowestEnding[result]){
                lowestEnding[++result] = array[i];
            }else{
                // case 2: we may update lowestEnding[smallestGreater + 1] because we find a better ascending subsequence
                // with length smallestGreater + 1(the ending value is smaller or equal)
                int index = findSmallestGreater(lowestEnding,1, result, array[i]);
                lowestEnding[index] = array[i];
            }

//            int index = findLargestSmallerIndex(lowestEnding,1, subSeqLength, array[i]);//
//            // case 2: we may update lowestEnding[index + 1] because we find a better ascending subsequence
//            // with length index + 1(the ending value is smaller or equal)
//            if(index == result){// 最后一个比array[i] 小的就是lowestEnding数组的最后一个，说明进来的比之前所有的都大，那么直接接在最后面，数组长度加1
//                lowestEnding[++result] = array[i];
//            }else{// index 是最后一个比array[i] 小的，所以把index后面一个更新为array[i]
//                lowestEnding[index + 1] = array[i];
//            }
        }
        return result;
    }
// bs find first larger element than target
    // goal : replace that larger value with target
    // what if target == array[i] like: target = 179,array : 179 246 ...
    // if replace 246 -> 179 179 not ascending subsequ anymore
    // so we need to find the first larger/equal value than target
    // or the first smaller element than target 然后给第一个比array[i] 的index， 给该index + 1
    private int findSmallestGreater(int[] array, int left, int right, int target){

        while(left < right - 1 ){
            int mid = left + (right - left) / 2;
            if(array[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if(array[left] >= target){
            return left;
        }else{
            return right;
        }
    }
    // find the index of the "largest smaller value" to target in the array, array is sorted in ascending order
    private int findLargestSmallerIndex(int[] array, int left, int right, int target ){
        while(left < right -1){
            int mid = left + (right - left) / 2;
            if(array[mid] < target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        // post process
        if(array[right] < target){
            return right;
        }else{
            return left;
        }
    }

    public static void main(String[] args){
        LongestAscendingSubsequence longestAscendingSubsequence = new LongestAscendingSubsequence();
        int[] array = {0 , 3 , 1,  6, 6,  2,  2,  7};
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {179,179,267};
        //        System.out.println(longestAscendingSubsequence.longest(array));
//        System.out.println("LAS length:" + longestAscendingSubsequence.longestAscendingSubarrayGreedy(array2));
//        System.out.println("longest subsequ:" + Arrays.toString(longestAscendingSubsequence.longestSubsequence(array2)));
//        System.out.println("SmallestGreater:" + longestAscendingSubsequence.findSmallestGreater(array1, 0, array1.length, 3));
        System.out.println("find largest smaller index: " + longestAscendingSubsequence.findLargestSmallerIndex(array1, 0, array1.length -1, 7));

    }
}
