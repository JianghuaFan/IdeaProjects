package LinkedList;

public class PartitionLinkedList {
	public ListNode partition(ListNode head, int target) {
		   // Write your solution here
		  //case 1: head is null, return null
		  //case 2: head.next is null, return head
		  //case 3: general case
		  if (head == null)
		    return null; 
		  if (head.next == null) 
		    return head;
		  ListNode dummySmall = new ListNode(0);
		  ListNode dummyLarge = new ListNode(0);
		  ListNode curSmall = dummySmall;
		  ListNode curLarge = dummyLarge;
//		  while (head != null) {
//		    if (head.value < target) {
//		    	curSmall.next = head;
//		    	curSmall = curSmall.next;      
//		    }
//		    else {
//		    	curLarge.next = head;
//		    	curLarge = curLarge.next;
//		    }
//		    head = head.next;
//		  }
//		  curSmall.next = dummyLarge.next;
//		  curLarge.next = null;
//		  return dummySmall.next;
		  while (head != null) {
			  if (head.value < target) {
				  curSmall.next = head;
				  curSmall = curSmall.next;
			  } else {
				  curLarge.next = head;
				  curLarge = curLarge.next;
			  }
			  head = head.next;
		  }
		  curSmall.next = dummyLarge.next;
		  curLarge.next = null;		  
		  return dummySmall.next;
		}
	public static ListNode getIndex(ListNode head, int index) {
		  if (head == null) 
		    return null;
		  while ( head != null && index >0) {
		    head = head.next;
		    index--;
		  }
		return head;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {3,2,1,2};
		ListNode head = new ListNode(-1);
		head = head.create(nums);
		PartitionLinkedList rLL = new PartitionLinkedList();
//		ListNode.printList(head);
		int target = 2;
		head = rLL.partition(head, target); 
		ListNode.printList(head);
		
	}

}
