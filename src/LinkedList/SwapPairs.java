package LinkedList;

public class SwapPairs{
	public ListNode swapPairs(ListNode head) {
		ListNode node = new ListNode(-1);
	    node.next = head;
	    ListNode pre = node;
	    while (pre.next != null && pre.next.next != null) {
	        ListNode l1 = pre.next, l2 = pre.next.next;
	        ListNode next = l2.next;
	        l1.next = next;
	        l2.next = l1;
	        pre.next = l2;
	        pre = l1;
	    }
	    return node.next;
	}
	public ListNode reverseInPairs(ListNode head){
		//base case: get to the last node
		if(head == null || head.next == null){
			return head;
		}
		ListNode N1 = head;
		ListNode N2 = head.next;
		ListNode N3 = reverseInPairs(head.next.next);
		N2.next = N1;
		N1.next = N3;
		return N2;		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {1,2,3,4};
		ListNode head = new ListNode(0);
		head = head.create(nums);
		head.printList(head);
		SwapPairs reverse = new SwapPairs();
		head = reverse.swapPairs(head);
//		head = reverse.reverseInPairs(head);
//		reverse.reverseInPairs(head);
		head.printList(head);

	}

}
