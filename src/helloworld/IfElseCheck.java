package helloworld;

import java.util.Arrays;

public class IfElseCheck {
	private int partition(int[] array, int left, int right){
		  
		  int pivot = array[right];
		  int leftBound = left;
		  int rightBound = right - 1;

		  while(leftBound <= rightBound) {
		    if(array[leftBound] < pivot){
		    	leftBound++;
		    }
		    if (array[rightBound] >= pivot ) {
		    	rightBound--;
		    }
		    else 
		    	swap(array, leftBound, rightBound);			    	
		  }
		  swap(array, leftBound++, right--);
		  return leftBound;
		}
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = 1;
//		int b = 2;
//		int c = 3;
//		while (a <= b) {
//			if (a <= 3) {
//				System.out.println("a <= 3. a: " + a);
//				a++;
//			}
//			if ( b <= 2) {
//				System.out.println("b <= 2. b: " + b);
//				b--;
//			}
//			else {
//				System.out.println("c = 3");
//			}
//			System.out.println("a: " + a);
////			System.out.println("b: " + b);
		int[] array = {1,2,3,4};
		IfElseCheck partition = new IfElseCheck();
		partition.partition(array, 0, 3);
		System.out.println(Arrays.toString(array));

		}

	}