package LinkedList;

import java.util.LinkedList;
import java.util.List;


public class InsertIntoSortedLinkedList {
	public static ListNode insertSorted(ListNode head, int value) {		
		
		ListNode newHead = new ListNode(value);
		 if (head == null)
		   return newHead;
		 
//		 if (head.value >= target) {
//		   newHead.next = head;
//		   return newHead;
//		 }
//		//bug 1: 忘记比较头结点，
//		 
////		 ListNode cur = new ListNode(0);
////		 cur.next = head;
//		 ListNode cur = head;
//		  while (cur.next != null && cur.next.value <= target) {
//		   cur = cur.next;
//		 }
//		 newHead.next = cur.next;
//		 cur.next = newHead;
//		 return head;
		 //头不确定所以可以考虑用dummy办法
		 
		 ListNode dummy = new ListNode(-1);
		 dummy.next = head;
		 ListNode prev = dummy;
		 while(prev.next != null && prev.next.value < value) {
			 prev = prev.next;
		 }
		 newHead.next = prev.next;
		 prev.next = newHead;
		 return dummy.next;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {2,4,6};
		ListNode head = new ListNode(0);
		head = head.create(nums);
		head = insertSorted(head,1);
		ListNode.printList(head);			
	}

}
