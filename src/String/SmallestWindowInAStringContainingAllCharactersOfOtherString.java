package String;

import java.util.HashMap;

/*
Given two strings, string and pattern, the task is to find the smallest substring in string containing all characters of pattern.

Examples:

Input: string = “this is a test string”, pattern = “tist”
Output: “t stri”
Explanation: “t stri” contains all the characters of pattern.

Input: string = “geeksforgeeks”, pattern = “ork”
Output: “ksfor”
 */
public class SmallestWindowInAStringContainingAllCharactersOfOtherString {
    static final int no_of_char = 256;
    public String findAnotherString(String input, String pattern){
        if(input == null || pattern == null){
            return null;
        }

        int inputLength = input.length();
        int patternLength = pattern.length();
        if(patternLength > inputLength){
            return "";
        }
        // step 1: store the pattern into a HashMap array
        int[] patternMap = new int[no_of_char];
        int[] inputMap = new int[no_of_char];

        for(int i = 0; i < patternLength; i++){
            patternMap[pattern.charAt(i)]++;
        };

        // record the start of the subString in the input
        int start = 0;
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < input.length(); i++){
            // put input.charAt(i) 到inputMap里
            char temp = input.charAt(i);
            inputMap[temp]++;
            if(patternMap[temp] >= inputMap[temp]){
                count++;
            }
            // all letters have been found in input[start, i], try to minimize the window by remove start side
            if(count == patternLength){
                while(patternMap[input.charAt(start)] == 0 || patternMap[input.charAt(start)] < inputMap[input.charAt(start)]){
                    if(patternMap[input.charAt(start)] < inputMap[input.charAt(start)]){
                        inputMap[input.charAt(start)]--;
                    }
                    start++;
                }
                int curMin = i - start + 1;
                if(minLen > curMin){
                    minLen = curMin;
                    startIndex = start;
                }
            }
        }
        if(startIndex == -1){
            System.out.println("No such string");
            return "";
        }
        return input.substring(startIndex,startIndex + patternLength);
    }

    public static void main(String[] args) {
        String input = "abacb";
        String pattern = "bc";
        SmallestWindowInAStringContainingAllCharactersOfOtherString small = new SmallestWindowInAStringContainingAllCharactersOfOtherString();
        System.out.println(small.findAnotherString(input, pattern));
        System.out.println("result..........................");
    }
}
