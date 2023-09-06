package TREE;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseOddLevelsofBinaryTree2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        // corner case:
        if(root == null){
            return null;
        }
        // Method 2:BFS: for every level, if it is even, just generation its children to the queue, if it is odd, reverse ///the whole level with an array
        Queue<TreeNode> queue = new ArrayDeque<>();
        int level = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode[] array = new TreeNode[size];
            int index = 0;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                array[index++] = cur;
            }
            if(level % 2 != 0){
                reverse(array);
            }
            level++;
        }
        return root;
    }

    private void reverse(TreeNode[] array){
        for(int i = 0; i < array.length / 2; i++){
            int temp = array[i].key;
            array[i].key = array[array.length - 1 - i].key;
            array[array.length - 1 - i].key = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {2,3,5,8,13,21,34};
        Integer[] array2 = {0,1,2,0,0,0,0,1,1,1,1,2,2,2,2};
        TreeNode[] nodes = Tree.arrayToTreeNodes(array);
        Tree.createTreeAsLevel(nodes);
        TreeNode root = nodes[0];
        ReverseOddLevelsofBinaryTree2415 reverseOddLevelsofBinaryTree2415 = new ReverseOddLevelsofBinaryTree2415();
        Tree.PrintLayerByLayer(reverseOddLevelsofBinaryTree2415.reverseOddLevels(root));
    }
}
