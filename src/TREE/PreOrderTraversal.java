package TREE;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
	public static List<Integer> preOrderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		System.out.print(res);
		return res;
	}

	private static void helper(TreeNode root, List<Integer> res) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		res.add(root.key);
		helper(root.left, res);
		helper(root.right, res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {1,2,3,4,5};
		Tree tree = new Tree();
		TreeNode[] nodes  = tree.arrayToTreeNodes(nums);
		for ( int i = 0; i < nums.length; i++) {
			System.out.println("nodes: " + nodes[i].key);
		}
		
		tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		System.out.println("root: " + root.key);
		System.out.print(preOrderTraversal(root));
	}

}
