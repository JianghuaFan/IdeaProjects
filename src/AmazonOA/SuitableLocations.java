package AmazonOA;

import java.util.Arrays;

public class SuitableLocations {
    public static int numSuitableLocations(int[] centers, int d) {
        int n = centers.length;
        Arrays.sort(centers);  // Sort the centers for efficient calculation

        int numSuitable = 0;

        for (int i = 0; i < n; i++) {
            int leftDist = Math.abs(centers[i] - centers[0]);
            int rightDist = Math.abs(centers[n - 1] - centers[i]);

            if (leftDist <= d && rightDist <= d) {
                numSuitable++;
            }
        }

        return numSuitable;
    }

    public static void main(String[] args) {
        int[] centers = {-2, 1, 0};
        int d = 8;

        int result = numSuitableLocations(centers, d);
        System.out.println("Number of suitable locations: " + result);  // Output: 3
    }
}
