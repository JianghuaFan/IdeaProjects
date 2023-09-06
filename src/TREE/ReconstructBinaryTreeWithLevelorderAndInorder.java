package TREE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * 215. Reconstruct Binary Tree With Levelorder And Inorder
Hard
Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

Assumptions

The given sequences are not null and they have the same length
There are no duplicate keys in the binary tree
Examples

levelorder traversal = {5, 3, 8, 1, 4, 11}

inorder traversal = {1, 3, 4, 5, 8, 11}

the corresponding binary tree is

        5

      /    \

    3        8

  /   \        \

1      4        11
 */
public class ReconstructBinaryTreeWithLevelorderAndInorder {
	public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
	    // Write your solution here
		// TC: O(nlogn)按层算  SC: O(n)
		List<Integer> levelList = getList(levelOrder);
		Map<Integer, Integer> inMap = new HashMap<>();
		for(int i = 0; i < inOrder.length; i++) {
			inMap.put(inOrder[i], i);
		}
		// map 保存 inOrder里每个元素的位置，为一会儿方便找到每个根的左子树，右子树即左半边和右半边
		return helper(levelList, inMap);
	}
	
	public TreeNode helper(List<Integer> levelList, Map<Integer, Integer> inMap) {
		if(levelList.size() == 0) {
			return null;
		}
		TreeNode root = new TreeNode(levelList.remove(0));
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		// 每次都是遍历level order里的数，从头上拿一个去找inOrder中和root的相对位置，
		// 在root 的左边的就加入左子树，在右边的加入右子树。两个分别还是level 的list
		
		for(int num : levelList) {
			if(inMap.get(num) < inMap.get(root.key)) {
				leftList.add(num);
			}else {
				rightList.add(num);
			}
		}
		root.left = helper(leftList, inMap);
		root.right = helper(rightList, inMap);
		return root;		
	}
	
	public List<Integer> getList(int[] array){
		List<Integer> list = new ArrayList<>();
		for(int i : array) {
			list.add(i);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] levelOrder = {5, 3, 1, 4, 8, 11};
		int[]  inOrder = {1, 3, 4, 5, 8, 11};
		ReconstructBinaryTreeWithLevelorderAndInorder reConstruct = new ReconstructBinaryTreeWithLevelorderAndInorder();
//		reConstruct.reconstruct(preOrder, inOrder);
		Tree.PrintLayerByLayer(reConstruct.reconstruct(inOrder, levelOrder));
	}

}
