package OOD;

import java.util.HashMap;
import java.util.Map;

public class LRUPractice<K,V> {
    class Node<K, V>{
        Node pre;
        Node next;
        K key;
        V value;
        public Node(K k, V v){
            this.key = k;
            this.value = v;
        }

        public void update(K k, V v){
            this.key = k;
            this.value = v;
        }
    }

    private static final int limit = 2;
    public int size = 0;
    private Node<K,V> head;
    private Node<K,V> tail;
    public Map<K, Node<K,V>> map = new HashMap<K, Node<K,V>>();

    public LRUPractice(Map<K, Node<K, V>> map) {
        this.map = map;
    }

    public V get(K k){
        Node node = map.get(k);
        if(map.containsKey(k)){
            remove(node);
            append(node);
            return (V)node.value;
        }else{
            return null;
        }
    }

    private Node<K,V> append(Node<K,V> node) {
        map.put(node.key, node);
        // step DLL:
        if(head == null){
            head = tail = node;
        }else{
            node.next = head;
            head.pre = node;
            head = node;
        }
        return node;
    }

    private Node<K,V> remove(Node node) {
        map.remove(node.key);
        // case 1: only 1 node
        if(node.next != null){
            node.next.pre = node.pre;
        }
        if(node.pre != null){
            node.pre.next = node.next;
        }
        if(head == node){
            head = head.next;
        }
        if(tail == node){
            tail = tail.pre;
        }
        node.next = null;
        node.pre = null;
        return node;
    }

    public void set(K key, V value){
        Node node = map.get(key);
        // case 1: this node exist, we need to update the value
        if(node != null){
           node.update(key, value);
           remove(node);
        }else if(map.size() < limit){// case 2: there is no such node, and size is smaller than limit
            node = new Node(key, value);
        }else{
            node = tail;
            remove(node);
            node.update(key,value);
        }
        append(node);
    }
}
