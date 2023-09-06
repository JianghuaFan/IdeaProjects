package Sort;
/*
276. Get Count Array
Hard
Given an array A of length N containing all positive integers from [1...N]. How to get an array B such that B[i] represents how many elements A[j] (j > i) in array A that are smaller than A[i].

Assumptions:

The given array A is not null.
Examples:

A = { 4, 1, 3, 2 }, we should get B = { 3, 0, 1, 0 }.
Requirement:

time complexity = O(nlogn).
 */

import java.util.Arrays;

public class GetCountArray276 {
    public int[] countArray(int[] array) {
        // Write your solution here
        // countArray is the result
        // helper array is to help merge sort
        // indexArray contains the indices in the original array, and it will be sorted by the corresponding number
        int[] countArray = new int[array.length];
        int[] helper = new int[array.length];
        int[] indexArray = initialIndexArray(array);
        System.out.println("indexArray: " + Arrays.toString(indexArray));
        mergeSort(array, countArray, helper, indexArray, 0, array.length - 1);
        return countArray;
    }

    private int[] initialIndexArray(int[] array) {
        int[] indices = new int[array.length];
        for(int i = 0; i < array.length; i++){
            indices[i] = i;
        }
        return indices;
    }

    private void mergeSort(int[] array, int[] countArray, int[] helper, int[] indexArray, int left, int right) {
        if( left >= right){
            return;
        }
        int mid = left + (right - left ) / 2;
        mergeSort(array, countArray, helper, indexArray, left, mid);
        mergeSort(array, countArray, helper, indexArray, mid + 1, right);
        merge(array, countArray, helper, indexArray, left, mid, right);
    }

    private void merge(int[] array, int[] countArray, int[] helper, int[] indexArray, int left, int mid, int right) {

        copyArray(indexArray, helper, left, right);
        System.out.println("helper: " + Arrays.toString(helper));
        int l = left;
        int r = mid + 1;
        while(l <= mid){
            if( r > right || array[helper[l]] <= array[helper[r]]){
                countArray[helper[l]] += (r - mid - 1);
                indexArray[left++] = helper[l++];
            }else{
                indexArray[left++] = helper[r++];
            }
        }
        System.out.println("indexArray: " + Arrays.toString(indexArray));
    }

    private void copyArray(int[] indexArray, int[] helper, int left, int right) {
        for(int i = left; i <= right; i++){
            helper[i] = indexArray[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {4,1,3,2};
        GetCountArray276 getCountArray276 = new GetCountArray276();
        System.out.println(Arrays.toString(getCountArray276.countArray(array)));
    }
}
