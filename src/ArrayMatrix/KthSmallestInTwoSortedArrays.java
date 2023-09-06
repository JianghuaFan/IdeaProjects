package ArrayMatrix;
/*
202. Kth Smallest In Two Sorted Arrays
Hard
Given two sorted arrays of integers, find the Kth smallest number.

Assumptions

The two given arrays are not null and at least one of them is not empty

K >= 1, K <= total lengths of the two sorted arrays

Examples

A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.

A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
 */

public class KthSmallestInTwoSortedArrays {

    public int kth(int[] a, int[] b, int k) {
        // Write your solution here
        // TC: O(logk)  SC: O(1)
         return helper(a, 0,b, 0,k);
    }
    // in the subarray of a starting from index aleft, and subarray of b starting from index bleft, find the kth smallest
    //element among these two subarrays
    private int helper(int[] a, int aLeft, int[] b, int bLeft, int k){
        // three cases:
        // 1. we already eliminate all the element in a
        // 2. we already eliminate all the element in b
        // 3. k become 1, in the following logic we need k >= 2 to make it work
        if(k > a.length + b.length){
            return -1;
        }
        if(aLeft >= a.length){
            return b[bLeft + k - 1];
        }
        if(bLeft >= b.length){
            return a[aLeft + k - 1];
        }
        if(k == 1){
            return Math.min(a[aLeft], b[bLeft]);
        }
//        choose k/2 from a and k/2 from b to determine which k/2 partition can be included in the result
        int amid = aLeft + k/2 - 1;
        int bmid = bLeft + k/2 - 1;
//        如果所选的一半的位置大于那个数组长度，说明答案一定在那个数组，所以填成最大值
        int aVal = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bVal = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
        if(aVal <= bVal){
            return helper(a, amid + 1, b, bLeft, k - k/2);
        }else{
            return helper(a,aLeft, b, bmid + 1, k - k/2);
        }
    }

    public static void main(String[] args) {
//        int[] a = {1,4,5,5,8,12,12,12};
//        int[] b = {2,2,3,7,9,9,9};
//        int k = 14;
        int[] a = {1};
        int[] b = {1,2,3,4};
        int k = 5;
        KthSmallestInTwoSortedArrays kthSmallestInTwoSortedArrays = new KthSmallestInTwoSortedArrays();
        System.out.println(kthSmallestInTwoSortedArrays.kth(a,b,k));
    }
}
