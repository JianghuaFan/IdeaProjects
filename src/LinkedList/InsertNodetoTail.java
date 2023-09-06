package LinkedList;

public class InsertNodetoTail {
	public static ListNode insertNode(ListNode head, int target) {
	    // Write your solution here
	    ListNode insertNode = new ListNode(target);

	    if (head == null)
	      return insertNode;
	    if (head.next == null) {
	      head.next = insertNode;
	      return head;
	    }      
	    
	    ListNode cur = new ListNode(0);
	    cur.next = head;
	    while (cur.next != null) {
	      cur = cur.next;
	    }
	    cur.next = insertNode;   
	    
	    return head;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {1,2,3};
		ListNode head = new ListNode(0);
		head = head.create(nums);
		ListNode.printList(insertNode(head,5));
	}

}
