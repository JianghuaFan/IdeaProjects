package LinkedList;

import java.util.*;

public class MergeKSortedLinkedList {
	
	public ListNode merge(List<ListNode> listOfLists) {
		ListNode res = new ListNode(0);
		ListNode cur = res;
		
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new myComparator());

		for(int i = 0; i < listOfLists.size(); i++) {
			ListNode node = listOfLists.get(i);
			if(node != null) {
				minHeap.offer(node);
			}
		}
		while(!minHeap.isEmpty()) {			
			cur.next = minHeap.poll();
			if(cur.next.next != null) {
				minHeap.offer(cur.next.next);
			}
			cur = cur.next;
		}
		return res.next;
	}

	private class myComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode n1, ListNode n2) {
			if(n1.value == n2.value) {
				return 0;
			}
			return n1.value < n2.value ? -1 : 1;
		}
	}
	public ListNode mergeKSortedLinkedList(ListNode[] lists){
		List<ListNode> res = new ArrayList<>();
		if(lists == null || lists.length == 0){
			return null;
		}
		int k = lists.length;
		//highlevel : we will use a minHeap to compare all the first ListNode of all the lists,
		// 谁小取谁，取谁移谁（ pick the smallest, move the smallest one node forward
		// step 1: offer all the first node into heap,
		// step 2: connect the dummy node to the smallest ListNode and move one node forward(offer to minHeap)
		// step 3: repeat step 2 util all the lists finished
//		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(k, (ListNode a, ListNode b) -> Integer.compare(a.value, b.value));
		PriorityQueue<ListNode> mineHeap = new PriorityQueue<ListNode>(k, new Comparator<ListNode>(){
			@Override
			public int compare(ListNode a, ListNode b){
				return Integer.compare(a.value, b.value);
			}
		});
		for(ListNode head: lists){
			if(head != null){
				mineHeap.offer(head);
			}
		}
		System.out.println(mineHeap);
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while(!mineHeap.isEmpty()){
			ListNode min = mineHeap.poll();
			cur.next = min;
			cur = cur.next;
			if(min.next != null){
				mineHeap.offer(min.next);
			}
		}
		System.out.println("dummy.value: " + dummy.next.value);
		return dummy.next;
	}
	public ListNode mergeK(List<ListNode> listOfList){

		if(listOfList == null || listOfList.size() == 0){
			return new ListNode(0);
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int k = listOfList.size();

		// step 1 : offer all the heads of the k linkedlist into a minHeap
		// step 2 : poll out the top into the result
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(k, new Comparator<ListNode>(){
			@Override
			public int compare(ListNode l1, ListNode l2){
				return l1.value < l2.value ? -1 : 1;
			}
		});
		for(ListNode node : listOfList){
			if(node != null){
				minHeap.offer(node);
			}
		}
		while(!minHeap.isEmpty()){
			ListNode node = minHeap.poll();
			cur.next = node;
			if(node.next != null){
				minHeap.offer(node.next);
			}
			cur = cur.next;
		}
		return dummy.next;
	}
//	while(!minHeap.isEmpty()) {
//		cur.next = minHeap.poll();
//		if(cur.next.next != null) {
//			minHeap.offer(cur.next.next);
//		}
//		cur = cur.next;
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeKSortedLinkedList mergeLinkedList = new MergeKSortedLinkedList();
		Integer[] nums1 = {1,5};
		Integer[] nums2 = {2,3};
		Integer[] nums3 = {};
		ListNode one = new ListNode(0);
		ListNode two = new ListNode(0);
		ListNode three = new ListNode(0);
//		one = mergeLinkedList.create(nums1);
		one = one.create(nums1);
		two = two.create(nums2);
		three = three.create(nums3);
		List<ListNode> lists = new ArrayList<>();
		lists.add(one);
		lists.add(two);
		lists.add(three);
		int k = 3;
		ListNode[] lists2 = new ListNode[k];
		lists2[0] = one;
		lists2[1] = two;
		lists2[2] = three;

//		mergeLinkedList.merge(lists);
//		for(ListNode node: lists){
//			System.out.println(node.value);
//		}

		ListNode head = mergeLinkedList.mergeK(lists);
		while(head != null){
			System.out.println(head.value);
			head = head.next;
		}
	}

}
