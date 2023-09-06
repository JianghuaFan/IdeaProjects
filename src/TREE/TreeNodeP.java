package TREE;

public class TreeNodeP {
	
	public TreeNodeP left;
	public TreeNodeP right;
	public TreeNodeP parent;
	public Integer key;
	
    public TreeNodeP(Integer key) {
        this.key = key;      
    }
    public TreeNodeP(Integer key, TreeNodeP left, TreeNodeP right, TreeNodeP parent) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}