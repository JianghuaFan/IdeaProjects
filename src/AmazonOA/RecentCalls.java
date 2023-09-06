package AmazonOA;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class RecentCounter {
    Node head;
    Node tail;

    class Node{
        int val;
        Node prev;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }


    Deque<Node> list;
    public RecentCounter() {
        list = new ArrayDeque<Node>();

    }

    public int ping(int t) {
        if(list == null || list.size() == 0){
            return 0;
        }
        Node node = new Node(t);
        insert(node);
        return get(node);
    }

    public void insert(Node node){
        list.offerLast(node);
    }

    public int get(Node node){

        int startTime = node.val - 3000;
        while(list.peekFirst().val < startTime){
            list.pollFirst();
        }
        return list.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */