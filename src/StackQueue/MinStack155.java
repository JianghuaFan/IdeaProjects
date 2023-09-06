package StackQueue;

import java.util.Deque;
import java.util.Stack;

public class MinStack155 {
	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;
	private int min;
	private Deque<Integer> stack;
	
	public void MinStack() {
		dataStack = new Stack<>();
		minStack = new Stack<>();
		min = Integer.MAX_VALUE;
	}
	
	public void push(int x) {
		dataStack.add(x);
		min = Math.min(min, x);
		minStack.add(min);
	}
	
	public void pop(){
		dataStack.pop();
		minStack.pop();
		min = minStack.isEmpty()? Integer.MAX_VALUE : minStack.peek();
	}
	
	public int top() {
		return dataStack.peek();
	}
	
	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
