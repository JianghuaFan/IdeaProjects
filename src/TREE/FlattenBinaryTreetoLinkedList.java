package TREE;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenBinaryTreetoLinkedList {
	public TreeNode flatten(TreeNode root) {
		   // Write your solution here
		TreeNode[] prev = new TreeNode[1];
		helper(root, prev);
		return root;
	}
	public void helper(TreeNode root, TreeNode[] prev) {
		if(root == null){
			return;
		}
		// step1: record current left and right child, because left child could be changed
		TreeNode leftNode = root.left;
		TreeNode rightNode = root.right;
		// prev[0] 是当前层的父节点
		if(prev[0] != null) { // if root is the 1st node to visit prev[0] == null
			prev[0].right = root;
		}
		root.left = null;// Or = prev[0] if we need to make it a doubly linked list
		prev[0] = root;	
		
		helper(leftNode, prev); 
		helper(rightNode, prev);		
	}
	public TreeNode flattenIteration(TreeNode root) {

		// base case
		if(root == null){
			return null;
		}
		TreeNode prev = null;
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.offerFirst(root);
		while(!deque.isEmpty()){
			TreeNode cur = deque.pollFirst();
			TreeNode left = cur.left;
			TreeNode right = cur.right;
			if(prev != null){
				prev.right = cur;
			}
			cur.left = null;
			prev = cur;
			if(right != null){
				deque.offerFirst(right);
			}
			if(left != null){
				deque.offerFirst(left);
			}
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {1,2,5,3,4,null,6};
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
//		Tree.PrintLayerByLayer(root);
		
		FlattenBinaryTreetoLinkedList flatten = new FlattenBinaryTreetoLinkedList();
//		flatten.flatten(root);
		flatten.flattenIteration(root);
		Tree.PrintLayerByLayer(root);

	}

}
