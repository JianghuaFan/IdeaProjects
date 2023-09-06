package TREE;
/*
1339. Maximum Product of Splitted Binary Tree
Medium
2.7K
100
company
Amazon
Two Sigma
company
Bloomberg
Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.

Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.

Note that you need to maximize the answer before taking the mod and not after taking it.



Example 1:


Input: root = [1,2,3,4,5,6]
Output: 110
Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
 */
public class MaximumProductOfSplintedBinaryTree {
    public int maxProduct(TreeNode root) {
        // Highlevel: DFS
        // step1: calculate the sum of the total tree
        // step2: from root traverse the tree to split the tree at any edge, calculate the sum of two subtree,
        // calculate the product, at the same time update the global max

        long[] maxProduct = new long[]{Integer.MIN_VALUE};
        int totalSum = getSum(root);
        DFS(root, maxProduct, totalSum);
        return (int)maxProduct[0]% 1000000007;
    }

    private int getSum(TreeNode root){
        // base case: null and leaf node
        if(root == null){
            return 0;
        }
//        recursive rule include this base case
//        if(root.left == null && root.right == null){
//            return root.key;
//        }
        // recursive rule:
        return getSum(root.left) + getSum(root.right) + root.key;
    }
// two Pass DFS
    private int DFS(TreeNode root, long[] maxProduct, int totalSum){
        // base case:
        if(root == null){
            return 0;
        }
        // recursive rule:
        // update result:
        int left = DFS(root.left, maxProduct, totalSum);
        int right = DFS(root.right, maxProduct, totalSum);
        int total = left + right + root.key;
        long curProduct = (long)total * (totalSum - total);
        maxProduct[0] = Math.max(maxProduct[0], curProduct);
        return total;
    }

    public static void main(String[] args) {
        Integer[] nums = {3434,4223,2441,6764,5911,7094,1827,9223,3580,6615,8446,2770,5112,718,3292,4092,3269,377,7407,4515,4512,6098,282,2197,9833,5285,5841,9643,8708,500,1834,7466,1360,8075,9353,804,656,8645,2445,4648,1194,2185,7883,null,3282,2067,8329,4847,1363,1037,2829,3789,1321,8183,2392,8978,436,7776,2286,8635,587,4391,5075,7307,8431,2236,3588,null,null,6968,6324,null,2149,null,5868,7401,null,8175,7064,1404,8772,null,null,2259,3610,2455,7961,null,3397,8996,7112,1316,4197,8704,2391,227,4720,9266,3273,3503,null,5237,7905,1921,8540,1886,6681,4740,6134,8408,3442,null,3830,2786,5382,3499,4469,1260,1456,6568,746,8076,1665,null,5700,7959,209,2485,null,3253,6181,1080,8731,4829,7285,null,2136,3995,3153,4968,549,3290,627,7812,4406,254,8382,null,null,null,null,4246,5958,8358,1853,2260,3188,1963,9753,null,8976,null,1244,null,null,9473,8385,null,2370,3469,2059,9616,1238,3089,9857,null,3873,2465,1945,6202,7906,9853,2006,null,null,null,9707,4539,4815,3158,4493,5941,7648,7964,6534,9843,7333,409,5246,null,null,7899,null};
        Integer[] nums1 = {5,3,6,2,4};
        TreeNode[] nodes = Tree.arrayToTreeNodes(nums1);
        Tree.createTreeAsLevel(nodes);
        Tree.PrintLayerByLayer(nodes[0]);
        TreeNode root = nodes[0];
        MaximumProductOfSplintedBinaryTree maximumProductOfSplintedBinaryTree = new MaximumProductOfSplintedBinaryTree();
        System.out.println(maximumProductOfSplintedBinaryTree.maxProduct(root));
        System.out.println(maximumProductOfSplintedBinaryTree.getSum(root));
    }
}
