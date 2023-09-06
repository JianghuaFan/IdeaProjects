package TREE;



/*
 * 211. Reconstruct Binary Search Tree With Postorder Traversal
Medium
Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

Assumptions

The given sequence is not null
There are no duplicate keys in the binary search tree
Examples

postorder traversal = {1, 4, 3, 11, 8, 5}

the corresponding binary search tree is

        5

      /    \

    3        8

  /   \        \

1      4        11
 */
public class ReconstructBinarySearchTreeWithPostorderTraversal {
	public TreeNode reconstruct(int[] post) {
	    // Write your solution here
		// TC: O(n)
		// Assumptions: post is not null， no duplicate, we traverse from right to left
		int[] postIndex = new int[] {post.length - 1};
		return helper(post, postIndex, Integer.MIN_VALUE);		
	}
	
	public TreeNode helper(int[] post, int[] postIndex, int min) {
		if(postIndex[0] < 0 || post[postIndex[0]] <= min) {
			return null;
		}
		// 因为是BST，所以"min" 意思是根， 利用根划分左右子树
		TreeNode root = new TreeNode(post[postIndex[0]--]);
		root.right = helper(post, postIndex, root.key);
		root.left = helper(post, postIndex, min);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  post = {1, 4, 3};
		ReconstructBinarySearchTreeWithPostorderTraversal reConstruct = new ReconstructBinarySearchTreeWithPostorderTraversal();
//		reConstruct.reconstruct(preOrder, inOrder);
		Tree.PrintLayerByLayer(reConstruct.reconstruct(post));
		
	}

}
