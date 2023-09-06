package LinkedList;

import java.util.LinkedList;
import java.util.List;

public class MergeSortLinkedList {
	public ListNode mergeSort(ListNode head) {
		   // Write your solution here
		//4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
		 
		  // 1.separate the list into two parts
		// 2. sort each part 
		// 3. recursively doting 2 until there is only one node in the list
		// 4. merge two parts
		  
		if (head == null || head.next == null)
		    return head;
		  ListNode middle = findMiddle(head);
		  ListNode middleNext = middle.next;
		  middle.next = null;
		  ListNode left = mergeSort(head);
		  ListNode right = mergeSort(middleNext);
		  return merge(left, right); 		
		}
		 
		public ListNode findMiddle(ListNode head) {
		  if (head == null)
		    return null;
		  if (head.next == null || head.next.next == null)
		    return head;
		  ListNode slow = head;
		  ListNode fast = head;
		  while (fast.next != null && fast.next.next != null) {
		    slow = slow.next;
		    fast = fast.next.next;
		  }
		  return slow; 
		}
		 
		public ListNode merge(ListNode left, ListNode right) {
		    // Write your solution here
			//first we need to check whether one or is is null, but with the help of dummyHead, we can skip this step
			ListNode dummy = new ListNode(0);
			  ListNode cur = dummy;
			  while (left != null && right != null) {
			    if (left.value <= right.value) {
			      cur.next = left;
			      left = left.next;
			    } else {
			      cur.next = right;
			      right = right.next;
			 
			    }
			    cur = cur.next;
			  }
			  if (left != null) {
				  cur.next = left;
			  }
			  if (right != null) {
				  cur.next = right;				  
			  }
			  return dummy.next;
			 }
	public ListNode mergeSort1(ListNode head){
		// base case :
		if(head == null || head.next == null){
			return head;
		}
		// step 1: find the middle node, separate the list into two parts,
		// step 2: merger two parts
		// recursively do step1 and step2
		ListNode middle = findMiddle1(head);
		ListNode middleNext = middle.next;
		System.out.println("middle.value" + middle.value);
		middle.next = null;
		ListNode left = mergeSort1(head);
		ListNode right = mergeSort1(middleNext);
		return merge1(left, right);
	}
	private ListNode findMiddle1(ListNode head){
		if(head == null || head.next == null || head.next.next == null){
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	private ListNode merge1(ListNode left, ListNode right){
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while(left != null && right != null){
			if(left.value <= right.value){
				cur.next = left;
				left = left.next;
			}else{
				cur.next =  right;
				right = right.next;
			}
			cur = cur.next;
		}
		if(left != null){
			cur.next = left;
		}
		if(right != null){
			cur.next = right;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {4,2,6,-3,5};
		ListNode head = new ListNode(0);
		head = head.create(nums);
		MergeSortLinkedList merge = new MergeSortLinkedList();
		head = merge.mergeSort1(head);
		ListNode.printList(head);;
	}

}
