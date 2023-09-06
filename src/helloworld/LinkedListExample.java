package helloworld;
import java.util.LinkedList;
import java.util.List;
public class LinkedListExample {
	class ListNode{
		ListNode next = null;
		int data;
		public ListNode(int data) {
			this.data = data;
		}
	}	
	public boolean hasCycle(ListNode head) {
    	if(head == null) {
    		return false;
    	}
    	ListNode l1 = head, l2 = head.next;
    	while(l1 != null && l2 != null && l2.next != null) {
    		if(l1 == l2) {
    			return  true;
    		}
    		l1= l1.next;
    		l2 = l2.next.next;
    	}
    	return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//    hasCycle(1);
	}

}
