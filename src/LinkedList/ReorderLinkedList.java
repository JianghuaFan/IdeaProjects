package LinkedList;
import java.util.List;
import java.util.LinkedList;

public class ReorderLinkedList {
	public ListNode reOrder(ListNode head) {
//		   // Write your solution here
//		//1. find the middle node, cut the list into two halves
//		//2. reverse the second half
//		//3. merge two halves
//		  if (head == null || head.next == null || head.next.next == null)
//		    return head;
//		  ListNode middle = findMiddle(head);
//		  ListNode middleNext = middle.next;
//		  middle.next = null;
//		  ListNode right = reverse(middleNext);
//		  return merge(head, right);
//		}
//		 
//		public ListNode findMiddle(ListNode head) {
//		  if (head == null)
//		    return null;
//		 	
//		   ListNode slow = head;
//		   ListNode fast = head;
//		   while (fast.next != null && fast.next.next != null) {
//		 	slow = slow.next;
//		 	fast = fast.next.next;
//		   }
//		   return slow;
//		}
//		 
//		public ListNode reverse(ListNode head) {
//	      if (head == null || head.next == null)
//			return head;
//		
//		  ListNode reversedNode = reverse(head.next);
//		  head.next.next = head;
//		  head.next = null;
//		  return reversedNode; 
//		}
//		 
//		public ListNode merge(ListNode left, ListNode right) {
//		  ListNode dummy = new ListNode(0);
//		  ListNode cur = dummy;
//		  while (left != null && right != null) {
//		  cur.next = left;
//		  left = left.next;
//		  cur = cur.next;
//		  cur.next = right;
//		  right = right.next;
//		  cur = cur.next;
//		  }
//		  if (left != null) {
//		    cur.next = left;
//		  }
//		  if (right != null) {
//		    cur.next = right;
//		  }
//		  return dummy.next;
//		}
		//1. find middle node
		//2. cut the LinkedList into two halves
		//3. reverse the second half
		//4. merge the two halves 
		  if (head == null || head.next == null)
			  return head;
		  ListNode middle = findMiddle(head);
		  ListNode two = middle.next;
		  middle.next = null;
		  ListNode one = head;
		  return merge(one, reverse(two));  
		}
		 
		public ListNode findMiddle(ListNode head) {
		  if (head == null || head.next == null)
		    return head;
		  ListNode slow = head;
		  ListNode fast = head;
		  while (fast.next != null && fast.next.next != null) {
		    slow = slow.next;
		    fast = fast.next.next;
		  }
		  return slow;
		}
		 
		public ListNode reverse(ListNode head) {
		  if (head == null || head.next == null)
		    return head;  
		  ListNode prev = null;
		  ListNode next = null;
		  while (head != null) {
		    next = head.next;
		    head.next = prev;
		    prev = head;
		    head = next;  
		  }
		  return prev;
		}
		 
		public ListNode merge(ListNode one, ListNode two) {
		  ListNode dummy = new ListNode(0);
		  ListNode cur = dummy;
		  while (one != null && two != null) {
		    cur.next = one;
		    one = one.next;
		    cur.next.next = two;
		    two = two.next;
		    cur = cur.next.next;
		  }
		  if (one != null) {
		    cur.next = one;
		  } else {
		    cur.next = two;
		  }
		  return dummy.next;
		} 


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {1234};
		ListNode head = new ListNode(0);
		head = head.create(nums);
		ReorderLinkedList reorder = new ReorderLinkedList();
		ListNode reOrderHead = reorder.reOrder(head);
		ListNode.printList(reOrderHead);
	}

}
