package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeByThreeStacks {
	private Deque<Integer> left;
	 private Deque<Integer> right;
	 private Deque<Integer> buffer;
	 
	 public DequeByThreeStacks() {
	   // Write your solution here.
	  left = new ArrayDeque<Integer>();
	  right = new ArrayDeque<Integer>();
	  buffer = new ArrayDeque<Integer>(); 
	}
	  public void offerFirst(int element) {
	    left.push(element);
	 }
	  public void offerLast(int element) {
	    right.push(element);
	 }
	  public Integer pollFirst() {
	    move(right, left);
	    if (left.isEmpty())
	      return null;
	    else return left.pop();
	 }
	  public Integer pollLast() {
	   move(left, right);
	   if (right.isEmpty()){	     
	      return null;	        
	   } else {
	    return right.pop();
	    }      
	   }
	  public Integer peekFirst() {
		  move(right, left);
		    if (left.isEmpty())
		      return null;
		    else return left.peek();
	 }
	  public Integer peekLast() {
		  move(left, right);
		   if (right.isEmpty()){	     
		      return null;	        
		   } else {
		    return right.peek();
		   } 
	   }
	 public void move(Deque<Integer> src, Deque<Integer> des){
		 if(!des.isEmpty()){
		      return;
		    } 
		 int halfSize = src.size() / 2;
		 for ( int i = 0; i < halfSize; i++) {
			 buffer.push(src.pop());
		 }
		 while(!src.isEmpty()) {
			 des.push(src.pop());
		 }
		 while (!buffer.isEmpty()) {
		     src.push(buffer.pop());
		   }	   
	   }   
	 
	  public int size() {
	   return left.size() + right.size();
	 }
	  public boolean isEmpty() {
	   return left.isEmpty() && right.isEmpty();
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DequeByThreeStacks deque = new DequeByThreeStacks();
		deque.offerFirst(1);
		deque.offerFirst(2);
		deque.offerFirst(3);
		deque.offerFirst(4);
		deque.offerFirst(5);
		deque.offerFirst(6);

		System.out.println("pollFirst: " + deque.pollFirst());
		System.out.println("pollLast: " + deque.pollLast());
		System.out.println("pollFirst: " + deque.pollFirst());
		System.out.println("pollLast: " + deque.pollLast());		
		System.out.println("pollFirst: " + deque.pollFirst());
		System.out.println("pollFirst: " + deque.pollFirst());
		System.out.println("pollLast: " + deque.pollLast());
		for ( int i = 0; i < 1 /2; i++) {
			System.out.println("i: " + i);
		   }

	}

}
