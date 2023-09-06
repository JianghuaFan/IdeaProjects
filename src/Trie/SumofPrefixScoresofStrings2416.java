package Trie;

import java.util.Arrays;

/*
2416. Sum of Prefix Scores of Strings
Hard
519
41
company
Google
You are given an array words of size n consisting of non-empty strings.

We define the score of a string word as the number of strings words[i] such that word is a prefix of words[i].

For example, if words = ["a", "ab", "abc", "cab"], then the score of "ab" is 2, since "ab" is a prefix of both "ab" and "abc".
Return an array answer of size n where answer[i] is the sum of scores of every non-empty prefix of words[i].

Note that a string is considered as a prefix of itself.



Example 1:

Input: words = ["abc","ab","bc","b"]
Output: [5,4,3,2]
Explanation: The answer for each string is the following:
- "abc" has 3 prefixes: "a", "ab", and "abc".
- There are 2 strings with the prefix "a", 2 strings with the prefix "ab", and 1 string with the prefix "abc".
The total is answer[0] = 2 + 2 + 1 = 5.
 */
public class SumofPrefixScoresofStrings2416 {
    // HighLight: TrieTree
    // step1: construct the TrieTree with the input array of String
    // step2: traverse the input string, for every string, count the prefixSum of the string
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        int prefixSum;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    public SumofPrefixScoresofStrings2416(String[] words){
        for(String word : words){
            insert(word);
        }
    }
    private void insert(String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cur.children[index] == null){
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
            cur.prefixSum++;
        }
        cur.isWord = true;
    }

    public int[] sumPrefixScores(String[] words){
        SumofPrefixScoresofStrings2416 sumofPrefixScoresofStrings2416 = new SumofPrefixScoresofStrings2416(words);
        int resIndex = 0;
        int[] res = new int[words.length];
        for(String word : words){
            TrieNode cur = root;
            int curr = 0;
            for(int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(cur.children[index] == null){
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
                curr += cur.prefixSum;
            }
            res[resIndex++] = curr;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"abc","ab","bc","b"};
        SumofPrefixScoresofStrings2416 sumofPrefixScoresofStrings2416 = new SumofPrefixScoresofStrings2416(words);
        System.out.println(Arrays.toString(sumofPrefixScoresofStrings2416.sumPrefixScores(words)));
    }
}
