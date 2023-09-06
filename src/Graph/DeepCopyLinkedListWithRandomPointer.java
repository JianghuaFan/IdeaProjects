package Graph;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;
    public RandomListNode(int value) {
      this.value = value;
    }
  }
public class DeepCopyLinkedListWithRandomPointer {
    public RandomListNode copy(RandomListNode head) {
        // Write your solution here.
        if(head == null){
            return null;
        }
        //map to avoid duplicate, Key: original node. Value: copied node
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.value);
        map.put(head, newHead);
        RandomListNode cur = newHead;
        while(head != null){
            if(head.next != null){//copy next
                if(!map.containsKey(head.next)) {
                    map.put(head.next, new RandomListNode(head.next.value));
                }
                // connect the copied node to deep copy list
                cur.next = map.get(head.next);
            }
            if(head.random != null){// copy random
                if(!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.value));
                }
                cur.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return newHead;
    }
}
