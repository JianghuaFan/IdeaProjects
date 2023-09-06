package TREE;

public class DeleteInBinarySearchTree {
	public TreeNode deleteTree(TreeNode root, int key) {
	    // Write your solution here
	    if (root == null)
	      return root;
	    //found the target, start deleting
	    if (root.key == key) {
	      if (root.left == null) { // case 1: no left child but has right child, or case 2: no children
		     return root.right;
		   } else if(root.right == null) { //case 3: no right child but has left child
		     return root.left;
		   }		    
		   if(root.right.left == null) {
		    	root.right.left = (root.left);
		    	return root.right;
		    }else {
		    	TreeNode smallest = deleteSmallest(root.right);
			    smallest.left = (root.left);
			    smallest.right = root.right; 	
			    return smallest;
		    }		    
	      }  
	      if (root.key < key) {
	        root.right = deleteTree(root.right, key);	      
	      }
	      if (root.key > key) {
	        root.left = (deleteTree(root.left, key));	      
	      }
	      return root;	    
	  }
	
	public TreeNode deleteSmallest(TreeNode cur) {
		TreeNode prev = cur;
		cur = cur.left;
		while (cur.left != null) {
			prev = cur;
			cur = cur.left;
		}
		prev.left = (cur.right);
		return cur;
	}
	public static TreeNode test() {
		   TreeNode root = new TreeNode(3);
	        TreeNode n11 = new TreeNode(2);
	        TreeNode n12 = new TreeNode(8);
//	        TreeNode n21 = new TreeNode(null);
//	        TreeNode n22 = new TreeNode(null);
	        TreeNode n23 = new TreeNode(6);
	        TreeNode n24 = new TreeNode(12);
	        TreeNode n31 = new TreeNode(5);
	        TreeNode n32 = new TreeNode(11);
	        TreeNode n33 = new TreeNode(14);
	        TreeNode n41 = new TreeNode(9);
	        TreeNode n51 = new TreeNode(10);

	        root.left = (n11);
	        root.right = n12;
//	        n11.left = n21;
//	        n11.right = n22;
	        n12.left = (n23);
	        n12.right = n24;	        
	        n23.left = (n31);
	        n24.left = (n32);
	        n24.right = n33;
	        n32.left = (n41);
	        n41.right = n51;
	        
	        return root;
	    }
	public static TreeNode test2() {
		   TreeNode root = new TreeNode(2);
	        TreeNode n11 = new TreeNode(1);
	        TreeNode n12 = new TreeNode(3);      
	        root.left = (n11);
	        root.right = n12;        
	        return root;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteInBinarySearchTree deleteBST = new DeleteInBinarySearchTree();
//		TreeNode root = deleteBST.test();
//		BTreePrinter.printTreeNode(root);
//		deleteBST.deleteTree(root, 8);
//		BTreePrinter.printTreeNode(root);
//		
		TreeNode root2 = deleteBST.test2();
		deleteBST.deleteTree(root2, 1);
		BTreePrinter.printTreeNode(root2);

	}

}
