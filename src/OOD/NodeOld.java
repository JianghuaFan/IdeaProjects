package OOD;

public class NodeOld {
	final private String key;
	private Integer value;
	NodeOld next;
	
	public NodeOld(String key, Integer value) {
		this.key = key;
		this.value = value;
	}
	
	
	public String getKey() {
		return key;
	}
	/**
	 * get Value of this Node
	 */
	public Integer getValue() {
		return value;
	}
	/**setValue with value  */
	public void setValue(Integer value) {
		this.value = value;
	}	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if(!(obj instanceof Node)) {
			return false;
		}
		Node another = (Node) obj;
		return this.key.equals(another.key) && this.value.equals(another.value);
	}
//	@Override
//	public int hashCode() {
//		return this.key*101 + value; 
//	}
	
	public static void main(String[] args) {
		Node node1 = new Node("Cindy", 1);
		Node node2 = new Node("Andy", 2);
		Node node3 = new Node("Cindy", 1);
		System.out.println("node1 == node3:" + (node1 == node3));
		System.out.println("node1.equals(node3):" + (node1.equals(node3)));
		
	}
}
