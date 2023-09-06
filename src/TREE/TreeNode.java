package TREE;

public class TreeNode{
    TreeNode left;
    TreeNode right;
    Integer key;
    public int numNodesLeft;
    public TreeNode(Integer key) {
        this.key = key;      
    }
    public TreeNode(Integer key, TreeNode left, TreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
	
}
