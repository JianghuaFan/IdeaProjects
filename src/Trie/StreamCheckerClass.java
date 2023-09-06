package Trie;

import OOD.OverRide;
import com.sun.corba.se.impl.naming.cosnaming.BindingIteratorImpl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/*
1032. Stream of Characters
Design an algorithm that accepts a stream of characters and
checks if a suffix of these characters is a string of a given array of strings words.

For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y', and 'z',
your algorithm should detect that the suffix "xyz" of the characters "axyz" matches "xyz" from words.

Implement the StreamChecker class:

StreamChecker(String[] words) Initializes the object with the strings array words.
boolean query(char letter) Accepts a new character from the stream and returns true
if any non-empty suffix from the stream forms a word that is in words

Example 1:

Input
["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
Output
[null, false, false, false, true, false, true, false, false, false, false, false, true]

Explanation
StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
streamChecker.query("a"); // return False
streamChecker.query("b"); // return False
streamChecker.query("c"); // return False
streamChecker.query("d"); // return True, because 'cd' is in the wordlist
streamChecker.query("e"); // return False
streamChecker.query("f"); // return True, because 'f' is in the wordlist
streamChecker.query("g"); // return False
streamChecker.query("h"); // return False
streamChecker.query("i"); // return False
streamChecker.query("j"); // return False
streamChecker.query("k"); // return False
streamChecker.query("l"); // return True, because 'kl' is in the wordlist
 */
public class StreamCheckerClass {

    //Highlights: Trie Tree
    // step 1: build the trie tree with every word in the array words, do this step in constructor
    //      1.1 TrieNode to store every TrieNode(Character) of every word
    // step 2: check the character from the stream, whether it is a suffix of the words(Trie Tree)
    //      2.1 use a stringBuilder to store the stream from the end to start,
    //      2.2 check whether it exist in trie and isWord
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            this.children = new TrieNode[256];
        }
    }
    TrieNode root;
    StringBuilder sb = new StringBuilder();


    public void insert(String word){
        TrieNode cur = root;
        for(int i = word.length() - 1; i >= 0 ; i--){
            int index = word.charAt(i) - 'A';
            if(cur.children[index] == null){
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }
    public boolean query(char letter){
        sb.append(letter);
        TrieNode cur = root;
        for(int i = sb.length() - 1; i >= 0; i--){
            int index = sb.charAt(i) - 'A';
            if(cur.children[index] == null){
                return false;
            }
            cur = cur.children[index];
            if(cur.isWord){
                return true;
            }
        }
        return false;
    }
    // Method 2: use map to store children
    TrieNodeWithMap rootMap  = new TrieNodeWithMap();;
    Deque<Character> stream = new ArrayDeque<>();
    class TrieNodeWithMap{
        Map<Character, TrieNodeWithMap> children = new HashMap<>();
        boolean isWord;
    }
    public StreamCheckerClass(String[] words){
        for(String word : words){
            TrieNodeWithMap cur = rootMap;
            String reverse = new StringBuilder(word).reverse().toString();
            for(char ch : reverse.toCharArray()){
                if(!cur.children.containsKey(ch)){
                    cur.children.put(ch, new TrieNodeWithMap());
                }
//                cur.children.putIfAbsent(ch, new TrieNodeWithMap());
                cur = cur.children.get(ch);
            }
            cur.isWord = true;
        }
//        System.out.println(cur);
    }
    public boolean queryWithMap(char letter){
        stream.offerFirst(letter);
        TrieNodeWithMap cur = rootMap;
        for(char ch : stream){
            if(!cur.children.containsKey(ch)){
                return false;
            }
            if(cur.children.get(ch).isWord){
                return true;
            }
            cur = cur.children.get(ch);
        }
        return cur.isWord;
    }



    public static void main(String[] args) {

        String[] words = {"abc", "xyz"};
        StreamCheckerClass streamCheckerClass = new StreamCheckerClass(words);
//        System.out.println("query a: " + streamCheckerClass.query('a'));
//        System.out.println("query b: " + streamCheckerClass.query('b'));
//        System.out.println("query c: " + streamCheckerClass.query('c'));
//        System.out.println("query x: " + streamCheckerClass.query('x'));
//        System.out.println("query y: " + streamCheckerClass.query('y'));
//        System.out.println("query z: " + streamCheckerClass.query('z'));
        System.out.println("queryWithMap b: " + streamCheckerClass.queryWithMap('b'));
        System.out.println("queryWithMap c: " + streamCheckerClass.queryWithMap('c'));
        System.out.println("queryWithMap x: " + streamCheckerClass.queryWithMap('x'));
        System.out.println("queryWithMap y: " + streamCheckerClass.queryWithMap('y'));
        System.out.println("queryWithMap z: " + streamCheckerClass.queryWithMap('z'));
    }
}
