package StackQueue;

import java.util.Deque;
import java.util.LinkedList;

public class QueueWithStacks {
	  private Deque<Integer> in;
		 private Deque<Integer> out;
		 
		 public QueueWithStacks(){
		  in = new LinkedList<Integer>();
		  out = new LinkedList<Integer>();
		 }
		 
		public Integer poll(){
		  if(!out.isEmpty()) {
		    return out.pollFirst();
		  }
		  move();
		  if (out.isEmpty())
		    return null;
		  else 
		    return out.pollFirst();
		 }
		 
		public void offer(Integer element){
		  in.offerFirst(element);
		}
		 
		public Integer peek(){
		  if (!out.isEmpty()) {
		    return out.peekFirst();  
		  }
		  move();
		  if (out.isEmpty())
		    return null;
		  else 
		    return out.peekFirst();
		 }
		  
		public void move(){
		  if (out.isEmpty()) {
			while(!in.isEmpty()) {
				out.offerFirst(in.poll());
			}
		  }		  
		}
		 
		public int size(){
		  return in.size() + out.size();
		}
		 
		public boolean isEmpty(){
		  return (in.isEmpty() && out.isEmpty());
		}
		
		public void printQueue() {
			move();
			while(!out.isEmpty()) {
				System.out.print(out.pollFirst());
			}
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueWithStacks s = new QueueWithStacks();
		s.offer(1);		
		s.offer(2);
		s.offer(3);
		s.printQueue();
//		System.out.print(s.poll());
//		System.out.print(s.poll());
//		System.out.print(s.poll());

	}

}
