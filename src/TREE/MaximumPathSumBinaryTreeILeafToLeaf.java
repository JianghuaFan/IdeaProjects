package TREE;

public class MaximumPathSumBinaryTreeILeafToLeaf {
	/*138. Maximum Path Sum Binary Tree I
Medium
Given a binary tree in which each node contains an integer number. 
Find the maximum possible sum from one leaf node to another leaf node.
 If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).

Examples

  -15

  /    \

2      11

     /    \

    6     14

The maximum path sum is 6 + 11 + 14 = 31.
	 */
	public int maximumPath(TreeNode root) {
		int[] global = new int[] {Integer.MIN_VALUE};
		max(root, global);
		return global[0];
	 }
	public int max(TreeNode root, int[] global){
//	base case:		
		if(root == null){
			return 0;
		}
//		 leaf node, return itself
		if(root.left == null && root.right == null) {
			return root.key;
		}
	// step 1: what do you want from your children?	
		int left = max(root.left, global);
		int right = max(root.right,global);

	// step 2: what do you do at the current level?
		if(root.left != null && root.right != null) {
			//both left and right not null, 
			//can calculate the minimum to guarantee take one leaf node
			global[0] = Math.max(global[0], left + right + root.key);
			// step 3: what do you report to your parents?
			return Math.max(left, right) + root.key;
			
		}
		// else return the non null leaf node
		return (root.left == null) ? right + root.key: left + root.key;
		// 另一种写法更复杂
//		if(root.left == null && root.right == null) {
//			return root.key;
//		}
//		if(root.left == null) {
//			return max(root.right,global) + root.key;
//		}
//		if(root.right == null) {
//			return max(root.left,global) + root.key;
//		}
//		global[0] = Math.max(global[0], max(root.left,global) + max(root.right,global) + root.key);
//		return Math.max(max(root.left,global), max(root.right,global)) + root.key;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] nums = {-1,2,2,2};
		Integer[] nums = {-91,83,68,null,null,5,null};
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		Tree.PrintLayerByLayer(root);
		MaximumPathSumBinaryTreeILeafToLeaf max = new MaximumPathSumBinaryTreeILeafToLeaf();
		System.out.println(max.maximumPath(root));
	}

}
