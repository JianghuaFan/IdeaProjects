package TREE;

import java.util.HashMap;
import java.util.Map;
/*
 * 213. Reconstruct Binary Tree With Preorder And Inorder
Medium
Given the preorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions

The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree
Examples

preorder traversal = {5, 3, 1, 4, 8, 11}

inorder traversal = {1, 3, 4, 5, 8, 11}

the corresponding binary tree is

        5

      /    \

    3        8

  /   \        \

1      4        11
 */
public class ReconstructBinaryTreeWithPreorderAndInorder {
	public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
	    // Write your solution here
		// TC: O(n)  SC: O(n)
		//Assumptions: preOrder and inOrder are not null,and lengths are the same, there is no duplicates
	    Map<Integer, Integer> map = new HashMap<>();
	    int index = 0;
	    for(int i : inOrder){
	      map.put(i, index++);
	    }
	    return helper(0, inOrder.length - 1, preOrder, 0, preOrder.length - 1, map);    
	  }

	public TreeNode helper(int inLeft, int inRight, int[] preOrder, int preLeft, int preRight, Map<Integer, Integer> map){
		if(inLeft > inRight){
	      return null;
	    }
	    TreeNode root = new TreeNode(preOrder[preLeft]);
	    // get the position of the root in inOrder array, so that we will know the size of left/right subTrees
	    // 在preOrder找根，再去inOrder找到位置，位置左半部分是左子树，右半部分是右子树
	    int CurRootIndex = map.get(root.key);
	    int leftSize = CurRootIndex - inLeft;

	    root.left = helper( inLeft, CurRootIndex - 1, preOrder, preLeft + 1, preLeft + leftSize, map);
	    root.right = helper( CurRootIndex + 1, inRight, preOrder, preLeft + leftSize + 1, preRight, map);
	    return root;
	  }
	
	public TreeNode reconstructII(int[] inOrder, int[] preOrder) {
		int[] preIndex = new int[] {0};
		int[] inIndex = new int[] {0};
		return helperII(inOrder, preOrder, preIndex, inIndex, Integer.MAX_VALUE);	
	}
	
	public TreeNode helperII(int[] inOrder, int[] preOrder, int[] preIndex, int[] inIndex, int target) {
		// Traversing and construct the binary tree using preOrder and inOrder,
		// the preOrder is[root][left subTree][right subTree]
		// the inOrder is [left subTree][root][right subTree]
		// when we know the root, we actually know the boundary of the left/ right subTree
		// the "target" is actually the root, using inOrder to identify the boundary of the left subtree
		if(inIndex[0] >= inOrder.length || inOrder[inIndex[0]] == target) {
			return null;
		}
		TreeNode root = new TreeNode(preOrder[preIndex[0]]);
		// preOrder, advance the index by 1 since we already finish the root
		preIndex[0]++;
		root.left = helperII(inOrder, preOrder, preIndex, inIndex, root.key);
		// inOrder, after we finish the left subtree, we can advance the index by 1
		inIndex[0]++;
		root.left = helperII(inOrder, preOrder, preIndex, inIndex, target);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preOrder = {5, 3, 1, 4, 8, 11};
		int[] inOrder = {1, 3, 4, 5, 8, 11};
		ReconstructBinaryTreeWithPreorderAndInorder reConstruct = new ReconstructBinaryTreeWithPreorderAndInorder();
//		reConstruct.reconstruct(preOrder, inOrder);
		Tree.PrintLayerByLayer(reConstruct.reconstruct(inOrder, preOrder));
		Tree.PrintLayerByLayer(reConstruct.reconstructII(inOrder, preOrder));
	}

}
