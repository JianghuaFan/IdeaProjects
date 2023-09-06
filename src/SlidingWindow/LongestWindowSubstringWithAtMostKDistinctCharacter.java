package SlidingWindow;
/*
Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters

input: s = "eceba", k = 2
output: 3
Explanation: substring is "ece" with length 3
Ex2:
input: s = "aa", k = 1
output: 2
 */

import java.util.HashMap;
import java.util.Map;

public class LongestWindowSubstringWithAtMostKDistinctCharacter {

    public int longestSubstringWithKDistinctCharacter(String str, int k){
        // Highlevel: sliding window: we will check sliding window whether there are less or equal than k distinct,
        // use a map(key is character, value is occurrence) map.size can tell how many distinct characters
        // step 1: add fast,
        // step2: while(不满足条件） remove slow 因为我们想要最长的，所以slow越靠左越好，所以一旦变成满足条件就更新结果
        // step3: update result
        if(str == null || str.length() == 0){
            return 0;
        }
        int longest = 0;
        int slow = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int fast = 0; fast < str.length(); fast++){
            // step1:
            Character cur = str.charAt(fast);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            // step2:
            while(map.size() > k){
                cur = str.charAt(slow);
                Integer count = map.get(cur);
                if(count != null){
                    if(count == 1){
                        map.remove(cur);
                    }
                    else{
                        map.put(cur, count - 1 );
                    }
                }
                slow++;
            }
            longest = Math.max(longest, fast - slow + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        String str = "eceda";
        int k = 2;
        LongestWindowSubstringWithAtMostKDistinctCharacter longestWindowSubstringWithAtMostKDistinctCharacter  = new LongestWindowSubstringWithAtMostKDistinctCharacter();
        System.out.println(longestWindowSubstringWithAtMostKDistinctCharacter.longestSubstringWithKDistinctCharacter(str, k));
    }
}

