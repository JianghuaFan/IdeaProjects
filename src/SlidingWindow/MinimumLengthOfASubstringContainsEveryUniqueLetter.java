package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Example:
"abcb" -> 3 "abc" is the shortest substring contains a b c
"aaa" -> 1
"abbbc" -> 5
 */
public class MinimumLengthOfASubstringContainsEveryUniqueLetter {
    public int minimumLength(String str){
        // highlevel: use a map to store all letters of the string, sliding window to calculate the shortest substring
        // step 1: build map
        // step 2: sliding window:
        // step 2.1 move fast
        // step 2.2 while(满足条件，remove slow) 知道不满足条件，
        // step 2.3 update result
        if(str == null ||  str.length() == 0){
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch : str.toCharArray()){
            map.put(ch, 1);// 每个字母需要1，一会儿add fast时候遇到该字母就-1，说明多了一个匹配字母，如果值变为0 则match++,remove slow的时候遇到一个就+1，说明少了一个匹配字母，如果count变成1，说明少了一个匹配match--
        }
        int slow = 0;
        int match = 0;// 初始值没有match，所以设置为0
        int shortest = Integer.MAX_VALUE;
        int start= 0;
        for(int fast = 0; fast < str.length(); fast++){
            // add fast
            Character cur = str.charAt(fast);
            Integer count = map.get(cur);

            if(count != null){// meaning fast is what we need, match 减少1
                if(count == 1){
                    match++;//
                }
                map.put(cur, count - 1);
            }
            // remove slow and update result
            while(match == map.size()){
                shortest = Math.min(shortest, fast - slow + 1);
                cur = str.charAt(slow);
                count = map.get(cur);
                if(count != null){// slow位置上的是我们需要的
                    if(count == 0){// 原先是0已经不需要的现在remove slow所以又需要了，match--
                        match --;
                    }
                    map.put(cur, count + 1);
                }
                slow++;
            }
        }
        return shortest;
    }
    public int sol(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), 0);
        }
        int count = map.size();
        int left = 0;
        int right = 0;
        int result = 0x7FFFFFFF;
        while (left < str.length()) {
            if (count == 0) {
                char c = str.charAt(left++);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count++;
                }
            } else {
                if (right == str.length()) break;
                char c = str.charAt(right++);
                map.put(c, map.get(c) + 1);
                if (map.get(c) == 1) { // come from 0
                    count--;
                }
            }
            if (count == 0) {
                result = Math.min(result, right - left);
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        MinimumLengthOfASubstringContainsEveryUniqueLetter minimumLengthOfASubstringContainsEveryUniqueLetter = new MinimumLengthOfASubstringContainsEveryUniqueLetter();
        String str = "abbcab";
        String str2 = "aaa";
        System.out.println(minimumLengthOfASubstringContainsEveryUniqueLetter.sol(str));
        System.out.println(minimumLengthOfASubstringContainsEveryUniqueLetter.sol(str2));
        System.out.println(minimumLengthOfASubstringContainsEveryUniqueLetter.minimumLength(str));
        System.out.println(minimumLengthOfASubstringContainsEveryUniqueLetter.minimumLength(str2));
    }
}
