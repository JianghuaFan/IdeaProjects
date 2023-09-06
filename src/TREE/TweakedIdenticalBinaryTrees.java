package TREE;
/*
50. Tweaked Identical Binary Trees
Medium
Determine whether two given binary trees are identical assuming any number of ‘tweak’s are allowed. A tweak is defined as a swap of the children of one node in the tree.

Examples

        5

      /    \

    3        8

  /   \

1      4

and

        5

      /    \

    8        3

           /   \

          1     4

the two binary trees are tweaked identical.
 */
public class TweakedIdenticalBinaryTrees {

	public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		// Write your solution here
		   // case 1:both of them are null
		    if(one == null && two == null)
		      return true;
		  // case 2:only one of them is null
		    else if(one == null || two == null) {
		      return false;
		    } else if (one.key != two.key) {
		      return false;
		    } else { 
		  // case3: check isSymmetric or isIdentical
		    return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
		     || isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
		    }
		  } 
	public TreeNode test1() {
		   TreeNode root = new TreeNode(5);
	        TreeNode n11 = new TreeNode(3);
	        TreeNode n12 = new TreeNode(null);
	        TreeNode n21 = new TreeNode(1);
	        TreeNode n22 = new TreeNode(4);
	        TreeNode n23 = new TreeNode(null);
	        TreeNode n24 = new TreeNode(null);

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
			// TODO Auto-generated method stub	
//			BTreePrinter b = new BTreePrinter();
			TweakedIdenticalBinaryTrees tweaked = new TweakedIdenticalBinaryTrees();
			TreeNode one = tweaked.test1();
			TreeNode two = tweaked.test2();			
			BTreePrinter.printTreeNode(one);
			BTreePrinter.printTreeNode(two);
			
			Integer[] array1 = {5,3,null,1,4,null,null};
			Integer[] array2 = {5,null,3,null,null,1,4};
			
			TreeNode[] nodes1 = Tree.arrayToTreeNodes(array1);
			TreeNode[] nodes2 = Tree.arrayToTreeNodes(array2);
			
			Tree.createTreeAsLevel(nodes1); 
			Tree.createTreeAsLevel(nodes2); 
			
			TreeNode root1 = nodes1[0];
			TreeNode root2 = nodes2[0];
			
			System.out.println(root1);
			System.out.println("isTweakedIdentical(root1, root2):");
			System.out.println(tweaked.isTweakedIdentical(root1, root2));
			System.out.println("isTweakedIdentical(one, two):");
			System.out.println(tweaked.isTweakedIdentical(one, two));
		}

}
