package Trie;
/*
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 */
public class ImplementTrie {
    class Trie {

        class TrieNode{
            TrieNode[] nei;
            boolean isWord;
            public TrieNode(){
                nei = new TrieNode[26];
            }
        }
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if(root == null){
                root = new TrieNode();
            }
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++){
                TrieNode next = cur.nei[word.charAt(i) - 'a'];
                if(next == null){
                    next = new TrieNode();
                    cur.nei[word.charAt(i) - 'a'] = next;
                }
                cur = next;
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            if(root == null){
                return false;
            }

            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++){
                TrieNode next = cur.nei[word.charAt(i) - 'a'];
                if(next == null){
                    return false;
                }else{
                    cur = next;
                }
            }
            return cur.isWord;
        }

        public boolean startsWith(String prefix) {
            if(root == null){
                return false;
            }

            TrieNode cur = root;
            for(int i = 0; i < prefix.length(); i++){
                TrieNode next = cur.nei[prefix.charAt(i) - 'a'];
                if(next == null){
                    return false;
                }else{
                    cur = next;
                }
            }
            return true;

        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
