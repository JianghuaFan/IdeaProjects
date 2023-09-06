package TREE;

public class IsBalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		// Write your solution here
		//corner case: root is null || base case: leaf node
		if (root == null) {
			return true;
		}

		boolean isLeft = isBalanced(root.left);
		boolean isRight = isBalanced(root.right);
		if (!isLeft || !isRight) {
			return false;
		}

		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}
		return true;
	}

	//
	public int getHeight(TreeNode root) {
		//corner case : base case: leaf node, the height is 0
		if (root == null)
			return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	/* TC :n * logn
	 *                    operation                    times    time
				ro        getH(ro.l), getH(ro.r) n/2     2     n/2 *2    n
			   /  \
			 ro.l  ro.r   getH(ro.l.l),getH(ro.l.r)  n/4  4     n/4 * 4  n
						   getH(ro.r.l),getH(ro.r.r)
		......
		average: logn level n* logn
		SC : O(height)
	
		*/
	public boolean isBalancedOptimize(TreeNode root) {
		if (root == null) {
			return true;
		}
		return getHeightOptimize(root) != -1;
	}

	public int getHeightOptimize(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (Math.abs(getHeightOptimize(root.left) - getHeightOptimize(root.right)) > 1) {
			return -1;
		}
		if (getHeightOptimize(root.left) == -1 || getHeightOptimize(root.right) == -1)
			return -1;
		return Math.max(getHeightOptimize(root.left), getHeightOptimize(root.right)) + 1;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsBalancedBinaryTree isBalanced = new IsBalancedBinaryTree();
		Integer[] array = {1,2,3,4};
		Integer[] array1 = {-940,500,-119,-454,80,45,-280,null,-854,-377,798,979,-955,null,-221,722,86,null,null,562,-595,436,-823,157,510};
		TreeNode[] nodes = Tree.arrayToTreeNodes(array1);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		isBalanced.isBalanced(root);
		System.out.println(isBalanced.isBalanced(root));
//		Tree.PrintLayerByLayer(root);
	}

}
