package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
Note: You cannot rotate an envelope.

Example 1:
Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class RussianRollEnvelopeLeetCode354 {
    public int maxEnvelopes(int[][] envelopes) {
        //highlight:  first sort the 2D array by width as ascending order,
        // if two envelopes are the same width, to prevent these two roll together, we sort higher one before shorter one
        // then use dynamic programming to find the longest ascending subsequence by height
        // step 1: sort the input
        // corner case:
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }
        // Method 1: lambda express
//        Arrays.sort(envelopes, (e1,  e2) -> e1[0] == e2[0] ? Integer.compare(e2[1], e1[1]) : e1[0] - e2[0]);
//        // Method 2: Anonymous class
//        Arrays.sort(envelopes, new Comparator<int[]>(){
//            @Override
//            public int compare(int[] e1, int[] e2){
//                if(e1[0] == e2[0]){
//                    return e2[1] - e1[1];
//                }
//                return e1[0] - e2[0];
//            }
//        });
        // Method 3: self define class
        // Method 1: sort height by descending order when the width are same
//        Arrays.sort(envelopes, new myComparator1());
        // Method 2: sort width only, compare height when doing DP
        Arrays.sort(envelopes, new myComparator2());
//        System.out.println("after sort: " + Arrays.deepToString(envelopes) );
        // step 2: find the longest ascending subsequence,
        // longest[i] represents the longest ascending subsequence ending at index i
        int[] longest = new int[envelopes.length];
        int globalMax = 1;
        longest[0] = 1;
        for (int i = 1; i < envelopes.length; i++) {
            int curMax = 1;
            for (int j = 0; j < i; j++) {
//                if (envelopes[j][1] < envelopes[i][1]) {
                  if (envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) {
                        curMax = Math.max(curMax, longest[j] + 1) ;

//                    System.out.println("j: " + j +" [ " + envelopes[j][0] + " ," + envelopes[j][1]+" ] ");
                  }
            }
            longest[i] = curMax;
//            System.out.println("i: " + i +" [ " + envelopes[i][0] + " ," + envelopes[i][1]+" ] ");
//            System.out.println("curMax: " + curMax);
            globalMax = Math.max(globalMax, longest[i]);
        }
        // optimize time complexity by binary search for the smallest greater than target, replace it with target:
        int[] lowestEnding = new int[envelopes.length + 1];
        lowestEnding[1] = envelopes[0][1];// longest ascending subsequence with smallest element
        int result = 1;
        for(int i = 1; i < envelopes.length; i++){
            int val = envelopes[i][1];
            if(val > lowestEnding[result]){
                lowestEnding[++result] = val;
            }else{
                int insertIndex = binarySearch(lowestEnding, val);// smallest greater than val
                lowestEnding[insertIndex] = val;
            }
        }
        return result;
//        return globalMax;
    }

    // find the smallest element that is greater than target
    private int binarySearch(int[] las, int target) {
        int left = 0;
        int right = las.length;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(las[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        // post process
        if(las[left] >= target){
            return left;
        }else{
            return right;
        }
    }

    class myComparator1 implements Comparator<int[]> {
        @Override
        public int compare(int[] e1, int[] e2) {
            if (e1[0] == e2[0]) {
                return e2[1] - e1[1];
            }
            return e1[0] - e2[0];
        }
    }
    class myComparator2 implements Comparator<int[]> {
        @Override
        public int compare(int[] e1, int[] e2) {
            return e1[0] - e2[0];
        }
    }

    public static void main(String[] args) {
//        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int[][] envelopes = {{4,5},{4,6},{6,7},{2,3},{1,1}};
//        int[][] envelopes = {{2,3},{4,5}};
        RussianRollEnvelopeLeetCode354 russianRollEnvelopeLeetCode354 = new RussianRollEnvelopeLeetCode354();
        System.out.println(russianRollEnvelopeLeetCode354.maxEnvelopes(envelopes));
    }

}
