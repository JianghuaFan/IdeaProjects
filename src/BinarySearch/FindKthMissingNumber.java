package BinarySearch;

import java.util.Arrays;

/*
k-th missing element in sorted array
Difficulty Level : Medium

Given an increasing sequence a[], we need to find the K-th missing contiguous element in the increasing sequence which is not present in the sequence.
If no k-th missing element is there output -1.

Examples :

Input : a[] = {2, 3, 5, 9, 10};
        k = 1;
Output : 1
Explanation: Missing Element in the increasing
sequence are {1,4, 6, 7, 8}. So k-th missing element
is 1

Input : a[] = {2, 3, 5, 9, 10, 11, 12};
        k = 4;
Output : 7
Explanation: missing element in the increasing
sequence are {1, 4, 6, 7, 8}  so k-th missing
element is 7
 */
public class FindKthMissingNumber {
    public int kthMissingNumber(int[] arr, int k){
        // corner case:
        if(arr == null || arr.length == 0){
            return -1;
        }
        // highLight: binary search, count how many missing number between left and mid,
        // if less than k, meaning need to look for the right part, otherwise left part
        // how to calculate count of missing numbers: array[end] - array[start] - (end - start)
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k){
                start = mid + 1;
            }else{
                end = mid - 1 ;
            }
        }
        return start + k;
    }
    public int[] findingAllMissingNumber(int[] array){
        int n = array[array.length - 1];
        int index = 0;
        int[] res = new int[n + 1];
        int[] missing = new int[n - array.length + 1] ;
        Arrays.fill(res, -1);
        for(int i = 0; i < array.length; i++){
            res[array[i]] += 1;
        }
        for(int i = 0; i < n; i++){
            if(res[i] == -1){
                missing[index++] = i ;
            }
        }
        return missing;
    }
    public static void main(String[] args) {
        int[] array = {1,4,6};
        FindKthMissingNumber findKthMissingNumber = new FindKthMissingNumber();
        System.out.println(findKthMissingNumber.kthMissingNumber(array,2));
        System.out.println(Arrays.toString(findKthMissingNumber.findingAllMissingNumber(array)));
    }
}
