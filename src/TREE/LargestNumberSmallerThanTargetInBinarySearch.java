package TREE;

import java.util.Arrays;

public class LargestNumberSmallerThanTargetInBinarySearch {
	public int largestSmaller(TreeNode root, int target) {
		   // Write your solution here
	 	int res = Integer.MIN_VALUE;
		if(root == null){
			return res;
		}
		while(root != null){
			if(root.key >= target){
				root = root.left;
			}
			else{
				// the candidate are all the nodes on the path of searching for target,
				// which is smaller than target.
				// and notice that, the later searched node has larger value than the earlier searched ones
				res = root.key;
				root = root.right;			
			} 
		}
		return res;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestNumberSmallerThanTargetInBinarySearch close = new LargestNumberSmallerThanTargetInBinarySearch();
		Integer[] nums = {5,2,11,null,null,6,14};
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		int target = 10;	
		System.out.print(close.largestSmaller(root, target));
	}

}
