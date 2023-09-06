package TREE;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII337Laicode472 {
	static Map<TreeNode, Integer> cache = new HashMap<>();
	// method 1: recursion
	public static int rob(TreeNode root){
		int res = 0;
		if(cache.containsKey(root))
			return cache.get(root);
		if(root == null)
			return 0;
		int val1 = root.key;
		if(root.left != null)
			val1 += rob(root.left.left) + rob(root.left.right);
		if(root.right != null)
		val1 += rob(root.right.left) + rob(root.right.right);
		int val2 = rob(root.left) + rob(root.right);
		res = Math.max(val1, val2);
		cache.put(root, res);
		return res;
	}
	// method 2: dp
	public int robLaiCode(TreeNode root) {
		// Write your solution here
		// 物理意义：
		// base case:
		if(root == null){
			return 0;
		}
		return Math.max(helper(root).rob,helper(root).notRob);
	}
	private Pair helper(TreeNode root){
		// base case:
		if(root == null){
			return new Pair(0,0);
		}
		// induction rule: if rob cur, must not rob left and right child,
		//					if not robCur, max (rob left, notRob left） + max(rob right, notRob right)
		Pair left = helper(root.left);
		Pair right = helper(root.right);
		int robCur = root.key + left.notRob + right.notRob;
		int notRobCur = Math.max(left.rob, left.notRob) + Math.max(right.rob, right.notRob);
		return new Pair(robCur, notRobCur);
	}
	class Pair{
		int rob;
		int notRob;
		public Pair(int rob, int notRob){
			this.rob = rob;
			this.notRob = notRob;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobberIII337Laicode472 houseRobberIII337Laicode472 = new HouseRobberIII337Laicode472();
		Integer[] nums = {3,2,3,null,3,null,1};
		TreeNode[] nodes = new TreeNode[nums.length];
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == null)
				nodes[i] = null;
			else nodes[i] = new TreeNode(nums[i].intValue());
		}
		Tree tree = new Tree();
		tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		System.out.println(rob(root));
		System.out.println(houseRobberIII337Laicode472.robLaiCode(root));
	}
}
