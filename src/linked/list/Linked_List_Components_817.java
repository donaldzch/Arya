package linked.list;

import java.util.HashSet;
import java.util.Set;

class Linked_List_Components_817 {
    class Solution {
        public int numComponents(ListNode head, int[] G) {
            int result = 0;

            Set<Integer> set = new HashSet<>();

            for (int g : G) {
                set.add(g);
            }

            ListNode cur = head;

            while (cur != null) {
                if (set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val))) {
                    result++;
                }
                cur = cur.next;
            }

            return result;
        }
    }
}