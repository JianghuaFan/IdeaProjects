package TREE;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetKeysInBinaryTreeLayerByLayer {
	public List<List<Integer>> layerByLayer(TreeNode root) {		
		List<List<Integer>> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeNode curNode = queue.poll();
				level.add(curNode.key);
				if(curNode.left != null){
					queue.offer(curNode.left);
				}
				if(curNode.right != null){
					queue.offer(curNode.right);
				}
			}
			res.add(level);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {5,2,8,1,3,null,9,4,6};
		TreeNode[] nodes = Tree.arrayToTreeNodes(array);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		GetKeysInBinaryTreeLayerByLayer layer = new GetKeysInBinaryTreeLayerByLayer();
		List<List<Integer>> res = layer.layerByLayer(root);
		System.out.print(res);
	}
}
