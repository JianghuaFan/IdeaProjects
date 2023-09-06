package StackQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;

public class QueueStackTest {
	
	public static void main(String[] args) {
		
		List<Integer>  a = new LinkedList<Integer>();
		((LinkedList)a).poll();
//		Queue<Integer> queue = new ArrayDeque<>();
		Queue<Integer> queue = new LinkedList<>();	
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.add(5);

		
		System.out.println("queue: " + queue);
		queue.peek();
		System.out.println("queue.peek: " + queue.peek());
		System.out.println("queue size: " + queue.size());
		queue.poll();
		System.out.println("after poll, queue size: " + queue.size());
		while(!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
		System.out.println();
		
		Stack<Integer> stack1 = new Stack<>();
		stack1.add(4);
		stack1.add(5);
		stack1.push(6);
		stack1.push(7);
		
		System.out.println("stack1: " + stack1);
		System.out.println("stack1 size: " + stack1.size());
		stack1.peek();
		System.out.println("stack1.peek: " + stack1.peek());
		stack1.pop();
		System.out.println("after pop, stack1 size: " + stack1.size());
		stack1.peek();
		System.out.println("stack1.peek: " + stack1.peek());
//		
		while(!stack1.isEmpty()) {
			System.out.print(stack1.pop() + " ");
		}
		System.out.println();
		
		Deque<Integer> deque = new ArrayDeque<>();
//		Deque<Integer> deque = new LinkedList<>();

		deque.add(9);
		deque.offer(10);
		deque.offerFirst(11);
		deque.offerFirst(12);
		deque.addLast(13);
		deque.offerLast(14);
		deque.addLast(15);
		System.out.println("deque: " + deque);
		// 打印是从top到bottom，从First到Last
//		deque: [12, 11, 9, 10, 13, 14, 15]
		System.out.println("pollFirst: ");
//		while(!deque.isEmpty()) {			
//			System.out.print(deque.pollFirst() + " ");
//		}
		System.out.println();
		
		System.out.println("pollLast: ");
		while(!deque.isEmpty()) {
			System.out.print(deque.pollLast() + " ");
		}
		System.out.println();
		
		System.out.println("pop: ");
		while(!deque.isEmpty()) {
			System.out.print(deque.pop() + " ");
		}
		System.out.println();
//		int[] nums = new int[3];
//		System.out.println(Arrays.toString(nums));
		int count = 5;
		while(count-- > 0) {
			System.out.println("count:" + count);
		}
    }
}
