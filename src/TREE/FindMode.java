package TREE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMode {
	private static int max = 0;
    static int cnt = 1;
    static TreeNode prevNode = null;
    public static int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();        
        inOrder(root, modes);
        int[] res = new int[modes.size()];
        for(int i = 0; i < modes.size(); i++){
            res[i] = modes.get(i);
//            System.out.print("modes:" + modes.get(i));
        }
        return res;
    }
    public static void inOrder(TreeNode node, List<Integer> modes){
        if(node == null)
            return;
        inOrder(node.left, modes);
//        System.out.print(node.val);
        if(prevNode != null){
            if(prevNode.key == node.key){
            cnt++;
            }else
            cnt = 1;
        	}
        if(cnt > max){
            max = cnt;
            modes.clear();            
            modes.add(node.key);
        }else if(cnt == max){
            modes.add(node.key);
        }
        prevNode = node;
        System.out.print(node.key);
        inOrder(node.right, modes);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = {1,null,2,2};
		TreeNode[] nodes = new TreeNode[nums.length];
		for(int i = 0; i < nums.length; i++) {
			nodes[i] =  nums[i] == null ? null : new TreeNode(nums[i].intValue());
//			if(nodes[i] != null)
//				System.out.print(nodes[i].val);
		}
		Tree tree = new Tree();
		tree.createTreeAsLevel(nodes);
		
		System.out.println(Arrays.toString(findMode(nodes[0])));

	}

}
