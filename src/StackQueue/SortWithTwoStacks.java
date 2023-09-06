package StackQueue;

import java.util.*;

public class SortWithTwoStacks {
	public void sortEasy(LinkedList<Integer> s1) {
		
	    LinkedList<Integer> s2 = new LinkedList<Integer>();
//	  Write your solution here.
	    if (s1.isEmpty() || s1.size() <= 1) {
	    	return;
	    }	      
	    while(!s1.isEmpty()) {
	       int j = s1.pop();	       
	       while(!s2.isEmpty() && s2.peek() > j) {
	          s1.push(s2.pop());
	        }
	          s2.push(j);
	     }    	      
	      while(!s2.isEmpty()) {
	          s1.push(s2.pop());
	      }
	}
	/*
	HighLevel: I will use input Deque and buffer Deque to sort the numbers in input, bottom part used as result, top part as buffer
	step1: poll out number from input one by one and offer into buffer, in the meantime maintain a minimum number with min,  also count how many times min appears
	step2: poll out number back from buffer one by one back to input which are different with min
	step3: offer the min( for count times) to buffer
	step4: repeat step1 - step3, until input stack is empty, now numbers in the buffer from top to bottom are decreasing
	step5: poll back from buffer to input so that numbers in the input from top to bottom are increasing

	 */
	public Deque<Integer> sortWithTwoStacksWithDupli(Deque<Integer> input){
		// corner case
		if(input == null || input.size() <= 1){
			return input;
		}
		Deque<Integer> buffer = new LinkedList<>();
		// step 1 - step 4
		while(!input.isEmpty()){
			int curMin = Integer.MAX_VALUE;
			int count = 0;
			//step 1: poll out number from input one by one and offer into buffer, in the meantime maintain a minimum number with min,  also count how many times min appears
			while(!input.isEmpty()){
				int cur = input.pollFirst();
				if(cur < curMin){
					curMin = cur;
					count = 1;
				}else if(cur == curMin){
					count++;
				}
				buffer.offerFirst(cur);
			}
			// step2: poll out number back from buffer one by one back to input which are different with min
			while(!buffer.isEmpty() &&  buffer.peekFirst() >= curMin){
				int temp = buffer.pollFirst();
				if(temp != curMin){
					input.offerFirst(temp);
				}
			}
			// step3: offer the min( for count times) to buffer
			while(count > 0){
				buffer.offerFirst(curMin);
				count--;
			}
		}
//		step5: poll back from buffer to input so that numbers in the input from top to bottom are increasing
		while(!buffer.isEmpty()){
			input.offerFirst(buffer.pollFirst());
		}
		return input;
	}
	/*
	HighLevel: sort numbers with dupli in deque to descending order with two stacks, result store in the bottom part of input
	step 1: while the top number is smaller than prevMax, which means there are still unsorted numbers, poll out number one by one to buffer, in the meantime maintain a curMax number, also count the times the curMax appears
	step 2: offer back the curMax to input for count times
	step 3: offer back all other numbers to input
	step 4: repeat step1 - step 3 until input is the top of the input is bigger prevMx, which means top would be the smallest number
	 */
	public Deque<Integer> sortWithTwoStacksWithDupliInput(Deque<Integer> input){
		// corner case
		if(input == null || input.size() <= 1){
			return input;
		}
		Deque<Integer> buffer = new LinkedList<>();


		int prevMax = Integer.MAX_VALUE;
		// step 1 - step 4
		while(input.peekFirst() < prevMax){
			int curMax = Integer.MIN_VALUE;
			int count = 0;
			// step 1
			while(!input.isEmpty() && input.peekFirst() < prevMax){
				int cur = input.pollFirst();
				if(cur > curMax){
					curMax = cur;
					count = 1;
				}else if(cur == curMax){
					count++;
				}
				buffer.offerFirst(cur);
			}
//			step 2
			while(count > 0){
				input.offerFirst(curMax);
				count--;
			}
//			step3
			while(!buffer.isEmpty()){
				int cur = buffer.pollFirst();
				if(cur != curMax){
					input.offerFirst(cur);
				}
			}
			prevMax = curMax;
		}
		return input;
	}

	public void sortWithTwoStacks(LinkedList<Integer> s1){
		// highlevel:use two stacks to sort, stack1 is input, stack2 is used as res and buffer.
		Deque<Integer> list2 = new LinkedList<>();

		// step 1: traverse stack1, poll them into stack2, in the meantime, find the min, than poll back from s2 to s1, except min, push min to s2
		// do the same operation for all the numbers in list1 till sorted
		// C: if there are many duplications
		while(!s1.isEmpty()){
			int min = Integer.MAX_VALUE;
			int count = 0;
			// step 1: traverse stack1, poll them into stack2, in the meantime, find the min, maintain the number of min
			while(!s1.isEmpty()){
				Integer cur = s1.pollFirst();
				if(cur < min){
					min = cur;
					count = 1;
				}else if(cur == min){
					count++;
				}
				list2.offerFirst(cur);
			}
			// step 2: poll back from s2 to s1, except min, push min to s2
			while(!list2.isEmpty() && list2.peekFirst() >= min ) {
				Integer cur = list2.pollFirst();
				if (cur != min) {
					s1.offerFirst(cur);
				}
				while (count != 0) {
					list2.offerFirst(min);
					count--;
				}
			}
		}
		// step 3: poll back from buffer to input, so that numbers in input are ascending from top to bottom
		while(!list2.isEmpty()){
			s1.offerFirst(list2.pollFirst());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array = {0,2,1,1,1,3};
		int[] array = {3,1,2,4};
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		int[] array1 = {3,1,2,4};
		Deque<Integer> input = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			input.offerFirst(array[i]);
		}
		SortWithTwoStacks sort = new SortWithTwoStacks();
		System.out.println("before sorting input: " + input);
//		System.out.println("original list: " + list);
//		sort.sort(list);
//		System.out.println("sorted result:" + list);
		System.out.println("sorted input ascending:"+ sort.sortWithTwoStacksWithDupli(input));
		System.out.println("sorted input Descending:"+ sort.sortWithTwoStacksWithDupliInput(input));
	}
}
