package OOD;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
class LRUCacheSimple {

    public LRUCacheSimple(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    // I need a HashMap to store the key of the node and the node,
    // DLL to store node(for each node, we need key and value) key 是联动 map和 DLL 的关键信息
    // Map<Key, Node> + DLL<Key + Info>
    private Map<Integer, Node> map;
    private int capacity;
    private LinkedList<Node> list = new LinkedList<>();
    private Node head;
    private Node tail;
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        // step 1: get the value
        Node node = map.get(key);

        // step 2: remove the node from DLL and append it to the head
        remove(node);
        append(node);
        return node.value;
    }

    public void put(int key, int value){
        // step 1；check if there is key,
        // case 1: yes : step 2.1 update the value with new value, 2.2 remove the node , and append it
        // case 2: no,  append the new node
        // case 2.1 there is still space, just append
        // case 2.2 there is no space, remove the oldest node and append the new node
        Node node = null;
        if(map.containsKey(key)){// case 1: key exists
            //
            node = map.get(key);
            node.value = value;
            // step 2.2
            remove(node);
        }else if(map.size() < capacity){// case 2.1: there is space
            node = new Node(key,value);
        }else{// case 2.2 no space, need to remove tail,
            node = tail;
            remove(node);
            node.key = key;
            node.value = value;
        }
        append(node);
    }

    public void remove(Node node){
        // part 1: map
        map.remove(node.key);
        // part2: DLL
        if(node.next != null){
            node.next.prev = node.prev;
        }else{
            tail = tail.prev;
        }
        if(node.prev != null){
            node.prev.next = node.next;
        }else{
            head = head.next;
        }
    }

    public void append(Node node){
        // part 1: map
        map.put(node.key, node);
        // part2: DLL
        if(head == null){
            head = tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
            node.prev = null;
        }
    }
    static class Node {
        Node next;
        Node prev;
        int key;
        int value;
        public Node (int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        /*
        ["LRUCache","put","put","get","put","get","put","get","get","get"]
            [[2],   [1,1], [2,2], [1], [3,3], [2], [4,4], [1],  [3],  [4]]
            [null,   null,  null,  1,   null,  -1,  null,  -1,   3,    4]
         */
        LRUCache lruCacheSimple = new LRUCache(1);
        lruCacheSimple.put(2,1);
//        lruCacheSimple.put(2,2);
        System.out.println(lruCacheSimple.get(2));
        lruCacheSimple.put(3, 2);
        System.out.println(lruCacheSimple.get(2));
//        lruCacheSimple.put(4,4);
//        System.out.println(lruCacheSimple.get(1));
        System.out.println(lruCacheSimple.get(3));
//        System.out.println(lruCacheSimple.get(4));
    }
}
