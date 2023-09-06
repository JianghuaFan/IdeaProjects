package TREE;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list.
For a circular doubly linked list, the predecessor of the first element is the last element,
and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation,
the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor.
You should return the pointer to the smallest element of the linked list.
 */
public class ConvertBinarySearchTreetoSortedDoublyLinkedListLeetCode426 {
    class Node{
        public int val;
        public Node left;
        public Node right;
        public Node() {}

        public Node(int _val) {
            val = this.val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    public Node TreeConvertToDDL(Node root){
        // highLevel: inorder traverse
        // Method 1: recursion
        if(root == null){
            return root;
        }
        Node[] head = new Node[1];
        Node[] pre = new Node[1];
        helper(root, pre, head);
        pre[0].right = head[0];
        head[0].left = pre[0];
        return head[0];
    }
    private void helper(Node root, Node[] pre, Node[] head){
        // step1: base case
        if(root == null){
            return;
        }
        // step 2: what do you ask from your children
        helper(root.left, pre, head);
        // stap 3: what do you do
        if(pre[0] == null){
            head[0] = root;
        }else{
            pre[0].right = root;
            root.left = pre[0];
        }
        pre[0] = root;

        helper(root.right, pre, head);
    }
    // Method 1: iteration
    public Node TreeConvertToDDLIterativeDummyHead(Node root){
        // highLevel: inorder traverse

        if(root == null){
            return root;
        }
        Node dummy = new Node(-1);
        Node pre = dummy;
        Node cur = root;
        Deque<Node> deque = new ArrayDeque<>();

        while(cur != null || !deque.isEmpty()){
            if(cur != null){
                deque.offerFirst(cur);
                cur = cur.left;
            }else{
                cur = deque.pollFirst();
                pre.right = cur;
                cur.left = pre;

                pre = cur;
                cur = cur.right;
            }
        }

        dummy.right.left = pre;
        pre.right = dummy.right;
        return dummy.right;
    }
    public Node TreeConvertToDDLIterative(Node root){
    if(root == null){
        return root;
    }
    Node head = null;
    Node pre = null;
    Node cur = root;
    Deque<Node> deque = new ArrayDeque<>();
//        deque.offerFirst(root);
        while(cur != null || !deque.isEmpty()){
        if(cur != null){
            deque.offerFirst(cur);
            cur = cur.left;
        }else{
            cur = deque.pollFirst();
            if(pre == null){
                head = cur;
            }else{
                pre.right = cur;
                cur.left = pre;
            }
            pre = cur;
            cur = cur.right;
        }
    }

    head.left = pre;
    pre.right = head;
        return head;
}


}
