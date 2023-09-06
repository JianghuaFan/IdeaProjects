package TREE;
/*
Q2. Distance between two given nodes in a given binary search tree.

    Assuming:

there is no parent pointer.

both nodes belong to the tree.

           15

        /          \

      5           20

     /    \

   3      10

 /   \      /

1   4    8

          /   \

         7     9


distance(3, 8) = 3

distance(5, 7) = 3

distance(1, 9) = 5
 */
public class DistanceBetweenTwoNodesInBST {
//    class TreeNode {
//
//        int val;
//
//        TreeNode left;
//
//        TreeNode right;
//
//    }

    private static final int INVALID = -1;
    public int distance(TreeNode root, int A, int B){
        if(root == null) return INVALID;
        if(root.key == A || root.key == B){
            return root.key == A ? getHeight(root,B) : getHeight(root,A);
        }
        TreeNode LCA = LCA(root, A, B);
        if(LCA == null){
            return INVALID;
        }
        if(LCA.key == A){
            TreeNode findB = LCA(LCA, B, B);
            if(findB == null){
                return INVALID;
            }
        }
        if(LCA.key == B){
            TreeNode findA = LCA(LCA, A, A);
            if(findA == null){
                return INVALID;
            }
        }
        return getHeight(root, A) + getHeight(root,B)- 2 * getHeight(root, LCA.key) ;
    }

    private TreeNode LCA(TreeNode root, int A, int B){
        // base case:
        if(root == null || root.key == A || root.key == B){
            return root;
        }
        // recursive rule
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        while(root != null){
            if(root.key < min){
                root = root.right;
            }else if(root.key > max){
                root = root.left;
            }else{
                return root;
            }
        }
        return null;
    }

    private int getHeight(TreeNode root, int A){
        //base case
        int height = 0;
        if(root.key == A){
            return height;
        }

        while(root.key != A){
            if(A < root.key){
                root = root.left;
            }else{
                root = root.right;
            }
            height += 1;
        }
        return height;
    }

    public static void main(String[] args) {
//        Integer[] array = {5,2,8,1,3,null,9};
        Integer[] array = {8,5,13,3,6,9,17,2,4,null,7,null,11,15,null,1,null,null,null,null,null,null,null,14,16};

        TREE.TreeNode[] nodes = Tree.arrayToTreeNodes(array);
        Tree.createTreeAsLevel(nodes);
        TREE.TreeNode root = nodes[0];
        Tree.PrintLayerByLayer(root);
        DistanceBetweenTwoNodesInBST distanceBetweenTwoNodesInBST = new DistanceBetweenTwoNodesInBST();
        System.out.println(distanceBetweenTwoNodesInBST.distance(root, 16,17));
    }
}
