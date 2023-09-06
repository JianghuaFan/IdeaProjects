package TREE;

public class IsPerfectBinaryTree {
    class ReturnType{
        int height;
        boolean isPerfect;
        public ReturnType(int h, boolean isPerfect){
            this.height = h;
            this.isPerfect = isPerfect;
        }
    }

    public boolean isPerfectBinaryTree(TreeNode root){
        // corner case
        if(root == null){
            return true;
        }
        ReturnType returnType = recursion(root);
        return returnType.isPerfect;
    }

    private ReturnType recursion(TreeNode root){
        // base case
        if(root == null){
            return new ReturnType(0, true);
        }
        // base case leaf node
        if(root.left == null && root.right == null){
            return new ReturnType(1, true);
        }
        // what do you ask from left and right child
        ReturnType left = recursion(root.left);
        ReturnType right = recursion(root.right);

        // what do you do
        if(left.isPerfect || right.isPerfect || left.height == right.height){
            return new ReturnType(left.height + 1, true);
        }
        else{
            return new ReturnType(-1, false);
        }
    }
    // 继续优化， isPerfect 是boolean，可以用int为负来表示false
    public boolean isPerfectII(TreeNode root){
        if(root == null){
            return true;
        }
        return recursionII(root) != -1;
    }
    public int recursionII(TreeNode root){
        // base case null and leaf
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        // what do you ask for left and right child
        int left = recursionII(root.left);
        int right = recursionII(root.right);
        // what do you do for current level
        if(left != -1 && right != -1 && left == right){
            return left + 1;
        }else{
            return -1;
        }
    }

}
