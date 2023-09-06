package TREE;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*
 * Given the root of a binary search tree, and an integer k, 
 * return the kth smallest value (1-indexed) of all the values 
 * of the nodes in the tree.
 */
public class KSmallestElement230 {
	private static int cnt = 0;
	public static int kthSmallest(TreeNode root, int k){
		List<Integer> nums = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        TreeNode cur = root;
        while(cur != null || !deque.isEmpty()){
            if(cur != null){
                deque.offer(cur);
                cur = cur.left;
            }else {
	            cur = deque.poll();
	            nums.add(cur.key);            
	            cnt++;
	            if(k == cnt) 
	                return cur.key;
	            cur = cur.right; 
            }
        }        
        return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {5,3,6,2,4,null,null,1};
		int k = 2;
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);			
		Tree.createTreeAsLevel(nodes);
		Tree.PrintLayerByLayer(nodes[0]);		
		System.out.println(kthSmallest(nodes[0],k));
				
	}

}
