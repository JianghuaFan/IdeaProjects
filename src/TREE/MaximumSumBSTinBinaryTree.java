package TREE;
public class MaximumSumBSTinBinaryTree {
    public int maximumSumBSTinBinaryTree(TreeNode root){
        if(root == null){
            return 0;
        }
        int[] maxSum = {0};
        recursion(root, maxSum);
        return maxSum[0] < 0 ? 0 : maxSum[0];
    }
    private void recursion(TreeNode root, int[] maxSum){
        if(root == null){
            return;
        }
        if(isBST(root)){
            maxSum[0] = Math.max(maxSum[0], getSum(root));
        }
        recursion(root.left, maxSum);
        recursion(root.right, maxSum);
    }
    private boolean isBST(TreeNode root){
        if (root == null) {
            return true;
        }
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBST(TreeNode root, int min, int max) {
        //  base case null
        if (root == null) {
            return true;
        }

        // what do you do
        if(root.key <= min || root.key >= max){
            return false;
        }

        // what do you ask from children
        return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
    }

    private int getSum(TreeNode root){
        if(root == null){
            return 0;
        }
        return getSum(root.left) + getSum(root.right) + root.key;
    }

    class ReturnType{
        int min;
        int max;
        int sum;
        public ReturnType(int min, int max, int sum){
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    private final static int INVALID = -1;
    public int maximumSumBSTReturnType(TreeNode root){
        if(root == null){
            return 0;
        }
        int[] maxSum = {0};
        recursionReturnTpye(root, maxSum);
        return maxSum[0];
    }
    private ReturnType recursionReturnTpye(TreeNode root, int[] maxSum){
        // base case
        if(root == null){
            return new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE,0);
        }

        // what do you ask from children
        ReturnType left = recursionReturnTpye(root.left, maxSum);
        ReturnType right = recursionReturnTpye(root.right, maxSum);

        // what do you do
        if(left.min == INVALID || right.min == INVALID || root.key <= left.max || root.key >= right.min){
            return new ReturnType(INVALID, INVALID, INVALID);
        }
        int sum = left.sum + right.sum + root.key;
        maxSum[0] = Math.max(maxSum[0], sum);
        int curMin = Math.min(left.min, root.key);
        int curMax = Math.max(right.max, root.key);
        return new ReturnType(curMin, curMax, sum);
    }
    public static void main(String[] args) {
        Integer[] array = {4,3,null,1,2};
        TREE.TreeNode[] nodes = Tree.arrayToTreeNodes(array);
        Tree.createTreeAsLevel(nodes);
        TREE.TreeNode root = nodes[0];
        MaximumSumBSTinBinaryTree maximumSumBSTinBinaryTree = new MaximumSumBSTinBinaryTree();
        System.out.println(maximumSumBSTinBinaryTree.maximumSumBSTinBinaryTree(root));
        System.out.println(maximumSumBSTinBinaryTree.maximumSumBSTReturnType(root));
    }
}
