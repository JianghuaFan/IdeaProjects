package TREE;
/*
55. Get Keys In Binary Search Tree In Given Range
Easy
Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

get the keys in [2, 5] in ascending order, result is  [3, 4, 5]

Corner Cases

What if there are no keys in the given range? Return an empty list in this case.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetKeysInBinarySearchTreeInGivenRange {
	public List<Integer> getRange(TreeNode root, int min, int max) {
	    // Write your solution here
		// coner case: root == null
	    List<Integer> res = new ArrayList<Integer>();
	    helper(root, res, min, max);
	    return res;
	  }
	  public void helper(TreeNode root, List<Integer> res, int min, int max) {
	    if (root == null)
	      return;
	    
	    if (root.key > min) {
	      helper(root.left, res, min, max);
	    }
	    if (root.key >= min && root.key <= max) {
	      res.add(root.key);
	    }
	    if (root.key < max) {
	      helper(root.right, res, min, max);
	    }

	  }
	  public TreeNode search(TreeNode root, int key) {
		    // Write your solution here		    	   

		    // iteration:
		    TreeNode cur = root;
		    while (cur.key != key && cur != null) {
		      if (cur.key < key) {
		        cur = cur.right;
		      }else if (cur.key > key) {
		        cur = cur.left;
		      }
		    }
		    return cur;
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {5,2,8,1,3,null,9};
		TREE.TreeNode[] nodes = Tree.arrayToTreeNodes(array);
		Tree.createTreeAsLevel(nodes);
		TREE.TreeNode root = nodes[0];

		GetKeysInBinarySearchTreeInGivenRange a = new GetKeysInBinarySearchTreeInGivenRange();
		System.out.print(a.getRange(root,0,3));
	}

}
