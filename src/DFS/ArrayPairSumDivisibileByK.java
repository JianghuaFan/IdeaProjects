package DFS;

import OOD.OverRide;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayPairSumDivisibileByK {
    // highlever: permutation
    // use DFS to swap every pair of index , in the meantime, check if both half of array can % k == 0, if yes return true
    // TC: O(n! * n ) SC:(n)call stack
    public boolean arrayPairSumDivisibleByK(int[] array, int k){

        if(array == null || array.length == 0 || array.length % 2 == 1){
            return false;
        }
        int size = array.length;
        int sum = 0;
        for(int i : array){
            sum += i;
        }
        boolean[] res = new boolean[1];
        DFS(array, 0, size, k, sum, res);
        return res[0];
    }
    private void DFS(int[] array, int index, int size , int k, int sum, boolean[] res){
//        if(index == size){// 当添加到一半元素的时候检查，左右两个子数组是否可以被k整除
            int sum1 = 0;
            for(int j = 0; j < size/ 2; j++){
                sum1 += array[j];
            }
            if(sum1 % k == 0 && (sum - sum1) % k == 0){
                res[0] =  true;
                return;
            }
//        }
        for(int i = index; i < size; i++){
            swap(array, index ,i);
            DFS(array, index + 1, size, k, sum, res );
            swap(array, index, i);
        }
    }
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public boolean canPair(int[] array , int k){
        // highlevel: hash map TC: O(n). //Auxiliary Space: O(n)
        // step 1: traverse the array and count the occurrences of all the remainder( (array[i] % k + k) % k
        // step2: traverse the array again
        // a. find the remainder of the current element
        // b. 2*rem == k
        //      If remainder divides k into two halves, then
        //      there must be even occurrences of it as it
        //      forms pair with itself only.
        //   c) rem == 0
        //      If the remainder is 0, then there must be
        //      even occurrences.
        //   d) rem + cur == k
        //      Else, number of occurrences of current
        //      the remainder must be equal to a number of
        //      occurrences of "k - current remainder".
        if(array == null || array.length == 0 || array.length % 2 == 1){
            return false;
        }
        // Create a frequency array to count occurrences
        // of all remainders when divided by k.
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = array.length;
        // Count occurrences of all remainders
        for(int i = 0; i < array.length; i++){
            int rem = (array[i] % k + k) % k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        // Traverse input array and use freq[] to decide
        // if given array can be divided in pairs
        for(int num: array) {
            int rem = (num % k + k) % k;
            // If remainder with current element divides
            // k into two halves.
            if (2 * rem == k || rem == 0) {
                // Then there must be even occurrences of
                // such remainder
                if (map.get(rem) % 2 == 1) {
                    return false;
                }
            }
            // If remainder is 0, then there must be two
            // elements with 0 remainder
//            else if (rem == 0) {
//                if (map.get(rem) % 2 == 1) {
//                    return false;
//                }
//            }
            // Else number of occurrences of remainder
            // must be equal to number of occurrences of
            // k - remainder
            else {
                if (map.get(rem) != map.get(k - rem)) {
                    return false;
                }
            }
        }
        return true;
    }
    //A Simple Solution is to iterate through every element arr[i].
    // Find if there is another not yet visited element that has a remainder like (k – arr[i]%k).
    // If there is no such element, return false. If a pair is found, then mark both elements as visited.
    // The time complexity of this solution is O(n2 and it requires O(n) extra space.
    static boolean canPairs(int nums[], int n, int k)
    {
        // Array with odd length
        // cannot be divided
        if (n % 2 == 1)
            return false;

        // Initialize count = 0
        int count = 0;

        int vis[] = new int[n];
        Arrays.fill(vis,-1);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((nums[i] + nums[j]) % k == 0 && vis[i] == -1 && vis[j] == -1) {

                    // if pair is divisible increment
                    // the count and mark elements
                    // as visited
                    count++;
                    vis[i] = 1;
                    vis[j] = 1;
                }
            }
        }

        if (count == n / 2)
            return true;

        return false;
    }
    public static void main(String[] args) {
        int[] array = {9,5,7,3};
        int[] array1 = {3,3,2,4};
        int k = 4;
        ArrayPairSumDivisibileByK arrayPairSumDivisibileByK = new ArrayPairSumDivisibileByK();
        System.out.println(arrayPairSumDivisibileByK.arrayPairSumDivisibleByK(array1, k));
        System.out.println(arrayPairSumDivisibileByK.canPair(array1, k));
    }
}
