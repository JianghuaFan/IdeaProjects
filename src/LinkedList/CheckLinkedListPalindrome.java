package LinkedList;

public class CheckLinkedListPalindrome {
	public boolean isPalindrome(ListNode head) {
		   // Write your solution here
		  // 1.find the middle node of the linkedList
		  // 2.reverse the second half
		  // 3.compare the two half
		  if (head == null)
		    return false;
		  if (head.next == null)
		    return true;
		  ListNode middle = findMiddle(head).next;
		  ListNode reversedMiddle = reverse(middle);
		  return compare(head, reversedMiddle);  
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
		 
		public ListNode reverse(ListNode head) {
		  if (head == null)
		    return null;
		  if (head.next == null)
		    return head;
		  ListNode reverseNode = reverse(head.next);
		  head.next.next = head;
		  head.next = null; 
		  return reverseNode;
		}
		 
		public boolean compare(ListNode one, ListNode two) {
		  while(one != null && two != null) {
		    if (one.value != two.value) {
		      return false;
		    }
		      one = one.next;
		      two = two.next;
		  }
		  return true;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {3,1,3};
		ListNode head = new ListNode(0);
		head = head.create(nums);
		CheckLinkedListPalindrome checkPalindrome = new CheckLinkedListPalindrome();
		System.out.print(checkPalindrome.isPalindrome(head));
	}

}
