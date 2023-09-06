package Sort;

import java.util.Arrays;

public class HeapSort {
	public static void HeapSort1(int[] arr) {
        long start = System.currentTimeMillis();
        buildMaxHeap(arr);
        int heapSize = arr.length-1;
        for(int i = heapSize; i > 0; i--) {
        	swap(arr,0,i);
        	heapSize--;
        	MaxHeapify(arr,0,heapSize);
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("It took " + elapsedTime + " milliseconds to finish the heapSort on this data set of size:." + arr.length);

	}

	private static void buildMaxHeap(int[] arr) {
		// TODO Auto-generated method stub
		for(int i = arr.length/2-1; i >= 0; i--)
			MaxHeapify(arr,i,arr.length-1);
	}

	private static void MaxHeapify(int[] arr, int parent, int indexLimit) {
		// TODO Auto-generated method stub
		int leftChild = 2*parent + 1;
		int rightChild = 2*parent + 2;		
		int maxIndex = parent;
		if(leftChild <= indexLimit && arr[parent] < arr[leftChild]) {
			maxIndex = leftChild;
		}
		if(rightChild <= indexLimit && arr[maxIndex] < arr[rightChild]) {
			maxIndex = rightChild;
		}
		if(parent != maxIndex) {
			swap(arr,parent,maxIndex);
			MaxHeapify(arr,maxIndex,indexLimit);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapSort heapSort = new HeapSort();
		int[] arr = new int[] {3,5,2,6,5,6,8};
		HeapSort1(arr);
		System.out.println(Arrays.toString(arr));
	}

}
