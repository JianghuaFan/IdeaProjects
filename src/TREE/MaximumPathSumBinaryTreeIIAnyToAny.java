package TREE;
/*Given a binary tree in which each node contains an integer number. 
 * Find the maximum possible sum from any node to any node.
 *  If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).
 */
public class MaximumPathSumBinaryTreeIIAnyToAny {
	public int maximumPath(TreeNode root) {
		int[] globalPath = new int[] {Integer.MIN_VALUE};
		helper(root, globalPath);
		return  globalPath[0];
	}
	
	public int helper(TreeNode root, int[] globalPath) {
		if(root == null) {
			return 0;
		}
		//Q1: What do you expect from your children?
		int leftPath = helper(root.left, globalPath);
		int rightPath = helper(root.right, globalPath);
		//Q2: What do you want to do in the curren level?
		// case1: leftPath is negative
		leftPath = leftPath < 0 ? 0 : leftPath;
		// case1: rightPath is negative
		rightPath = rightPath < 0 ? 0 : rightPath;
		globalPath[0] = Math.max(globalPath[0], leftPath + root.key + rightPath);
		
		//Q3: What do you want to report to your parent?
		return Math.max(leftPath, rightPath) + root.key;
		
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] nums = {-1,2,11,6,-14};
		Integer[] nums = {-45,null,-2,null,-100,null,null};
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		
		MaximumPathSumBinaryTreeIIAnyToAny max = new MaximumPathSumBinaryTreeIIAnyToAny();
		System.out.println(max.maximumPath(root));		
	}

}
