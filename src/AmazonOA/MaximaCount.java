package AmazonOA;

public class MaximaCount {
    public static int findMaximumMaximaCount(String categories) {
        int n = categories.length();
        int[] freq = new int[26]; // Assuming categories consist of lowercase English letters
        int maxMaximaCount = 0;

        for (int i = 0; i < n; i++) {
            freq[categories.charAt(i) - 'a']++; // Increment frequency of current category
            int maxFreq = 0;

            // Calculate maximum frequency encountered so far
            for (int j = 0; j < 26; j++) {
                if (freq[j] > maxFreq) {
                    maxFreq = freq[j];
                }
            }

            int maximaCount = 0;

            // Calculate MaximaCount for each category up to index i
            for (int j = 0; j < 26; j++) {
                if (freq[j] == maxFreq) {
                    maximaCount++;
                }
            }

            // Update maximum MaximaCount
            if (maximaCount > maxMaximaCount) {
                maxMaximaCount = maximaCount;
            }
        }

        return maxMaximaCount;
    }

    public static void main(String[] args) {
        String categories = "adbcbcbcc";
        int result = findMaximumMaximaCount(categories);
        System.out.println(result);  // Output: 6
    }
}
