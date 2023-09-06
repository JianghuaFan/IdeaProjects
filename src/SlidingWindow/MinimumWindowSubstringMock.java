package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringMock {
    public String Anagram(String s, String t){
        if(t.length() > s.length()){
            return new String();
        }
        Map<Character, Integer> mapT = count(t);
        int globalMin = Integer.MAX_VALUE;
//
        int match = 0;
        int start = 0;
        int slow = 0;
        StringBuilder sb = new StringBuilder();
        String res = new String();
        for(int fast = 0; fast < s.length(); fast++) {
            char curFast = s.charAt(fast);
            Integer countFast = mapT.get(curFast);
            if ( countFast != null) {
                countFast--;
                mapT.put(curFast, countFast);
                if (countFast == 0) {
                    match++;
                }
            }
                //step2: while(condition satisfies) delete left letters,
            while( match == mapT.size()){
                int curMin = fast - slow + 1;
                if( curMin < globalMin){
                    globalMin = curMin;
                    start = slow;
                    res = s.substring(start, fast + 1).toString();
                }
                char curSlow = s.charAt(slow);
                Integer countSlow = mapT.get(curSlow );
                if ( countSlow != null){
                    countSlow++;
                    if(countSlow > 0){
                        match--;
                    }
                    mapT.put(curSlow, countSlow);
                }
                slow++;
            }
        }
        return res;
    }


    //freq map <char, freq>
    private Map<Character, Integer> count(String t){
        Map<Character, Integer> mapT = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer countLetter = mapT.get(c);
            if(countLetter == null){
                mapT.put(c, 1);
            } else {
                mapT.put(c, countLetter + 1);
            }
        }
        return mapT;
    }
    public static void main(String[] args) {
        MinimumWindowSubstringMock minimumWindowSubstringMock = new MinimumWindowSubstringMock();
        String longer = "ABCDEBDAC";
        String shorter = "ABC";
        System.out.println(minimumWindowSubstringMock.Anagram(longer, shorter));
    }
}
