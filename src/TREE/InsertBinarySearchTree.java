package TREE;

public class InsertBinarySearchTree {
	public TreeNode insertBSTRecursion(TreeNode root, int key) {
		// base case:
		if(root == null) {
			return new TreeNode(key);
		}
		if(key < root.key) {
			root.left = insertBSTRecursion(root.left, key);
		}else {
			root.right = insertBSTRecursion(root.right, key);
		}
		return root;
	}
	public TreeNode insertBSTIterative(TreeNode root, int key) {
		TreeNode newNode = new TreeNode(key);
		if(root == null)
		    return newNode;
		TreeNode cur = root;
		while (cur.key != key) {
			if(cur.key > key){
			      if (cur.left == null){
			        cur.left = (newNode);
			        return root;
			      } else {
			        cur = cur.left;
			      }
			    }
			else if (cur.key < key) {
			  if (cur.right == null) {
				cur.right = newNode;
				return root;
			  } else {
				cur = cur.right;
			  }
			}
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {2,1,3};
		TreeNode[] nodes = Tree.arrayToTreeNodes(array);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];		
		InsertBinarySearchTree insert = new InsertBinarySearchTree();
		Tree.PrintLayerByLayer(insert.insertBSTIterative(root, 4));
	}

}
