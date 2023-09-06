package LinkedList;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		  if (head == null || n == 0) {
		    return head;
		  }
		  ListNode dummy = new ListNode(0);
		  ListNode prev = dummy;
		  prev.next = head; 
		  ListNode fast = head;
		  while (n > 0  && fast != null) {
		    fast = fast.next;
		    n = n - 1; 
		  }
		  // n is bigger than the length of the LinkedList
		  if (n > 0)
			  return head;
		  while (fast != null) {
		    prev = prev.next;
		    fast = fast.next;
		  }
		  prev.next = prev.next.next;
		  return dummy.next;
		}
	
	public static void main(String[] args) {
		Integer[] nums = {1,2,3,4};
		ListNode head = new ListNode(0);
		head = head.create(nums);
		RemoveNthNodeFromEndofList removeNthNode = new RemoveNthNodeFromEndofList();
		head = removeNthNode.removeNthFromEnd(head, 5);
		ListNode.printList(head);
	}

}
