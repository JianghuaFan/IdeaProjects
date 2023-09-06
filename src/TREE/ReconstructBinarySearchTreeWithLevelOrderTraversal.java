package TREE;

public class ReconstructBinarySearchTreeWithLevelOrderTraversal {
	public TreeNode reconstruct(int[] level) {
	    // Write your solution here
 		if(level == null || level.length == 0) {
			return null;
		}
		TreeNode root = null;
		// 逐个遍历数组元素，和root。key比较，小的就挂在左边，大的挂在右边，不断的新建左右子树上的新节点，并且再挂回去。
		// 有点像BST中插入新元素
		for(int i = 0; i < level.length; i++) {			
			root = helper(root, level[i]);
		}
		return root;
	}	
	
	private TreeNode helper(TreeNode root, int i) {
		// TODO Auto-generated method stub
		if(root == null) {
			//
//			root = getRoot(i);
			root = new TreeNode(i);
			return root;
		}
		if(i <= root.key) {
			root.left = helper(root.left, i);
		}else {
			root.right = helper(root.right, i);
		}
		return root;
	}

	private TreeNode getRoot(int i) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(i);
		root.left = root.right = null;
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  level = {5, 3, 8, 1, 4, 11};
		ReconstructBinarySearchTreeWithLevelOrderTraversal reConstruct = new ReconstructBinarySearchTreeWithLevelOrderTraversal();
		Tree.PrintLayerByLayer(reConstruct.reconstruct(level));
	}

}
