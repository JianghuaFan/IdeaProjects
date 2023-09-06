package LinkedList;

public class InsertionSortList147 {
	 public static ListNode insertionSortList(ListNode head) {
	        if (head == null)
	            return null;
	        
	        if (head.next == null)
	            return head;
	        
	        ListNode dummy = new ListNode(0); //new starter of the sorted list
	        ListNode cur = head; //the node will be inserted
	        ListNode pre = dummy; //insert node between pre and pre.next
	        ListNode next = null; //the next node will be inserted
	        //not the end of input list
	        while( cur != null ){
	            next = cur.next;
	            //find the right place to insert
	            while( pre.next != null && pre.next.value < cur.value ){
	                pre = pre.next;
	            }
	            //insert between pre and pre.next
	            cur.next = pre.next;
	            pre.next = cur;
	            pre = dummy;
	            cur = next;
	        }

	        return dummy.next;
	        
//	        ListNode dummy = new ListNode(0);
//	        //拿出的节点
//	        while (head != null) {
//	            ListNode tempH = dummy;
//	            ListNode headNext = head.next;
//	            head.next = null; 
//	            while (tempH.next != null && tempH.next.valueue < head.valueue) {
//	                //找到大于要插入的节点的位置
//	            	tempH = tempH.next;
//	            }
//	            head.next = tempH.next;
//	            tempH.next = head;
//	            tempH = dummy;
//	            
//	                if (tempH.next.value > head.value) {
//	                    head.next = tempH.next;
//	                    tempH.next = head; 
//	                    break;
	            //break语句通常用在循环语句和开关语句中。当break用于开关语句switch中时，可使程序跳出switch而执行switch以后的语句；

//如果没有break语句，则会从满足条件的地方（即与switch（表达式）括号中表达式匹配的case）开始执行，直到switch结构结束。

//当break语句用于do-while、for、while循环语句中时，可使程序终止循环。

//而执行循环后面的语句，通常break语句总是与if语句联在一起。即满足条件时便跳出循环。
//	                }
//	                tempH = tempH.next;
//	            }
	            //没有执行插入，将当前节点加到末尾
//	            if (tempH.next == null) {
//	                tempH.next = head;
//	            }
//	            head = headNext;
//	        }
//	        return dummy.next;
	    
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {6,4,2};
		ListNode head = new ListNode(0);
		head = head.create(nums);
		head = insertionSortList(head);
		ListNode.printList(head);
	}

}
