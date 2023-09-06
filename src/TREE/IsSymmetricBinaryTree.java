package TREE;

public class IsSymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root){
        // corner case
        if(root == null){
            return false;
        }
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode A, TreeNode B){
        // base case
        if(A == null && B == null){
            return true;
        }else if (A == null || B == null){
            return false;
        }else if(A.key != B.key){
            return false;
        }
        return helper(A.left, B.right) && helper(A.right, B.left);
    }
    public TreeNode test1() {
        TreeNode root = new TreeNode(5);
        TreeNode n11 = new TreeNode(3);
        TreeNode n12 = new TreeNode(2);
        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(4);
        TreeNode n23 = new TreeNode(4);
        TreeNode n24 = new TreeNode(1);

        root.left = (n11);
        root.right = n12;

        n11.left = (n21);
        n11.right = n22;

        n12.left = (n23);
        n12.right = n24;
        return root;
    }
    public TreeNode test2() {
        TreeNode root = new TreeNode(5);
        TreeNode n11 = new TreeNode(null);
        TreeNode n12 = new TreeNode(3);
        TreeNode n21 = new TreeNode(null);
        TreeNode n22 = new TreeNode(null);
        TreeNode n23 = new TreeNode(1);
        TreeNode n24 = new TreeNode(4);

        root.left = (n11);
        root.right = n12;

        n11.left = (n21);
        n11.right = n22;

        n12.left = (n23);
        n12.right = n24;
        return root;
    }

    public static void main(String[] args) {
        IsSymmetricBinaryTree isSymmetricBinaryTree = new IsSymmetricBinaryTree();
        TreeNode root1 = isSymmetricBinaryTree.test1();
        TreeNode root2 = isSymmetricBinaryTree.test2();
        System.out.println(isSymmetricBinaryTree.isSymmetric(root1));
    }
}
