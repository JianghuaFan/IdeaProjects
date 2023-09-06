package LinkedList;

public class ReverseLinkedList206 {
	public ListNode reverseLinkedList(ListNode head) {
//		interative:
//		if (head == null || head.next == null)
//		      return head;
//		    
//		    ListNode prev = null;//		    
//		    while (head != null) {
//		      ListNode next = head.next;
//		      head.next = prev;
//		      prev = head;
//		      head = next;
//		    }
//		    return prev;

	
		//base case: head is null or nead.next is null, we return head
		  if (head == null || head.next == null)
		    return head;		  

		// we assume our method reverseLinkedList for the next node will return the new Head of the subproblem
		 
		    ListNode reversedHead = reverseLinkedList(head.next);
		    head.next.next = head;
		    head.next = null;
		    return reversedHead;




		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {1,2,3,4};
		ListNode head = new ListNode(-1);
		head = head.create(nums);
		ReverseLinkedList206 rLL = new ReverseLinkedList206();
		head = rLL.reverseLinkedList(head); 
		ListNode.printList(head);
//		ReverseLinkedList206 rLL = new ReverseLinkedList206();
//		ListNode n1 = new ListNode(1);
//		n1.next = new ListNode(2);
//		n1.next.next = new ListNode(3);
//		rLL.printLinkedList(n1);		
//		ListNode reversedHead = rLL.reverseLinkedList(n1);
//		rLL.printLinkedList(reversedHead);			
	}

	private void printLinkedList(ListNode n1) {
		while(n1 != null) {
			System.out.print(n1.value + " --> ");
			n1 = n1.next;
		}
		System.out.println(" null ");
	}

}
