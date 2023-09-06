package TREE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	public static void createTreeAsLevel(TreeNode[] nodes) {
		int n = nodes.length;
		int flag = 0;//按层构造时一个值为null，则它之后的孩子序号应该相应减2flag
		for(int i=0; 2*i+1 < n-1; i++){
			if(nodes[i] != null){
				nodes[i].left= nodes[2*i+1-2*flag];
				nodes[i].right = 2*i+2 == n ? null : nodes[2*i+2-2*flag];
//				nodes[i].left = nodes[2*i+1];
//				nodes[i].right = 2*i+2 == n ? null : nodes[2*i+2];
			}else{
				flag++;
			}
		}
	}
	public static TreeNode[] arrayToTreeNodes(Integer[] nums) {
		 TreeNode[] nodes = new TreeNode[nums.length];
		 for (int i = 0; i < nums.length; i++) {			 
			nodes[i] = nums[i] == null ? null : new TreeNode(nums[i].intValue());
		 }
		 return nodes;
	 }
	
	public static int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	public static int getNodesNumber(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return getNodesNumber(root.left) + getNodesNumber(root.right) + 1;
	}
	
	public static void postOrderPrinter(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node == null)
				continue;
			res.add(node.key);			 
			if(root.left != null) {
				stack.push(node.left);
			} 
			if(root.right != null) {
				stack.push(node.right);
			}
		}
		Collections.reverse(res);
		System.out.println(res);
	}
	public static void PrintLayerByLayer(TreeNode root) {
	    // Write your solution here
		//corner case: the tree is null
	    if(root == null) {
	    	System.out.print("The tree is null.");
	    }
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
	    while(!queue.isEmpty()) {
	    	int size = queue.size();
	    	for (int i = 0; i < size; i++) {
	    		TreeNode cur = queue.poll();
	    		System.out.print(cur.key);
	    		if(cur.left != null) {
	    			queue.offer(cur.left);
	    		}
	    		if(cur.right != null) {
	    			queue.offer(cur.right);
	    		}
	    	}
	    	System.out.println();
	    }
	  }
	
	public static void main(String arg[]) {
		Integer[] nums = {5,2,8,1,3,null,9};
		Integer[] nums1 = {0,1,2,null,null,5,6,null,null,null,null,11};
		Tree tree = new Tree();
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);
		TreeNode[] nodes1 = Tree.arrayToTreeNodes(nums1);
		Tree.createTreeAsLevel(nodes);
		Tree.createTreeAsLevel(nodes1);
		//通过createAsLevel方法将nodes存储为树，所以root还连着整个树
		TreeNode root = nodes[0];
		TreeNode root1 = nodes1[0];
//		int height = tree.getHeight(root);
//		System.out.println("height:" + height);			
//		System.out.println("root:" + root.key);	
		postOrderPrinter(root);	
//		Tree.PrintLayerByLayer(root);
		Tree.PrintLayerByLayer(root1);
	}
}
