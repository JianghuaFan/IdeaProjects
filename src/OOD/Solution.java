package OOD;
import java.util.PriorityQueue;

import java.util.*;

/*
input1: list of string
input2: int k
kth high frequency(one)
principle: HashMap : count freq of all string, (TC: O(n), SC: O(n))
    MaxHeap string through freq(TC: O(k*logk + (n-k)*logk), SC: O(logk))
    poll k-1 , get last kth res :
 */
public class Solution {
    public String kthMinHeap(List<String> list, int k){
        Map<String, Integer> map = new HashMap<>();
        for(String str: list){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2){
                if(m1.getValue().intValue() == m2.getValue().intValue()){
                    return 0;
                }
                return m1.getValue() -  m2.getValue();
            }

        });

        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(entry);
            }
            else{
                if(minHeap.peek().getValue() < entry.getValue()){
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        return minHeap.poll().getKey();
    }

    public String kthMaxHeap(List<String> list, int k){
        Map<String, Integer> map = new HashMap<>();
        for(String str : list){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(map.size(), new Comparator<Map.Entry<String, Integer>>(){

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().intValue() == o2.getValue().intValue()){
                    return 0;
                }
                return o2.getValue().intValue() - o1.getValue().intValue();
            }
        });
        for(Map.Entry<String, Integer> entry : map.entrySet()){
          maxHeap.offer(entry);
        }
        for(int i = 0; i < k - 1 ; i++){
            maxHeap.poll();
        }
        return maxHeap.peek().getKey();
    }

    public static void main(String[] args) {
        String[] str = {"a", "a","a","b","b","d","c"};
        List<String> list = new ArrayList<>();
        for(String string : str){
            list.add(string);
        }
        Solution solution =  new Solution();
        System.out.println(solution.kthMinHeap(list, 2));
        System.out.println(solution.kthMaxHeap(list, 3));
    }
}
