package Greedy;

import java.util.Arrays;

public class FindMinimumGroupOfArrayWithDifferenceLessThanK {

    public int minSegments(int[] nums, int k) {
        Arrays.sort(nums);
        int segments = 1;
        int minInSegment = nums[0];
        int maxInSegment = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num - minInSegment > k || maxInSegment - num > k) {
                segments++;
                minInSegment = num;
                maxInSegment = num;
            } else {
                minInSegment = Math.min(minInSegment, num);
                maxInSegment = Math.max(maxInSegment, num);
            }
        }

        return segments;
    }

    public static void main(String[] args) {
        FindMinimumGroupOfArrayWithDifferenceLessThanK solution = new FindMinimumGroupOfArrayWithDifferenceLessThanK();
        int[] nums1 = {3, 7, 1, 5, 9};
        int[] nums2 = {1, 13, 6, 8, 9, 3, 5};
        int k = 3;
        int result = solution.minSegments(nums1, k);
        int result1 = solution.minSegments(nums2, 4);
        System.out.println("Minimum number of segments 1 : " + result); // Output: Minimum number of segments: 3
        System.out.println("Minimum number of segments 2: " + result1); // Output: Minimum number of segments: 3

    }

}
