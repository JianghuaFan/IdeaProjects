package TREE;
/*
In a binary tree, two nodes are cousins of each other if they are at the same level and have different parents.

Clarification:

Input: TreeNode root, TreeNode one and TreeNode two.

Output: Boolean if two TreeNodes are cousins.

Assumption: Null.

Result: We can try three methods to solve this problem.

Naive solution seperate the definition of cousin into two piece: 1. at same level; 2. have different parents.

BFS solution uses a queue to generate and expand TreeNodes layer by layer; expand当前这一层，generate下一层；

三部曲 solution should define “我要从孩子要什么， 我这一层要做什么，我要向上传什么”.
 */
public class CousinInABinaryTree {
    public boolean isCousin(TreeNode root, int a, int b){
        if(root == null ){
            return false;
        }
        boolean[] res = new boolean[1];
        helper(root, a, b, 0, res);
        return res[0];
    }
    private int helper(TreeNode root, int a , int b, int level, boolean[] res){
        if(root == null){
            return 0;
        }
        // 找到期中一个返回当前高度level
        if(root.key == a || root.key == b){
            return level;
        }
        // 分别在左右子树里找，如果各找到一个，且level一样，并且与当前根相比高度差大于1，则是cousin
        int left = helper(root.left, a, b, level + 1, res);
        int right = helper(root.right, a, b, level + 1, res);
        if(left == right && left - level > 1){
            res[0] = true;
        }
        return left == 0 ? right : left;
    }

    public static void main(String[] args) {
        Integer[] nums = {5,2,8,1,3,null,9};
        TreeNode[] nodes = Tree.arrayToTreeNodes(nums);
        Tree.createTreeAsLevel(nodes);
        TreeNode root = nodes[0];
        CousinInABinaryTree cousinInABinaryTree = new CousinInABinaryTree();
        System.out.println(cousinInABinaryTree.isCousin(root, 1,9));
    }
}
