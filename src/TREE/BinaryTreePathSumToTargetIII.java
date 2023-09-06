package TREE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
141. Binary Tree Path Sum To Target III
Medium
Given a binary tree in which each node contains an integer number.
Determine if there exists a path (the path can only be from one node to itself or to any of its descendants),
the sum of the numbers on the path is the given target number.

Examples

    5

  /    \

2      11

     /    \

    6     14

  /

 3

If target = 17, There exists a path 11 + 6, the sum of the path is target.

If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.
 */
public class BinaryTreePathSumToTargetIII {
	public boolean exist(TreeNode root, int target) {
	    // Write your solution here
	    if(root == null){
				return false;
			} 
	    Set<Integer> set = new HashSet<>();
	    set.add(0);
	    return helper(root, target, set, 0);
	  }
	// with set which stores all the prefixSum(increasing more and more nodes), 
	// to find one node, target - node.key is already in set, meaning find subPath equals target 
	 public boolean helper(TreeNode root, int target, Set<Integer> set, int prefixSum){
	   if(root == null){
	     return false; 
	   }
	    //以下先判断后加是不可以的
		//	    if(set.contains(target - root.key)){
		//	      return true;
		//	    }
		//	    prefixSum += root.key;
		
		prefixSum += root.key; 
		if(set.contains(prefixSum - target)){
		      return true;
		}
		   
		boolean needRemove = set.add(prefixSum);
		if(root.left != null && helper(root.left, target, set, prefixSum)){
		  return true;
		}
		if(root.right != null && helper(root.right, target, set, prefixSum)){
		  return true;
		} 
		//加入树是：{1, null, -1,1,2}, target = 2。 加第二个1 的时候加不进去，因为set里已经有1了，所以不需要再吐
		if(needRemove){
		  set.remove(prefixSum);
		}
		return false;
	  }
	 public boolean existI(TreeNode root, int target) {
		    // Write your solution here
	    if(root == null){
			return false;
		} 
	    List<TreeNode> path = new ArrayList<>();
	    return helperI(root, target, path);
	  }
	  public boolean helperI(TreeNode root, int target, List<TreeNode> path){
		  if(root == null){
		     return false; 
		  }
		  path.add(root);
		  int temp = 0;
		  // check if we can find a subPath ended at root node, the sum of the subPath is target
		  for(int i = path.size() - 1; i >= 0; i --) {
			  temp += path.get(i).key;
			  if(temp == target) {
				  return true;
			  }
		  }
		  boolean res = helperI(root.left, target, path) || helperI(root.right, target, path);
		  // don't forget for the cleanup (backtracking) when return to the previous level
		  path.remove(path.size() - 1);
		  return res;	    
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePathSumToTargetIII findTarget = new BinaryTreePathSumToTargetIII();
		Integer[] nums = {5,2,11,null,null,6,14};
		int k = 9;
		TreeNode[] nodes = Tree.arrayToTreeNodes(nums);		
		Tree.createTreeAsLevel(nodes);
		Tree.PrintLayerByLayer(nodes[0]);
		System.out.println(findTarget.exist(nodes[0], 17));
		System.out.println(findTarget.existI(nodes[0], 17));
//		Set<Integer> set = new HashSet<>();
//		set.add(1);
//		System.out.println(set);
//		set.remove(1);
//		System.out.println(set);
	}

}
