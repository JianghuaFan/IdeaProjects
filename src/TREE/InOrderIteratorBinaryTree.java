package TREE;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class InOrderIteratorBinaryTree implements Iterator<TreeNode>{
	Deque<TreeNode> deque = new ArrayDeque<>();
	public void inOrderIterator(TreeNode root){
		if(root != null) {
			deque.offerFirst(root);
		}		
	}		
	@Override	
	public TreeNode next() {		
		TreeNode cur = deque.pollFirst();
		TreeNode helper = null;
		while(hasNext() || cur != null) {
			if(cur != null) {
				deque.offer(cur);
				cur = cur.left;
			}else {
				cur = deque.poll();				
				helper = cur;
//				System.out.println(helper.key);
				cur = cur.right;
			}
		}
//		System.out.println(helper.key);
		return helper;
	}
	
	@Override
	public boolean hasNext() {
		return (!deque.isEmpty());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {5,2,8,1,3,null,9};
		TreeNode[] nodes = Tree.arrayToTreeNodes(array);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		InOrderIteratorBinaryTree inOrderIterator = new InOrderIteratorBinaryTree();
		inOrderIterator.inOrderIterator(root);
		for(int i = 0; i < nodes.length; i++) {
			System.out.println(inOrderIterator.next().key);
		}
		
	}
	

}
