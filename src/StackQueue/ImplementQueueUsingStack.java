package StackQueue;

import java.util.Stack;

public class ImplementQueueUsingStack {
	private Stack<Integer> in = new Stack<>();
	private Stack<Integer> out = new Stack<>();
	public void push(int x) {
		in.push(x);
	}
	public int pop() {
		in2out();
		return out.pop();
	}
	public int peek() {
		in2out();
		return out.peek();
		
	}

	private void in2out() {
		// TODO Auto-generated method stub
		if(out.isEmpty()) {
			while(!in.isEmpty()) {
				out.push(in.pop());
			}
		}
	}
	public boolean empty() {
		return in.isEmpty() && out.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
