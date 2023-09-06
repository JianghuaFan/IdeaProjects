package TREE;

import java.util.ArrayDeque;
import java.util.Deque;

public class ClosestNumberInBinarySearchTree {
	public int closest(TreeNode root, int target) {
		   // Write your solution here
//		int res = root.key;
//		Deque<Integer> deque = new ArrayDeque<>();
//		while(root != null){
//			if(target == root.key){
//			return root.key;
//			} else if(target < root.key){
//				deque.offerLast(root.key);
//				root = root.left;
//			}else {
//				deque.offerFirst(root.key);
//				root = root.right;
//			}
//		} 
//		int smaller = deque.peekFirst();
//		int larger = deque.peekLast();
//		if(Math.abs(target - smaller) < Math.abs(larger - target)){
//			return smaller;
//		}else {
//			return larger;
//		}
		int res = root.key;
		while(root != null){
			if(target == root.key){
				return root.key;
			}else{
				if(Math.abs(target - root.key) < Math.abs(res - target)){
					res = root.key;
				}else if(root.key < target){
					root = root.right;
				}else{
					root = root.left;
				}
			}
		}
		return res;
	}
	public int closestII(TreeNode root, int target){
		if(root == null) return -1;
		TreeNode[] closest = new TreeNode[1];
		closest[0] = root;
		helperRecursion(closest, root, target);
		return closest[0].key;
	}
	public int closestValue(TreeNode root, int target) {
		return closest(root, target, root.key);
	}

//Super clean recursive Java solution
	private int closest(TreeNode node, double target, int val) {
		if (node == null) return val;
		if (Math.abs(node.key - target) < Math.abs(val - target)) val = node.key;
		if (node.key < target) val = closest(node.right, target, val);
		else if (node.key > target) val = closest(node.left, target, val);
		return val;
	}
	public TreeNode helperRecursion(TreeNode[] closest, TreeNode root, int target){
		if(root == null) return closest[0];

		if( Math.abs(root.key - target) < Math.abs(closest[0].key - target) ){
			closest[0] = root;
		}

		if(root.key < target){
			closest[0] = helperRecursion(closest, root.right, target);
		}else{
			closest[0] = helperRecursion(closest, root.left, target);
		}
		return closest[0];
	}

	public int closestIterative(TreeNode root, int target){
		TreeNode closest = root;
		if(root == null) return -1;
		while(root != null){
			if(Math.abs(closest.key - target) > Math.abs(root.key - target)){
				closest = root;
			}
			if(root.key < target) root = root.right;
			else root = root.left;
		}
		return closest.key;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestNumberInBinarySearchTree closest = new ClosestNumberInBinarySearchTree();
		Integer[] nums = {5,3,6,2,4,null,null,1};
		int target = 1;
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);			
		Tree.createTreeAsLevel(nodes);
//		System.out.println(closest.closest(nodes[0],target));
		System.out.println(closest.closestII(nodes[0],target));
		System.out.println(closest.closestIterative(nodes[0],target));
	}

}
