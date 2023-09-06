package CrossTraining;

import java.util.*;

public class FirstNonRepeatingCharacter {
    // each node is a double linked list(dll) node and it contains one distinct character
    static class Node{
        Node next;
        Node prev;
        Character ch;
        public Node(Character ch){
            this.ch = ch;
        }
    }
    // record the head and tail of the list all the time. only the characters only appear just once will be in the dll
    private Node head;
    private Node tail;
    // for any character, it could be in three state:
    // 1. not exited yet, it will not be in singled map or repeated set
    // 2. only exists once, it will be in single map and corresponding node in dll
    // 3. exists more than once, it will be in the repeated set, and it will be removed from dll
    Map<Character, Node> map;
    Set<Character> repeated;

    public FirstNonRepeatingCharacter() {
        // Initialize the class.

        tail = new Node(null);
        tail.next = tail.prev = tail;
        head = tail;
        this.map = new HashMap<Character,Node>();
        repeated = new HashSet<>();
    }
    public void read(char ch) {
        // if the character already exsits more than once, we just ignore
        if(repeated.contains(ch)){
            return;
        }
        Node node = map.get(ch);
        if(node == null){
            // if the character appears for the first time, it should be added to the list and added to the nonRepeated
            node = new Node(ch);
            append(node);
        }else{
            // if the character is already in the nonRepeated map, we should remove it from the map and list, and put it into set
            remove(node);
        }
    }
    private void append(Node node){
        map.put(node.ch, node);
        tail.next = node;
        node.prev = tail;
        node.next = head;
        tail = node;
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if(node == tail){
            tail = node.prev;
        }
        node.next = node.prev = null;
        repeated.add(node.ch);
        map.remove(node.ch);
    }
    public Character firstNonRepeating(Deque<Character> deque,Map<Character, Integer> map) {
        // Implement this method here.
        if(head == tail){
            return null;
        }else{
            return head.next.ch;
        }

    }

}
