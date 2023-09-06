package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMinArrowShots452 {
	public static int findMinArrowShots(int[][] points) {
		if (points.length == 0)
			return 0;
		int cnt = 1;
		Arrays.sort(points, Comparator.comparingInt(o->o[0]));
        int right = points[0][1];
//        然后我们将res初始化为1，因为气球数量不为0，所以怎么也得先来一发啊，然后这一箭能覆盖的最远位置就是第一个气球的结束点，用变量end来表示。然后我们开始遍历剩下的气球，如果当前气球的开始点小于等于end，说明跟之前的气球有重合，之前那一箭也可以照顾到当前的气球，此时我们要更新end的位置，end更新为两个气球结束点之间较小的那个，这也是当前气球和之前气球的重合点，然后继续看后面的气球；如果某个气球的起始点大于end了，说明前面的箭无法覆盖到当前的气球，那么就得再来一发，既然又来了一发，那么我们此时就要把end设为当前气球的结束点了，这样贪婪算法遍历结束后就能得到最少的箭数了，
        for (int i = 1; i < points.length; i++) {
        	if ( points[i][0] <= right) {
        		right = Math.min(points[i][1], right);
        	}
        	else {
        		cnt++;
        		right = points[i][1];
        	}
        				        	
        }
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return ( o1[1] < o2[1] ) ? -1 : (( o1[1] == o2[1] ) ? 0  : 1);
            }
        });
		
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] points = {{1,2}};
		int[][] points = {{10,16},{2,8},{1,6},{7,12}};
		System.out.print(findMinArrowShots(points) );
	}

}
