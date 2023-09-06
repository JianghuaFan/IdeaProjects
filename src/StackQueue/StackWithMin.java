package StackQueue;

import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
		private Deque<Integer> stack;
		private Deque<Integer> minStack;

		public StackWithMin() {
		    // write your solution here
		    stack = new LinkedList<Integer>();
		    minStack = new LinkedList<Integer>();
		  }
		  
		  public int pop() {
		    if (stack.isEmpty())
		      return -1;
		    int res = stack.pollFirst();
		    if (minStack.peekFirst().equals(res))
		      minStack.pollFirst();
		    return res;
		  }
		  
		  public void push(int element) {
		    stack.offerFirst(element);
		    if (minStack.isEmpty() || element <= minStack.peekFirst()) 
		      minStack.offerFirst(element);
		  }
		  
		  public int top() {
		    if(stack.isEmpty())
		      return -1;
		    return stack.peekFirst();
		  }
		  
		  public int min() {
		    if(stack.isEmpty())
		      return -1;
		    return minStack.peekFirst();
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithMin stack = new StackWithMin();
		stack.push(9);
		stack.push(8);
		stack.push(7);
		stack.push(6);
		stack.push(5);
		System.out.println("stack.min(): " + stack.min());
		System.out.println("stack.top(): " + stack.top());
		System.out.println("stack.pop(): " + stack.pop());		
		System.out.println("stack.min(): " + stack.min());
		System.out.println("stack: " + stack);
	}

}
