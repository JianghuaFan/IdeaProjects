package CrossTraining;

import java.util.HashMap;

public class MostPointsOnALine {
	public int most(Point[] points) {
	    // Write your solution here.
	    int res = 0;
//	    we use each pair of points to form a line
	    for(int i = 0; i < points.length; i++) {
	    	// 任何一条线都可以用一个点和一个斜率来表示， 我们用当前point当做seed找出所有可能斜率
	    	Point seed = points[i];
	    	//记录所有有相同<x,y> 的点
	    	int same = 1;
	    	// 记录所有有相同x的点，平行于y轴的case
	    	int sameX = 0;
//	    	记录所有所有穿过seed这个点的点
	    	int most = 0;
	    	// map 记录所有的斜率
	    	HashMap<Double, Integer> cnt = new HashMap<>();
	    	for(int j = 0; j < points.length; j++) {
	    		if(i == j) {
	    			continue;
	    		}
	    		
	    		if(points[j].x == seed.x && points[j].y == seed.y) {
	    			same++;
	    		}else if(points[j].x == seed.x) {
	    			sameX++;
	    		}else {
	    			double slope = ((points[j].y - seed.y)  + 0.0) / (points[j].x - seed.x);
	    			cnt.put(slope, cnt.getOrDefault(slope, 0) + 1);   		
	    			most = Math.max(most, cnt.get(slope));
	    		}
	    	}
	    	most = Math.max(sameX, most) + same;
	    	res = Math.max(res, most);
	    }
		return res;
	}
	class Point{
		int x;
		int y;
		public Point(int x, int y) {
			 this.x = x;
			 this.y = y;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MostPointsOnALine most = new MostPointsOnALine();
		Point[] points = {most.new Point(0,0), most.new Point(1,1),most.new Point(2,3),most.new Point(3,3)};
		System.out.print(most.most(points));
	}

}
