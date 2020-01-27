package linked.list;

import java.util.*;

class Next_Greater_Node_In_Linked_List_1019 {
    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }

            int[] result = new int[list.size()];

            Stack<Integer> indices = new Stack<>();

            for (int i = 0; i < list.size(); i++) {
                while (!indices.isEmpty() && list.get(indices.peek()) < list.get(i)) {
                    result[indices.pop()] = list.get(i);
                }
                indices.push(i);
            }

            return result;
        }
    }
}