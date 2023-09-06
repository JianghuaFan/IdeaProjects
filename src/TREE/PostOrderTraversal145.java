package TREE;

import java.util.*;

public class PostOrderTraversal145 {
	
	public List<Integer> postorderTraversal(TreeNode root) { 
        // recursion approach
	List<Integer> res = new ArrayList<>();
      if(root == null)
          return res;      
        
      Deque<TreeNode> stack = new ArrayDeque<>();
      
      stack.offerFirst(root);
      while(!stack.isEmpty()){
          TreeNode cur = stack.pollFirst();
          res.add(cur.key);
//          System.out.print(cur.key);
          if(cur.left != null) 
              stack.push(cur.left);
          if(cur.right != null)
              stack.push(cur.right);
      }
      Collections.reverse(res);
      return res;   
	}
        //iteration:
		public List<Integer> postorderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
          return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
          TreeNode cur = stack.peekFirst();
          if(prev == null || prev.left == cur || prev.right == cur) {
        	  // prev == null 根节点 || 从父节点向左边来|| 从父节点向右边来
            if(cur.left != null) { 
              stack.offerFirst(cur.left);
            } else if (cur.right != null) {//这里必须是else if，因为不能同时压栈左边和右边，要先向左一路走到底
              stack.offerFirst(cur.right);
            } else {
              stack.pollFirst();
              res.add(cur.key);
            }
          }
          else if(prev == cur.left) {
            if (cur.right != null) {
              stack.offerFirst(cur.right);
            } else {
              stack.pollFirst();
              res.add(cur.key);
            }
          }
          else if(prev == cur.right) {
            stack.pollFirst();
            res.add(cur.key);
          }
          prev = cur;
        }
        return res;
	}
    public List<Integer> post(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        TreeNode prev = null;
        while(!stack.isEmpty()){
            TreeNode cur = stack.peekFirst();
            // case 1 and 0.5
            if(prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
//                    cur = cur.left; //不能挪动cur，不然变成了下次的
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
//                    cur = cur.right;
                    stack.offerFirst(cur.right);
                } else {
                    res.add(stack.pollFirst().key);
                }
            }
            // case 2: prev是左孩子
            if(cur.left == prev){
                if(cur.right != null){
//                    cur = cur.right;
                    stack.offerFirst(cur.right);
                } else {
                    res.add(stack.pollFirst().key);
                }
            }
            // case 3:
            if(cur.right == prev){
                res.add(stack.pollFirst().key);
            }
            prev = cur;
        }
        return res;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {5,2,8,1,3,null,9};
		TreeNode[] nodes = Tree.arrayToTreeNodes(array);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];		
		PostOrderTraversal145 postOrder = new PostOrderTraversal145();
		System.out.println(postOrder.postorderTraversalIteration(root));
		System.out.println(postOrder.postorderTraversal(root));
        System.out.println(postOrder.post(root));
	}

}
