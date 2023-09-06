package LinkedList;

import javax.xml.soap.Node;
import java.util.*;

public class ListNode {
	int value;
	ListNode next;
	public ListNode(int val) {
		this.value = val;
	}
	public ListNode(int val, ListNode next) {
		this.value = val;
		this.next = next;
	}
	public ListNode create(Integer[] nums) {
		ListNode head = null;
		ListNode link = null;
		for(int i = 0; i < nums.length; i++) {
			if(head == null) {
				head = new ListNode(nums[i]);
				link = head;
			}else {
				link.next = new ListNode(nums[i]);
				link = link.next;
			}
		}
		return head;
	}
	
	public static void printList(ListNode head) {
		// TODO Auto-generated method stub
		System.out.print('[');
	   	 while(head != null) {
	   		 System.out.print(head.value + ",");
	   		 head = head.next;
	   	 }
	   	 System.out.println(']');
	}
//	public void create(Integer[] nums) {
		// TODO Auto-generated method stub
//	public static void printList(ListNode[] head) {
//		// TODO Auto-generated method stub
//		System.out.print('[');
//		for(int i = 0; i < head.length; i++){
//			System.out.print('[');
//			ListNode headI = head[i];
//			while(headI != null) {
//				System.out.print(headI.val);
//				headI = headI.next;
//			}
//			System.out.print(']');  
//		}
//		System.out.print(']');
//	}	
	public static void printList(ListNode[] head) {
		// TODO Auto-generated method stub
		System.out.print('[');
		for(int i = 0; i < head.length; i++){
			System.out.print('[');
//			ListNode headI = head[i];
			while(head[i] != null) {
				System.out.print(head[i].value);
				head[i] = head[i].next;
			}
			System.out.print(']');  
		}
		System.out.print(']');
		LinkedList<Node> list = new LinkedList<>();
		Deque<Integer> deque = new ArrayDeque<>();
		Queue<Integer> queue = new ArrayDeque<>();
		Queue<Integer> queue1 = new LinkedList<>();
		List<Integer> list2 = new LinkedList<>();
	}	
}


