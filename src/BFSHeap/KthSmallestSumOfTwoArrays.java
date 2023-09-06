package BFSHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestSumOfTwoArrays {
	
	public int kthSmallestSum(int[] A, int[] B, int k) {
		int res = -1;
		if(A == null && B == null) {
			return res;
		}else if(A == null && B.length >= k) {
			return B[k-1];
		}else if(B == null && A.length >= k) {
			return A[k-1];
		}else if(k > A.length * B.length) {
			System.out.println("k is out of Bounds");
			return -1;
		}
		
		boolean[][] visited = new boolean[A.length][B.length];
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				int sum1 = A[c1.aIndex] + B[c1.bIndex];
				int sum2 = A[c2.aIndex] + B[c2.bIndex];
//				if(sum1 == sum2) {
//					return 0;
//				}
//				return sum1 < sum2 ? -1 : 1;
				return Integer.compare(sum1, sum2);
			}
		});
		minHeap.offer(new Cell(0,0));
		for(int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();
//			System.out.println("Nowcur.aIndex:" + (cur.aIndex));
//			System.out.println("cur.bIndex:" + cur.bIndex);
//			System.out.println("sum of cur a,b:"+ (A[cur.aIndex]+B[cur.bIndex]));
			if(cur.aIndex + 1 < A.length && !visited[cur.aIndex + 1][cur.bIndex]) {
				visited[cur.aIndex + 1][cur.bIndex] = true;
//				System.out.println("curRow.aIndex:" + (cur.aIndex));
//				System.out.println("curRow.bIndex:" + cur.bIndex);
//				System.out.println("sum of curRow a,b:"+ (A[cur.aIndex+1]+B[cur.bIndex]));
				minHeap.offer(new Cell(cur.aIndex + 1,cur.bIndex));
			}
			if(cur.bIndex + 1 < B.length && !visited[cur.aIndex][cur.bIndex + 1]) {
				visited[cur.aIndex][cur.bIndex + 1] = true;
//				System.out.println("curCol.aIndex:" + cur.aIndex);
//				System.out.println("curCol.bIndex:" + (cur.bIndex));
//				System.out.println("sum of curCol a,b:"+ (A[cur.aIndex]+B[cur.bIndex + 1]));
				minHeap.offer(new Cell(cur.aIndex,cur.bIndex + 1));
			}			
		}
		Cell resElement = minHeap.peek();
		return A[resElement.aIndex]+B[resElement.bIndex];
	}
	public class Cell{
		int aIndex;
		int bIndex;
		public Cell(int aIndex, int bIndex) {
			this.aIndex = aIndex;
			this.bIndex = bIndex;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub//		
//		int[] A = {1,3,5};
//		int[] B = {4,8};
		int[] A = {1,3,5,8,9};
		int[] B = {2,3,4,7};
		KthSmallestSumOfTwoArrays kthSmallestSum = new KthSmallestSumOfTwoArrays();
		int smallestSum = kthSmallestSum.kthSmallestSum(A, B, 6);
		System.out.println(smallestSum);
	}

}
