package BFSHeap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/*
191. Largest Product Of Length
Hard
Given a dictionary containing many words, find the largest product of two words’ lengths, such that the two words do not share any common characters.

Assumptions

The words only contains characters of 'a' to 'z'
The dictionary is not null and does not contains null string, and has at least two strings
If there is no such pair of words, just return 0
Examples

dictionary = [“abcde”, “abcd”, “ade”, “xy”], the largest product is 5 * 2 = 10 (by choosing “abcde” and “xy”)
 */
public class LargestProductOfLength {
    // TC: O(n^2 + |sum of all words' length|)
    // SC: O(n)
    public int largestProduct(String[] dict) {
        // Write your solution here
        //The words in the dictionary only use character 'a' - 'z'
        // Get the bit mask for each of the word in the dict,
        // the bit mask is represented by the lowest 26 bits of an integer
        // each of the bit represented ont of the characters in 'a' - 'z'
        HashMap<String, Integer> bitMasks = getBitMasks(dict);
        Arrays.sort(dict, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()){
                    return 0;
                }
                return s2.length() - s1.length();
            }
        });
        int res = 0;
        // note the order of constructing all the pairs, we make our best to try the largest product

        for(int i = 1; i < dict.length; i++){
            for(int j = 0; j < i; j++){
                // early break if the product is already smaller than the current largest one
                int prod = dict[i].length() * dict[j].length();
                if(prod <= res){
                    break;
                }
                int iMask = bitMasks.get(dict[i]);
                int jMask = bitMasks.get(dict[j]);
                // if two words do not share any common characters, the bit masks "and" result should be 0
                // since there is not any position such that in the two bit masks they are all 1
                if((iMask & jMask) == 0){
                    res = prod;
                }
            }
        }
        return res;
    }
    // Get the bit mask for each of the words
    private HashMap<String, Integer> getBitMasks(String[] dict) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : dict){
            int bitMask = 0;
            for(int i = 0; i < str.length(); i++){
                // the 26 characters 'a' - 'z' are mapped to 0 - 25th bit to determine which bit it is for a character x
                // use (x  - 'a') since there values are in a consecutive range
                // if character x exists in the word, we set the bit at corresponding index to 1
                bitMask |= 1 << str.charAt(i) - 'a';
            }
            map.put(str, bitMask);
        }
        return map;
    }

    public static void main(String[] args){
        LargestProductOfLength largest = new LargestProductOfLength();
        String[] input = {"abcde","abcd", "ade","xy", "abc", "ab"};
        String[] test = {"abc", "ab"};
//        System.out.println(largest.largestProduct(input));
        System.out.println(largest.getBitMasks(test));
    }
}
