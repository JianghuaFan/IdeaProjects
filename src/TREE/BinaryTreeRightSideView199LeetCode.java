package TREE;

import OOD.OverRide;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199LeetCode {
    public List<Integer> rightSideView(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                if(i == size - 1){
                    res.add(cur.key);
                }
            }
        }
        return res;
    }
    public List<Integer> rightViewDFS(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }
    private void helper(List<Integer> res, TreeNode root, int level){
        // base case: bottom level
        if(root == null){
            return;
        }
        // every level add one node, level equals the number of the size of the res
        if(res.size() == level){
            res.add(root.key);
        }

        helper(res, root.right, level + 1);
        helper(res, root.left, level + 1);
    }
    public List<Integer> RightViewOfBinaryTree(TreeNode root){
// corner case:
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size ; i++){
                TreeNode cur = queue.poll();
                if(i == size - 1){
                    res.add(cur.key);
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }

    public List<Integer> rightSide(TreeNode root){
        // BFS,
        // CART: is it possible null? TC: O(n), SC: O(n)
        //conner case:
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                if(i == size - 1){
                    res.add(cur.key);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Integer[] nums = {5,2,11,null,null,6,14};
        TreeNode[] nodes = Tree.arrayToTreeNodes(nums);
        Tree.createTreeAsLevel(nodes);
        Tree.PrintLayerByLayer(nodes[0]);
        TreeNode root = nodes[0];
        BinaryTreeRightSideView199LeetCode rightSideView199LeetCode = new BinaryTreeRightSideView199LeetCode();
//        System.out.println(rightSideView199LeetCode.rightSideView(root));
        System.out.println(rightSideView199LeetCode.RightViewOfBinaryTree(root));
    }

}
