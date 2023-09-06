package CrossTraining;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxWaterTrappedII {
	public int maxTrapped(int[][] matrix) {
	    // Write your solution here
		int res = 0;
		// 用一个minHeap先从最外面一圈找到最小的level（最短板），确定他的积水，之后确定他邻居的水位
		// 确定完后扔掉这个格子，generate他的邻居再确定邻居的水位level
		// BFS2 generate 邻居节点对应移动指针得出新的左右max的值
		int rows = matrix.length;
		int cols = matrix[0].length;
		if( rows < 3 || cols < 3) {
			return 0;
		}
		boolean[][] visited = new boolean[rows][cols];
		PriorityQueue<Pair> minHeap = new PriorityQueue<>();
		initialBoard(matrix, visited, minHeap, rows, cols);
		while(!minHeap.isEmpty()) {
			Pair cur = minHeap.poll();
			List<Pair> neighbors = getNeighbor(cur, matrix);
			for(Pair nei : neighbors) {
				if(visited[nei.x][nei.y]) {
					continue;
				}else {
					visited[nei.x][nei.y] = true;
					// 算积水的容量，用最大边界高度和自己的高度比
					res += Math.max(0, cur.height - nei.height);
//					更新邻居点的最大水位为较高的那一个水位
					nei.height = Math.max(nei.height, cur.height);
					minHeap.offer(nei);
				}
			}			
		}
		return res;
	}
	
	private List<Pair> getNeighbor(Pair cur, int[][] matrix) {
		// TODO Auto-generated method stub
		List<Pair> nei = new ArrayList<>();
		if(cur.x + 1 < matrix.length) {
			nei.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
		}
		if(cur.x - 1 >= 0) {
			nei.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
		}
		if(cur.y + 1 < matrix[0].length) {
			nei.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
		}
		if(cur.y - 1 >= 0) {
			nei.add(new Pair(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
		}
		return nei;
	}

	private void initialBoard(int[][] matrix, boolean[][] visited, PriorityQueue<Pair> minHeap, int rows, int cols) {
		// TODO Auto-generated method stub
		for(int i = 0; i < rows; i++) {
			visited[i][0] = true;
			visited[i][cols - 1] = true;
			minHeap.offer(new Pair(i,0, matrix[i][0]));
			minHeap.offer(new Pair(i,cols - 1,matrix[i][cols - 1]));
		}
		for(int i = 1; i < cols - 1; i++) {
			visited[0][i] = true;
			visited[rows - 1][i] = true;
			minHeap.offer(new Pair(0,i,matrix[0][i]));
			minHeap.offer(new Pair(rows - 1,i,matrix[rows - 1][i]));
		}
	}

	class Pair implements Comparable<Pair>{
		int x;
		int y;
		int height;
		public Pair(int x, int y, int height) {
			this.x = x;
			this.y = y;
			// 最大边界高度
			this.height = height;
		}
		// 以下是比较器，不能用来写在类里面，只能作为比较器传给priorityQueue或者Arrays.sort作为参数
//		@Override
//		public int compare(Pair p1, Pair p2) {
////			return Integer.compare(p1.height, p2.height);
//			if(p1.height == p2.height) {
//				return 0;
//			}
//			return p1.height < p2.height ? -1 : 1;
//		}
		//实现PQ中优先级比较的方式，实现Comparable 接口重写compareTo方法
		public int compareTo(Pair another) {
			if(this.height == another.height) {
				return 0;
			}
			return this.height < another.height ? -1 : 1;
		}
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 2, 3, 4, 2 },
				  { 3, 1, 2, 3 },
				  { 4, 3, 5, 4 } };
		MaxWaterTrappedII trap = new MaxWaterTrappedII();
		System.out.print(trap.maxTrapped(matrix));
	}

}
