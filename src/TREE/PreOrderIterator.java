package TREE;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class PreOrderIterator {

    class preOrderIterator implements Iterator<TreeNode>{
        Deque<TreeNode> queue;
        public preOrderIterator(TreeNode root){
            queue = new ArrayDeque<>();
            if(root != null){
                queue.offer(root);
            }
        }
    // TC: next() : O(1)    hasNext() : O(1)
        // SC: O(height) the stack we created on heap for queue
        @Override
        public TreeNode next(){
            if(hasNext()){
                TreeNode cur = queue.pollFirst();
                if(cur.right != null){
                    queue.offerFirst(cur.right);
                }
                if(cur.left != null){
                    queue.offerFirst(cur.left);
                }
                return cur;
            }
            return null;
        }
        @Override
        public boolean hasNext(){
            return !queue.isEmpty();
        }
    }
}
