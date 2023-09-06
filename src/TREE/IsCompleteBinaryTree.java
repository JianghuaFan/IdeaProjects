package TREE;
import java.util.Queue;
import java.util.LinkedList;

public class IsCompleteBinaryTree {
	public boolean isComplete(TreeNode root) {
		if(root == null) {
			return true;
		}
		boolean flag = false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(cur.left != null) {
				if(flag == true) {
					return false;
				}else {
					queue.offer(cur.left);
				}
			}else {
				flag = true;
			}
			if(cur.right != null) {
				if(flag == true) {
					return false;
				}else {
					queue.offer(cur.right);
				}
			} else {
				flag = true;
			}
		}
		return true;
	}
	/*   1
	    / \
	   2   null
	  / \
     3   null
	queue{ } 
	cur: 1, 2
	flag = true,
	
	TC: O(n)
	SC: O(n/2) ~ O(n)
	 */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsCompleteBinaryTree isComplete = new IsCompleteBinaryTree();
		Integer[] array = {1,2,3,null};
		TreeNode[] nodes = Tree.arrayToTreeNodes(array);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		isComplete.isComplete(root);
		System.out.print(isComplete.isComplete(root));		

	}

}
