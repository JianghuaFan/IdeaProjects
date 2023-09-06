package TREE;
/*
390. Determine If Binary Tree Is Min Heap
Medium
Determine if the given binary tree is min heap.
 */
public class IsBinaryTreeMinHeap {
    //method 1: isCompleteTree && isMinHeap
    // complete 可以用BFS做，或者multi return type， isMinHeap判断当前点是否比左右子树都小
    // method 2: multi return type, 需要信息有 isPerfect, isComplete, height, minimum
    class ReturnType{
        boolean isPerfect;
        boolean isComplete;
        int height;
        int minimum;
        public ReturnType(boolean isPerfect, boolean isComplete, int height, int minimum){
            this.isPerfect = isPerfect;
            this.isComplete = isComplete;
            this.height = height;
            this.minimum = minimum;
        }
    }

    public boolean isMinHeap(TreeNode root) {
        // Write your solution here
        // base case
        if(root == null){
            return true;
        }
        ReturnType res = recursion(root);
        return res.isComplete;
    }
    private ReturnType recursion(TreeNode root){
        if(root == null){
            return new ReturnType(true, true, 0, Integer.MAX_VALUE);
        }
        if(root.left == null && root.right == null){
            return new ReturnType(true, true, 1, root.key);
        }
        ReturnType left = recursion(root.left);
        ReturnType right = recursion(root.right);
        if(!left.isComplete || !right.isComplete || root.key > left.minimum || root.key > right.minimum){
            return new ReturnType(false, false, -1,-1);
        }
        boolean isPerfect = left.isPerfect && right.isPerfect && left.height == right.height;
        int height = Math.max(left.height, right.height) + 1;
        int minimum = Math.min(root.key, Math.min(left.minimum, right.minimum));
        boolean isComplete = (left.isComplete && right.isPerfect && left.height == right.height + 1 )
                || left.isPerfect && right.isComplete && left.height == right.height
                && minimum == root.key;

        return new ReturnType(isPerfect,isComplete, height, minimum);
    }

    public boolean isMin(TreeNode root){
        if(root == null){
            return true;
        }
        boolean left = isMin(root.left);
        boolean right = isMin(root.right);

        if(root.left != null && root.key >= root.left.key){
            return false;
        }
        if(root.right != null && root.key >= root.right.key){
            return false;
        }
        return left && right;
    }

    public static void main(String[] args) {
        Integer[] array = {1,2,3,1};
        TREE.TreeNode[] nodes = Tree.arrayToTreeNodes(array);
        Tree.createTreeAsLevel(nodes);
        TREE.TreeNode root = nodes[0];
        IsBinaryTreeMinHeap isBinaryTreeMinHeap = new IsBinaryTreeMinHeap();
        System.out.println(isBinaryTreeMinHeap.isMin(root));
        System.out.println(isBinaryTreeMinHeap.isMinHeap(root));
    }
}
