package TREE;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPostOrderAndInorder {
	public TreeNode reconstruct(int[] inOrder, int[] postOrder) {
	    // Write your solution here
		int inLeft = 0;
		int postLeft = 0;
		int inRight = inOrder.length - 1;
		int postRight = postOrder.length - 1;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < inOrder.length; i++) {
			map.put(inOrder[i], i);
		}
		return helper(inOrder, postOrder, inLeft, inRight, postLeft,postRight, map);
	}
	private TreeNode helper(int[] inOrder, int[] postOrder, int inLeft, int inRight, int postLeft, int postRight, Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		if(postRight < postLeft) {
			return null;
		}
		TreeNode root = new TreeNode(postOrder[postRight]);
		int rootIndex = map.get(root.key);
		int size = inRight - rootIndex;
		root.right = helper(inOrder, postOrder, rootIndex + 1, inRight, postRight - size, postRight - 1, map);
		root.left = helper(inOrder, postOrder, inLeft, rootIndex - 1, postLeft, postRight - size - 1, map);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] postOrder = {1, 4, 3, 11, 8, 5};
		int[] inOrder = {1, 3, 4, 5, 8, 11};
		ReconstructBinaryTreeWithPostOrderAndInorder reConstruct = new ReconstructBinaryTreeWithPostOrderAndInorder();
		Tree.PrintLayerByLayer(reConstruct.reconstruct(inOrder, postOrder));
	}

}
