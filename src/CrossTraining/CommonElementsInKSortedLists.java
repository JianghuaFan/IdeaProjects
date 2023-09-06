package CrossTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CommonElementsInKSortedLists {
	// Method 1 : Iterative reduction	
	public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
		
		List<Integer> res = input.get(0);
		for(int i = 1; i < input.size(); i++) {
			res = helper(res, input.get(i));
		}
		return res;
	}
	private List<Integer> helper(List<Integer> a, List<Integer> b) {
		// TODO Auto-generated method stub
		List<Integer> res = new ArrayList<>();
		int i = 0;
		int j = 0;
		while(i < a.size() && j < b.size()) {
			System.out.println("a.get(i):" + a.get(i));
			System.out.println("b.get(j):" + b.get(j));
			int compare = Integer.compare(a.get(i), b.get(j));
			if(compare == 0) {
				res.add(a.get(i));
				i++;
				j++;
			}else if (compare < 0) {
				i++;
			}else {
				j++;
			}
		}
		return res;
	}
	//  Method 2 : minHeap + max实现。每次维护最小堆和当前堆里的最大值，如果两个相等表示堆里所有元素相等
	public List<Integer> commonElementsInKSortedArraysII(List<List<Integer>> input) {
	    // Write your solution here
		List<Integer> res = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(new myComparatorMin());
		for(int i = 0; i < input.size(); i++) {
			if(input.get(i) != null) {
				minHeap.offer(new Cell(i, 0, input.get(i).get(0)));
				max = Math.max(max,input.get(i).get(0));
			}			
		}
		while(!minHeap.isEmpty()) {
			Cell min = minHeap.peek();
			
			if(min.value == max) {
				res.add(min.value );			
				for(int i = 0 ; i < input.size(); i++) {
					Cell cur = minHeap.poll();
					if(cur != null && cur.col + 1 < input.get(cur.row).size()) {
						minHeap.offer(new Cell(cur.row, cur.col + 1, input.get(cur.row).get(cur.col + 1)));
						max = Math.max(max,input.get(min.row).get(min.col + 1));
					}
				}
			}
			minHeap.poll();
			if(min.col + 1 < input.get(min.row).size()) {
				minHeap.offer(new Cell(min.row, min.col + 1, input.get(min.row).get(min.col + 1)));
				max = Math.max(max,input.get(min.row).get(min.col + 1));
			}			
		}
		return res;
	}
	
	private class myComparatorMin implements Comparator<Cell>{
		@Override
		public int compare(Cell c1, Cell c2){
			if(c1.value == c2.value) {
				return 0;
			}
			return c1.value < c2.value ? -1 : 1;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1 = Arrays.asList(1, 2, 2, 3);
		List<Integer> l2 = Arrays.asList(2, 2, 3, 5);
		List<Integer> l3 = Arrays.asList(2, 2, 4);
		List<List<Integer>> Input = new ArrayList<>();
		Input.add(l1);
		Input.add(l2);
		Input.add(l3);
		CommonElementsInKSortedLists common = new CommonElementsInKSortedLists();
		System.out.print(common.commonElementsInKSortedArrays(Input));
	}
//Expected: [[]]
//	Your Solution: [[6, 7, 7, 9, 12]]
}
