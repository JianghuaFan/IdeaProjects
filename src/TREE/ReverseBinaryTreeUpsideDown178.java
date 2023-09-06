package TREE;

public class ReverseBinaryTreeUpsideDown178 {
	public TreeNode reverse(TreeNode root) {
	    // Write your solution here
		if(root == null || root.left == null){
			return root;
		}
		TreeNode newNode = reverse(root.left);
		root.left.left =(root);
		root.left.right = root.right;
	
		root.left =(null);
		root.right = null;
		return newNode;

	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] nums = {1,2,3,4,5,null, null, 6,7};
		Integer[] nums = {41,18,41,37,20};
		
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		
		ReverseBinaryTreeUpsideDown178 reverse = new ReverseBinaryTreeUpsideDown178();
		Tree.PrintLayerByLayer(root);		
		Tree.PrintLayerByLayer(reverse.reverse(root));
	}

}
