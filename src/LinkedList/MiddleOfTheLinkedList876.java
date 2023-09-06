package LinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class MiddleOfTheLinkedList876 {
	public static ListNode middleNode(ListNode head) {
         if(head == null || head.next == null)
             return head;
//         ListNode slow = head;
//         ListNode fast = head;
//         while(fast.next != null && fast.next.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
////         偶数个节点
//         if(fast.next == null) return slow;
//         
////         奇数个节点
//         else return slow.next;
//         
          ListNode slow = head;
          ListNode fast = head.next;
          while(fast != null && fast.next != null) {
        	  slow = slow.next;
        	  fast = fast.next.next;
          }
//          奇数个节点
          if (fast == null)
              return slow;
//          偶数个节点
          else return slow.next;
         
//         计数方法
//        if(head == null || head.next == null)
//             return head;
//        ListNode slow = head;
//        int cnt = 1;
//        while(slow != null && slow.next != null) {
//            cnt++;
//            slow = slow.next;
//        }
////        System.out.println(cnt);
//        ListNode middle = head;
//        for(int i = 1; i <= cnt / 2 ; i++) {
//            middle = middle.next;
//        }
//            return middle;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {1,2,3,4,5};
		Integer[] nums1 = {1,2,3,4,5,6};
		ListNode head = new ListNode(0);
		ListNode head1 = new ListNode(0);
		head = head.create(nums);
		head1 = head1.create(nums1);

		ListNode middle = middleNode(head.create(nums));
		
		ListNode.printList(middle);
	}

}
