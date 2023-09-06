package TREE;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraverse {
	public List<Integer> postOrder(TreeNode root) {
	    // Write your solution here
	    List<Integer> res = new ArrayList<>();
	    if (root == null)
	      return res;
	    helper(root, res);
	    return res;
	  }

	  private void helper(TreeNode root, List<Integer> res) {
	    if (root == null)
	      return;
	    helper(root.left, res);
	    helper(root.right, res);
	    res.add(root.key);
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
