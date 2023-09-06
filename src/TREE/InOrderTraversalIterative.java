package TREE;
import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class InOrderTraversalIterative {
	public List<Integer> inOrderIterative(TreeNode root) { 
		List<Integer> res = new ArrayList<>();
	    if (root == null) {
	      return res;
	    } 
	    Deque<TreeNode> stack = new ArrayDeque<>();    
	    TreeNode helper = root;	    

	    while(!stack.isEmpty() || helper != null){      
	        if(helper != null){	          
	          stack.offerFirst(helper);
	          helper = helper.left;//就是要让helper去左边一脚踩空才会结束当前的if条件，
				// 才会去stack里拿刚才压栈的根的元素。否则如果判断left！=null才赋给helper，那么下次还是！null，还会进去当前if里又循环压栈
	        }else{
	          helper = stack.pollFirst();
	          res.add(helper.key);	          
	          helper = helper.right;
	         //helper = helper.right;切记不需要判断helper.right是否为null，
	          //即使是null也要直接到右子树，就是要跑到null，才会再去stack里拿东西，
	          //否则就又去到helper！=null的if里，然后就成了死循环
	        }
	      }
	    return res;
	}
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null){
			return res;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		TreeNode prev = root;
		while(!queue.isEmpty() || prev != null){
			if(prev != null){
				queue.offerFirst(prev);
				prev = prev.left;
			}else{
				prev = queue.pollFirst();
				res.add(prev.key);
				if(prev.right != null){
					queue.offerFirst(prev.right);
					prev = prev.right;
				}
			}

		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Integer[] array = {5,2,8,1,3,null,9};
		Integer[] array = {1,2,3,null,4};
		TreeNode[] nodes = Tree.arrayToTreeNodes(array);
		Tree.createTreeAsLevel(nodes);
		TreeNode root = nodes[0];
		Tree.PrintLayerByLayer(root);
		InOrderTraversalIterative inOrder = new InOrderTraversalIterative();
		List<Integer> res = inOrder.inorderTraversal(root);
		System.out.print(res);
	}

}
