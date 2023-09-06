package TREE;

import java.util.ArrayList;
import java.util.List;

public class NumberNodesLeft { 
	public void numberNodesLeft(TreeNode root) {			
		numNodes(root);
	}
	public int numNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int left = numNodes(root.left);
		int right = numNodes(root.right);
		root.numNodesLeft = left;
		return (left + right + 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {1,2,3};
		TreeNode[] nodes = Tree.arrayToTreeNodes(array);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		Tree.PrintLayerByLayer(root);
		NumberNodesLeft numberNodesLeft = new NumberNodesLeft();
		numberNodesLeft.numberNodesLeft(root);
		System.out.print(root.numNodesLeft);
	}

}
