package TREE;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GetKeysInBinaryTreeLayerByLayerZigZagOrder {
    public List<Integer> zigZag(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        int level = 0;
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0; i < size; i++){// 偶数层，左进右出，先右后左
                if(level % 2 == 0){
                    TreeNode cur = deque.pollLast();
                    res.add(cur.key);
                    if(cur.right != null){
                        deque.offerFirst(cur.right);
                    }
                    if(cur.left != null){
                        deque.offerFirst(cur.left);
                    }
                } else{// 奇数层，右进左出，先左后右
                    TreeNode cur = deque.pollFirst();
                    res.add(cur.key);
                    if(cur.left != null){
                        deque.offerLast(cur.left);
                    }
                    if(cur.right != null){
                        deque.offerLast(cur.right);
                    }
                }
            }
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        GetKeysInBinaryTreeLayerByLayerZigZagOrder get = new GetKeysInBinaryTreeLayerByLayerZigZagOrder();
//		TreeNode root = BTreePrinter.testGeneral();
//		BTreePrinter.printTreeNode(root);
//        Integer[] array = {5,3,8,1,4,null,11};
        Integer[] array = {1,2,3,4,5,6,7};
        TreeNode[] nodes = Tree.arrayToTreeNodes(array);
        Tree.createTreeAsLevel(nodes);
        TreeNode root = nodes[0];
        List<Integer> res = get.zigZag(root);
        System.out.print(res.toString());

    }
}
