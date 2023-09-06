package TREE;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * Given the root of a Binary Search Tree and a target number k, 
 * return true if there exist two elements in the BST such that 
 * their sum is equal to the given target.
 */
public class TwoSumofBST653 {
	public static boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root,nums);
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//        while(!stack.isEmpty() || cur != null){
//            while(cur != null){
//                stack.push(cur);
//                cur = cur.left;
//            }
//            TreeNode node = stack.pop();
//            nums.add(node.val);
//            cur = node.right;
//        }
//        System.out.print(nums.size());
//        System.out.print(nums.toString());
        int i = 0, j = nums.size() - 1;
        while(i < j){
            if(nums.get(i) + nums.get(j) == k)
                return true;
            else if(nums.get(i) + nums.get(j) > k)
                j--;
            else i++;
        }
        return false;           
    }

	private static void inOrder(TreeNode root, List<Integer> nums) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		inOrder(root.left, nums);
		nums.add(root.key);
		inOrder(root.right, nums);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {5,3,6,2,4,null,7};
		int k = 9;
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);		
		Tree.createTreeAsLevel(nodes);
		System.out.println(findTarget(nodes[0], 9));

	}

}
