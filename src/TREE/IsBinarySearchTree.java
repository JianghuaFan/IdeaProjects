package TREE;

public class IsBinarySearchTree {
    public boolean isBST(TreeNode root){
        if(root == null){
            return true;
        }
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int minValue, int maxValue) {
        // base case : leaf node
        if(root == null){
            return true;
        }
        // recursion rule:
        if(root.key >= maxValue || root.key <= minValue){
            return false;
        }
        boolean left = helper(root.left, minValue, root.key);
        boolean right = helper(root.right, root.key,  maxValue);
        return left && right;
    }

    class ReturnType{
        int min;
        int max;
        boolean isBST;
        public ReturnType(int min, int max, boolean isBST){
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    public boolean isBSTBottomToTopMultiReturnType(TreeNode root) {
        if(root == null){
            return true;
        }
        ReturnType res = recursion(root);
        return res.isBST;
    }
    private ReturnType recursion(TreeNode root){
        // base case
        if(root == null){
            return new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        // leaf node
        // what do you ask for left and right child
        ReturnType left = recursion(root.left);
        ReturnType right = recursion(root.right);
        // what do you do for current level : recursive rule
        if(!left.isBST || !right.isBST || root.key <= left.max || root.key >= right.min){
            return new ReturnType(-1,-1,false);
        }else{
            return new ReturnType(Math.min(left.min, root.key), Math.max(right.max, root.key), true);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {5,2,8,1,3,null,9};

        TREE.TreeNode[] nodes = Tree.arrayToTreeNodes(array);
        Tree.createTreeAsLevel(nodes);
        TREE.TreeNode root = nodes[0];
        Tree.PrintLayerByLayer(root);
        IsBinarySearchTree isBinarySearchTree = new IsBinarySearchTree();
        System.out.println(isBinarySearchTree.isBST(root));
        System.out.println(isBinarySearchTree.isBSTBottomToTopMultiReturnType(root));
    }
}
