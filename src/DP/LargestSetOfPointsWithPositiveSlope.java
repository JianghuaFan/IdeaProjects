package DP;

import java.util.Arrays;
import java.util.Comparator;

/*
217. Largest Set Of Points With Positive Slope
Medium
Given an array of 2D coordinates of points (all the coordinates are integers),
find the largest number of points that can form a set such that any pair of points in the set
can form a line with positive slope. Return the size of such a maximal set.

Assumptions:The given array is not null

Note: if there does not even exist 2 points can form a line with positive slope, should return 0.
Examples

<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum set of points are {<0, 0>, <1, 1>, <2, 3>}, the size is 3.
 */
public class LargestSetOfPointsWithPositiveSlope {
    public int largest(Point[] points) {
        // Write your solution here.
        // sort : O(nlopgn) + longestsubsequence O(n^2)
        // SC: O(n)
        // 首先排序按照x升序，y降序.平行于y轴斜率不存在，所以得排除这些情况。求longest ascending subsequence的时候就得选x相同情况下更大的y。
        Arrays.sort(points, new myComparator());
        // 接下来求longest ascending subsequence
        int max = 1;
        int[] dp = new int[points.length];
        dp[0] = 1;
        for(int i = 1; i < points.length; i++){
            int cur = 1;
            for(int j = 0; j < i; j++){
                if(points[j].y < points[i].y){
                    cur = Math.max(cur, dp[j]+1);
                }
            }
            dp[i] = cur;
            max = Math.max(max, cur);
        }
        return max == 1 ? 0 : max;
    }
    //按照x升序y降序 来排序
    class myComparator implements Comparator<Point>{
        @Override
        public int compare(Point p1, Point p2){
            if(p1.x == p2.x){
                return p2.y - p1.y;
            }else{
                return p1.x - p2.x;
            }

        }
    }
 class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

    public static void main(String[] args) {
        LargestSetOfPointsWithPositiveSlope largestSetOfPointsWithPositiveSlope = new LargestSetOfPointsWithPositiveSlope();

        Point[] points = new Point[4];
        int[][] a = {{0,0},{1,1},{2,3},{3,3}};
        for(int i = 0; i < points.length; i++){
            points[i] = largestSetOfPointsWithPositiveSlope.new Point(a[i][0],a[i][1]);
            System.out.print("points[i].x:" + points[i].x + "   ");
            System.out.println("points[i].y:" + points[i].y);
        }

        System.out.println(largestSetOfPointsWithPositiveSlope.largest(points));
    }
}
