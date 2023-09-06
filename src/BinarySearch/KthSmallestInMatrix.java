package BinarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class KthSmallestInMatrix {
	
	public static int kthSmallestInMatrix(int[][] matrix, int k) {
		//方法一（1）：二分法
//		int m = matrix.length, n = matrix[0].length;
//		int lo = matrix[0][0], hi = matrix[m-1][n-1];		
//		while(lo <= hi){
//			int mid = lo + (hi - lo)/2;
//			int cnt = 0;
//			for(int i = 0; i < m; i++) {
//				for(int j = 0; j < n && matrix[i][j] <= mid ; j++) {	
//					cnt ++;											
//				}
//			}
			//方法一（2）：从左下角开始往右上角遍历
//			for(int i = n-1; i >= 0;) {
//				for(int j = 0; j < m;) {
//					if(matrix[i][j] <= mid) {
//						// 小于等于 mid，往右走且当前列的元素肯定都比mid小，所以count加 i+1，当前列的i行以上的元素	
//						cnt += i + 1;
//						j++;
//					}
//					else i--; //大于mid，往上走		
//				}			
//			}
//			if(cnt < k) lo = mid + 1;
//			else hi = mid-1;
//		}
//		return lo;// lo will be the largest element that is less or equal than kth 
		//方法S三 优先队列和堆办法
		int n = matrix.length;
		PriorityQueue<Coord> minHeap =new PriorityQueue<>((a,b) -> a.val - b.val);
		minHeap.offer(new Coord(0,0,matrix[0][0]));
		boolean[][] visited = new boolean[n][n];
		for(int v = 0; v < k-1; v++) {
			Coord top = minHeap.poll();			
			if(top.i + 1 < n && !visited[top.i+1][top.j]) {
				visited[top.i+1][top.j] = true;
				minHeap.offer(new Coord(top.i +1, top.j, matrix[top.i+1][top.j]));
			}
			if(top.j + 1 < n && !visited[top.i][top.j + 1]) {
				visited[top.i][top.j+1] = true;
				minHeap.offer(new Coord(top.i, top.j + 1, matrix[top.i][top.j + 1]));
			}
		}
		return minHeap.peek().val;
		
		//brute force 方法四:转化成一维数组取第k小的值
//		int index = 0, m = matrix.length, n = matrix[0].length;		 
//		int[] matrixReshaped = new int[m*n];
//		while(index < m*n) {
//			for(int i = 0; i < m*n; i++) {								
//				matrixReshaped[index] = matrix[i/n][i%n];
//				index++;
//			}
//		}
//		System.out.println(Arrays.toString(matrixReshaped));
//		Arrays.sort(matrixReshaped);		
//		return matrixReshaped[k-1];
	}	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = {{1,2},{2,5}};	
//		int[][] matrix = {{1},{}};
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};			
		System.out.println(kthSmallestInMatrix(matrix,8));
		System.out.println(Arrays.deepToString(matrix));
//		System.out.println(Arrays.toString(matrix[1]));
		
		
	}

}
