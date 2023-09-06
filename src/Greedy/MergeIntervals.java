package Greedy;

import java.util.*;
/*
Given a list of possibly overlapped intervals(左闭右开）, how to merge them so that there is no overlap between them afterwards?
input: {{0,3},{1,2},{2,5},{6,7}}
output: [[0, 5], [6, 7]]
 */
public class MergeIntervals {
    public int[][] mergeIntervals(int[][] nums){
        if(nums == null || nums.length == 0){
            return nums;
        }
        List<int[]> list = new ArrayList<>();
        int[][] res = new int[nums.length][];
        // step 1: sort all the int[] in the int[][]
//        Arrays.sort(nums, new MyComparator());
        Arrays.sort(nums, new Comparator<int[]>(){
                @Override
                public int compare(int[] i1, int[] i2){
                    return Integer.compare(i1[0], i2[0]);
                }
        });
        int[] prev = nums[0];
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i][0] <= prev[1]){ // 前者还未走，后者已抵达, 新的结束时间是前一个和当前更晚结束的
                prev[1] = Math.max(nums[i][1], prev[1]);
            }else{// 否则就是另一个没有overlap的interval，添加到结果中，更新前者为当前的int[]
                list.add(prev);
                prev = nums[i];
            }
        }
        list.add(prev);
        return list.toArray(new int[list.size()][]);
    }
    class MyComparator implements Comparator<int[]>{
            @Override
            public int compare(int[] I1, int[] I2) {
                return Integer.compare(I1[0], I2[0]);
            }
    }
    class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
/*
Given a list of possibly overlapped intervals(左闭右开）, return the total length of the area covered by those intervals

 */
    public int mergeIntervalsTotalLength(List<Interval> intervals){
        if(intervals == null || intervals.size()  == 0){
            return 0;
        }
        // highLevel: sort the intervals with the start time so that we can traverse from left
        // step 1: merge them : case 1: prev end is larger than the cur start time meaning that they are overlapped
        //                      case 2: prev end is smaller than cur start meaning that they are non overlapped
        Interval prev = intervals.get(0);
        int res = 0;
        for(int i = 1; i < intervals.size(); i++){
            if(prev.end >= intervals.get(i).start){
                prev.end = Math.max(prev.end, intervals.get(i).end);
            }else{
                res += prev.end - prev.start;
                prev = intervals.get(i);
            }
        }
        res += prev.end - prev.start;
        return res;
    }

    public int length(List<Interval> intervals) {
        // Write your solution here.
        int res = 0;
        // step 1: sort intervals
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return Integer.compare(i1.start, i2.start);
            }
        });
        //reason: no instance(s) of type variable(s) T exist so that List<MergeIntervals.Interval> conforms to T[]
        Interval prev = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            if(prev.end >= intervals.get(i).start){
                prev.end = Math.max(prev.end, intervals.get(i).end);
            }else{
                res += prev.end - prev.start;
                prev = intervals.get(i);
                System.out.println(res);
            }
        }
        res += prev.end - prev.start;
        return res;
    }
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] nums = {{0,3},{1,2},{2,5},{6,7}};
        List<Interval> intervals = new ArrayList<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            intervals.add(mergeIntervals.new Interval(nums[i][0],nums[i][1]));
        }

        Interval interval = mergeIntervals.new Interval(0,0);
        System.out.println(Arrays.deepToString(mergeIntervals.mergeIntervals(nums)));
        System.out.println(mergeIntervals.mergeIntervalsTotalLength(intervals));
        System.out.println(mergeIntervals.length(intervals));
    }
}
