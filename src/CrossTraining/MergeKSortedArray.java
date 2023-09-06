package CrossTraining;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
 * 133. Merge K Sorted Array
Medium
Merge K sorted array into one big sorted array in ascending order.

Assumptions

The input arrayOfArrays is not null, none of the arrays is null either.
 */
public class MergeKSortedArray {
	public int[] merge(int[][] arrayOfArrays) {
		// TC: O(kn * logk)  SC: O (k)
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(arrayOfArrays.length, new myComparator());
		int length = 0;
		
		// step 1 : calculate the length of the result array, 
		// initialize the minHeap with the first element of all the rows in the 2d array
		for(int i = 0; i < arrayOfArrays.length; i++) {		
     		length += arrayOfArrays[i].length;
     		if(arrayOfArrays[i].length != 0){
     			minHeap.offer(new Cell(i, 0, arrayOfArrays[i][0]));
     		}
	    }       
	    int[] A = new int[length];
	    int index = 0;
	    while(!minHeap.isEmpty()){
			Cell cur = minHeap.poll();
			A[index++] = cur.value;
			if(cur.col + 1 < arrayOfArrays[cur.row].length){
			minHeap.offer(new Cell(cur.row, cur.col + 1, arrayOfArrays[cur.row][cur.col+1]));
			}	
	    }
	    return A; 
	}
	private class myComparator implements Comparator<Cell>{
		@Override
		public int compare(Cell c1, Cell c2){
			if(c1.value == c2.value) {
				return 0;
			}
			return c1.value - c2.value < 0 ? -1 : 1;
		}
	}
	private class Cell{
		int row; 
		int col;
		int value;
		public Cell(int row, int col, int value){
			this.row = row;
			this.col = col;
			this.value = value;
		}
	}
	
	// Method 2 : IterativeReduction
	public int[] mergeIterativeReduction(int[][] arrayOfArrays) {
		// TC: O(k^2 * n)  SC:  O(kn)
		int m = arrayOfArrays.length;
		int length = 0;
		for(int i = 0; i < arrayOfArrays.length; i++) {
			length += arrayOfArrays[i].length;
		}				
		int[] A = new int[length];
		int index = 0;
		Arrays.fill(A, Integer.MAX_VALUE);
		// put array[0] to the final result A
		for(int num : arrayOfArrays[0]) {
			A[index++] = num;
		}
		// iteratively merge every array[i], store the result in final result A
		for(int i = 1; i < m; i++) {
			A = mergeTwo(A, arrayOfArrays[i]);
		}
		return A;
	}
		
	private int[] mergeTwo(int[] a, int[] b) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = 0;
		int k = 0;
		int index = 0;
		// use a helper array to temporarily store the merge result, later put back into A
		int[] helper = new int[a.length];
		
		while(i < a.length && j < b.length) {
			if(a[i] <= b[j]) {
				helper[k++] = a[i++];
			}
			else {
				helper[k++] = b[j++];
			}
		}
		while(k <a.length  && i < a.length) {
			helper[k++] = a[i++];
		}
		while(k <a.length  && j < b.length) {
			helper[k++] = b[j++];
		}		
		for(int num : helper) {
//			if(num != Integer.MAX_VALUE) {
				a[index++] = num;
//			}			
		}
		
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arrayOfArrays = {{1,3},{2,4},{3,5}};
//		int[][] arrayOfArrays = {{3},{1,2,3,4,5}};
		int[][] arrayOfArrays = {{},{1,5,7},{},{2,3,5,11},{2,4,4,6,8}};
		MergeKSortedArray merge = new MergeKSortedArray();
		System.out.println(Arrays.toString(merge.merge(arrayOfArrays)));
		System.out.println(Arrays.toString(merge.mergeIterativeReduction(arrayOfArrays)));
	}

}
