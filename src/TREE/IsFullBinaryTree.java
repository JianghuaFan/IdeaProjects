package TREE;
/*
392. Determine If Binary Tree Is Full Tree
Medium
Determine if a given binary tree is full.

A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes.
Conversely, there is no node in a full binary tree, which has one child node.

If the root is null, return false.
 */
public class IsFullBinaryTree {
    // Method 1: DFS(recursion)
    public boolean isFull(TreeNode root) {
        // Write your solution here
        // base case: null
        if(root == null){
            return true;
        }
        // leaf node
        if(root.left == null && root.right == null){
            return true;
        }
        // leaf node with only one child false
        else if(root.left == null || root.right == null){
            return false;
        }
        // what do you ask from left and right child:
        boolean leftIsFull = isFull(root.left);
        boolean rightIsFull = isFull(root.right);

        // what do you do at current level:
        if(!leftIsFull ||  !rightIsFull ){
            return false;
        }
        return true;
    }
}
