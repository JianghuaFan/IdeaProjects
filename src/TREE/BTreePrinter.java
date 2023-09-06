package TREE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinter {
	public static <T extends Comparable<?>> void printTreeNode(TreeNode root) {
	       int maxLevel = BTreePrinter.maxLevel(root);

	       printTreeNodeInternal(Collections.singletonList(root), 1, maxLevel);
	   }

	   private static <T extends Comparable<?>> void printTreeNodeInternal(List<TreeNode> TreeNodes, int level, int maxLevel) {
	       if (TreeNodes.isEmpty() || BTreePrinter.isAllElementsNull(TreeNodes))
	           return;

	       int floor = maxLevel - level;
	       int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
	       int firstSpaces = (int) Math.pow(2, (floor)) - 1;
	       int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

	       BTreePrinter.printWhitespaces(firstSpaces);

	       List<TreeNode> newTreeNodes = new ArrayList<TreeNode>();
	       for (TreeNode TreeNode : TreeNodes) {
	           if (TreeNode != null) {
	               System.out.print(TreeNode.key);
	               newTreeNodes.add(TreeNode.left);
	               newTreeNodes.add(TreeNode.right);
	           } else {
	               newTreeNodes.add(null);
	               newTreeNodes.add(null);
	               System.out.print(" ");
	           }

	           BTreePrinter.printWhitespaces(betweenSpaces);
	       }
	       System.out.println("");

	       for (int i = 1; i <= endgeLines; i++) {
	           for (int j = 0; j < TreeNodes.size(); j++) {
	               BTreePrinter.printWhitespaces(firstSpaces - i);
	               if (TreeNodes.get(j) == null) {
	                   BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
	                   continue;
	               }

	               if (TreeNodes.get(j).left != null)
	                   System.out.print("/");
	               else
	                   BTreePrinter.printWhitespaces(1);

	               BTreePrinter.printWhitespaces(i + i - 1);

	               if (TreeNodes.get(j).right != null)
	                   System.out.print("\\");
	               else
	                   BTreePrinter.printWhitespaces(1);

	               BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
	           }

	           System.out.println("");
	       }

	       printTreeNodeInternal(newTreeNodes, level + 1, maxLevel);
	   }

	   private static void printWhitespaces(int count) {
	       for (int i = 0; i < count; i++)
	           System.out.print(" ");
	   }

	   private static <T extends Comparable<?>> int maxLevel(TreeNode TreeNode) {
	       if (TreeNode == null)
	           return 0;

	       return Math.max(BTreePrinter.maxLevel(TreeNode.left), BTreePrinter.maxLevel(TreeNode.right)) + 1;
	   }

	   private static <T> boolean isAllElementsNull(List<T> list) {
	       for (Object object : list) {
	           if (object != null)
	               return false;
	       }

	       return true;
	   }
	   
	   public static TreeNode test1() {
		   TreeNode root = new TreeNode(1);
	        TreeNode n11 = new TreeNode(2);
//	        TreeNode n12 = new TreeNode(null);
	        TreeNode n21 = new TreeNode(3);
	        TreeNode n22 = new TreeNode(4);
//	        TreeNode n23 = new TreeNode(null);
//	        TreeNode n24 = new TreeNode(null);
//	        TreeNode n31 = new TreeNode(null);
//	        TreeNode n32 = new TreeNode(8);
//	        TreeNode n33 = new TreeNode(4);

	        root.left = n11;
//	        root.right = n12;

	        n11.left = n21;
	        n11.right = n22;

//	        n12.left = n23;
//	        n12.right = n24;

	        
//	        n22.left = n31;
//	        n22.right = n32;
//	        n23.left = n33;

	        return root;
	    }
		public static TreeNode test2() {
	        TreeNode root = new TreeNode(1);
//	        TreeNode n11 = new TreeNode(null);
	        TreeNode n12 = new TreeNode(2);
//	        TreeNode n21 = new TreeNode(null);
//	        TreeNode n22 = new TreeNode(null);
	        TreeNode n23 = new TreeNode(3);
	        TreeNode n24 = new TreeNode(4);	        
//	        TreeNode n31 = new TreeNode(null);
//	        TreeNode n32 = new TreeNode(8);
//	        TreeNode n33 = new TreeNode(4);

//	        root.left = n11;
	        root.right = n12;

//	        n11.left = n21;
//	        n11.right = n22;

	        n12.left = n23;
	        n12.right = n24;
	        
//	        n22.left = n31;
//	        n22.right = n32;
//	        n23.left = n33;

	        return root;
	    }
		public static TreeNode testGeneral() {
			TreeNode root = new TreeNode(5);
	        TreeNode n11 = new TreeNode(2);
	        TreeNode n12 = new TreeNode(8);
	        TreeNode n21 = new TreeNode(1);
	        TreeNode n22 = new TreeNode(3);
//	        TreeNode n23 = new TreeNode(3);
	        TreeNode n24 = new TreeNode(9);
	        root.left = n11;
	        root.right = n12;
	        n11.left = (n21);
	        n11.right = n22;
//	        n12.left = n23;
	        n12.right = n24;
	   	    return root;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
//		BTreePrinter.printTreeNodeInternal(null, 0, 0);
		TreeNode one = test1();
		TreeNode two = test2();
		BTreePrinter b = new BTreePrinter();
//		BTreePrinter.printTreeNode(test1());
//		BTreePrinter.printTreeNode(test2());
//		TweakedIdenticalBinaryTrees tweaked = new TweakedIdenticalBinaryTrees();
//		System.out.println(tweaked.isTweakedIdentical(one, two));
		BTreePrinter.printTreeNode(testGeneral());


	}

}
