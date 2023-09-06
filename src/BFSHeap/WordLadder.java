package BFSHeap;

import java.util.*;

/*
661. Word Ladder
Medium
Given a begin word, an end word and a dictionary, find the least number transformations from begin word to end word, and return the length of the transformation sequence. Return 0 if there is no such transformations.

In each transformation, you can only change one letter, and the word should still in the dictionary after each transformation.

Assumptions

1. All words have the same length.

2. All words contain only lowercase alphabetic characters.

3. There is no duplicates in the word list.

4.The beginWord and endWord are non-empty and are not the same.

Example: start = "git", end = "hot", dictionary = {"git","hit","hog","hot"}

Output: 3

Explanation: git -> hit -> hot
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Write your solution here
        int endIndex = wordList.indexOf(endWord);
        int beginIndex = wordList.indexOf(beginWord);
        if (endIndex == beginIndex) {
            return 0;
        }
        List<String> words;

        if (beginIndex == -1) {// beginWord 不在list里，要先加上
            // the input wordList might not be appendable(e.g., the result of Arrays.asList).
            words = new ArrayList<String>(wordList);
            words.add(beginWord);
            beginIndex = words.size() - 1;
        } else {
            words = wordList;
        }
        NeighborFinder neighborFinder = new NeighborFinder(words);
        Queue<Pair<Integer,Integer>> queue = new ArrayDeque<>();
        Map<Integer, Boolean> visited = new HashMap<>();
//
        queue.offer(new Pair(beginIndex,1));
        visited.put(beginIndex, true);
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.index;
            int length = pair.length;
            if (x == endIndex) {
                return length;
            }
            for (int y : neighborFinder.findNeighbors(x)) {
                if (!visited.containsKey(y)) {
                    queue.offer(new Pair<>(y,length + 1));
                    visited.put(y, false);
                }
            }
//            length += 1;
        }
        return 0;
    }
    class Pair<S, I extends Number> {
        Integer index;
        Integer length;
        public Pair(Integer index, Integer length){
            this.index = index;
            this.length = length;
        }
    }
    static class NeighborFinder{
        private Map<String, Integer> wordIndex = new HashMap<>();
        private List<String> words;
        public NeighborFinder(List<String> words){
            for(int i = 0; i < words.size(); i++){
                String word = words.get(i);
                wordIndex.put(word, i);
            }
            this.words = words;
        }
        public List<Integer> findNeighbors(int i){
            List<Integer> neighbors = new ArrayList<>();
            String word = words.get(i);
            StringBuilder wordModifier = new StringBuilder(word);
            for(int j = 0; j < wordModifier.length(); j++){
                char orig = word.charAt(j);
                for(char c = 'a'; c <= 'z'; c++){
                    if(c == orig){
                        continue;
                    }
                    wordModifier.setCharAt(j, c);
                    int neighbor = wordIndex.getOrDefault(wordModifier.toString(), -1);
                    if(neighbor != -1){
                        neighbors.add(neighbor);
                    }
                }
                wordModifier.setCharAt(j,orig);
            }
            return neighbors;
        }
    }
    public static void main(String[] args){
        WordLadder wordLadder = new WordLadder();
        String beginWord = "hit";
        String endWord = "hot";
        String[] input = {"git","hit","hog","hot","got"};
        List<String> wordList = Arrays.asList(input);
        System.out.println(wordLadder.ladderLength(beginWord, endWord,wordList));
        String[] input2 = {"bac","adb","abb","bdb","bba","cdd","bab","aaa","bcd","acd","cdb"};
        String beginWord2 = "cdb";
        String endWord2 = "bab";
        List<String> wordList2 = Arrays.asList(input2);
        System.out.println(wordLadder.ladderLength(beginWord2, endWord2,wordList2));
    }
}
