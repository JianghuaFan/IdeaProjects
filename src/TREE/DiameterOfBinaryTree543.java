package TREE;


public class DiameterOfBinaryTree543 {
	 static int max = 0;
	    public static int diameterOfBinaryTree(TreeNode root){
	        depth(root);
	        return max;
	    }
	    public static int depth(TreeNode root){
	        if(root == null)
	            return 0;
	        
	        int l = depth(root.left );
	        int r = depth(root.right);
	        //以当前节点为转折点，最大路径就是左边加右边
	        max = Math.max(max, l+r) ; 
	        //若不以当前节点为转折点，只能返回左边或者右边中的一边加上当前节点到左或右子树的1
	        return Math.max(l,r) + 1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] data = {1,2,3,4,5,6,7};
		TreeNode[] nodes = new TreeNode[data.length];
		for(int i = 0; i < data.length; i++) {
			nodes[i] = data[i] == null ? null : new TreeNode(data[i].intValue());
		}
		Tree tree = new Tree();
		tree.createTreeAsLevel(nodes);
		System.out.println(diameterOfBinaryTree(nodes[0]));

	}

}
