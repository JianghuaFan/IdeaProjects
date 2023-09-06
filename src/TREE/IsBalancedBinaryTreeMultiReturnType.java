package TREE;

public class IsBalancedBinaryTreeMultiReturnType {
    class ReturnValue{
        int height;
        boolean isBalanced;
        public ReturnValue(int h, boolean isBalanced){
            this.height = h;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        ReturnValue returnValue = recursion(root);
        return returnValue.isBalanced;
    }
    private ReturnValue recursion(TreeNode root){
        // base case:
        if(root == null){
            return new ReturnValue(0,true);
        }
        // what do you want from you left and right child:
        ReturnValue left = recursion(root.left);
        ReturnValue right = recursion(root.right);
        // recursion rule: what do you do at current level:
        if(!left.isBalanced || !right.isBalanced || Math.abs(left.height - right.height) > 1){
            return new ReturnValue(Math.max(left.height,right.height) + 1, false);
        }else{
            return new ReturnValue(Math.max(left.height,right.height) + 1, true);
        }
    }

    public static void main(String[] args) {
        IsBalancedBinaryTreeMultiReturnType isBalancedBinaryTreeMultiReturnType = new IsBalancedBinaryTreeMultiReturnType();
        Integer[] array = {1,2,3,4};
        Integer[] array1 = {-940,500,-119,-454,80,45,-280,null,-854,-377,798,979,-955,null,-221,722,86,null,null,562,-595,436,-823,157,510};
        TreeNode[] nodes = Tree.arrayToTreeNodes(array);
        Tree.createTreeAsLevel(nodes);
        TreeNode root = nodes[0];
        isBalancedBinaryTreeMultiReturnType.isBalanced(root);
        System.out.println(isBalancedBinaryTreeMultiReturnType.isBalanced(root));
    }
}
