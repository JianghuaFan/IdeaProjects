package OOD;

public class Node<K,V> {
	final K key;
	V value;
	Node<K,V> next;
	
	Node(K key, V value){
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	/**
	 * get Value of this Node
	 */
	public V getValue() {
		return value;
	}
	/**setValue with value  */
	public V setValue(V newValue) {
		V oldValue = this.value;
		this.value = newValue;
		return oldValue;
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

}
