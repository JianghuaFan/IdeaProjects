package BFSHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestSumInTwoSortedArrays {
	public int kthSum(int[] A, int[] B, int k) {
		if(A == null || A.length == 0 || B == null || B.length == 0)
			return -1;		
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				int sum1 = A[c1.indexA] + B[c1.indexB];
				int sum2 = A[c2.indexA] + B[c2.indexB];
				return sum1 < sum2 ? -1 : 1;
			}
		});
		boolean[][] visited = new boolean[A.length][B.length]; 
		minHeap.offer(new Cell(0,0));
		visited[0][0] = true;
		for(int i = 0; i < k-1; i++) {
			Cell cur = minHeap.poll();
			if(cur.indexA+1 < A.length && !visited[cur.indexA+1][cur.indexB] ) {
				visited[cur.indexA+1][cur.indexB] = true;
				minHeap.offer(new Cell(cur.indexA+1, cur.indexB));
			}
			if(cur.indexB+1 < B.length && !visited[cur.indexA][cur.indexB+1] ) {
				visited[cur.indexA][cur.indexB+1] = true;
				minHeap.offer(new Cell(cur.indexA, cur.indexB+1));
			}			
		}
		Cell res = minHeap.peek();
		return A[res.indexA]+ B[res.indexB];
		
	}
	class Cell{
		int indexA;
		int indexB;
		public Cell(int indexA, int indexB){
			this.indexA = indexA;
			this.indexB = indexB;	
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,8,9};
		int[] B = {2,3,4,7};
		KthSmallestSumInTwoSortedArrays kth = new KthSmallestSumInTwoSortedArrays();
		System.out.print(kth.kthSum(A, B, 6));
		
	}

}
