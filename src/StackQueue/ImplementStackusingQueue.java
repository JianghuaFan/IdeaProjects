package StackQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueue {
//	Queue<Integer> q = new LinkedList<>();
//	public void push(int x){
//		q.offer(x);
//		int cnt = q.size();
//		while(cnt-- > 1) {
//			q.add(q.poll());
//		}
//	}
//	public int pop(){
//		//q.poll();
//		return q.poll();
//	}
//	public int top() {
//		return q.peek();
//	}
//	public boolean isEmpty(){
//		return q.isEmpty();
//	}
	   private Queue<Integer> queue;
	    /** Initialize your data structure here. */
	   
	    public ImplementStackusingQueue() {
	       queue = new ArrayDeque<Integer>();
	    }

	    /** Push element x onto stack. */
	    public void push(int x) {
	        queue.offer(x);
	        int count = queue.size();
	        while (count >  1) {
	          queue.offer(queue.poll());
	          count--;
	        }
	    }

	    /** Removes the element on top of the stack and returns that element. */
	    public Integer pop() {
	        if(queue.isEmpty())
	          return null;	        
	        return queue.poll();
	    }

	    /** Get the top element. */
	    public Integer top() {
	        if(queue.isEmpty())
	          return null;	        
	        return queue.peek();
	    }

	    /** Returns whether the stack is empty. */
	    public boolean isEmpty() {
	      return queue.isEmpty();
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStackusingQueue stack = new ImplementStackusingQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.top());
		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//			Input: [push(1), push(2), push(3), isEmpty(), top(), pop(), isEmpty(), top(), pop(), isEmpty(), top(), pop(), isEmpty()] 
//		expected:<["push(1)", "push(2)", "push(3)", "false", "3", "3", "false", "2", "2", "false", "1", "1", "true"]> 
//		but was:< ["push(1)", "push(2)", "push(3)", "false", "3", "2", "false", "1", "3", "false", "1", "1", "true"]>


	}

}
