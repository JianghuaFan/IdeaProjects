package TREE;
//public class TreeNodeP {
//	
//	TreeNodeP left;
//	TreeNodeP right;
//    TreeNodeP parent;
//    Integer key;
//    public int numNodesLeft;
//    public TreeNodeP(Integer key) {
//        this.key = key;      
//    }
//    public TreeNodeP(Integer key, TreeNodeP left, TreeNodeP right, TreeNodeP parent) {
//        this.key = key;
//        this.left = left;
//        this.right = right;
//        this.parent = parent;
//    }
//}
/*
 * 127. Lowest Common Ancestor II  Medium
Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.
Assumptions
There is parent pointer for the nodes in the binary tree
The given two nodes are not guaranteed to be in the binary tree
 */
public class LowestCommomAncestorLCAII {
	public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		   // Write your solution here.
	   	int depthOne = getDepth(one);
		int depthTwo = getDepth(two);
		if(depthOne <= depthTwo) {
			return mergeNode(one, two, depthTwo - depthOne);
		}else {
			return mergeNode(one, two, depthOne - depthTwo);
		}
	}
	
	public TreeNodeP mergeNode(TreeNodeP shorter, TreeNodeP longer, int dif) {
		while(dif > 0){
			longer = longer.parent;
			dif--;		
		}
		while(shorter != longer){
			shorter = shorter.parent;
			longer = longer.parent;
			}		
		return longer;
	}
	public int getDepth(TreeNodeP node){
		int count = 0;
		while(node != null){
			node = node.parent;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
