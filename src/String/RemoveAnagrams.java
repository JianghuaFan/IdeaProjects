package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RemoveAnagrams {
    public String[] removeAnagrams(List<String> words){
        // highlevel traverse every word to check is there is any anagram, yes: continue. no: add into res
        // corner case:
        if(words == null || words.size() == 0){
            return new String[0];
        }
        List<String> res = new ArrayList<>();
        // step 1:
        String prev = "";
        for(String str : words){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String cur = String.valueOf(array);
            if(!cur.equals(prev)){
                res.add(str);
                prev = cur;
            }
        }
        int n = res.size();
        String[] ret = new String[n];
        for(int i = 0; i < n; i++){
            ret[i] = res.get(i);
        }
        return ret;
    }
    public List<String> removeAnagrams(String[] words) {
        Stack<String> stack = new Stack<>();
        for(int i = words.length-1;i>= 0;i--){
            String s = words[i];
            while(!stack.isEmpty() && anagram(stack.peek(),s) == true)stack.pop();
            stack.push(s);
        }
        List<String> res = new ArrayList<>();
        while(!stack.isEmpty())res.add(stack.pop());
        return res;
    }

    public boolean anagram(String p,String q){
        int arr[] = new int[26];
        for(char i : p.toCharArray())arr[i-'a']+=1;
        for(char i : q.toCharArray())arr[i-'a']-=1;
        for(int i : arr)if(i != 0)return false;
        return true;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abba","cd","baba","bbaa","cd");

        System.out.println(list);
        RemoveAnagrams removeAnagrams = new RemoveAnagrams();
        String[] strs = removeAnagrams.removeAnagrams(list);
        for (String str : strs)
        System.out.print(str + ",");
//        String str1 = "abc";
//        System.out.println();
//        System.out.print("valueOfString:" + String.valueOf(str1));
    }
}
