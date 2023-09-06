package LinkedList;

public class ChecKIfLinkedListHasACycle37 {
	public static boolean hasCycle(ListNode head) {
	    // write your solution here
	    
	    //1.check if the list LinkedList is null
		  if (head == null || head.next == null)
			  return false;

	    //2. use slow and quick pointer to check if they are equal that means there is a cycle in the linkedList
		  ListNode slow = head;
		  ListNode fast = head;
		  while(fast.next != null && fast.next.next != null) {
		    slow = slow.next;
		    fast = fast.next.next;
		    if (slow == fast)
			    return true;
	    }
	    return false;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {1,2,1};
		ListNode head = new ListNode(0);
		head.create(nums);
		System.out.print(hasCycle(head));

	}

}
