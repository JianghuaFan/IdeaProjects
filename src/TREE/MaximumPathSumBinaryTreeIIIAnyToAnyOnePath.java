package TREE;

public class MaximumPathSumBinaryTreeIIIAnyToAnyOnePath {
	public int maxPathSum(TreeNode root) {
		   // Write your solution here
		if(root == null){
			return Integer.MIN_VALUE;
		} 
		int[] global = new int[]{Integer.MIN_VALUE};
		helper(root, global, 0);
		return global[0];
	}
	public void helper(TreeNode root, int[] global, int prefixSum){
		if(root == null){
			return;
		}
		prefixSum = prefixSum < 0 ? 0 : prefixSum;		
		prefixSum += root.key;
		global[0] = Math.max(global[0], prefixSum);

		if(root.left != null){
			helper(root.left, global, prefixSum); 
		}
		if(root.right != null){
			helper(root.right, global, prefixSum); 
		}		
//		prefixSum -= root.key;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {-5,2,11,null,null, 6,14};
//		Integer[] nums = {null};
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
//		Tree.PrintLayerByLayer(root);
		MaximumPathSumBinaryTreeIIIAnyToAnyOnePath max = new MaximumPathSumBinaryTreeIIIAnyToAnyOnePath();
		System.out.println(max.maxPathSum(root));
	}

}
