package TREE;
/*
 * Given a binary tree in which each node contains an integer number. 
 * Find the maximum possible path sum from a leaf to root.
Assumptions
The root of given binary tree is not null.
Examples

         10

       /      \

    -2        7

  /     \

8      -4
The maximum path sum is 10 + 7 = 17.
 */
public class MaximumPathSumBinaryTreeFromLeafToRoo639 {
	public int maxPathSumLeafToRoot(TreeNode root) {
	    // Write your solution here
		// TC: O(n)  SC: O(h)
		// method 1: Bottom Up: return the max suffix sum : from leaf to root  
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return root.key;
		}
		if(root.left == null) {
			return maxPathSumLeafToRoot(root.right) + root.key;
		}
		if(root.right == null) {
			return maxPathSumLeafToRoot(root.left) + root.key;
		}
		int left = maxPathSumLeafToRoot(root.left);
		int right = maxPathSumLeafToRoot(root.right);
		return root.key + Math.max(left, right);
	  }
	// method 2: Top Down: Pass down the prefix sum : from root to leaf, 
	public int maxPathSumLeafToRootII(TreeNode root) {
//		if(root == null) {
//			return 0;
//		}
		return helper(root, 0);
	}
	
	private int helper(TreeNode root, int sum) {
		if(root == null) {
			return 0;
		}
		sum += root.key;
		if(root.left == null && root.right == null) {
			return sum;
		} 
//		else if (root.left == null) {
//			return helper(root.right, sum);
//		} else if (root.right == null) {
//			return helper(root.left, sum);
//		}
		
		int left = helper(root.left, sum);
		int right = helper(root.right, sum);
		if(root.left == null) {
			return right;
		}
		if(root.right == null) {
			return left;
		}
		return Math.max(left, right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] nums = {-1,2,2};
		Integer[] nums = {-16,-2,0,7,-11,2,null,-2,-5,-5,-15,5,15};
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
//		Tree.PrintLayerByLayer(root);
		MaximumPathSumBinaryTreeFromLeafToRoo639 max = new MaximumPathSumBinaryTreeFromLeafToRoo639();
		System.out.println(max.maxPathSumLeafToRoot(root));
		System.out.println(max.maxPathSumLeafToRootII(root));
	}

}
