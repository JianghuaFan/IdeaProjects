package TREE;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class AverageOfLevelsBFS637 {
	/**
	 * @param root
	 * @return
	 */
	/**
	 * @param root
	 * @return
	 */
	/**
	 * @param root
	 * @return
	 */
	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> ave = new ArrayList<>();
		if(root == null)
			return ave;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			double sum = 0.0;
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				sum += (double)cur.key;			
			if(cur.left != null)
				queue.offer(cur.left);
			if(cur.right != null)
				queue.offer(cur.right);
			}
			ave.add(sum/size);
			
		}		
		return ave;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {3,9,20,null,null,15,7};
		TreeNode[] nodes = new TreeNode[nums.length];
		for(int i = 0; i < nums.length; i++) {
			nodes[i] = nums[i] == null ? null : new TreeNode(nums[i].intValue());
		}
		Tree tree = new Tree();
		tree.createTreeAsLevel(nodes);
		System.out.println(averageOfLevels(nodes[0]));

	}

}
