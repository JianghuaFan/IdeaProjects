package Trie;

import OOD.OverRide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns the list of words with the same prefix, if this is a new word, add it to the dictionary.

 input: "a" , "a", "apple", "app", "a"
 output:[""], ["a"], [""], ["app","apple"],["a","app","apple"]

        ""
        a/\
       ""
      p/
      ""
    p/
   ""
  l/
  ""
  e/
   */
public class AutoCompletion {
    //use a trie tree to build the dictionary with the input words
    // TC: O(n ) n is the length of the words input, worst case would be the length of the longest word in the dictionary
    private TrieNode root = new TrieNode();
//    public AutoCompletion(TrieNode root) {
//        this.root = root;
//    }

    static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    public List<String> search(String word) {
        // we will search word in the dictionary, if we can find it, we will return true;
        // otherwise if we cannot find it, we add it to the dictionary and mark it as a word
        TrieNode cur = root;
        boolean exist = true;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(cur == null){
//                cur = new TrieNode();
            }
            if (!cur.children.containsKey(ch)) {
                exist = false;// there are no words with the same prefix of the word, we need to add it to the dictionary
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(exist){// there are words with the same prefix of the word
            sb.append(word);
            res.add(word);
            findAllWords(res, sb, word, cur);
        }
        return res;
    }

    private void findAllWords(List<String> res, StringBuilder sb, String word, TrieNode cur) {
        // DFS to find all the words with prefix of word
        // base case:
        if(cur == null){
            if(cur.isWord) {
                res.add(sb.toString());
            }
            return;
        }
        for(Map.Entry<Character, TrieNode> entry : cur.children.entrySet()){

            sb.append(entry.getKey());
            if(entry.getValue().isWord) {
                res.add(sb.toString());
            }
            findAllWords(res, sb, word,entry.getValue());
            sb.deleteCharAt(sb.length() - 1);
            }
        }

    public static void main(String[] args) {
        String input1 = "a";
        String input2 = "app";
        String input3 = "apple";
        AutoCompletion autoCompletion = new AutoCompletion();
        System.out.print(autoCompletion.search(input1));
        System.out.print(autoCompletion.search(input2));
        System.out.print(autoCompletion.search(input3));
        System.out.print(autoCompletion.search(input1));
    }
}
