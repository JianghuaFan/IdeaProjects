package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MinimumWindowSubstring {
    public String minimumWindowSubstring(String shorter, String longer){
        // highlevel: sliding window, for every sliding window in longer string to check whether it contains all the character of the shorter string
        // step 1: build a map of shorter string
        // step 2: use a sliding window to check :
        // 2.1 move fast
        // 2.2 move slow, while 满足结果，尽可能移动slow直到不满足条件，前一个状态就是最后的结果
        // 2.3 update result
        // TC: O(n) SC: O(m): n is the length of longer, m is the length of shorter
        if(longer == null || shorter == null || longer.length() == 0 || shorter.length() == 0){
            return "";
        }
        if(shorter.length() > longer.length()){
            return new String();
        }
        // step 1：
        HashMap<Character, Integer> map = buildMap(shorter);
        // step 2:
        int match = 0;
        int slow = 0;
        int start = 0;
        int shortest = Integer.MAX_VALUE;
        for(int fast = 0; fast < longer.length(); fast++){
            // 2.1 move fast
            char cur = longer.charAt(fast);
            Integer count = map.get(cur);
            // case 1 : null 说明shorter里没有当前fast元素，什么也不做， case 2: 有当前元素，count就减1， 如果count是1，减1后成为0，就多一个match
            if(count != null){
                if(count == 1){
                    match++; // 当前元素需求变为了0
                }
                map.put(cur, count - 1);// 需要当前char的需求减1
            }
            // 2.2 move slow 同时更新结果
            // while 当前Sliding window满足情况，move slow，一直移动到第一个不满足条件的slow为止，while loop里所有Sliding window都满足条件，所有每次都更新global min
            while(match == map.size()){
                if(shortest > fast - slow + 1){
                    shortest = fast - slow + 1;
                    start = slow;
                }
                char ch = longer.charAt(slow);
                Integer countSlow = map.get(ch);
                if(countSlow != null){
                    if(countSlow == 0){// 由于 slow 的count本来是0， remove 掉slow后需求变多了，match就变少了
                        match--;
                    }
                    map.put(ch, countSlow + 1);
                }
                slow++;
            }
        }
        return shortest == Integer.MAX_VALUE ? "" : longer.substring(start, start + shortest);
    }
    public void TreeMapTest(){

    }

    private HashMap<Character,Integer> buildMap(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for(char a: str.toCharArray()){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String longer = "ADEBAC";
        String shorter = "ABC";
        System.out.println(minimumWindowSubstring.minimumWindowSubstring(shorter, longer));
        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        treeMap.put('f',6);
        treeMap.put('d',4);
        treeMap.put('c',3);
        treeMap.put('b',2);
        treeMap.put('e',5);
        System.out.println(treeMap.ceilingEntry('a'));
        System.out.println(treeMap.ceilingKey('a'));
        System.out.println(treeMap.floorEntry('z'));

    }
}
