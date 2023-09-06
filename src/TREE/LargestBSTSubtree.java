package TREE;
/*
467. Largest BST Subtree
Medium
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:

    10
    / \
   5  15
  / \   \
 1   8   7
The Largest BST Subtree in this case is the highlighted one.
The return value is the subtree's size, which is 3.

Follow up:
Can you figure out ways to solve it with O(n) time complexity?
 */
public class LargestBSTSubtree {
    private static final int INVALID = -1;
    class ReturnType{
        int min;
        int max;
        int size;
        public ReturnType(int min, int max, int size){
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    public int largestBSTSubtree(TreeNode root){
        if(root == null){
            return 0;
        }
        int[] largest = new int[]{0};
        ReturnType returnType = recursion(root,largest);
        return largest[0];
    }
    private ReturnType recursion(TreeNode root, int[] largest){
        // base case
        if(root == null){
            return new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE,0);
        }
        // base case leaf node
        if(root.left ==null && root.right == null){
            return new ReturnType(root.key, root.key, 1);
        }
        // what do you ask from left and right child
        ReturnType left = recursion(root.left, largest);
        ReturnType right = recursion(root.right, largest);
        // what do you do recursive rule
        if(left.size == INVALID || right.size  == INVALID || root.key <= left.max || root.key >= right.min){
            return new ReturnType(INVALID, INVALID, INVALID);

        }else{
            int size = left.size + right.size + 1;
            largest[0] = Math.max(largest[0], size);
            return new ReturnType(Math.min(left.min, root.key), Math.max(right.max, root.key), size);
        }
    }
}
