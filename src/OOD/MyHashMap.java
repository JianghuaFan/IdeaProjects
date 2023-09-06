package OOD;

import java.util.Arrays;

public class MyHashMap<K,V> {

	public Node<K,V>[] array;
	public int capacity;
	public int size;
	public float loadFactor;
	
	private static final int DEFAULT_CAPACITY = 16;
	private static final float DEFAULT_LOAD_FACTOR = 3/4;
	private static final double SCALE_FACTOR = 1.5;
	
	/** constructor  */
	public MyHashMap(int capacity, float loadFactor) {
		if(capacity <= 1) {
			throw new IllegalArgumentException("cap can not be <=1 ");
		}
		this.array = (Node<K,V>[])(new Node[capacity]);
		this.loadFactor = loadFactor;
		this.size = 0;
		this.capacity = capacity;
	}
	/** constructor without parameters */
	public MyHashMap() {
		this(DEFAULT_CAPACITY,DEFAULT_LOAD_FACTOR);		
	}
	/**
	 * nested class Node<K,V>
	 */
//	class Node<K,V> {
//		final K key;
//		V value;
//		Node<K,V> next;
//
//		Node(K key, V value){
//			this.key = key;
//			this.value = value;
//		}
//		public synchronized K getKey() {
//			return key;
//		}
//		/**
//		 * get Value of this Node
//		 */
//		public synchronized V getValue() {
//			return value;
//		}
//		/**setValue with value  */
//		public synchronized V setValue(V newValue) {
//			V oldValue = this.value;
//			this.value = newValue;
//			return oldValue;
//		}
//		@Override
//		public boolean equals(Object obj) {
//			if(obj == this) {
//				return true;
//			}
//			if(!(obj instanceof Node)) {
//				return false;
//			}
//			Node another = (Node) obj;
//			return this.key.equals(another.key) && this.value.equals(another.value);
//		}
//
//	}
	public synchronized int size() {
		return size;
	}
	public synchronized void clear() {
		Arrays.fill(this.array, null);
		size = 0;
	}
	public synchronized boolean isEmpty() {
		return size == 0;
	}
	
	/**利用key计算hashNumber*/
	public int hash(K key) {
		if(key == null) {
			return 0;
		}
		int hashNumber = key.hashCode();
		return hashNumber & 0X7FFFFFFF;
	}

	/*
	0x7FFFFFFF is 0111 1111 1111 1111 1111 1111 1111 1111 : all 1 except the sign bit.

	(hash & 0x7FFFFFFF) will result in a positive integer.

	(hash & 0x7FFFFFFF) % tab.length will be in the range of the tab length
	 */
	/**OverLoad getIndex, if parameter is key will use this method.利用key计算哪个桶*/
	public int getIndex(K key) {
		if(key == null) {
			return 0;
		}
		int hashNumber = key.hashCode();
		hashNumber = hashNumber & 0x7FFFFFFF;
		return hashNumber % array.length;		
	}
	
	private boolean equalsValue(V v1, V v2) {
		if(v1 == null && v2 == null) {
			return true;
		}
		if(v1 == null || v2 == null) {
			return false;
		}
		return v1.equals(v2);
	}
	
	public synchronized boolean containsValue(V v) {
		//corner case
		if(isEmpty()) {
			return false;
		}
		for(Node<K,V> node : array) {
			while (node != null) {
				if(equalsValue(node.getValue(),v)) {
					return true;
				}else {
					node = node.next;
				}
			}
		}		
		return false;
	}
	
	private boolean equalsKey(K k1, K k2) {
		if(k1 == null && k2 == null) {
			return true;
		}else if(k1 == null || k2 == null) {
			return false;
		}
		return k1.equals(k2);
	}
	/** check is there is k in the HashMap */
	public synchronized boolean containsKey(K k) {
		int index = getIndex(k);
		Node<K,V> node = array[index];
		while(node != null) {
			if(equalsKey(node.getKey(), k)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	/** if key exist, return it's value, else return null*/
	public synchronized V get(K key) {
		int index = getIndex(key);
		Node<K,V> node = array[index];
		while(node != null) {
			if(node.getKey().equals(key)) {
				return node.getValue();
			}
			node = node.next;
		}
		return null;		
	}
	public V putNew(K key, V value){
		int index = getIndex(key);
		Node<K,V> node = array[index];
		V oldValue = null;
		if(node == null){
			Node<K, V> newNode = new Node(key,value);
			newNode.next = array[index];
			array[index] = newNode ;
		}else{
			while(node.getKey() != key){
				node = node.next;
			}
			oldValue = node.value;
			node.value = value;
		}
		size++;
		if(needHashing()){
			reHashing();
		}
		return oldValue;
	}










	/** insert/ update :
	 * if key exists, return the old corresponding value, update with the new value.
	 * if key not exists, create the new node and put it in the head of the corresponding bucket, return null  */
	public synchronized V put(K key, V value) {
		//step1: search for index of key
		//step2: with index, iterate LL, if find key, update value, return oldValue.
		//step3: if didn't find, insert newNode with key and value into the head of array[index] 
		int index = getIndex(key);
		Node<K,V> node = array[index];
		while(node != null) {
			if(node.getKey().equals(key)) {
				V oldValue = node.getValue();
				node.setValue(value);
				return oldValue;
			}else {
				node = node.next;
			}
		}
		Node<K,V> newNode = new Node<K, V>(key,value);
		newNode.next = array[index];
		array[index] = newNode;
		size++;
		if(needHashing()) {
			reHashing();
		}
		return null;
	}
	/** remove the value with the same key*/
	public synchronized V remove(K key) {
		//step1: getIndex with key
		//step2: with array[index] iterate LL, if find key, remove the Node, return oldValue, else return null
		int index = getIndex(key);
		Node<K,V> node = array[index];
		Node<K,V> pre = null;
		while(node != null) {
			if(equalsKey(node.key, key)) {
				if (pre == null) {
					array[index] = node.next;					
				}else {
					pre.next = node.next;
				}
				size--;
				return node.getValue();
			}
			pre = node;
			node = node.next;
		}
		return null;
	}
	private boolean needHashing() {
		float ratio = (float)size / array.length;
		if(ratio >= 0.75) {
			return true;
		}
		return false;
	}
	private void reHashing() {
		Node<K,V>[] oldArray = this.array;
//		this.array = (Node<K,V>[])(new Node[array.length+ array.length>>1]);
		this.array = (Node<K,V>[]) (new Node[(int)(array.length * SCALE_FACTOR)]);
		for(Node<K,V> node : oldArray) {			
			while(node != null) {
				Node<K,V> next = node.next;
				int newIndex = getIndex(node.getKey());//new index				
				node.next = array[newIndex];
				array[newIndex] = node;//更新新的头
				node = next;				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyHashMap<String, Integer> map = new MyHashMap<>();
		String key1 = "Cindy";
		System.out.println("1. get Cindy's index: " + map.getIndex(key1));
		System.out.println("2. map.isEmpty:" + map.isEmpty());
		String key2 = "Andy";
		System.out.println("3. get Andy's index: " + map.getIndex(key2));
		System.out.println("4. contains Andy:" + map.containsKey("Andy"));
//		System.out.println("5. map.put(\"Andy\", 5):" + map.put("Andy", 5));
		System.out.println("5-1. map.putNew(\"Andy\", 6):" + map.putNew("Andy", 6));
		System.out.println("5-2. map.putNew(\"Andy\", 7):" + map.putNew("Andy", 7));
		System.out.println("5-3. map.put(\"Andy\", 8):" + map.put("Andy", 8));
		System.out.println("6. contains Andy:" + map.containsKey("Andy"));
		System.out.println("7. map.isEmpty:" + map.isEmpty());
		System.out.println("8. get value of Andy:" + map.get("Andy"));
		System.out.println("9. get value of Cindy:" + map.get("Cindy"));
		int a = 3;
		int b = a + (a>>1);
		int c = (int)(a * SCALE_FACTOR);
		
		System.out.println("b:" + b);
		System.out.println("c:" + c);
	}

}
