package DP;

import java.util.Arrays;

/*
238. Product of Array Except Self
Medium

15538

867

Add to List

Share
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
 */
/* Test Cases:
1. array of positive numbers
2. array of negative numbers
3. array of 1 zero
4. array of multiple zeros
 */

public class ProductOfArrayExceptForSelf {
    public int[] productExceptSelf(int[] nums) {
        // high level: calculate the prefix(product forward) and suffix(product backward) of elements previous the current element,
        // store in the left array and right array, then combine the two array
        // TC: O(n)  SC: O(n)
        // optimize with SC: O(1) , use one array res[] to store the prefix, traverse backward to multiply the prefix with the next element
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int[] res = new int[nums.length];
        //step 1: calculate the prefix
        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        // step 2: calculate the product exclude itself, we use a suffix to store the right suffix
        int suffix = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] = res[i] * suffix;
            suffix *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        ProductOfArrayExceptForSelf productOfArrayExceptForSelf = new ProductOfArrayExceptForSelf();
        System.out.println(Arrays.toString(productOfArrayExceptForSelf.productExceptSelf(nums)));
    }
}
