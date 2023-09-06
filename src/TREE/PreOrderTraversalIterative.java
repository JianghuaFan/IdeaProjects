package TREE;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

public class PreOrderTraversalIterative {
	public List<Integer> preOrderIterate(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
	    // coner case: if root is null
	    if (root == null)
	      return res;
	    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
	    stack.offerFirst(root);
	    while (!stack.isEmpty()) {
	      TreeNode cur = stack.pollFirst();
	      res.add(cur.key);
	      if(cur.right != null) {
	        stack.offerFirst(cur.right);
	      } 
	      if(cur.left != null) {
	        stack.offerFirst(cur.left);
	      }
	    }
	    return res;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreOrderTraversalIterative preOrder = new PreOrderTraversalIterative();
//		TreeNode root = BTreePrinter.testGeneral();
//		BTreePrinter.printTreeNode(root);
		Integer[] array = {5,2,8,1,3,null,9};
		TreeNode[] nodes = Tree.arrayToTreeNodes(array);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		System.out.println("height: " + Tree.getHeight(root));
		List<Integer> res = preOrder.preOrderIterate(root);
		System.out.print(res.toString());		
	}
}
