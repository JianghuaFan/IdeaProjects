package TREE;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class KClosestNumberInBinaryTree {
	public int[] closestKValues(TreeNode root, double target, int k) {
		   // Write your solution here
			int[] res = new int[k];
			Deque<Integer> deque = new ArrayDeque<>();
			inOrder(deque, root, target, k);
			return toArray(deque);
	 }
	public void inOrder(Deque<Integer> deque, TreeNode root, double target, int k){
		// base case:
		if(root == null){
			return;
		}
		if(root.left != null){
			inOrder(deque, root.left, target, k);
		}
		if(deque.size() < k){
			deque.offerLast(root.key);
		}else{
			if(Math.abs(target - deque.peekFirst()) > Math.abs(root.key - target)){
				deque.pollFirst();
				deque.offerLast(root.key);
			} else{
				return;
			}
		}
		if(root.right != null){
			inOrder(deque, root.right, target, k);
		}
	}
	private int[] toArray(Deque<Integer> deque){
		int[] array = new int[deque.size()];
		for(int i = 0; i < array.length; i++){
			array[i] = deque.pollFirst();
		}
		return array;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KClosestNumberInBinaryTree kclose = new KClosestNumberInBinaryTree();
		Integer[] nums = {5,2,11,null,null,6,14};
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		Tree.PrintLayerByLayer(root);
		int target = 10;
		int k = 2;
		System.out.print(Arrays.toString(kclose.closestKValues(root, 10, 2)));
//		kclose.closestKValues(root, 10, 2);
	}

}
