package OOD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TTLCache {

    public List<Integer> getCacheSize1(List<List<Integer>> data, List<Integer> queries){
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<queries.size();i++){
            int count = 0;
            int curTime = queries.get(i);
            for(int j =0;j<data.size();j++)
            {
                int startTime = data.get(j).get(0);
                int endTime = data.get(j).get(1)+startTime;
                if(curTime>=startTime && curTime<=endTime)
                    count++;
            }
            ans.add(count);
        }
        return ans;
    }

    public List<Integer> getCacheSize(List<List<Integer>> data, List<Integer> queries) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < data.size(); i++){
            int start = data.get(i).get(0);
            int end = data.get(i).get(1) + start;
            minHeap.offer(end);
        }

        for(int j = 0; j < queries.size(); j++){
            int curTime = queries.get(j);
            while(!minHeap.isEmpty() && curTime > minHeap.peek()){
                minHeap.poll();
            }
            ans.add(minHeap.size());
        }

        return ans;
    }

        public static void main(String[] args) {
        Integer[] array ={1,2,3};
        List<Integer> list = Arrays.asList(array);
        Integer[][] dataArray = {{105231,183},{105334,34},{105198,543}};
        List<List<Integer>> data = new ArrayList<>();
        for(Integer[] dataIterator : dataArray){
            data.add(Arrays.asList(dataIterator));
        }
        List<Integer> queries = Arrays.asList(105338,105410);
        TTLCache ttlCache = new TTLCache();
        System.out.println(Arrays.toString(ttlCache.getCacheSize(data,queries).toArray()));
        System.out.println(ttlCache.getCacheSize(data,queries).toArray());
    }
}
