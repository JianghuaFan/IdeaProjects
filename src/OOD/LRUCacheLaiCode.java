package OOD;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheLaiCode<K,V> {
    // each node contains the key, value pair, and it is also a double linked list node
    static class Node<K,V> {
        Node<K,V> next;
        Node<K,V> prev;
        K key;
        V value;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
        void update(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    // make it final for the pre-defined size limit of the cache
    private final int limit = 2;
    // record all the time the head and tail of the double linked list
    private Node<K,V> head;
    private Node<K,V> tail;
    // maintains the relationship of key and its corresponding node in the double linked list
    private Map<K,Node<K,V>> map;

    public LRUCacheLaiCode(int limit){
        this.map = new HashMap<K,Node<K,V>>();
    }
    public void set(K key, V value){
        Node<K, V> node = null;
        // case 1: if the key already in the cache, we need to update its value and move it to head(most recent position)
        if(map.containsKey(key)){
            node = map.get(key);
            node.value = value;
            remove(node);
        }else if(map.size() < limit){
            // case2: if the key is not in the cache, and there is still space, we can append a new node to head
            node = new Node<K,V>(key,value);
        }else{
            // case3: if the key is not in the cache, and there isn't any space, we need to remove tail, and
            // reuse the node let it maintain the new key, value and put it to head
            node = tail;
            remove(node);
            node.update(key,value);
        }
        append(node);
    }

    public V get(K key){
        Node node = map.get(key);
        if(node == null){
            return null;
        }else{
            remove(node);
            append(node);
            return (V) node.value;
        }
    }
    private Node<K,V> remove(Node<K,V> node){
        map.remove(node.key);
        if(node.next != null){
            node.next.prev = node.prev;
        }
        if(node.prev != null ){
            node.prev.next = node.next;
        }
        if(node == head){
            head = head.next;
        }
        if(node == tail){
            tail = tail.prev;
        }
        node.next = null;
        node.prev = null;
        return node;
    }
    private Node<K,V> append(Node<K,V> node){
        map.put(node.key, node);
        if(head == null){
            head = tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node;
    }
}
