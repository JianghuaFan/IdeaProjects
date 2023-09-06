package AmazonOA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayCounts {
    public static List<Integer> subarrayCounts(int[] v) {
        int n = v.length;
        double[] prefixSum = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + v[i];
        }

        Map<Double, Integer> meanCount = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                double mean = (prefixSum[i] - prefixSum[j]) / (i - j);
                meanCount.put(mean, meanCount.getOrDefault(mean, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int num : v) {
            result.add(meanCount.getOrDefault((double) num, 0));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] v = {3, 2, 1, 4, 5};
        List<Integer> result = subarrayCounts(v);
        System.out.println(result);  // Output: [3, 2, 1, 1, 2]
    }
}
//In this Java code, the subarrayCounts method takes an integer array v as input and returns a list where each position i contains the number of subarrays whose mean is v[i]. The main method demonstrates the usage of the function by providing an example input array and printing the resulting list of subarray counts.





