package TREE;

public class ReconstructBinarySearchTreeWithPreOrderTraversal {
	public TreeNode reconstruct(int[] pre) {
		if(pre == null) {
			return null;
		}
		int[] index = new int[] {0};
//		return helper(pre, index, Integer.MAX_VALUE );
		return helperII(pre, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private TreeNode helperII(int[] pre, int[]index, int min, int max){
		if(index[0] >= pre.length || pre[index[0]] < min || pre[index[0]] > max){
			return null;
		}
		TreeNode root = new TreeNode(pre[index[0]++]);
		root.left = helperII(pre, index, min, root.key);
		root.right = helperII(pre, index, root.key, max);
		return root;
	}
	private TreeNode helper(int[] array, int[] preOrder, int max) {
		// TODO Auto-generated method stub
		if(preOrder[0] >= array.length || array[preOrder[0]] > max) {
			return null;
		}
		TreeNode root = new TreeNode(array[preOrder[0]++]);
		root.left = helper(array, preOrder, root.key);
		root.right = helper(array, preOrder, max);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  preOrder = { 5, 3, 1, 4, 8, 11};
		ReconstructBinarySearchTreeWithPreOrderTraversal reConstruct = new ReconstructBinarySearchTreeWithPreOrderTraversal();
		Tree.PrintLayerByLayer(reConstruct.reconstruct(preOrder));
	}

}
