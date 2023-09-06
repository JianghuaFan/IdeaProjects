package BFSHeap;

import java.util.Arrays;

public class MinHeap {
	int[] array;
	int size;
	public MinHeap(int[] array) {
		if(array == null || array.length <= 1) {
			throw new IllegalArgumentException("input array cannot be null or empty");
		}
		this.array = array;
		this.size = array.length;
		heapify();
	}
	public MinHeap(int cap) {
		if(cap <= 0) {
			throw new IllegalArgumentException("capacity cannot be <= 0");
		}
		array = new int[cap];
		size = 0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public boolean isFull() {
		return size == array.length;
	}
	private void heapify() {
		// TODO Auto-generated method stub
		for (int i = size / 2 - 1; i >= 0; i--) {
			percolateDown(i);
		}
		
	}

	private void percolateDown(int index) {
		// TODO Auto-generated method stub
		while(index <= size / 2 - 1) {
			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = 2 * index + 2;
			int swapCandidate = leftChildIndex;
			if(rightChildIndex <= size - 1 && array[swapCandidate] > array[rightChildIndex] ) {
				swapCandidate = rightChildIndex;
			}
			if(array[index] > array[swapCandidate]) {
				swap(index, swapCandidate);
			} else {
				break;
			}
			index = swapCandidate;								
		}				
	}
	private void percolateUp(int index) {
		while(index > 0) {
	int parentIndex = (index - 1) / 2;
		if(array[index] < array[parentIndex ]) {
		swap(index, parentIndex );
		} else {
			break;
		}
		index = parentIndex ;
		}
	}
	public int peek() {
		if(size == 0) {
		System.out.print("array is empty!");
		}
		return array[0];
	}
	public void offer(int ele) {
		if(size == array.length - 1) {
		this.array = Arrays.copyOf(this.array, (int)1.5 * this.array.length);
		}
		array[size] = ele;
		size++;
		percolateUp(size - 1);
	}
	public int poll() {
	if(size == 0) {
		System.out.print("array is empty!");
		}
		int res = array[0];
		swap(0,size - 1);
		size--;
		percolateDown(0);
		return res;
	}
	public int update(int index, int value) {
		if(index < 0 || index > size -1) {
			throw new ArrayIndexOutOfBoundsException("index out of bounds");
		}
		int res = array[index];
		array[index] = value;
		if( res < value) {
			percolateDown(index);
		}else {
			percolateUp(index);
		}
			return res;
		}

	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
