package DFS;

import doubleIndex.Palindrome;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all the possible palindrome partitioning of s. A palindrome string is a string that reads the same backward as forward.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]
 */
/*
        aac
      /     \
     a|ab   aa|b
    /   \   /   \
  a|a|b    aa
 */
public class PalindromePartition {
    // highLevel: DFS
    // 多少层表示从哪里开始切，每一层所有可以切的位置

    public List<List<String>> allPalindromePartition(String input){
        if(input == null){
            return new ArrayList<>();
        }

        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        helper(input, res, cur, 0);
        return res;
    }
    private void helper(String input, List<List<String>> res, List<String> cur, int index){
        if(index == input.length()){
            res.add(new ArrayList<>(cur));
            return;
        }
        // 这一层所有可以切的位置
        for(int i = index; i < input.length(); i++){
            if(isPalindrome(input, index,i)){
                cur.add(input.substring(index, i + 1));
                helper(input, res, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String input, int i, int j) {
        while(i < j){
            if(input.charAt(i) != input.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "aab";
        PalindromePartition palindromePartition = new PalindromePartition();
        System.out.println(palindromePartition.allPalindromePartition(input));
    }
}
