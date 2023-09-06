package HashMap;

import CrossTraining.MergeKSortedArray;

import java.util.*;

/*
67. Top K Frequent Words
Medium
Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

Assumptions: the composition is not null and is not guaranteed to be sorted
K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
Return

a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
Examples

Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]
 */
public class TopKFrequentWords {
	class myComparator implements Comparator<Map.Entry<String, Integer>>{

		@Override
		public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
			if(m1.getValue() == m2.getValue()){
				return 0;
			}
			return m1.getValue() < m2.getValue() ? 1 : -1;
		}
	}
	public String[] topKFrequent(String[] combo, int k) {

		// CART:
		// Clarify: input : list or array? is it null? is k valid, what if k is smaller than the length of input
		//			output: list or array? Order
		// Assumptions: the composition is not null and is not guaranteed to be sorted
		// Solution: 1. count all the words and their frequency in a map
		// 			2. sort the words by their frequency in a priorityQueue
		//				(1) maxHeap: store all the word and frequency entry pairs of the map into the maxHeap, pop out k times into the result
		//				(2) minHeap: store first k entry pairs into the minHeap, compare (n - k) pairs with the top of the minHeap
		//			3. store the result
		// 	Result: TC: (1) maxHeap: n + klogk, SC: O(n) + O(n)
		//				(2) minHeap: klogk + (n-k) logk + klogk  SC: O(k) + O(n)
		// Test case:


		PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(k, new myComparator());
		Map<String, Integer> map = new HashMap<>();
		// count all the frequencies of the words into a map, key is the word, value is the frequency
		for(String str : combo){
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		for( Map.Entry<String, Integer> entry : map.entrySet()){
			maxHeap.offer(entry);
		}
		return getFreqStrings(maxHeap, k);
	}
		private String[] getFreqStrings(PriorityQueue<Map.Entry<String, Integer>> maxHeap, int k){

			if( k < maxHeap.size()){
				String[] res = new String[k];
				for(int i = 0; i < k; i++){
					res[i] = maxHeap.poll().getKey();
				}
				return res;
			}else{
				int size = maxHeap.size();
				String[] res = new String[size];
				for(int i = 0; i < size; i++){
					res[i] = maxHeap.poll().getKey();
				}
				return res;
			}
		}
	public String[] kMostFre(String[] input, int k){
		if (input == null || input.length == 0){
			return new String[]{};
		}
//highlevel:1.map store the key(word),value(frequence)
// 2. minHeap or maxHeap store the entries based on the frequce
		HashMap<String, Integer> map = new HashMap<>();
		for(String str: input){
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(k, new myComparator());
		for(Map.Entry entry: map.entrySet()){
			maxHeap.offer(entry);
		}
		String[] res = new String[k];
		for(int i = 0; i < k; i++){
			res[i] = maxHeap.poll().getKey().toString();
//					maxHeap.poll().getKey();
		}
		return res;
	}

	public String[] topK(String[] combo, int k){
		if(combo.length == 0) {
			return new String[0];
		}

		Map<String, Integer> freqMap = getFreqMap(combo);
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) -> entry2.getValue() - entry1.getValue());
//		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
//			@Override
//			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
//				return e1.getValue().compareTo(e2.getValue());
//			}
//		});
		for(Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			if(minHeap.size() < k) {
				minHeap.offer((entry));
			}else if(minHeap.peek().getValue() < entry.getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}
		return getFreqString(minHeap);
	}

	public String[] getFreqString(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
		String[] res = new String[minHeap.size()];
		int size = minHeap.size() - 1;
		for(int i = size; i >= 0; i--) {
			res[i] = minHeap.poll().getKey();
		}
		return res;
	}

	public Map<String, Integer> getFreqMap(String[] combo){
		Map<String, Integer> freqMap = new HashMap<>();
		if(combo == null){
			return freqMap;
		}
		for( String str : combo){
			freqMap.put(str, freqMap.getOrDefault(str,0) + 1);
		}
		return freqMap;
	}

	public List<Integer> descendingSort(List<Integer> list){
		Collections.sort(list,(i1, i2) -> i2 - i1);
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> freqMap = new HashMap<>();
		freqMap.put("a", 1);
//		System.out.print(freqMap.entrySet());
		String[] str = {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
		String[] input = {"i", "love", "school", "i", "love", "coding"};
		int k = 2;
		TopKFrequentWords top = new TopKFrequentWords();
		System.out.println(Arrays.toString(top.kMostFre(input,k)));
		System.out.println(Arrays.toString(top.topKFrequent(input,k)));
		System.out.println(Arrays.toString(top.topK(str, k)));
		Integer[] array = {5,3,2,4,1};
		List<Integer> list = Arrays.asList(array);
		System.out.println(top.descendingSort(list));
	}

}
