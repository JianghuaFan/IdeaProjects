package BFSHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FurthestBuilding {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> bricksUsed = new PriorityQueue<>(Collections.reverseOrder());
            int i = 0;
            for(i=0;i<heights.length-1;i++){
                if(heights[i+1] <= heights[i]) continue;

                int diff = heights[i+1] - heights[i];

                if(diff <= bricks){
                    bricks -= diff;
                    bricksUsed.add(diff);
                }else if( ladders > 0){
                    if(!bricksUsed.isEmpty() && bricksUsed.peek() > diff){
                        bricks += (bricksUsed.remove() - diff);
                        bricksUsed.add(diff);
                    }
                    ladders--;
                }else break;
            }
            return i;
        }
    public int nthUglyNumber(int n) {
        int dp[]=new int[n];
        dp[0]=1;
        int p2=0,p3=0,p5=0;
        for(int i=1;i<n;i++){
            int min=Math.min(dp[p2]*2,Math.min(dp[p3]*3,dp[p5]*5));
            if(min==dp[p2]*2)p2++;
            if(min==dp[p3]*3)p3++;
            if(min==dp[p5]*5)p5++;
            dp[i]=min;
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int[] heights = {4,2,7,6,9};
        int bricks = 5, ladders = 1;
        FurthestBuilding furthestBuilding = new FurthestBuilding();
//        System.out.println(furthestBuilding.furthestBuilding(heights, bricks, ladders));
        System.out.println(furthestBuilding.nthUglyNumber(10));
    }
}
