package BFSHeap;

import java.util.*;
/*
662. Word Ladder II
Medium
Given a begin word, an end word and a dictionary, find the least number transformations from begin word to end word, and return the transformation sequences. Return empty list if there is no such transformations.

In each transformation, you can only change one letter, and the word should still in the dictionary after each transformation.

Assumptions

1. All words have the same length.

2. All words contain only lowercase alphabetic characters.

3. There is no duplicates in the word list.

4.The beginWord and endWord are non-empty and are not the same.

Example: start = "git", end = "hot", dictionary = {"git","hit","hog","hot","got"}

Output: [["git","hit","hot"], ["git","got","hot"]]
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int endIndex = wordList.indexOf(endWord);
        if (endIndex == -1 || endIndex >= wordList.size()) {
            return new ArrayList<>();
        }
        List<String> words;
        int beginIndex = wordList.indexOf(beginWord);
        if (beginIndex == -1) {
            // the input wordList might not be appendable(e.g., the result of Arrays.asList).
            words = new ArrayList<String>(wordList);
            words.add(beginWord);
            beginIndex = words.size() - 1;
        } else {
            words = wordList;
        }
        NeighborFinder neighborFinder = new NeighborFinder(words);
        Queue<Integer> queue = new ArrayDeque<>();
        // step[i] represents the number of steps needed to convert the starting word to words[i](-1 if this word has not been generated)
        int[] step = new int[words.size()];
        Arrays.fill(step, -1);
        queue.offer(beginIndex);
        step[beginIndex] = 0;
        Tracer tracer = new Tracer(words);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == endIndex) {
                return tracer.findLadders(beginIndex, endIndex);
            }
            for (int y : neighborFinder.findNeighbors(x)) {
                if (step[y] == -1) {
                    queue.offer(y);
                    step[y] = step[x] + 1;
                }
                if (step[x] + 1 == step[y]) {
                    tracer.addPredecessor(x, y);
                }
            }
        }
        return new ArrayList<>();
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

    public class Tracer{
        private List<String> words;
        private List<List<Integer>> preds;
        public Tracer(List<String> words){
            this.words = words;
            preds = new ArrayList<>(words.size());
            for(int i = 0; i < words.size(); i++){
                preds.add(new ArrayList<>(16));
            }
        }

        public void addPredecessor(int x, int y){
            preds.get(y).add(x);
        }

        public List<List<String>> findLadders(int beginIndex, int y) {
            List<List<String>> ladders = new ArrayList<>();
            List<String> trace = new ArrayList<>();
            trace.add(words.get(y));
            findLaddersHelper(beginIndex, y, trace, ladders);
            return ladders;
        }

        private void findLaddersHelper(int beginIndex, int y, List<String> trace, List<List<String>> ladders) {
            if(beginIndex == y){
                List<String> ladder = new ArrayList<>(trace);
                Collections.reverse(ladder);
                ladders.add(ladder);
                return;
            }
            for(int x : preds.get(y)){
                trace.add(words.get(x));
                findLaddersHelper(beginIndex, x, trace, ladders);
                trace.remove(trace.size() - 1);
            }
        }
    }
    public static void main(String[] args){
        WordLadderII wordLadderII = new WordLadderII();
        String beginWord = "gat";
        String endWord = "hot";
        String[] input = {"git","hit","hog","hot","got"};
        List<String> wordList = Arrays.asList(input);
        System.out.println(wordLadderII.findLadders(beginWord, endWord,wordList));
    }
}
