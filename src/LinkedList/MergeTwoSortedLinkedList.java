package LinkedList;

public class MergeTwoSortedLinkedList {
	public ListNode merge(ListNode one, ListNode two) {
	    // Write your solution here
		//first we need to check whether one or is is null, but with the help of dummyHead, we can skip this step
		  ListNode dummyHead = new ListNode(0);
		  ListNode cur = dummyHead;
		  while (one != null && two != null) {
		    if (one.value <= two.value) {
		      cur.next = one;
		      one = one.next;
		    } else {
		      cur.next = two;
		      two = two.next;
		    }
		    cur = cur.next;
		  }
		  if (one != null) {
		    cur.next = one;
		  }
		  if (two != null) {
		    cur.next = two;
		  }
		  return dummyHead.next;
		 }

	  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums1 = {0,5,5,5,8,10};
		Integer[] nums2 = {2,3,4,4,5,7};
		ListNode one = new ListNode(0);
		ListNode two = new ListNode(0);
		one = one.create(nums1);
		two = two.create(nums2);
		MergeTwoSortedLinkedList mergeLinkedList = new MergeTwoSortedLinkedList();
		ListNode mergeHead = mergeLinkedList.merge(one, two);
		ListNode.printList(mergeHead);

		
				
	}

}
