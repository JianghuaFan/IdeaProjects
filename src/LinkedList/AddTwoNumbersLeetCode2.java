package LinkedList;

public class AddTwoNumbersLeetCode2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		  ListNode dummy = new ListNode(0);
		  ListNode cur = dummy;
		 
		  int val = 0;
		  
		  while(l1 != null || l2 != null || val != 0) {
			  if (l1 != null) {
				  val += l1.value;
				  l1 = l1.next;
			  }
			  if (l2 != null) {
				  val += l2.value;
				  l2 = l2.next;
			  }
			cur.next = new ListNode(val%10); 		    
			val = val / 10;		    
		    cur = cur.next;    
		  }
		  return dummy.next; 
		}
		public ListNode reverseLinkedList(ListNode head) {
			// iterative approach
			  if (head == null || head.next == null) 
			    return head;

			// we use a prev node to store the new Head, move the head and prev until to the end of the //list, return prev, we use next to store the subList

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] nums1 = {2,4,3};
//		Integer[] nums2 = {5,6,4};
		Integer[] nums1 = {2,4,9};
		Integer[] nums2 = {5,6,4,9};
		ListNode one = new ListNode(0);
		ListNode two = new ListNode(0);
		one = one.create(nums1);
		two = two.create(nums2);
		AddTwoNumbersLeetCode2 addTN = new AddTwoNumbersLeetCode2();
		ListNode res = addTN.addTwoNumbers(one, two);
	}

}
