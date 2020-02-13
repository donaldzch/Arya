package reservior.sampling;

import java.util.*;

class Linked_List_Random_Node_382 {
    /**
 * Definition for singly-linked list.
 */
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {

    private ListNode head;
    private Random random;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode result = null;
        ListNode current = head;
        
        for(int n = 1; current!=null; n++) {
            if (random.nextInt(n) == 0) {
                result = current;
            }
            current = current.next;
        }
        
        return result.val;
    }
}
}