package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervalToSortedNonOverlapIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval){
        // step1: sort the intervals first,
        // step 2: insert newInterval
        // case 1: non-overlap1: 君死我未生，prev[1] < newInterval[0]
        // case 2: non-overlap2:君生我已死， prev[0] > newInterval[1], 此时插入我
        // case 3: overlap
        List<int[]> res = new ArrayList<>();
        boolean inserted = false;
        for(int[] cur: intervals){
            if(cur[1] < newInterval[0]){
                res.add(cur);
            }else if(cur[0] > newInterval[1]){
                if(!inserted){
                    res.add(newInterval);
                    inserted = true;
                }
                res.add(cur);
            }else{
                newInterval[0] = Math.min(cur[0], newInterval[0]);
                newInterval[1] = Math.max(cur[1], newInterval[1]);
            }
        }
        if(!inserted){
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        InsertIntervalToSortedNonOverlapIntervals insert = new InsertIntervalToSortedNonOverlapIntervals();
        int[][] nums = {{0,2},{3,5},{6,7}};
        int[] newInterval = {1,4};
        System.out.println(Arrays.deepToString(insert.insert(nums,newInterval)));
    }
}
