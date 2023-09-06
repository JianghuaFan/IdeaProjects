package TREE;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Queue;

public class FindBottomLeftValue513 {
	public static int findBottomLeftValue(TreeNode root) {
//		if(root == null)
//			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			root = queue.poll();
			if(root.right != null) 
				queue.offer(root.right);
			if(root.left != null) {
				queue.offer(root.left);
			}
		}
		return (int) root.key;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {2,1,3};
		TreeNode[] nodes = new TreeNode[nums.length];
		for(int i = 0; i < nums.length; i++) {
			nodes[i] =  nums[i] == null ? null : new TreeNode(nums[i].intValue());
		}
		Tree tree = new Tree();
		tree.createTreeAsLevel(nodes);
		System.out.println(findBottomLeftValue(nodes[0]));

	}

}
