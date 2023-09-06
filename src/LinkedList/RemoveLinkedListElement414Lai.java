package LinkedList;

public class RemoveLinkedListElement414Lai {
	public static ListNode removeElements(ListNode head, int val) {
//		if (head == null)
//		      return head;		
		// we creat dummy node helps ue keep track of the new head in case the existing head has to be removed
//		since we are not using a previous pointer, we will set the current node to the dummy node
//		we will check the following two conditions:
//		(1)cur.next.val == val, then we will remove the cur.next node by setting cur.next = cur.next.next.Please note
//		we will not we will not move the current pointer in this step as new cur.next has not been validated yet
//		(2)cur.next.val != val, move cur to cur.next 
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;		
		
		while( cur.next != null) {
			if (cur.next.value == val)
				cur.next = cur.next.next;
			else
				cur = cur.next;				
		}
		
		return dummy.next;
//		// recursive approach
		  
//		  if (head == null )
//		    return null;	
//		  
//		  head.next = removeElements(head.next, val);
//		  head = head.value == val ? head.next : head; 
//		  return head;

			    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {1,2,6,3,4,5,6};
		ListNode head = new ListNode(0);
		head = head.create(nums);
		removeElements(head,6);
		ListNode.printList(head);
	}

}
