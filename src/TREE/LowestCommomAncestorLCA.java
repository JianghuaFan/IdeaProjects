package TREE;
/*
126. Lowest Common Ancestor I
Medium
Given two nodes in a binary tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes are guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9
 */
public class LowestCommomAncestorLCA {
	public TreeNode lowestCommonAncestor(TreeNode root,
		     TreeNode one, TreeNode two) {
		   // Write your solution here.
		   	//base case: subproblem has arrived at leaf node, or current node is a or b,then just return current node
			if(root == null || root == one || root == two){
				return root;
			}
			TreeNode left = lowestCommonAncestor(root.left, one, two);
			TreeNode right= lowestCommonAncestor(root.right, one, two);
			if(left != null && right != null){
				return root;
			}
			return left == null ? right : left;
		 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {5,2,8,1,3,null,9};
		TreeNode[] nodes = Tree.arrayToTreeNodes(array);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		LowestCommomAncestorLCA LCA = new LowestCommomAncestorLCA();
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(3);
//		System.out.println(root == one);
//		System.out.print(LCA.lowestCommonAncestor(root, one, two).key);
		LCA.lowestCommonAncestor(root, one, two);
	}

}
