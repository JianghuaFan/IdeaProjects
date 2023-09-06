package DP;
/*
683. Count Ascending Subsequence
Medium
Given an array A[0]...A[n-1] of integers, count the number of ascending subsequences.

In case that the result is larger than 32-bit integer, return the result in 10^9+7 modulo.

Assumptions

A is not null
Examples
Input: A = {1,2,3}
Output: 7
Explanation: [1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]
 */
public class CountAscendingSubsequence {
    // TC: O(# of distinctive state) *
    // O(# of Dependent states of a single state) *
    // O(Time you spend at calculating the result of a single state)
    // TC: O(n * n * 1)  SC: O(n)
    public int numIncreasingSubsequences(int[] a) {
        // Write your solution here
        // corner case: a is empty
        int res = 0;
        if(a.length == 0){
            return res;
        }
        // M[i] represents total # of Ascending Subsequence ends at index i
        int[] M = new int[a.length];
        // base case: only one letter
        M[0] = 1;
        // induction rule : if a[i] > a[j], M[i] is sum of all the a[j] + 1(1是我自己对于结果的贡献)
        for(int i = 1; i < a.length; i++){
            for(int j = 0; j < i; j++){
                if(a[i] > a[j]){
                    M[i] += M[j];// 当 a[i] > a[j]的时候，所有j的馈赠都能拿来用
                }
            }
            M[i] += 1;// i 自己本身
        }
        for(int i = 0; i < M.length; i++){
            res += M[i];
        }
        return res;
    }

    public static void main(String[] args){
        CountAscendingSubsequence countAscendingSubsequence = new CountAscendingSubsequence();
        System.out.println(countAscendingSubsequence.numIncreasingSubsequences(new int[]{1,2,3}));
    }
}
