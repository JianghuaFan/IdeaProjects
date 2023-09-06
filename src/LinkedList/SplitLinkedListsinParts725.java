package LinkedList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//import helloworld.src.LinkedList.ListNode.java;

public class SplitLinkedListsinParts725 {
	
	    public static ListNode[] splitListToParts(ListNode head, int k) {
	        ListNode[] result = new ListNode[k];
	        ListNode cur = head;
	        int cnt = 0;
	        while(cur != null){
	            cnt ++;
	            cur = cur.next;
	        }
	        int size = cnt/k;
	        int num1 = cnt%k;
	       
	        cur = head;
	        for(int i = 0; i < num1; i++){
	            result[i] = cur;            
	            for(int j = 0; j < size; j++){
	                cur = cur.next;
	            }
//	            System.out.print(size);
	            ListNode next = cur.next;
	            cur.next = null;
	            cur = next;
	        }
	        for(int i = num1; i < k && cur != null; i++){
	            result[i] = cur;
	            for(int j = 0; j < size - 1; j++){
	                cur = cur.next;
	            }
	            ListNode next = cur.next;
	            cur.next = null;
	            cur = next;
	        }
	        return result;
	    
	}

	@SuppressWarnings({ "null", "static-access" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {1,2,3,4,5,6,7,8,9,10};
		ListNode head = new ListNode(0);
		head = head.create(nums);
//		ListNode temp = head;
//		ListNode.printList(temp); // temp和head指向同一地址，当head改变时，temp也跟着改变了
		ListNode[] result = splitListToParts(head,3);
		splitListToParts(head,3);
		ListNode.printList(result);
		
//		ListNode.printList(head);
//		System.out.println("nums:" + Arrays.toString(nums));
//		ListNode.printList(temp);
	}

}
