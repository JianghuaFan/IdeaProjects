package TREE;
/*
128. Lowest Common Ancestor III
Hard
Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).

Return null If any of the nodes is not in the tree.

Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes are not guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)
 */
public class LowestCommonAncestorLCAIII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // write your solution here
        if(root == null){
            return root;
        }
        // if lca is one, then one is possible two's parent ,如果lca是one，那么one可能是two的上级，需要确认two也在树里面，
        // 以one为根再找two和自己的lca
        TreeNode lca = LCA(root,one,two);
        if(lca == one){
            TreeNode findTwo = LCA(one, two, two);
            if(findTwo == null){
                return null;
            }
        }
        if(lca == two){
            TreeNode findOne = LCA(two, one, one);
            if(findOne == null){
                return null;
            }
        }
        return lca;
    }
    private TreeNode LCA(TreeNode root, TreeNode one, TreeNode two){
        // base case: if we have found each one node, then return this node, if cannot find any till leaf,then return null
        if(root == null || root == one || root == two){
            return null;
        }
        // recursion rule: find lca in left subtree and right subtree, check if both not null, then current root is lca,otherwise return the non-null one
        TreeNode left = LCA(root.left, one, two);
        TreeNode right = LCA(root.right, one ,two);
        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }
    public TreeNode lowestCommonAncestorByKey(TreeNode root, int one, int two) {
        // write your solution here
        if(root == null){
            return root;
        }
        // if lca is one, then one is possible two's parent ,如果lca是one，那么one可能是two的上级，需要确认two也在树里面，
        // 以one为根再找two和自己的lca
        TreeNode lca = LCAByKey(root,one,two);
        if(lca.key == one){
            TreeNode findTwo = LCAByKey(lca, two, two);
            if(findTwo == null){
                return null;
            }
        }
        if(lca.key == two){
            TreeNode findOne = LCAByKey(lca, two, two);
            if(findOne == null){
                return null;
            }
        }
        return lca;
    }
    private TreeNode LCAByKey(TreeNode root, int one, int two){
        // base case: if we have found each one node, then return this node, if cannot find any till leaf,then return null
        if(root == null || root.key == one || root.key == two){
            return root;
        }
        // recursion rule: find lca in left subtree and right subtree, check if both not null, then current root is lca,otherwise return the non-null one
        TreeNode left = LCAByKey(root.left, one, two);
        TreeNode right = LCAByKey(root.right, one ,two);
        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }

    public static void main(String[] args) {
//        Integer[] array = {8,5,13,3,6,9,17,2,4,null,7,null,11,15,null,1,null,null,null,null,null,null,null,14,16};
        Integer[] array = {8,5,13,3,6,9,17,2,4,null,7,null,11,15};
        TREE.TreeNode[] nodes = Tree.arrayToTreeNodes(array);
        Tree.createTreeAsLevel(nodes);
        TREE.TreeNode root = nodes[0];
        LowestCommonAncestorLCAIII lowestCommomAncestorLCAIII = new LowestCommonAncestorLCAIII();
        System.out.println(lowestCommomAncestorLCAIII.lowestCommonAncestorByKey(root, 5,2).key);
    }
}
